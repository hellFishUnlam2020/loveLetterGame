package interfaces;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import view.GameFrame;

public interface GameConstants {

	public static final Image logo = Toolkit.getDefaultToolkit().getImage(GameFrame.class.getResource("/images/logo.png"));
	
	public static final int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
//	public static final int width = 1920;
	
	public static final int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
//	public static final int height = 1080;
	
	public static final Dimension screenSize = new Dimension(width, height);
	
	public static final double aspectRelX = (double)width/1920;
	
	public static final double aspectRelY = (double)height/1080;
	
}
