package view;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
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

public class MainMenu extends JPanel implements CardEligible{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8521929087087608231L;
	private double aspectRelX;
	private double aspectRelY;
	private Dimension screenDim;
	private ImageIcon backMain;
	private JFrame gameFrame;
	private JPanel gameSelect;
	
	public MainMenu(JFrame gameFrame) {
		
		this.gameFrame = gameFrame;
		
		screenDim = new Dimension(gameFrame.getWidth(), gameFrame.getHeight());
		
		backMain = new ImageIcon(MainMenu.class.getResource("/images/mainMenu/main.png"));
		Image scaledBack = backMain.getImage().getScaledInstance(screenDim.width, screenDim.height, Image.SCALE_SMOOTH);
		
		aspectRelX = screenDim.width/1920;
		aspectRelY = screenDim.height/1080;
		
		setBounds(0, 0, screenDim.width, screenDim.height);
		setLayout(null);
		
		addPlayButton();		
		addProfileButton();
		addConfigButton();
		addExitBuuton();
		addShowCardsButton();
		addStatsButton();
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setIcon(new ImageIcon(scaledBack));
		backgroundImage.setSize(screenDim);
		add(backgroundImage);
		
	}
	
	private void addStatsButton() {
		ImageIcon stats = new ImageIcon(GameScreen.class.getResource("/images/mainMenu/stats.png"));
		Image scaledStats = stats.getImage().getScaledInstance((int)Math.ceil(aspectRelX*stats.getIconWidth()), (int)Math.ceil(aspectRelY*stats.getIconHeight()), Image.SCALE_SMOOTH);
		
		JButton statsButton = new JButton();
		createButton(statsButton);
		statsButton.setIcon(new ImageIcon(scaledStats));
		statsButton.setBounds((int)Math.ceil(969*aspectRelX), (int)Math.floor(964*aspectRelY), statsButton.getIcon().getIconWidth(), statsButton.getIcon().getIconHeight());
		statsButton.setToolTipText("Stats");
		add(statsButton);
	}
	private void addPlayButton() {
		
		ImageIcon play = new ImageIcon(GameScreen.class.getResource("/images/mainMenu/play.png"));
		Image scaledPlay = play.getImage().getScaledInstance((int)Math.ceil(aspectRelX*play.getIconWidth()), (int)Math.ceil(aspectRelY*play.getIconHeight()), Image.SCALE_SMOOTH);				

		JButton playButton = new JButton("");
		createButton(playButton);
		playButton.setIcon(new ImageIcon(scaledPlay));
		playButton.setBounds((int)Math.ceil(840*aspectRelX), (int)Math.floor(746*aspectRelY), playButton.getIcon().getIconWidth(),playButton.getIcon().getIconHeight());
		playButton.setToolTipText("Play");
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				gameSelect.setVisible(true);
				gameFrame.repaint();
			}
		});
		add(playButton);

	}
	
	private void addProfileButton() {
		ImageIcon profile = new ImageIcon(GameScreen.class.getResource("/images/mainMenu/profile.png"));
		Image scaledProfile = profile.getImage().getScaledInstance((int)Math.ceil(aspectRelX*profile.getIconWidth()), (int)Math.ceil(aspectRelY*profile.getIconHeight()), Image.SCALE_SMOOTH);
		
		JButton profileButton = new JButton("");
		createButton(profileButton);
		profileButton.setIcon(new ImageIcon(scaledProfile));
		profileButton.setBounds((int)Math.ceil(860*aspectRelX), (int)Math.floor(966*aspectRelY), profileButton.getIcon().getIconWidth(), profileButton.getIcon().getIconHeight());
		profileButton.setToolTipText("Profile");
		add(profileButton);

	}	

	private void addConfigButton() {
		ImageIcon config = new ImageIcon(GameScreen.class.getResource("/images/mainMenu/config.png"));
		Image scaledConfig = config.getImage().getScaledInstance((int)Math.ceil(aspectRelX*config.getIconWidth()), (int)Math.ceil(aspectRelY*config.getIconHeight()), Image.SCALE_SMOOTH);

		JButton configButton = new JButton("");
		createButton(configButton);
		configButton.setIcon(new ImageIcon(scaledConfig));
		configButton.setBounds((int)Math.ceil(1083*aspectRelX), (int)Math.floor(966*aspectRelY), configButton.getIcon().getIconWidth(), configButton.getIcon().getIconHeight());
		configButton.setToolTipText("Configuration");
		configButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showConfigFrame();
			}
		});
		add(configButton);
	} 
	
	private void addExitBuuton() {
		ImageIcon exit = new ImageIcon(GameScreen.class.getResource("/images/mainMenu/exit.png"));
		Image scaledExit = exit.getImage().getScaledInstance((int)Math.ceil(aspectRelX*exit.getIconWidth()), (int)Math.ceil(aspectRelY*exit.getIconHeight()), Image.SCALE_SMOOTH);

		JButton exitButton = new JButton("");
		createButton(exitButton);
		exitButton.setIcon(new ImageIcon(scaledExit));
		exitButton.setBounds((int)Math.ceil(1726*aspectRelX), (int)Math.ceil(84*aspectRelY), exitButton.getIcon().getIconWidth(), exitButton.getIcon().getIconHeight());
		exitButton.setToolTipText("Exit");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
			}
		});
		add(exitButton);
	}
	
	private void addShowCardsButton() {
		ImageIcon dados = new ImageIcon(GameScreen.class.getResource("/images/mainMenu/cards.png"));
		Image scaledDados = dados.getImage().getScaledInstance((int)Math.ceil(aspectRelX*dados.getIconWidth()), (int)Math.ceil(aspectRelY*dados.getIconHeight()), Image.SCALE_SMOOTH);

		JButton showCardsButton = new JButton("");	
		createButton(showCardsButton);
		showCardsButton.setIcon(new ImageIcon(scaledDados));
		showCardsButton.setBounds((int)Math.ceil(748*aspectRelX), (int)Math.ceil(966*aspectRelY), showCardsButton.getIcon().getIconWidth(), showCardsButton.getIcon().getIconHeight());
		showCardsButton.setToolTipText("Cards");
		showCardsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showCardPickerFrame();
			}
		});
		add(showCardsButton);
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
	
	private void createButton(JButton button) {
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setIgnoreRepaint(true);
		button.setOpaque(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
	}

	@Override
	public void cardElected(Card card) {
		CardPreviewFrame cardPreview = new CardPreviewFrame(card);
		cardPreview.init();
		cardPreview.setFocusable(true);
		cardPreview.requestFocusInWindow();
		cardPreview.setVisible(true);
	}
	
	public void setSwitchPanel(JPanel panel) {
		this.gameSelect = panel;
	}
}
