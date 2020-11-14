package jpanels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cards.Card;
import view.MatchFrame;

public class PlayerLabel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8641985058062734814L;
	private Dimension screenDim;
	private double aspectRelX;
	private double aspectRelY;
	
	private Card cardSelected;
	private int nCardSelected;
	
	private JLabel label;
	private JButton card1;
	private JButton card2;
	private MatchFrame frame;
	private JLabel protegido;
	public PlayerLabel(int nroPlayer, int tamTotal, MatchFrame frame, int aff) {
		
		this.frame = frame;
		
		screenDim = frame.getSize();

		aspectRelX = (double) screenDim.width / 1920;
		aspectRelY = (double) screenDim.height / 1080;

		ImageIcon p1 = new ImageIcon(getClass().getResource("/images/boardP" + nroPlayer + ".png"));
		Image scaledP1 = p1.getImage().getScaledInstance((int) Math.ceil(aspectRelX * p1.getIconWidth()), (int) Math.ceil(aspectRelY * p1.getIconHeight()), Image.SCALE_SMOOTH);

		setOpaque(false);
		setLayout(null);
		setSize(screenDim);
		
		label = new JLabel();
		label.setIcon(new ImageIcon(scaledP1));
		
		protegido = new JLabel();
		protegido.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
		protegido.setForeground(Color.white);
		protegido.setHorizontalAlignment(SwingConstants.CENTER);
		protegido.setVisible(false);
		
		if (nroPlayer == 1) {
			
			label.setBounds((int) Math.ceil(aspectRelX * 361), (int) Math.ceil(aspectRelY * 902), (int) Math.ceil(aspectRelX * 350), (int) Math.ceil(168 * aspectRelY));
			protegido.setSize(label.getWidth()/2, (int) Math.ceil(aspectRelX * 40));
			protegido.setLocation((label.getX() + label.getWidth()/2) -protegido.getWidth()/2, (int) Math.ceil(aspectRelY * 870));
			
		} else {
			label.setBounds(((screenDim.width / tamTotal) - label.getIcon().getIconWidth() / 2), (int) Math.ceil(40 * aspectRelY), label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
			
			JLabel name = new JLabel(frame.getPlayers().get(nroPlayer - 1).getName());
			name.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
			name.setForeground(Color.white);
			name.setHorizontalAlignment(SwingConstants.CENTER);
			
			name.setSize(label.getWidth()/2, (int) Math.ceil(aspectRelX * 40));
			name.setLocation((label.getX()+label.getWidth()/2)-name.getWidth()/2, (int) Math.ceil(aspectRelX * 130));
			
			protegido.setSize(label.getWidth()/2, (int) Math.ceil(aspectRelX * 40));
			protegido.setLocation((label.getX()+label.getWidth()/2)-name.getWidth()/2, (int) Math.ceil(aspectRelX * 200));
			
			add(name);
			
		}
		
		add(protegido);
		addAffection(nroPlayer, aff);
		add( (card1 = createCardButton(0, nroPlayer)) );
		add( (card2 = createCardButton(1, nroPlayer)) );
		
		add(label);
	}
	
	public void setCard(Card card) {
		
		ImageIcon cardIm = new ImageIcon(getClass().getResource(card.getCardImageName()));
		Image scaledCard = cardIm.getImage().getScaledInstance((int) Math.ceil(aspectRelX * cardIm.getIconWidth()), (int) Math.ceil(aspectRelY * cardIm.getIconHeight()), Image.SCALE_SMOOTH);
		
		if(card1.getIcon() == null) {
			card1.setIcon(new ImageIcon(scaledCard));
			card1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cardSelected = card;
					nCardSelected = 0;
				}
			});
		}
		else {
			card2.setIcon(new ImageIcon(scaledCard));
			card2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cardSelected = card;
					nCardSelected = 1;
				}
			});
		}
		frame.repaint();
	}

	public JButton createCardButton(int i, int id) {
		
		JButton card = new JButton();
		card.setCursor(new Cursor(Cursor.HAND_CURSOR));
		card.setContentAreaFilled(false);
		card.setBorder(null);
		card.setOpaque(false);
		card.setVisible(false);
		
		int y = 0;
		
		if (id == 1)
			y = screenDim.height - (int) Math.ceil(aspectRelX * 321);
		
		card.setBounds((label.getX() + label.getWidth() + (int) Math.ceil(aspectRelX * 297)*i) , y, (int) Math.ceil(aspectRelX * 297), (int) Math.ceil(aspectRelX * 321));
		return card;
	}
	
	private void addAffection(int nro, int aff) {
		
		ImageIcon affect = new ImageIcon(getClass().getResource("/images/boardToken.png"));
		Image scaledAff = affect.getImage().getScaledInstance((int) Math.ceil(aspectRelX * affect.getIconWidth()), (int) Math.ceil(aspectRelY * affect.getIconHeight()), Image.SCALE_SMOOTH);

		affect = new ImageIcon(scaledAff);
		
		int widthTotal = affect.getIconWidth() * aff;
		
		int x;
		
		if(nro == 1) {
			x = (int) Math.ceil(aspectRelX * 350);
		} else {
			x = (int) Math.ceil(aspectRelX * 780);
		}
		x += ( ((int) Math.ceil(aspectRelX * 350) / 2) - (widthTotal / 2) );
		
		for(int i = 0; i < aff; i++) {
			JLabel token = new JLabel();
			token.setIcon(affect);
			int y;
			if(nro == 1)
				y = 943;
			else
				y = 170;
			
			token.setBounds(x + token.getIcon().getIconWidth() * i, (int) Math.ceil(y * aspectRelY), token.getIcon().getIconWidth(), token.getIcon().getIconHeight());
			add(token);
		}
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
		protegido.setText(text);
		protegido.setVisible(val);
	}
}
