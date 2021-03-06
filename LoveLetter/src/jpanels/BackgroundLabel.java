package jpanels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.GameConstants;

public class BackgroundLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 297642885123493729L;

	public BackgroundLabel(int x, int y, String path) {
		
		setIcon(new ScaledIcon(path).getScaledIcon());
		setBounds((int)Math.ceil(x*GameConstants.aspectRelX),(int)Math.floor(y*GameConstants.aspectRelY), getIcon().getIconWidth(), getIcon().getIconHeight());
	
	}
	
	public BackgroundLabel(ImageIcon icon) {
		setIcon(icon);
		setSize(icon.getIconWidth(), icon.getIconHeight());
	}
}
