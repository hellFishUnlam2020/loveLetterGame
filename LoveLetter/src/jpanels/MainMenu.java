package jpanels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;
import interfaces.ScreenConstants;
import loveLetter.Deck;
import view.CardPickerFrame;
import view.CardPreviewFrame;
import viewCommunication.CardElegible;

public class MainMenu extends JPanel implements CardElegible{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8521929087087608231L;

	public MainMenu() {
						
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
		
		JLabel backgroundImage = new JLabel();
		backgroundImage.setIcon(new ScaledIcon("/images/main.png").getScaledIcon());
		backgroundImage.setSize(getSize());
		
		add(backgroundImage);
	}
	
	private void addShowCardsButton() {
		JButton showCardsButton = new CreateButton(new ScaledIcon("/images/mainCards.png").getScaledIcon(), 748, 966);
		showCardsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showCardPickerFrame();
			}
		});
		add(showCardsButton);
	}
	
	private void addPlayButton() {
		JButton playButton = new CreateButton(new ScaledIcon("/images/mainPlay.png").getScaledIcon(), 840, 746);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFrame frame = (JFrame)getTopLevelAncestor();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new GameSelection());
				frame.repaint();
			}
		});
		add(playButton);

	}
	
	private void addProfileButton() {
		JButton profileButton = new CreateButton(new ScaledIcon("/images/mainProfile.png").getScaledIcon(), 860, 966);

		add(profileButton);

	}	
	
	private void addStatsButton() {		
		JButton statsButton = new CreateButton(new ScaledIcon("/images/mainStats.png").getScaledIcon(), 969, 964);
		add(statsButton);
	}

	private void addConfigButton() {
		JButton configButton = new CreateButton(new ScaledIcon("/images/mainConfig.png").getScaledIcon(), 1083, 966);
		configButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				frame.add(new configPanel(this));
			}
		});
		add(configButton);
	} 
	
	private void addExitButon() {
		JButton exitButton = new CreateButton(new ScaledIcon("/images/mainExit.png").getScaledIcon(), 1726, 84);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTopLevelAncestor().dispatchEvent(new WindowEvent((JFrame)getTopLevelAncestor(), WindowEvent.WINDOW_CLOSING));
			}
		});
		add(exitButton);
	}
	
	
	public void showCardPickerFrame() {
		CardPickerFrame cardPicker = new CardPickerFrame();
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
