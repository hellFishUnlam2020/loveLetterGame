package jpanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import interfaces.GameConstants;

public class TextLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5938516393778799012L;
	private Font font = new GameFont().getFont();
	public TextLabel(Rectangle r, Color fontColor, float fontSize) {
		
		setBounds((int)Math.ceil(r.x * GameConstants.aspectRelX), (int)Math.ceil(r.y * GameConstants.aspectRelY), (int)Math.ceil(r.width * GameConstants.aspectRelX), (int)Math.ceil(r.height * GameConstants.aspectRelY));
		setFont(font.deriveFont(fontSize));
		setForeground(fontColor);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
	}
}
