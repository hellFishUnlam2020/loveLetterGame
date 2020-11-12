package view;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;

import jpanels.BoardPanel;
import loveLetter.Match;
import loveLetter.Player;

public class MatchFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8952160177980476586L;
	private Match match;
	private Dimension screenDim;
	
	public MatchFrame(List<Player>players) {
		
		match = new Match(players, 5);
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenDim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
	
		setTitle("Love Letter");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/images/logo.png")));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(screenDim.width, screenDim.height);
		setLocationRelativeTo(null);
		
		getContentPane().add(new BoardPanel(this, match));
	}
}