package view;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;

import jpanels.BoardPanel;
import jpanels.PlayerLabel;
import loveLetter.Match;
import loveLetter.Player;

public class MatchFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8952160177980476586L;
	private Dimension screenDim;
	private int aff;
	private List<Player>players;
	private BoardPanel board;
	
	public MatchFrame(List<Player>players, int aff) {
		
		this.aff = aff;
		this.players = players;
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenDim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
	
		setTitle("Love Letter");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/images/logo.png")));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(screenDim.width, screenDim.height);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new GameScreen(players.get(0)).setVisible(true);
				dispose();
			}
		});

		for(int i = 0; i < players.size(); i++) {
			
			PlayerLabel playerLabel = new PlayerLabel(i+1, players.size(), this, aff);
			
			players.get(i).setLabel(playerLabel);
	
			getContentPane().add(playerLabel);
		}
		
		board = new BoardPanel(this);
		getContentPane().add(board);

		setVisible(true);
		repaint();
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
	
}