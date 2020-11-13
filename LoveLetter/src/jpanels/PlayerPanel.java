package jpanels;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;
import loveLetter.Player;
import view.MatchFrame;

public class PlayerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8641985058062734814L;
	private Dimension screenDim;
	private double aspectRelX;
	private double aspectRelY;
	private JButton card1;
	private JButton card2;
	private int affection;
	private Player player;
	
	public PlayerPanel(Player player, int i, int aff, MatchFrame frame) {
		
		this.affection = aff;
		this.player = player;
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenDim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
		
		setBorder(null);
		setLayout(null);
		
		aspectRelX = (double)screenDim.width/1920;
		aspectRelY = (double)screenDim.height/1080;
			
		switch (i) {
		case 0:
			createPlayer1();
			break;
		case 1:
			createPlayer2();
			break;
//		case 2:
//			createPlayer3();
//			break;
//		case 3:
//			createPlayer4();
		}

	}
	
	public void createPlayer1() {
	
		ImageIcon p1 = new ImageIcon(getClass().getResource("/images/boardP1.png"));
		Image scaledP1 = p1.getImage().getScaledInstance((int) Math.ceil(aspectRelX * p1.getIconWidth()), (int) Math.ceil(aspectRelY * p1.getIconHeight()), Image.SCALE_SMOOTH);
		

		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(scaledP1));
		setBounds((int) Math.ceil(361 * aspectRelX), (int) Math.ceil(902 * aspectRelY), label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
		label.setSize(getSize());
		label.setBounds(getBounds());
		add(label);
		
		for (int i = 0; i < affection; i++) {
//			add(addAffection(label.getX(), label.getWidth(), (int) Math.ceil(943 * aspectRelY), i));
		}
//		
//		JButton card1 = new JButton();
//		createCardButton(card1);
//		card1.setBounds((int) Math.ceil(1000 * aspectRelX), (int) Math.ceil(729 * aspectRelY), (int) Math.ceil(279 * aspectRelX), (int) Math.ceil(321 * aspectRelY));
//		add(card1);
//		
//		JButton card2 = new JButton();
//		createCardButton(card2);
//		card2.setBounds((int) Math.ceil(1200 * aspectRelX), (int) Math.ceil(729 * aspectRelY), (int) Math.ceil(279 * aspectRelX), (int) Math.ceil(321 * aspectRelY));
//		add(card2);
//		
//		
	}
	
	public void createPlayer2() {
		
		ImageIcon p1 = new ImageIcon(getClass().getResource("/images/boardP2.png"));
		Image scaledP1 = p1.getImage().getScaledInstance((int) Math.ceil(aspectRelX * p1.getIconWidth()), (int) Math.ceil(aspectRelY * p1.getIconHeight()), Image.SCALE_SMOOTH);

		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(scaledP1));
		label.setBounds((int) Math.ceil(780 * aspectRelX), (int) Math.ceil(39 * aspectRelY), label.getIcon().getIconWidth(), label.getIcon().getIconHeight());

		for (int i = 0; i < affection; i++) {
			add(addAffection(label.getX(), label.getWidth(), (int) Math.ceil(170 * aspectRelY), i));
		}
		
//		JButton card1 = new JButton();
//		createCardButton(card1);
//		card1.setBounds((int) Math.ceil(300 * aspectRelX), (int) Math.ceil(39 * aspectRelY), (int) Math.ceil(279 * aspectRelX), (int) Math.ceil(321 * aspectRelY));
//		add(card1);
//		
//		JButton card2 = new JButton();
//		createCardButton(card2);
//		card2.setBounds((int) Math.ceil(500 * aspectRelX), (int) Math.ceil(39 * aspectRelY), (int) Math.ceil(279 * aspectRelX), (int) Math.ceil(321 * aspectRelY));
//		add(card2);
		
		add(label);
	}
	
	public void createCardButton(JButton card) {
		
		card.setOpaque(false);
		card.setBorder(null);
		card.setContentAreaFilled(false);
		card.setCursor(new Cursor(Cursor.HAND_CURSOR));
		card.setVisible(false);
		card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
	
	public JLabel addAffection(int x, int width, int y, int i) {
		ImageIcon affect = new ImageIcon(getClass().getResource("/images/boardToken.png"));
		Image scaledAff = affect.getImage().getScaledInstance((int) Math.ceil(aspectRelX * affect.getIconWidth()), (int) Math.ceil(aspectRelY * affect.getIconHeight()), Image.SCALE_SMOOTH);

		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(scaledAff));

		int widthTotal = label.getIcon().getIconWidth() * affection;

		int newX = (((x + (width/ 2)) - (widthTotal / 2)));
		
		label.setIcon(affect);
		label.setBounds(newX + label.getIcon().getIconWidth() * i, (int) Math.ceil(aspectRelY * y), label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
		
		return label;
	}
	
	public void setCard1(Card card) {
		card1.setIcon(new ImageIcon(getClass().getResource(card.getCardImageName())));
		player.addCard(card);
		card1.setVisible(true);
	}
	
	public void setCard2(Card card) {
		card1.setIcon(new ImageIcon(getClass().getResource(card.getCardImageName())));
		player.addCard(card);
		card2.setVisible(true);
	}
	
	public Player getPlayer() {
		return player;
	}
}
