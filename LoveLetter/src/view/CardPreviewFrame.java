package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cards.Card;

public class CardPreviewFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4312502719334838350L;
	private DrawPanel drawPanel;
	private BufferedImage cardImage;
	private Card card;

	/**
	 * Create the frame.
	 */
	public CardPreviewFrame(Card card) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CardPreviewFrame.class.getResource("/images/login_main/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(500,500));
	
		this.card = card;
		setTitle(card.getName());
	}

	public void init() {
		
		try {
			cardImage = ImageIO.read(CardPreviewFrame.class.getResource(card.getCardImageName()));
			setSize(new Dimension(cardImage.getWidth()+16, cardImage.getHeight()+38));
			setLocationRelativeTo(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		drawPanel = new DrawPanel();
		getContentPane().add(drawPanel);
	}

	public void display() {
		drawPanel.repaint();
	}

	private class DrawPanel extends JPanel {

		private static final long serialVersionUID = 402497620181405758L;

		public DrawPanel() {
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

//			Dimension currentDimension = getRootPane().getSize();
//			g2.scale(currentDimension.getWidth() / WIDTH, currentDimension.getHeight() / HEIGHT);

			g2.drawImage(cardImage, null, 0, 0);

		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(WIDTH, HEIGHT);
		}
	}

}
