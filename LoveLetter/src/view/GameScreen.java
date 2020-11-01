package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import viewCommunication.UserLoggable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JSlider;

public class GameScreen implements UserLoggable {

	private JFrame gameFrame;
	private boolean isLogged = false;
	JLabel welcomeLabel;
	JButton loginButton;

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
		gameFrame = new JFrame();
		gameFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/images/icon.jpg")));
		gameFrame.setFont(new Font("Dialog", Font.PLAIN, 16));
		gameFrame.setTitle("Love Letter");
		gameFrame.getContentPane().setBackground(new Color(46, 139, 87));
		gameFrame.getContentPane().setLayout(null);
		gameFrame.setBounds(100, 100, 800, 581);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		welcomeLabel = new JLabel("");
		welcomeLabel.setBounds(61, 40, 203, 40);
		welcomeLabel.setVisible(false);
		gameFrame.getContentPane().add(welcomeLabel);
		
		loginButton = new JButton("Entrar");
		loginButton.setBounds(367, 236, 117, 29);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showLoginFrame();
			}
		});
		gameFrame.getContentPane().add(loginButton);

	}
	

	public void showLoginFrame() {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setUserLoggable(this);
		loginFrame.setVisible(true);
		loginFrame.setLocationRelativeTo(this.gameFrame);
	}
	
	
	public void startGame() {
		if(!isLogged) {
			showLoginFrame();
		}
	}
	
	
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

	@Override
	public void userLogged(String name) {
		isLogged = true;
		welcomeLabel.setText("Bienvenido " + name);
		welcomeLabel.setVisible(true);
		loginButton.setVisible(false);
	}
}
