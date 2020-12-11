package jpanels;

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
import viewCommunication.CardElegible;

public class CardPickerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -646140357203059775L;
	private Card[] cards;
	private JLabel backLabel;
	private CardElegible cardElegible;
	
	public void setCardElegible(CardElegible cardElegible) {
		this.cardElegible = cardElegible;
	}

	public CardPickerPanel() {
		this.cards = new Deck().getCards();

		setSize(GameConstants.screenSize);
		setLayout(null);
		setBorder(null);
		
		addCards(0, cards.length / 2, 0);
		addCards(cards.length / 2, cards.length, 1);
		addCancel();
		addBackground();
	}

	public void addBackground() {

		backLabel = new JLabel();
		backLabel.setIcon(new ScaledIcon("/images/cardPickerBack.png").getScaledIcon());
		backLabel.setSize(backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		add(backLabel);
	}

	public void addCancel() {
		JButton cancelButton = new CreateButton("/images/cardPickerCancel.png", (GameConstants.width -  183) / 2 , GameConstants.height - 181, "/images/cardPickerCancelClicked.png");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame =  (JFrame)getTopLevelAncestor();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new MainMenu());
				frame.repaint();
			}
		});
		add(cancelButton);
	}
	public void addCards(int offset, int cant, int row) {
		
		for (int i = offset; i < cant; i++) {
			
			Card card = cards[i];
			ImageIcon cardIcon = new ImageIcon(getClass().getResource(card.getCardImageName()));

			JButton button = new CreateButton(card.getCardImageName(), (GameConstants.width - 840) / 2 +  + cardIcon.getIconWidth()*(i<4?i:i-4), (GameConstants.height - 590) / 2 + cardIcon.getIconHeight() * row + 1, null);
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
