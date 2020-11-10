package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		Dimension dim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
		
		this.cards = cards;
		
		setSize(dim);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cartas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CardPickerFrame.class.getResource("/images/login_main/logo.png")));
	    setBackground(new Color(0,0,0,90));
	    getContentPane().setLayout(null);
	    
		JPanel panel = new JPanel();
		if(cards.length < 4) {
			
			createCardsPanel(panel, 0, cards.length, 0);
			panel.setSize(279*2, 321);
			
		} else {
			
			int cardsCount = cards.length / 2;
			createCardsPanel(panel , 0, cardsCount, 0);
		    createCardsPanel(panel , cardsCount, cards.length, 1);
		    panel.setSize(279*4, 321*2);
		}
		
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBackground(getBackground());		
		panel.setLocation(new Point((dim.width-panel.getWidth())/2, (dim.height-panel.getHeight())/2));
		getContentPane().add(panel);
		
		setVisible(true);
	}
	
	public JPanel createCardsPanel(JPanel panel, int offset, int cant, int row) {

		int j = 0;
		for(int i = offset; i < cant; i++) {
			Card card = this.cards[i];
			
			ImageIcon cardIcon = new ImageIcon(CardPickerFrame.class.getResource(card.getCardImageName()));
				
			JButton button = new JButton();
			button.setOpaque(false);
			button.setBorder(null);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.setIgnoreRepaint(false);
			button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button.setIcon(cardIcon);
			button.setBounds(cardIcon.getIconWidth() * j++, cardIcon.getIconHeight() * row, cardIcon.getIconWidth(), cardIcon.getIconHeight());
			button.setSize(cardIcon.getIconWidth(), cardIcon.getIconHeight());
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cardElected(card);
				}
			});
			button.addKeyListener(new KeyAdapter() {
				@Override
				public  void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
						dispose();
				}
			});
			panel.add(button);
		}
		return panel;
	}
	
	public void cardElected(Card card) {
		cardEligile.cardElected(card);
	}
}