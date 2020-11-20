package jpanels;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import cards.Card;
import interfaces.ScreenConstants;
import view.CardPickerFrame;

public class CardPickerLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -646140357203059775L;
	private Card[] cards;
	private Dimension cartasDim = new Dimension(279 * 4, 321 * 2);

	public CardPickerLabel(Card[] cards) {
		this.cards = cards;

		setLayout(null);
		setBackground(getBackground());
		setSize(ScreenConstants.width, ScreenConstants.height);

		int cardsCount = cards.length / 2;

		addCards(0, cardsCount, 0);
		addCards(cardsCount, cards.length, 1);

	}

	public void addCards(int offset, int cant, int row) {

		int j = 0;
		for (int i = offset; i < cant; i++) {
			Card card = this.cards[i];

			ImageIcon cardIcon = new ImageIcon(CardPickerFrame.class.getResource(card.getCardImageName()));

			JButton button = new CreateButton(cardIcon,
					(ScreenConstants.width - cartasDim.width) / 2 + cardIcon.getIconWidth() * j++,
					(ScreenConstants.height - cartasDim.height) / 2 + cardIcon.getIconHeight() * row + 1);
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					((CardPickerFrame) getTopLevelAncestor()).cardElected(card);
				}
			});
			button.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
						((CardPickerFrame) getTopLevelAncestor()).dispose();
				}
			});
			add(button);
		}
	}
}
