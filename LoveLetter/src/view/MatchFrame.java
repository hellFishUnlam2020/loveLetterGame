package view;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import jpanels.BoardPanel;
import jpanels.PlayerPanel;
import loveLetter.Player;

public class MatchFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8952160177980476586L;
	private Dimension screenDim;
	private ArrayList<PlayerPanel> panels = new ArrayList<PlayerPanel>(3);
	
	public MatchFrame(List<Player>players, int aff) {
			
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
		
		for (int i = 0; i < players.size(); i++) {
			panels.add(new PlayerPanel(players.get(i), i, aff, this));
			getContentPane().add(panels.get(i));
		}
		
		getContentPane().add(new BoardPanel(this));
	}
	
}