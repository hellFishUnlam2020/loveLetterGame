package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;
import loveLetter.Deck;
import viewCommunication.CardEligible;
import viewCommunication.UserLoggable;

public class GameScreen implements UserLoggable, CardEligible {

	private JFrame gameFrame;
	private JPanel panel;
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
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		gameFrame = new JFrame();
		
//		gameFrame.setFont(new Font("Dialog", Font.PLAIN, 16));
//		gameFrame.setTitle("Love Letter");
//		gameFrame.getContentPane().setBackground(new Color(46, 139, 87));
//		gameFrame.setBounds(100, 100, 800, 581);
//		gameFrame.setPreferredSize(JFrame.);
//		gameFrame.getContentPane().setLayout(null);
		
		gameFrame.setResizable(false);
		gameFrame.setUndecorated(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gameFrame.setSize(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
		gameFrame.setLocationRelativeTo(null);
	
		panel = new JPanel();
		panel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
		panel.setLayout(null);
		
		gameFrame.getContentPane().add(panel);
		
		
		JButton playButton = new JButton("");
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false);
		playButton.setIgnoreRepaint(true);
		playButton.setOpaque(false);
		playButton.setIcon(new ImageIcon(GameScreen.class.getResource("/images/Login/Capa 1.png")));
		playButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playButton.setBounds(839, 737, 242, 160);
		playButton.setBorder(null);
		panel.add(playButton);
		
		JButton profileButton = new JButton("");
		profileButton.setContentAreaFilled(false);
		profileButton.setBorderPainted(false);
		profileButton.setIgnoreRepaint(true);
		profileButton.setOpaque(false);
		profileButton.setIcon(new ImageIcon(GameScreen.class.getResource("/images/Login/Capa 2.png")));
		profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profileButton.setBounds(889, 885, 120, 174);
		profileButton.setBorder(null);
		panel.add(profileButton);
		
		JButton configButton = new JButton("");
		configButton.setContentAreaFilled(false);
		configButton.setBorderPainted(false);
		configButton.setIgnoreRepaint(true);
		configButton.setOpaque(false);
		configButton.setIcon(new ImageIcon(GameScreen.class.getResource("/images/Login/Capa 4.png")));
		configButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		configButton.setBounds(1061, 965, 96, 94);
		configButton.setBorder(null);
		panel.add(configButton);

		JButton exitButton = new JButton("");
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.setIgnoreRepaint(true);
		exitButton.setOpaque(false);
		exitButton.setIcon(new ImageIcon(GameScreen.class.getResource("/images/Login/Capa 5.png")));
		exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitButton.setBounds(1727, 83, 82, 84);
		exitButton.setBorder(null);
		exitButton.setToolTipText("Exit");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
			}
		});
		panel.add(exitButton);
		
		JButton dadosButton = new JButton("");	
		dadosButton.setContentAreaFilled(false);
		dadosButton.setBorderPainted(false);
		dadosButton.setIgnoreRepaint(true);
		dadosButton.setOpaque(false);
		dadosButton.setIcon(new ImageIcon(GameScreen.class.getResource("/images/Login/Capa 3.png")));
		dadosButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dadosButton.setBounds(763, 965, 104, 92);
		dadosButton.setBorder(null);
		dadosButton.setToolTipText("DadosButton");
		dadosButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showCardPickerFrame();
			}
		});
		panel.add(dadosButton);
		
//		welcomeLabel = new JLabel("");
//		welcomeLabel.setBounds(61, 40, 203, 40);
//		welcomeLabel.setVisible(false);
//		gameFrame.getContentPane().add(welcomeLabel);
//
//		loginButton = new JButton("Entrar");
//		loginButton.setBounds(367, 236, 117, 29);
//		loginButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				showLoginFrame();
//			}
//		});
//		gameFrame.getContentPane().add(loginButton);
//
//		JButton btnNewButton = new JButton("Ver las cartas");
//		btnNewButton.setBounds(48, 348, 117, 29);
//		gameFrame.getContentPane().add(btnNewButton);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				showCardPickerFrame();
//			}
//		});
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setIcon(new ImageIcon(GameScreen.class.getResource("/images/Fondo.png")));
		backgroundImage.setBounds(0, 0, panel.getWidth(), panel.getHeight());
		panel.add(backgroundImage);
		
	}

	public void showLoginFrame() {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setUserLoggable(this);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setVisible(true);
	}

	public void showCardPickerFrame() {
		Deck deck = new Deck();
		CardPickerFrame cardPicker = new CardPickerFrame(deck.getCards());
		cardPicker.setVisible(true);
		cardPicker.setFocusable(true);
		cardPicker.requestFocusInWindow();
		cardPicker.setCardEligile(this);
	}

	public void startGame() {
		if (!isLogged) {
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
//		welcomeLabel.setText("Bienvenido " + name);
//		welcomeLabel.setVisible(true);
//		loginButton.setVisible(false);
	}

	@Override
	public void cardElected(Card card) {
		CardPreviewFrame cardPreview = new CardPreviewFrame(card);
		cardPreview.setVisible(true);
		cardPreview.setFocusable(true);
		cardPreview.requestFocusInWindow();
		cardPreview.init();
	}
}
