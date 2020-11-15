package jpanels;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import interfaces.ScreenConstants;

public class CreateButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8304780372416324360L;

	public CreateButton(ImageIcon icon, int x, int y) {
		
		setIcon(icon);
		setBounds((int)Math.ceil(ScreenConstants.aspectRelX * x), (int)Math.floor(ScreenConstants.aspectRelY * y), icon.getIconWidth(), icon.getIconHeight());
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIgnoreRepaint(true);
		setOpaque(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBorder(null);
		
	}
}
