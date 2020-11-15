package jpanels;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;
import interfaces.ScreenConstants;
import loveLetter.Deck;
import loveLetter.Player;
import view.CardPickerFrame;
import view.CardPreviewFrame;
import view.GameScreen;
import viewCommunication.CardElegible;

public class MainMenu extends JPanel implements CardElegible{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8521929087087608231L;
	
	private Player player;
	private GameScreen frame;
	private ImageIcon icon;
	private Image scaledIcon;
	
	public MainMenu(GameScreen frame, Player player) {
		
		this.player = player;
		this.frame = frame;
		
		setSize(ScreenConstants.width, ScreenConstants.height);
		setLayout(null);
		
		addPlayButton();		
		addShowCardsButton();
		addProfileButton();
		addStatsButton();
		addConfigButton();
		addExitButon();
		addBackground();
		
	}
	
	private void addBackground() {
		
		icon = new ImageIcon(MainMenu.class.getResource("/images/main.png"));
		scaledIcon = icon.getImage().getScaledInstance(getSize().width, getSize().height, Image.SCALE_SMOOTH);
		
		JLabel backgroundImage = new JLabel();
		backgroundImage.setIcon(new ImageIcon(scaledIcon));
		backgroundImage.setSize(getSize());
		
		add(backgroundImage);
	}
	
	private void addShowCardsButton() {
		icon = new ImageIcon(GameScreen.class.getResource("/images/mainCards.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
		
		JButton showCardsButton = new CreateButton(new ImageIcon(scaledIcon), 748, 966);
		showCardsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showCardPickerFrame();
			}
		});
		add(showCardsButton);
	}
	
	private void addPlayButton() {
		
		icon = new ImageIcon(GameScreen.class.getResource("/images/mainPlay.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconHeight()), Image.SCALE_SMOOTH);				

		JButton playButton = new CreateButton(new ImageIcon(scaledIcon), 840, 746);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.removeAll();
				frame.getContentPane().add(new GameSelection(frame, player));
			}
		});
		add(playButton);

	}
	
	private void addProfileButton() {
		icon = new ImageIcon(GameScreen.class.getResource("/images/mainProfile.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
	
		JButton profileButton = new CreateButton(new ImageIcon(scaledIcon), 860, 966);

		add(profileButton);

	}	
	
	private void addStatsButton() {
		icon = new ImageIcon(GameScreen.class.getResource("/images/mainStats.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
		
		JButton statsButton = new CreateButton(new ImageIcon(scaledIcon), 969, 964);
		add(statsButton);
	}

	private void addConfigButton() {
		icon = new ImageIcon(GameScreen.class.getResource("/images/mainConfig.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);

		JButton configButton = new CreateButton(new ImageIcon(scaledIcon), 1083, 966);
		configButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				frame.add(new configPanel(this));
			}
		});
		add(configButton);
	} 
	
	private void addExitButon() {
		icon = new ImageIcon(GameScreen.class.getResource("/images/mainExit.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);

		JButton exitButton = new CreateButton(new ImageIcon(scaledIcon), 1726, 84);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		add(exitButton);
	}
	
	
	public void showCardPickerFrame() {
		Deck deck = new Deck();
		CardPickerFrame cardPicker = new CardPickerFrame(deck.getCards());
		cardPicker.setCardEligile(this);
	}

	@Override
	public void cardElected(Card card) {
		CardPreviewFrame cardPreview = new CardPreviewFrame(card);
		cardPreview.init();
		cardPreview.setFocusable(true);
		cardPreview.requestFocusInWindow();
		cardPreview.setVisible(true);
	}
}
