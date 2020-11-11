package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

import viewCommunication.UserLoggable;

public class GameScreen implements UserLoggable {

	private JFrame gameFrame;
	private boolean isLogged = false;
	private Dimension screenDim;
	private MainMenu mainMenu;
	private GameSelection gameSelect;
	
	/**
	 * Create the application.
	 */
	public GameScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenDim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
	
		gameFrame = new JFrame();
		gameFrame.setTitle("Love Letter");
		gameFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/images/logo.png")));
		gameFrame.setResizable(false);
		gameFrame.setUndecorated(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(screenDim.width, screenDim.height);
		gameFrame.setLocationRelativeTo(null);

		mainMenu = new MainMenu(gameFrame);
		gameSelect = new GameSelection(gameFrame);

		mainMenu.setSwitchPanel(gameSelect);
		gameSelect.setSwitchPanel(mainMenu);
		
		gameFrame.add(mainMenu);
		gameFrame.add(gameSelect);
	}
	

	//---------------------------------------------------------------
	//Events methods
	
	public void showLoginFrame() {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setUserLoggable(this);
	}
	
	//---------------------------------------------------------------
	//Game actions
	
	public void startGame() {
		if (!isLogged) {
			showLoginFrame();
		}
	}

	@Override
	public void userLogged(String name) {
		isLogged = true;
	}

	//---------------------------------------------------------------
	//Main

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameScreen window = new GameScreen();
					window.gameFrame.setVisible(true);
					window.startGame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//---------------------------------------------------------------
	// createElements
	

}
