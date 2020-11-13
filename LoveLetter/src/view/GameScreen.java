package view;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

import jpanels.MainMenu;
import loveLetter.Player;

public class GameScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5428637329420503484L;
	private Dimension screenDim;
	private Player player;
	/**
	 * Create the application.
	 */
	public GameScreen(Player player) {
		this.player = player;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenDim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
	
		setTitle("Love Letter");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/images/logo.png")));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenDim.width, screenDim.height);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		getContentPane().add(new MainMenu(this, player));
	}
}
