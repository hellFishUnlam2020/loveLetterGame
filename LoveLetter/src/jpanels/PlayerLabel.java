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
import javax.swing.SwingConstants;

import cards.Card;
import view.MatchFrame;

public class PlayerLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8641985058062734814L;
	private Dimension screenDim;
	private double aspectRelX;
	private double aspectRelY;
	private MatchFrame frame;
	private Card cardSelected;
	
	public PlayerLabel(int nroPlayer, int tamTotal, MatchFrame frame) {

		this.frame = frame;
		screenDim = frame.getSize();

		aspectRelX = (double) screenDim.width / 1920;
		aspectRelY = (double) screenDim.height / 1080;

		ImageIcon p1 = new ImageIcon(getClass().getResource("/images/boardP" + nroPlayer + ".png"));
		Image scaledP1 = p1.getImage().getScaledInstance((int) Math.ceil(aspectRelX * p1.getIconWidth()), (int) Math.ceil(aspectRelY * p1.getIconHeight()), Image.SCALE_SMOOTH);

		setIcon(new ImageIcon(scaledP1));

		if (nroPlayer == 1) {
			setBounds((int) Math.ceil(361 * aspectRelX), (int) Math.ceil(810 * aspectRelY), getIcon().getIconWidth(), getIcon().getIconWidth());
		} else {
			JLabel name = new JLabel(frame.getPlayers().get(nroPlayer - 1).getName());
			name.setBounds(getX(), (int) Math.ceil(aspectRelX * 130), getWidth(), (int) Math.ceil(40 * aspectRelY));
			name.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
			name.setForeground(Color.white);
			name.setHorizontalAlignment(SwingConstants.CENTER);
			frame.getContentPane().add(name);
			
			setBounds(((screenDim.width / tamTotal) - getIcon().getIconWidth() / 2), (int) Math.ceil(40 * aspectRelY), getIcon().getIconWidth(), getIcon().getIconHeight());
		}
	}

	public void addCard(Card card, int i, int id) {

		ImageIcon cardIm = new ImageIcon(getClass().getResource(card.getCardImageName()));
		Image scaledCard = cardIm.getImage().getScaledInstance((int) Math.ceil(aspectRelX * cardIm.getIconWidth()), (int) Math.ceil(aspectRelY * cardIm.getIconHeight()), Image.SCALE_SMOOTH);

		JButton button = new JButton();
		button.setIcon(new ImageIcon(scaledCard));
		createCardButton(button);

		int y;
		if (id == 0)
			y = screenDim.height - button.getIcon().getIconHeight() - (int) Math.ceil(aspectRelX * 20);
		else
			y = (int) Math.ceil(aspectRelX * 20);

		button.setBounds((getX() + button.getIcon().getIconWidth()) + (button.getIcon().getIconWidth() / 2) * i, y, button.getIcon().getIconWidth(), button.getIcon().getIconHeight());
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cardSelected = card;
			}
		});
		frame.getContentPane().add(button);
		frame.getContentPane().setComponentZOrder(button, 0);
		frame.refresh();
	}

	public void createCardButton(JButton card) {
		
		card.setOpaque(false);
		card.setBorder(null);
		card.setContentAreaFilled(false);
		card.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}
	
	public Card getCardSelected() {
		return cardSelected;
	}
}
