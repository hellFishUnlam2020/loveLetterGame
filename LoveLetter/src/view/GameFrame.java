package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import cards.Card;
import interfaces.GameConstants;
import jpanels.MainMenu;
import loveLetter.Player;

public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5428637329420503484L;
	private Player player;
	/**
	 * Create the application.
	 */
	public GameFrame(Player player) {
		this.player = player;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		setTitle("Love Letter");
		setIconImage(GameConstants.logo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GameConstants.width, GameConstants.height);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(new MainMenu(this));
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void cardElected(Card card) {
		CardPreviewFrame cardPreview = new CardPreviewFrame(card);
		cardPreview.init();
		cardPreview.setFocusable(true);
		cardPreview.requestFocusInWindow();
		cardPreview.setVisible(true);
	}
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new GameFrame(new Player("Nahuel")).setVisible(true);;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
