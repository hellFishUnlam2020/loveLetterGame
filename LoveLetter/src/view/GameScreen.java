package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
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
	private double aspectRelX;
	private  double aspectRelY;
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
		
		aspectRelX = (double)screenDim.width/back.getIconWidth();
		aspectRelY = (double)screenDim.height/back.getIconHeight();
			
		gameFrame = new JFrame();
		gameFrame.setTitle("Love Letter");
		gameFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/images/login_main/logo.png")));
		gameFrame.setResizable(false);
		gameFrame.setUndecorated(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(screenDim.width, screenDim.height);
		gameFrame.setLocationRelativeTo(null);
	
		
//		panel = new DrawPanel(new BufferedImage(scaledBack.getWidth(null), scaledBack.getHeight(null), BufferedImage.TYPE_INT_ARGB));
		panel = new JPanel();
		panel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
		panel.setLayout(null);
		
		gameFrame.getContentPane().add(panel);
		
		addPlayButton();		
		addProfileButton();
		addConfigButton();
		addExitBuuton();
		addShowCardsButton();
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setIcon(new ImageIcon(scaledBack));
		backgroundImage.setBounds(0, 0, panel.getWidth(), panel.getHeight());
		panel.add(backgroundImage);
		
	}
	
	//---------------------------------------------------------------
	//Screen config
	
	private void addPlayButton() {
		ImageIcon play = new ImageIcon(GameScreen.class.getResource("/images/login_main/playButton.png"));
		Image scaledPlay = play.getImage().getScaledInstance((int)Math.ceil(aspectRelX*play.getIconWidth()), (int)Math.ceil(aspectRelY*play.getIconHeight()), Image.SCALE_SMOOTH);				

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
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playFrame();
			}
		});
		panel.add(playButton);

	}
	
	
	private void addProfileButton() {
		ImageIcon profile = new ImageIcon(GameScreen.class.getResource("/images/login_main/profileButton.png"));
		Image scaledProfile = profile.getImage().getScaledInstance((int)Math.ceil(aspectRelX*profile.getIconWidth()), (int)Math.ceil(aspectRelY*profile.getIconHeight()), Image.SCALE_SMOOTH);
		
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

	}	

	private void addConfigButton() {
		ImageIcon config = new ImageIcon(GameScreen.class.getResource("/images/login_main/configButton.png"));
		Image scaledConfig = config.getImage().getScaledInstance((int)Math.ceil(aspectRelX*config.getIconWidth()), (int)Math.ceil(aspectRelY*config.getIconHeight()), Image.SCALE_SMOOTH);

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
		configButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showConfigFrame();
			}
		});
		panel.add(configButton);
	} 
	
	private void addExitBuuton() {
		ImageIcon exit = new ImageIcon(GameScreen.class.getResource("/images/login_main/exitButton.png"));
		Image scaledExit = exit.getImage().getScaledInstance((int)Math.ceil(aspectRelX*exit.getIconWidth()), (int)Math.ceil(aspectRelY*exit.getIconHeight()), Image.SCALE_SMOOTH);

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
	}
	
	
	private void addShowCardsButton() {
		ImageIcon dados = new ImageIcon(GameScreen.class.getResource("/images/login_main/dadosButton.png"));
		Image scaledDados = dados.getImage().getScaledInstance((int)Math.ceil(aspectRelX*dados.getIconWidth()), (int)Math.ceil(aspectRelY*dados.getIconHeight()), Image.SCALE_SMOOTH);

		JButton showCardsButton = new JButton("");	
		showCardsButton.setContentAreaFilled(false);
		showCardsButton.setBorderPainted(false);
		showCardsButton.setIgnoreRepaint(true);
		showCardsButton.setOpaque(false);
		showCardsButton.setIcon(new ImageIcon(scaledDados));
		showCardsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showCardsButton.setBounds((int)Math.ceil(763*aspectRelX), (int)Math.ceil(967*aspectRelY), showCardsButton.getIcon().getIconWidth(), showCardsButton.getIcon().getIconHeight());
		showCardsButton.setBorder(null);
		showCardsButton.setToolTipText("Cards");
		showCardsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showCardPickerFrame();
			}
		});
		panel.add(showCardsButton);
	}

	
	//---------------------------------------------------------------
	//Events methods
	
	public void showLoginFrame() {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setUserLoggable(this);
	}

	public void showCardPickerFrame() {
		Deck deck = new Deck();
		CardPickerFrame cardPicker = new CardPickerFrame(deck.getCards());
		cardPicker.setCardEligile(this);
	}
	
	public void showConfigFrame() {
		ConfigFrame cf = new ConfigFrame();
		cf.setVisible(true);
	}
	
	public void playFrame() {
		PlayFrame pf = new PlayFrame();
		pf.setVisible(true);
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

	@Override
	public void cardElected(Card card) {
		CardPreviewFrame cardPreview = new CardPreviewFrame(card);
		cardPreview.init();
		cardPreview.setFocusable(true);
		cardPreview.requestFocusInWindow();
		cardPreview.setVisible(true);
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

}
