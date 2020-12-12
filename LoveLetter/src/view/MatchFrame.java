package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import interfaces.GameConstants;
import jpanels.BoardPanel;
import jpanels.PlayerPanel;
import jpanels.TextLabel;
import loveLetter.Match;
import loveLetter.Player;

public class MatchFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8952160177980476586L;
	private int aff;
	private List<Player>players;
	private TextLabel pickPlayer;
	
	public MatchFrame(List<Player>players, int aff, GameFrame gameFrame) {
		
		this.aff = aff;
		this.players = players;
	
		setTitle("Love Letter");
		setIconImage(GameConstants.logo);
		setSize(GameConstants.screenSize);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				new GameFrame(players.get(0)).setVisible(true);
//				dispose();
//			}
//		});

		pickPlayer = new TextLabel(new Rectangle(getWidth()/2-100, getHeight()/2+20, 700,40), Color.black, 40f);
		pickPlayer.setText("Pick a Player By Clicking her name");
		pickPlayer.setVisible(false);
		
		add(pickPlayer);
		
		for(int i = 0; i < players.size(); i++) {
			PlayerPanel playerLabel = new PlayerPanel(players.get(i), i+1, players.size(), aff);
			players.get(i).setLabel(playerLabel);
			getContentPane().add(playerLabel);
		}
		getContentPane().add(new BoardPanel());
		
		setVisible(true);
		
		Match match = new Match(players, 5, this, gameFrame);
		match.setName("Match");
		match.start();
		
	}
	
	public void setPickPlayer(boolean val) {
		pickPlayer.setVisible(val);
	}
	public List<Player> getPlayers(){
		return players;
	}
	
	public int getAff() {
		return aff;
	}
	
	public static void main(String[] args) {
//		ArrayList<Player>players = new ArrayList<Player>();
//		
//		players.add(new Player("Nahuel"));
//		players.add(new Player("Esteban"));
//		players.add(new Player("Gabriel"));
//		players.add(new Player("Mauro"));
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new MatchFrame(players, 5);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}
}