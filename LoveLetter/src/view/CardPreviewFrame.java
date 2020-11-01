package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cards.Card;

public class CardPreviewFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4312502719334838350L;
	private JPanel contentPane;
	DrawPanel drawPanel;	
	private BufferedImage cardImage;
	private Card card;

	/**
	 * Create the frame.
	 */
	public CardPreviewFrame(Card card) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.card = card;
		
		this.setTitle(card.getName());
	}
	
	public void init() {
		try {
			cardImage = ImageIO.read(new File(card.getCardImageName()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		drawPanel = new DrawPanel();
		contentPane.add(drawPanel);
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
