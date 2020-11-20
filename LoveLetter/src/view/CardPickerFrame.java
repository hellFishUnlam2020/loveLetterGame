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
import interfaces.ScreenConstants;
import jpanels.CardPickerLabel;
import jpanels.CreateButton;
import loveLetter.Deck;
import viewCommunication.CardElegible;

public class CardPickerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4486080160427752361L;
	private CardElegible cardEligile;
	
	public void setCardEligile(CardElegible cardEligile) {
		this.cardEligile = cardEligile;
	}

	/**
	 * Create the frame.
	 */
	public CardPickerFrame(){	
		
		setSize(ScreenConstants.width, ScreenConstants.width);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cartas");
		setIconImage(ScreenConstants.logo);
	    setBackground(new Color(0,0,0,90));

	    getContentPane().setLayout(null);
		getContentPane().add(new CardPickerLabel(new Deck().getCards()));
		
		setVisible(true);
	}
	
	public void cardElected(Card card) {
		cardEligile.cardElected(card);
		dispose();
	}
}