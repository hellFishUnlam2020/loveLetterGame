package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import cards.Card;
import viewCommunication.CardEligible;

public class CardPickerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4486080160427752361L;
	private Card [] cards;
	private CardEligible cardEligile;
	
	public void setCardEligile(CardEligible cardEligile) {
		this.cardEligile = cardEligile;
	}

	/**
	 * Create the frame.
	 */
	public CardPickerFrame(Card [] cards) {
		this.cards = cards;

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
//		JFrame pickerFrame = new JFrame();
//	    pickerFrame.setTitle("Cartas");
//	    pickerFrame.setUndecorated(true);
//	    pickerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//	    pickerFrame.setLocationByPlatform(true);
//		setLocationByPlatform(true);
		
//		setUndecorated(true);
//		setSize(new Dimension(gd.getDisplayMode().getWidth()/2, gd.getDisplayMode().getHeight()/2));
		
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cartas");
		setLocationRelativeTo(null);

		Box verticalBox = Box.createVerticalBox();
	    
		if(cards.length < 4) {
			verticalBox.add(createCardsBox(0, cards.length));
			setSize(279*cards.length, 321);
		} else {
			int cardsCount = cards.length / 2;
			verticalBox.add(createCardsBox(0,cardsCount));
		    verticalBox.add(createCardsBox(cardsCount, cards.length - cardsCount));
		    setSize(279*4+15, 321*2+38); 
		}
	    
//		setSize(verticalBox.getWidth(), verticalBox.getHeight());
//		setSize(verticalBox.getSize());
		
		getContentPane().add(verticalBox);
//		pack();
		setVisible(true);
	}
	
	public Box createCardsBox(int offset, int cardsCount) {
	    Box box = Box.createHorizontalBox();

		for(int i=offset; i < (offset+cardsCount); i++) {
			Card card = this.cards[i];
			
			ImageIcon cardIcon = new ImageIcon(CardPickerFrame.class.getResource(card.getCardImageName()));
			
//			JButton button = new JButton(new ImageIcon((cardImage.getImage()).getScaledInstance(cardImage.getIconWidth(), cardImage.getIconHeight(), Image.SCALE_SMOOTH)));
//			button.setSize(200, 300);
//			button.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					cardElected(card);
//				}
//			});
//			box.add(button);
			
			JButton button = new JButton();
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.setIgnoreRepaint(true);
			button.setOpaque(false);
			button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button.setBorder(null);
			button.setIcon(cardIcon);
			button.setSize(cardIcon.getIconWidth(), cardIcon.getIconHeight());
			box.add(button);
		}
		return box;
	}
	
	public void cardElected(Card card) {
		cardEligile.cardElected(card);
	}
}
