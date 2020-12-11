package jpanels;

import java.awt.Image;

import javax.swing.ImageIcon;

import interfaces.GameConstants;

public class ScaledIcon {

	private ImageIcon scaledIcon;
	
	public ScaledIcon(String path) {
	
		scaledIcon = new ImageIcon(getClass().getResource(path));
		Image scaled = scaledIcon.getImage().getScaledInstance((int)Math.ceil(GameConstants.aspectRelX*scaledIcon.getIconWidth()), (int)Math.ceil(GameConstants.aspectRelY*scaledIcon.getIconHeight()), Image.SCALE_SMOOTH);
		scaledIcon = new ImageIcon(scaled);
	}
	
	public ImageIcon getScaledIcon() {
		return scaledIcon;
	}
}
