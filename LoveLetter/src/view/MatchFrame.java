package view;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
	private double aspectRelX;
	private double aspectRelY;
	private int aff;
	private List<Player>players;
	private BoardPanel board;
	
	public MatchFrame(List<Player>players, int aff) {
		
		this.aff = aff;
		this.players = players;
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenDim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
	
		aspectRelX = (double) screenDim.width / 1920;
		aspectRelY = (double) screenDim.height / 1080;
	
		setTitle("Love Letter");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/images/logo.png")));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(screenDim.width, screenDim.height);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		for(int i = 0; i < players.size(); i++) {
			
			PlayerLabel playerLabel = new PlayerLabel(i+1, players.size(), this);
			players.get(i).setLabel(playerLabel);
			
			addAffection(playerLabel.getX(), playerLabel.getWidth(), i);
			getContentPane().add(playerLabel);
		}
		
		board = new BoardPanel(this);
		getContentPane().add(board);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				new Match(players, 5).start();
				repaint();
			}
		});
		
		repaint();
	}
	
	private void addAffection(int x, int width, int nro) {
		
		ImageIcon affect = new ImageIcon(getClass().getResource("/images/boardToken.png"));
		Image scaledAff = affect.getImage().getScaledInstance((int) Math.ceil(aspectRelX * affect.getIconWidth()), (int) Math.ceil(aspectRelY * affect.getIconHeight()), Image.SCALE_SMOOTH);

		affect = new ImageIcon(scaledAff);
		
		int widthTotal = affect.getIconWidth() * aff;
		int newX = (((x + (width / 2)) - (widthTotal / 2)));
		
		for(int i = 0; i < aff; i++) {
			JLabel token = new JLabel();
			token.setIcon(affect);
			int y;
			if(nro == 0)
				y = 943;
			else
				y = 170;
			
			token.setBounds(newX + token.getIcon().getIconWidth() * i, (int) Math.ceil(y * aspectRelY), token.getIcon().getIconWidth(), token.getIcon().getIconHeight());
			getContentPane().add(token);
		}
	}
	
	public void refresh() {
		repaint();
	}
	
	public List<Player> getPlayers(){
		return players;
	}
	
	public int getAff() {
		return aff;
	}
}