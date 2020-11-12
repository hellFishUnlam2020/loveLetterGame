package view;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import loveLetter.Player;
import panels.LobbyPanel;

public class Lobby extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1222623036047932957L;
	private List<Player>players;
	private LobbyPanel lobbyPanel;
	
	public Lobby() {
		
		players = new ArrayList<Player>(4);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		Dimension screenDim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
		
		setTitle("Love Letter");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/images/logo.png")));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenDim.width, screenDim.height);
		setLocationRelativeTo(null);
		
		lobbyPanel = new LobbyPanel(this);
		getContentPane().add(lobbyPanel);
		setVisible(false);
	}

	public void addPlayer(Player newPlayer) {
		players.add(newPlayer);
		lobbyPanel.refresh();
	}
	
	public List<Player> getPlayers(){
		return players;
	}

}
