package view;

import javax.swing.JFrame;
import cards.Card;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CardPickerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4486080160427752361L;
	private Card [] cards;

	/**
	 * Create the frame.
	 */
	public CardPickerFrame(Card [] cards) {
		this.cards = cards;

		JFrame pickerFrame = new JFrame();
	    pickerFrame.setTitle("Cartas");
	    pickerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    pickerFrame.setLocationByPlatform(true);

		Box verticalBox = Box.createVerticalBox();
	    
		if(cards.length < 4) {
			verticalBox.add(createCardsBox(0, cards.length));
		    pickerFrame.setSize(1000, 500);

		} else {
			int cardsCount = cards.length / 2;
			verticalBox.add(createCardsBox(0,cardsCount));
		    verticalBox.add(createCardsBox(cardsCount, cards.length - cardsCount));
		    pickerFrame.setSize(1300, 850);
		}
	      
	    pickerFrame.getContentPane().add(verticalBox);
	    pickerFrame.setVisible(true);
	}
	
	public Box createCardsBox(int offset, int cardsCount) {
	    Box box = Box.createHorizontalBox();

		for(int i=offset; i < (offset+cardsCount); i++) {
			Card card = this.cards[i];
						
			ImageIcon cardImage = new ImageIcon(card.getCardImageName());

			JButton button = new JButton(new ImageIcon((cardImage.getImage()).getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH)));
			button.setSize(200, 300);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showCardPreview(card);
				}
			});
			box.add(button);
		}
		return box;
	}
	
	public void showCardPreview(Card card) {
		CardPreviewFrame cardPreview = new CardPreviewFrame(card);
		cardPreview.setVisible(true);
		cardPreview.setFocusable(true);
		cardPreview.requestFocusInWindow();
		cardPreview.init();
	}
}
