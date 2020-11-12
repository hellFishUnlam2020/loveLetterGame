package jpanels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import loveLetter.Match;
import loveLetter.Player;
import view.GameScreen;

public class LobbyPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2816319407817472061L;
	private JLabel backgroundLabel;
	private double aspectRelX;
	private double aspectRelY;
	private Dimension screenDim;
	private JFrame frame;
	private JButton invalidButton;
	private JButton validButton;
	private List<Player>players;
	
	public LobbyPanel(JFrame gameFrame) {
		
		this.frame = gameFrame;
		players = new ArrayList<Player>(3);
		screenDim = frame.getSize();
		
		aspectRelX = (double)screenDim.width/1920;
		aspectRelY = (double)screenDim.height/1080;
	
		setSize(screenDim);
		setLayout(null);
		setBorder(null);
		
		addBackgroundLabel();
		addInvalidStart();
		addValidStart();
		addBackButton();
		addConfigButton();
		addPlayer(1254, 530);
		addPlayer(1254, 624);
		addPlayer(1254, 718);
		setComponentZOrder(backgroundLabel, getComponentCount()-1);
		
		frame.repaint();
	}
	
	private void addBackgroundLabel() {
		
		ImageIcon back = new ImageIcon(GameSelection.class.getResource("/images/lobby/emptyLobby.png"));
		Image scaledBack = back.getImage().getScaledInstance((int)Math.ceil(aspectRelX*back.getIconWidth()), (int)Math.ceil(aspectRelY*back.getIconHeight()), Image.SCALE_SMOOTH);
		
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(scaledBack));
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
		add(backgroundLabel);
	}
	
	private void addInvalidStart() {
		ImageIcon invalidStar = new ImageIcon(GameSelection.class.getResource("/images/lobby/invalidStart.png"));
		Image scaledInvalid = invalidStar.getImage().getScaledInstance((int)Math.ceil(aspectRelX*invalidStar.getIconWidth()), (int)Math.ceil(aspectRelY*invalidStar.getIconHeight()), Image.SCALE_SMOOTH);
		
		invalidButton = new JButton();
		createButton(invalidButton);
		invalidButton.setIcon(new ImageIcon(scaledInvalid));
		invalidButton.setBounds((int)Math.ceil(860*aspectRelX), (int)Math.floor(820*aspectRelY), invalidButton.getIcon().getIconWidth(),invalidButton.getIcon().getIconHeight());
		invalidButton.setToolTipText("Invalid");
		add(invalidButton);
	}
	
	private void addValidStart() {
		ImageIcon validStar = new ImageIcon(GameSelection.class.getResource("/images/lobby/validStart.png"));
		Image scaledValid = validStar.getImage().getScaledInstance((int)Math.ceil(aspectRelX*validStar.getIconWidth()), (int)Math.ceil(aspectRelY*validStar.getIconHeight()), Image.SCALE_SMOOTH);
		
		validButton = new JButton();
		createButton(validButton);
		validButton.setIcon(new ImageIcon(scaledValid));
		validButton.setBounds((int)Math.ceil(860*aspectRelX), (int)Math.floor(820*aspectRelY), validButton.getIcon().getIconWidth(),validButton.getIcon().getIconHeight());
		validButton.setToolTipText("Valid");
		validButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Match(players, 5);
			}
		});
		add(validButton);
	}
	
	private void addBackButton() {
		
		ImageIcon backIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/back.png"));
		Image scaledBackIcon = backIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*backIcon.getIconWidth()), (int)Math.ceil(aspectRelY*backIcon.getIconHeight()), Image.SCALE_SMOOTH);
		
		JButton backButton = new JButton();
		createButton(backButton);
		backButton.setIcon(new ImageIcon(scaledBackIcon));
		backButton.setBounds((int)Math.ceil(606*aspectRelX), (int)Math.ceil(262*aspectRelY), backButton.getIcon().getIconWidth(), backButton.getIcon().getIconHeight());
		backButton.setToolTipText("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GameScreen(players.get(0)).setVisible(true);;
				frame.dispose();
			}
		});
		add(backButton);	
	}
	
	private void addConfigButton() {
		
		ImageIcon configIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/config.png"));
		Image scaledConfigIcon = configIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*configIcon.getIconWidth()), (int)Math.ceil(aspectRelY*configIcon.getIconHeight()), Image.SCALE_SMOOTH);
		
		JButton configButton = new JButton();
		createButton(configButton);
		configButton.setIcon(new ImageIcon(scaledConfigIcon));
		configButton.setBounds((int)Math.ceil(1254*aspectRelX), (int)Math.ceil(268*aspectRelY), configButton.getIcon().getIconWidth(), configButton.getIcon().getIconHeight());
		configButton.setToolTipText("Back");
		configButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
		add(configButton);	
	}
	
	private void addPlayer(int x, int y) {
		
		String[]nombres = {"Matias", "Nicolas", "Esteban"};
		ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/gameMode/back.png"));
		Image scaledBackIcon = backIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*backIcon.getIconWidth()), (int)Math.ceil(aspectRelY*backIcon.getIconHeight()), Image.SCALE_SMOOTH);
	
		JButton addButton = new JButton();
		createButton(addButton);
		addButton.setIcon(new ImageIcon(scaledBackIcon));
		addButton.setBounds((int)Math.ceil(x*aspectRelX), (int)Math.ceil(y*aspectRelY), addButton.getIcon().getIconWidth(), addButton.getIcon().getIconHeight());
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addPlayer(new Player(nombres[players.size()-1]));
			}
		});
		add(addButton);
	}
	
	private void createButton(JButton button) {
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setIgnoreRepaint(true);
		button.setOpaque(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
	}
	
	private void add1stPlayer() {
										
		ImageIcon im1 = new ImageIcon(LobbyPanel.class.getResource("/images/lobby/player1.png"));
		Image scaled1 = im1.getImage().getScaledInstance((int)Math.ceil(aspectRelX*im1.getIconWidth()), (int)Math.ceil(aspectRelY*im1.getIconHeight()), Image.SCALE_SMOOTH);
		
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(scaled1));
		backLabel.setBounds((int)Math.ceil(759*aspectRelX), (int)Math.ceil(412*aspectRelY), backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		
		JLabel nombreLabel = new JLabel(players.get(0).getName());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		nombreLabel.setForeground(Color.black);
		nombreLabel.setBounds((int)Math.ceil(858*aspectRelX), (int)Math.ceil(436*aspectRelY), (int)Math.ceil(288*aspectRelY), (int)Math.ceil(37*aspectRelY));
		
		add(nombreLabel);
		add(backLabel);
		
	}
	
	private void add2ndPlayer() {
	
		ImageIcon im2 = new ImageIcon(LobbyPanel.class.getResource("/images/lobby/player2.png"));
		Image scaled2 = im2.getImage().getScaledInstance((int)Math.ceil(aspectRelX*im2.getIconWidth()), (int)Math.ceil(aspectRelY*im2.getIconHeight()), Image.SCALE_SMOOTH);
		
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(scaled2));
		backLabel.setBounds((int)Math.ceil(759*aspectRelX), (int)Math.ceil(506*aspectRelY), backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		
		JLabel nombreLabel = new JLabel(players.get(1).getName());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		nombreLabel.setForeground(Color.black);
		nombreLabel.setBounds((int)Math.ceil(858*aspectRelX), (int)Math.ceil(530*aspectRelY), (int)Math.ceil(288*aspectRelY), (int)Math.ceil(37*aspectRelY));
		
		add(nombreLabel);
		add(backLabel);
		
		validButton.setVisible(true);
		invalidButton.setVisible(false);
	}
	
	private void add3rdPlayer() {
		
		ImageIcon im3 = new ImageIcon(LobbyPanel.class.getResource("/images/lobby/player3.png"));
		Image scaled3 = im3.getImage().getScaledInstance((int)Math.ceil(aspectRelX*im3.getIconWidth()), (int)Math.ceil(aspectRelY*im3.getIconHeight()), Image.SCALE_SMOOTH);
		
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(scaled3));
		backLabel.setBounds((int)Math.ceil(759*aspectRelX), (int)Math.ceil(600*aspectRelY), backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
			
		JLabel nombreLabel = new JLabel(players.get(2).getName());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		nombreLabel.setForeground(Color.black);
		nombreLabel.setBounds((int)Math.ceil(858*aspectRelX), (int)Math.ceil(624*aspectRelY), (int)Math.ceil(288*aspectRelY), (int)Math.ceil(37*aspectRelY));
	
		add(nombreLabel);
		add(backLabel);
	}
	
	private void add4thPlayer() {

		ImageIcon im2 = new ImageIcon(LobbyPanel.class.getResource("/images/lobby/player4.png"));
		Image scaled2 = im2.getImage().getScaledInstance((int)Math.ceil(aspectRelX*im2.getIconWidth()), (int)Math.ceil(aspectRelY*im2.getIconHeight()), Image.SCALE_SMOOTH);
		
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(scaled2));
		backLabel.setBounds((int)Math.ceil(759*aspectRelX), (int)Math.ceil(694*aspectRelY), backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		
		
		JLabel nombreLabel = new JLabel(players.get(3).getName());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 20));
		nombreLabel.setForeground(Color.black);
		nombreLabel.setBounds((int)Math.ceil(858*aspectRelX), (int)Math.ceil(718*aspectRelY), (int)Math.ceil(288*aspectRelY), (int)Math.ceil(37*aspectRelY));
		
		add(nombreLabel);
		add(backLabel);
	}
	
	public void refresh() {
		switch (players.size()) {
		case 1:
			add1stPlayer();
			break;
		case 2:
			add2ndPlayer();
			break;
		case 3:
			add3rdPlayer();
			break;
		case 4:
			add4thPlayer();
			break;
		}
		setComponentZOrder(backgroundLabel, getComponentCount()-1);
		repaint();
		frame.repaint();
	}
	
	public void addPlayer(Player newPlayer) {
		players.add(newPlayer);
		refresh();
	}
	
	public List<Player> getPlayers(){
		return players;
	}
}
