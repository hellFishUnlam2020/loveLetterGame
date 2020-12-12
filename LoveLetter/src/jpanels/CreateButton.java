package jpanels;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;

import interfaces.GameConstants;

public class CreateButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8304780372416324360L;

	public CreateButton(String icon, int x, int y, String rolloverIcon) {
		
		setIcon(new ScaledIcon(icon).getScaledIcon());
		
		if(rolloverIcon != null) 
			setRolloverIcon(new ScaledIcon(rolloverIcon).getScaledIcon());
		
		setBounds((int)Math.ceil(GameConstants.aspectRelX * x), (int)Math.floor(GameConstants.aspectRelY * y), getIcon().getIconWidth(), getIcon().getIconHeight());
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIgnoreRepaint(true);
		setOpaque(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBorder(null);
		setBackground(new Color(0,0,0,0));
	}
	
	public CreateButton(int x, int y, int width, int height) {
		
		setBounds((int)Math.ceil(GameConstants.aspectRelX * x), (int)Math.floor(GameConstants.aspectRelY * y),(int)Math.ceil(GameConstants.aspectRelX * width), (int)Math.floor(GameConstants.aspectRelY * height));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIgnoreRepaint(true);
		setOpaque(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBorder(null);
		setFocusPainted(false);
	}
}
