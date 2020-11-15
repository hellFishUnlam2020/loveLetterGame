package jpanels;

import java.awt.Image;

import javax.swing.ImageIcon;

import interfaces.ScreenConstants;

public class ScaledIcon {

	private ImageIcon scaledIcon;
	
	public ScaledIcon(String path) {
	
		ImageIcon icon = new ImageIcon(getClass().getResource(path));
		Image scaled = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
		scaledIcon = new ImageIcon(scaled);
	}
	
	public ImageIcon getScaledIcon() {
		return scaledIcon;
	}
}
