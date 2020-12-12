package jpanels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;
import interfaces.GameConstants;
import loveLetter.Player;
import viewCommunication.PlayerElegible;

public class PlayerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8641985058062734814L;
	
	private Card cardSelected;
	private int nCardSelected;
	
	private PlayerElegible playerElegible;
	private Player player;
	
	private JButton card1;
	private	JButton card2;
	
	private JButton name;
	
	private JLabel protectedLabel;
	
	public void setPlayerElegible(PlayerElegible playerElegible) {
		this.playerElegible = playerElegible;
	}
	
	public PlayerPanel(Player player, int nroPlayer, int tamTotal, int aff) {
		
		this.player = player;
		setSize(GameConstants.screenSize);
		setOpaque(false);
		setLayout(null);
		
		JLabel playerLabel;
		
		if (nroPlayer == 1) {
			playerLabel = new BackgroundLabel(361, 902, "/images/boardP" + nroPlayer + ".png" );
			protectedLabel = new TextLabel(new Rectangle((playerLabel.getX()), 862, playerLabel.getWidth(), 40), Color.black, 35f);
			
			name = new CreateButton(361, 902 + 5, 350, 40);
			
			add(name);
			card1 = new CreateButton(361 + 350 + 20, 1080 - 295, 210, 295);
			card2 = new CreateButton(361 + 350 + 210, 1080 - 295, 210, 295);
			
			add(card1);
			add(card2);
			
			add(new AffectionPanel(playerLabel.getX(), playerLabel.getY() + (int)Math.floor(GameConstants.aspectRelY * 40) , aff, playerLabel.getIcon().getIconWidth()/2, "/images/boardToken.png"));
			add(playerLabel);
			
		} else {
			int x = 480*(nroPlayer-1) - 175;
			playerLabel = new BackgroundLabel(x, 40, "/images/boardP" + nroPlayer + ".png");
			protectedLabel = new TextLabel(new Rectangle(x, 208, 350, 40), Color.black, 35f);
			
			name = new CreateButton(x, 135, 350, 40);
			
			add(name);	
			
			card1 = new CreateButton(x - 210/2, 40 + 168, 210, 295);
			card2 = new CreateButton(x + 210/2, 40 + 168, 210, 295);
			
			add(card1);
			add(card2);
			
			add(new AffectionPanel(playerLabel.getX(), (int)Math.floor(GameConstants.aspectRelY * 170), aff, playerLabel.getIcon().getIconWidth()/2, "/images/boardToken.png"));
			add(playerLabel);
		}
		name.setForeground(new Color(230,190,148));
		name.setFont(new GameFont().getFont().deriveFont(25f));
		name.setText(player.getName());
		name.setCursor(new Cursor(Cursor.HAND_CURSOR));
		protectedLabel.setVisible(false);
		
		add(protectedLabel);	

	}
	
	public JButton getCard1() {
		return card1;
	}

	public void setCard1(JButton card1) {
		this.card1 = card1;
	}

	public JButton getCard2() {
		return card2;
	}

	public void setCard2(JButton card2) {
		this.card2 = card2;
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
	
	public void setMouseListener() {
		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerElegible.playerElected(player);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				name.setFont(name.getFont().deriveFont(30f));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				name.setFont(name.getFont().deriveFont(25f));
			}
		});
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
	
	public void setStatus(String text, boolean val) {
		protectedLabel.setText(text);
		protectedLabel.setVisible(val);
	}
}
