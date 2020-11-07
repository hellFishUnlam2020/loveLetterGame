package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

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
		Dimension screenDim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
		
		ImageIcon back = new ImageIcon(GameScreen.class.getResource("/images/login_main/fondo.png"));
		Image scaledBack = back.getImage().getScaledInstance(screenDim.width, screenDim.height, Image.SCALE_SMOOTH);
		
		double aspectRelX = (double)screenDim.width/back.getIconWidth();
		double aspectRelY = (double)screenDim.height/back.getIconHeight();
		
		ImageIcon play = new ImageIcon(GameScreen.class.getResource("/images/login_main/playButton.png"));
		Image scaledPlay = play.getImage().getScaledInstance((int)Math.ceil(aspectRelX*play.getIconWidth()), (int)Math.ceil(aspectRelY*play.getIconHeight()), Image.SCALE_SMOOTH);
		
		ImageIcon profile = new ImageIcon(GameScreen.class.getResource("/images/login_main/profileButton.png"));
		Image scaledProfile = profile.getImage().getScaledInstance((int)Math.ceil(aspectRelX*profile.getIconWidth()), (int)Math.ceil(aspectRelY*profile.getIconHeight()), Image.SCALE_SMOOTH);
		
		ImageIcon config = new ImageIcon(GameScreen.class.getResource("/images/login_main/configButton.png"));
		Image scaledConfig = config.getImage().getScaledInstance((int)Math.ceil(aspectRelX*config.getIconWidth()), (int)Math.ceil(aspectRelY*config.getIconHeight()), Image.SCALE_SMOOTH);
		
		ImageIcon exit = new ImageIcon(GameScreen.class.getResource("/images/login_main/exitButton.png"));
		Image scaledExit = exit.getImage().getScaledInstance((int)Math.ceil(aspectRelX*exit.getIconWidth()), (int)Math.ceil(aspectRelY*exit.getIconHeight()), Image.SCALE_SMOOTH);
		
		ImageIcon dados = new ImageIcon(GameScreen.class.getResource("/images/login_main/dadosButton.png"));
		Image scaledDados = dados.getImage().getScaledInstance((int)Math.ceil(aspectRelX*dados.getIconWidth()), (int)Math.ceil(aspectRelY*dados.getIconHeight()), Image.SCALE_SMOOTH);
		gameFrame = new JFrame();
		
		gameFrame.setResizable(false);
		gameFrame.setUndecorated(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(screenDim.width, screenDim.height);
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
		playButton.setIcon(new ImageIcon(scaledPlay));
		playButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playButton.setBounds((int)Math.ceil(840*aspectRelX), (int)Math.floor(745*aspectRelY), playButton.getIcon().getIconWidth(),playButton.getIcon().getIconHeight());
		playButton.setBorder(null);
		playButton.setToolTipText("Play");
		panel.add(playButton);
		
		JButton profileButton = new JButton("");
		profileButton.setContentAreaFilled(false);
		profileButton.setBorderPainted(false);
		profileButton.setIgnoreRepaint(true);
		profileButton.setOpaque(false);
		profileButton.setIcon(new ImageIcon(scaledProfile));
		profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profileButton.setBounds((int)Math.ceil(916*aspectRelX), (int)Math.floor(967*aspectRelY), profileButton.getIcon().getIconWidth(), profileButton.getIcon().getIconHeight());
		profileButton.setBorder(null);
		profileButton.setToolTipText("Profile");
		panel.add(profileButton);
		
		JButton configButton = new JButton("");
		configButton.setContentAreaFilled(false);
		configButton.setBorderPainted(false);
		configButton.setIgnoreRepaint(true);
		configButton.setOpaque(false);
		configButton.setIcon(new ImageIcon(scaledConfig));
		configButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		configButton.setBounds((int)Math.ceil(1068*aspectRelX), (int)Math.floor(967*aspectRelY), configButton.getIcon().getIconWidth(), configButton.getIcon().getIconHeight());
		configButton.setBorder(null);
		configButton.setToolTipText("Configuration");
		panel.add(configButton);

		JButton exitButton = new JButton("");
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.setIgnoreRepaint(true);
		exitButton.setOpaque(false);
		exitButton.setIcon(new ImageIcon(scaledExit));
		exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitButton.setBounds((int)Math.ceil(1727*aspectRelX), (int)Math.ceil(84*aspectRelY), exitButton.getIcon().getIconWidth(), exitButton.getIcon().getIconHeight());
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
		dadosButton.setIcon(new ImageIcon(scaledDados));
		dadosButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dadosButton.setBounds((int)Math.ceil(763*aspectRelX), (int)Math.ceil(967*aspectRelY), dadosButton.getIcon().getIconWidth(), dadosButton.getIcon().getIconHeight());
		dadosButton.setBorder(null);
		dadosButton.setToolTipText("Cards");
		dadosButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showCardPickerFrame();
			}
		});
		panel.add(dadosButton);
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setIcon(new ImageIcon(scaledBack));
		backgroundImage.setBounds(0, 0, panel.getWidth(), panel.getHeight());
		panel.add(backgroundImage);
		
	}

	public void showLoginFrame() {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setUserLoggable(this);
	}

	public void showCardPickerFrame() {
		Deck deck = new Deck();
		CardPickerFrame cardPicker = new CardPickerFrame(deck.getCards());
//		cardPicker.setVisible(true);
//		cardPicker.setFocusable(true);
//		cardPicker.requestFocusInWindow();
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
