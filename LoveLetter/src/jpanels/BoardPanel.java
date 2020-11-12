package jpanels;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import loveLetter.Match;
import view.MatchFrame;

public class BoardPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 982821929971812735L;

	private MatchFrame frame;
	private Match match;
	private double aspectRelX;
	private double aspectRelY;
	private Dimension screenDim;
	private JLabel backgroundLabel;
	
	public BoardPanel(MatchFrame frame, Match match) {
	
		this.frame = frame;
		this.match = match;
				
		screenDim = frame.getSize();
		
		aspectRelX = (double)screenDim.width/1920;
		aspectRelY = (double)screenDim.height/1080;
	
		
		setSize(screenDim);
		setLayout(null);
		setBorder(null);
		
		addBackgroundLabel();
		
		setComponentZOrder(backgroundLabel, getComponentCount()-1);
		setVisible(true);
		frame.repaint();
	}
	
	public void addBackgroundLabel() {
		
		ImageIcon back = new ImageIcon(getClass().getResource("/images/game/board.png"));
		Image scaledBack = back.getImage().getScaledInstance((int)Math.ceil(aspectRelX*back.getIconWidth()), (int)Math.ceil(aspectRelY*back.getIconHeight()), Image.SCALE_SMOOTH);
		
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(scaledBack));
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
		
		add(backgroundLabel);
	}
	
	public void addPlayer1() {
		
	}
	
	public void add2Players() {
		
	}
	
	public void add3Players() {
		
	}
	
	public void add4Players() {
		
	}
	
	public void setUp() {
		switch (match.getPlayers().size()) {
		case 2:
			add2Players();
			break;
		case 3:
			add3Players();
			break;
		case 4:
			add4Players();
			break;
		}
	}
}
