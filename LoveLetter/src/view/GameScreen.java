package view;

import javax.swing.JFrame;

import interfaces.ScreenConstants;
import jpanels.MainMenu;
import loveLetter.Player;

public class GameScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5428637329420503484L;
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
	
		setTitle("Love Letter");
		setIconImage(ScreenConstants.logo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ScreenConstants.width, ScreenConstants.height);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setLayout(null);
		add(new MainMenu());
	}
}
