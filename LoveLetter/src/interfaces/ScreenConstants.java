package interfaces;

import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import view.GameScreen;

public interface ScreenConstants {

	public static final Image logo = Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/images/logo.png"));
	
	public static final int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
	
	public static final int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
	
	public static final double aspectRelX = (double)width/1920;
	
	public static final double aspectRelY = (double)height/1080;
}
