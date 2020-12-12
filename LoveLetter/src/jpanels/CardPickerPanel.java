package jpanels;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;
import interfaces.GameConstants;
import loveLetter.Deck;
import view.GameFrame;
import viewCommunication.CardElegible;

public class CardPickerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -646140357203059775L;
	private Card[] cards;
	private JLabel background;
	private CardElegible cardElegible;
	private GameFrame frame;
	
	public void setCardElegible(CardElegible cardElegible) {
		this.cardElegible = cardElegible;
	}

	public CardPickerPanel(GameFrame frame) {
		this.cards = new Deck().getCards();

		setSize(GameConstants.screenSize);
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		setBorder(null);
		
		
		addCards(0, cards.length / 2, 0);
		addCards(cards.length / 2, cards.length, 1);
		addCancel();
		addBackground();
		
		this.frame = frame;
	}

	public void addBackground() {

		background = new JLabel();
		background.setIcon(new ScaledIcon("/images/cardPickerFrame.png").getScaledIcon());
		background.setSize(background.getIcon().getIconWidth(), background.getIcon().getIconHeight());
		background.setLocation((GameConstants.width - background.getIcon().getIconWidth())/2, (GameConstants.height - background.getIcon().getIconHeight())/2);
		add(background);
	}

	public void addCancel() {
		JButton cancelButton = new CreateButton("/images/cardPickerCancel.png", (1920 -  183) / 2 , 1080 - 181, "/images/cardPickerCancelClicked.png");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new MainMenu(frame));
				frame.repaint();
			}
		});
		add(cancelButton);
	}
	public void addCards(int offset, int cant, int row) {
		
		for (int i = offset; i < cant; i++) {
			
			Card card = cards[i];
			ImageIcon cardIcon = new ImageIcon(getClass().getResource(card.getCardImageName()));

			JButton button = new CreateButton(card.getCardImageName(), (1920 - 840) / 2 + cardIcon.getIconWidth()*(i<4?i:i-4), (1080 - 590) / 2 + cardIcon.getIconHeight() * row + 1, null);
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cardElegible.cardElected(card);
				}
			});
			add(button);
		}
	}
}
