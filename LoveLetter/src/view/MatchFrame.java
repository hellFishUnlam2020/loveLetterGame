package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import interfaces.GameConstants;
import jpanels.BoardPanel;
import jpanels.PlayerPanel;
import loveLetter.Match;
import loveLetter.Player;

public class MatchFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8952160177980476586L;
	private int aff;
	private List<Player>players;
	
	public MatchFrame(List<Player>players, int aff) {
		
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

		for(int i = 0; i < players.size(); i++) {
			PlayerPanel playerLabel = new PlayerPanel(players.get(i), i+1, players.size(), aff);
			players.get(i).setLabel(playerLabel);
			getContentPane().add(playerLabel);
		}
		getContentPane().add(new BoardPanel());
		
		setVisible(true);
		
		Match match = new Match(players, 5, this);
		match.setName("Match");
		match.start();
		
	}
	
	public List<Player> getPlayers(){
		return players;
	}
	
	public int getAff() {
		return aff;
	}
	
	public static void main(String[] args) {
		ArrayList<Player>players = new ArrayList<Player>();
		
		players.add(new Player("Nahuel"));
		players.add(new Player("Esteban"));
		players.add(new Player("Gabriel"));
		players.add(new Player("Mauro"));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MatchFrame(players, 5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}