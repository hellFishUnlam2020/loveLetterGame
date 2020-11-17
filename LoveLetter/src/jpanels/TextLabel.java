package jpanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import interfaces.ScreenConstants;

public class TextLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5938516393778799012L;
	private Font font = new GameFont().getFont();
	public TextLabel(Rectangle r, Color fontColor, float fontSize) {
		
		setBounds((int)Math.ceil(r.x * ScreenConstants.aspectRelX), (int)Math.ceil(r.y * ScreenConstants.aspectRelY), (int)Math.ceil(r.width * ScreenConstants.aspectRelX), (int)Math.ceil(r.height * ScreenConstants.aspectRelY));
		setFont(font.deriveFont(fontSize));
		setForeground(fontColor);
		setHorizontalAlignment(SwingConstants.CENTER);
		
	}
}
