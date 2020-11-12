package panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.Lobby;

public class LobbyPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2816319407817472061L;
	private JLabel backgroundLabel;
	private double aspectRelX;
	private double aspectRelY;
	private Dimension screenDim;
	private Lobby frame;
	private JPanel playersPanel;
	private JButton invalidButton;
	private JButton validButton;
	
	public LobbyPanel(Lobby frame) {
		
		this.frame = frame;
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
		
		playersPanel = new JPanel();
		add(backgroundLabel);
		frame.repaint();
		
	}
	
	private void addBackgroundLabel() {
		
		ImageIcon back = new ImageIcon(GameSelection.class.getResource("/images/lobby/emptyLobby.png"));
		Image scaledBack = back.getImage().getScaledInstance((int)Math.ceil(aspectRelX*back.getIconWidth()), (int)Math.ceil(aspectRelY*back.getIconHeight()), Image.SCALE_SMOOTH);
		
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(scaledBack));
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
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
				//TODO
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
//				frame.returnFrame();
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
		
		playersPanel.add(backLabel);
		
		JLabel nombreLabel = new JLabel(frame.getPlayers().get(0).getName());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setVerticalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		nombreLabel.setForeground(Color.black);
		nombreLabel.setBounds((int)Math.ceil(858*aspectRelX), (int)Math.ceil(436*aspectRelY), (int)Math.ceil(288*aspectRelY), (int)Math.ceil(37*aspectRelY));
		playersPanel.add(nombreLabel);
		
		frame.add(playersPanel);
		frame.repaint();
	}
	
	private void add2ndPlayer() {
		
		ImageIcon im2 = new ImageIcon(LobbyPanel.class.getResource("/images/lobby/player2.png"));
		Image scaled2 = im2.getImage().getScaledInstance((int)Math.ceil(aspectRelX*im2.getIconWidth()), (int)Math.ceil(aspectRelY*im2.getIconHeight()), Image.SCALE_SMOOTH);
		
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(scaled2));
		backLabel.setBounds((int)Math.ceil(759*aspectRelX), (int)Math.ceil(506*aspectRelY), backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		
		playersPanel.add(backLabel);
		
		JLabel nombreLabel = new JLabel(frame.getPlayers().get(1).getName());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setVerticalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		nombreLabel.setForeground(Color.black);
		nombreLabel.setBounds((int)Math.ceil(858*aspectRelX), (int)Math.ceil(530*aspectRelY), (int)Math.ceil(288*aspectRelY), (int)Math.ceil(37*aspectRelY));
		playersPanel.add(nombreLabel);
		
		frame.add(playersPanel);
		
		validButton.setVisible(true);
		invalidButton.setVisible(false);
		
		frame.repaint();
	}
	
	private void add3rdPlayer() {
		
		ImageIcon im3 = new ImageIcon(LobbyPanel.class.getResource("/images/lobby/player3.png"));
		Image scaled3 = im3.getImage().getScaledInstance((int)Math.ceil(aspectRelX*im3.getIconWidth()), (int)Math.ceil(aspectRelY*im3.getIconHeight()), Image.SCALE_SMOOTH);
		
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(scaled3));
		backLabel.setBounds((int)Math.ceil(759*aspectRelX), (int)Math.ceil(506*aspectRelY), backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		
		playersPanel.add(backLabel);
		
		JLabel nombreLabel = new JLabel(frame.getPlayers().get(2).getName());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setVerticalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		nombreLabel.setForeground(Color.black);
		nombreLabel.setBounds((int)Math.ceil(858*aspectRelX), (int)Math.ceil(530*aspectRelY), (int)Math.ceil(288*aspectRelY), (int)Math.ceil(37*aspectRelY));
		playersPanel.add(nombreLabel);
		
		frame.add(playersPanel);
		frame.repaint();
	}
	
	private void add4thPlayer() {
		
		ImageIcon im2 = new ImageIcon(LobbyPanel.class.getResource("/images/lobby/player3.png"));
		Image scaled2 = im2.getImage().getScaledInstance((int)Math.ceil(aspectRelX*im2.getIconWidth()), (int)Math.ceil(aspectRelY*im2.getIconHeight()), Image.SCALE_SMOOTH);
		
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(scaled2));
		backLabel.setBounds((int)Math.ceil(759*aspectRelX), (int)Math.ceil(506*aspectRelY), backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		
		playersPanel.add(backLabel);
		
		JLabel nombreLabel = new JLabel(frame.getPlayers().get(3).getName());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setVerticalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		nombreLabel.setForeground(Color.black);
		nombreLabel.setBounds((int)Math.ceil(858*aspectRelX), (int)Math.ceil(530*aspectRelY), (int)Math.ceil(288*aspectRelY), (int)Math.ceil(37*aspectRelY));
		playersPanel.add(nombreLabel);
		
		frame.add(playersPanel);
		frame.repaint();
	}
	
	public void refresh() {
		switch (frame.getPlayers().size()) {
		case 0:
			add1stPlayer();
			break;
		case 1:
			add2ndPlayer();
			break;
		case 2:
			add3rdPlayer();
			break;
		case 3:
			add4thPlayer();
			break;
		default:
			break;
		}
	}
}
