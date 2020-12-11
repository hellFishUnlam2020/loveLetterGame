package jpanels;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;
import interfaces.GameConstants;
import loveLetter.Player;

public class PlayerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8641985058062734814L;
	
	private Card cardSelected;
	private int nCardSelected;
//	private Player player;
	
	private JButton card1;
	private	JButton card2;
	
	private JLabel protectedLabel;
	
	public PlayerPanel(Player player, int nroPlayer, int tamTotal, int aff) {

//		this.player = player;
		
		setSize(GameConstants.screenSize);
		setOpaque(false);
		setLayout(null);
		
		JLabel playerLabel;
		
		if (nroPlayer == 1) {
			playerLabel = new BackgroundLabel(361, 902, "/images/boardP" + nroPlayer + ".png" );
			protectedLabel = new TextLabel(new Rectangle((playerLabel.getX()), 862, playerLabel.getWidth(), 40), Color.black, 35f);
			
			card1 = new CreateButton(playerLabel.getX() + playerLabel.getWidth() + 20, GameConstants.height - 295, 210, 295);
			card2 = new CreateButton(playerLabel.getX() + playerLabel.getWidth() + 210/2, GameConstants.height - 295, 210, 295);
			
			add(card1);
			add(card2);
			
			add(new AffectionPanel(playerLabel.getX(), playerLabel.getY() + 40 , aff, playerLabel.getIcon().getIconWidth()/2, "/images/boardToken.png"));
			add(playerLabel);
			
		} else {
			playerLabel = new BackgroundLabel( ((GameConstants.width / tamTotal)*(nroPlayer-1)) - 350/2,  40, "/images/boardP" + nroPlayer + ".png");
			protectedLabel = new TextLabel(new Rectangle(playerLabel.getX(), 208 ,playerLabel.getWidth(), 40), Color.black, 35f);
			
			JLabel name = new TextLabel(new Rectangle(playerLabel.getX(), 135, playerLabel.getWidth(), 40), new Color(230,190,148), 25f);
			name.setText(player.getName());
			
			add(name);	
			
			card1 = new CreateButton(playerLabel.getX() - 20, playerLabel.getY() + playerLabel.getHeight(), 210, 295);
			card2 = new CreateButton(playerLabel.getX() - 210/2, playerLabel.getY() + playerLabel.getHeight(), 210, 295);
			
			add(card1);
			add(card2);
			
			add(new AffectionPanel(playerLabel.getX(), 170, aff, playerLabel.getIcon().getIconWidth()/2, "/images/boardToken.png"));
			add(playerLabel);
		}
		
		protectedLabel.setVisible(false);
		
		add(protectedLabel);	

	}
	
	public void setCard(Card card) {
				
		if(card1.getIcon() == null) {
			card1.setIcon(new ScaledIcon(card.getCardImageName()).getScaledIcon());
			card1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cardSelected = card;
					nCardSelected = 0;
				}
			});
		}
		else {
			card2.setIcon(new ScaledIcon(card.getCardImageName()).getScaledIcon());
			card2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cardSelected = card;
					nCardSelected = 1;
				}
			});
		}
		getTopLevelAncestor().repaint();
	}
	
	public int getNCardSelected() {
		return nCardSelected;
	}
	
	public void setCardsVisible(Boolean val) {
		card1.setVisible(val);
		card2.setVisible(val);
	}
	
	public Card getCardSelected() {
		return cardSelected;
	}
	
	public void resetCardSelected() {
		cardSelected = null;
		if(nCardSelected == 0) {
			card1.setIcon(null);
		}
		else
			card2.setIcon(null);
	}
	
	public void setProtected(String text, boolean val) {
		protectedLabel.setText(text);
		protectedLabel.setVisible(val);
	}
}
