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
		
		
	      Box verticalBox = Box.createVerticalBox();
	      
	      Box upperBox = Box.createHorizontalBox();
	      
	      for(int i=0; i<4; i++) {
	    	  
	    	  Card card = cards[i];
	    	  ImageIcon cardImage = new ImageIcon(card.getCardImageName());

	          JButton button = new JButton(new ImageIcon((cardImage.getImage()).getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH)));
	          button.setSize(200, 300);
	          button.addActionListener(new ActionListener() {
	        	  public void actionPerformed(ActionEvent arg0) {
	        		  showCardPreview(card);
	        	  }
	          });

	          upperBox.add(button);
	      }
	      Box bottomBox = Box.createHorizontalBox();
	      for(int i=4; i<8; i++) {
	    	  Card card = cards[i];
	    	  ImageIcon cardImage = new ImageIcon(card.getCardImageName());

	          JButton button = new JButton(new ImageIcon((cardImage.getImage()).getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH)));
	          button.setSize(200, 300);
	          button.addActionListener(new ActionListener() {
	        	  public void actionPerformed(ActionEvent arg0) {
	        		  showCardPreview(card);
	        	  }
	          });
	          
	          bottomBox.add(button);
	      }

	      verticalBox.add(upperBox);
	      verticalBox.add(bottomBox);
	      
	      JFrame frmCartas = new JFrame();
	      frmCartas.setTitle("Cartas");
	      frmCartas.getContentPane().add(verticalBox);
	      frmCartas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      frmCartas.setLocationByPlatform(true);
	      frmCartas.setSize(1300, 850);
	      frmCartas.setVisible(true);
	}
	
	public void showCardPreview(Card card) {
		CardPreviewFrame cardPreview = new CardPreviewFrame(card);
		cardPreview.setVisible(true);
		cardPreview.setFocusable(true);
		cardPreview.requestFocusInWindow();
		cardPreview.init();
	}
}
