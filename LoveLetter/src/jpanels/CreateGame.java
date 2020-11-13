package jpanels;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import loveLetter.Player;

public class CreateGame extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3492739264759917878L;
	private double aspectRelX;
	private double aspectRelY;
	private Dimension screenDim;
	private JFrame gameFrame;
	private JLabel backgroundLabel;
	private Player player;
	private LobbyPanel lobby;
	
	public CreateGame(JFrame gameFrame, Player player){
		
		this.gameFrame = gameFrame;
		this.player = player;
		
		screenDim = gameFrame.getSize();
		
		aspectRelX = (double)screenDim.width/1920;
		aspectRelY = (double)screenDim.height/1080;
	
		
		setSize(screenDim);
		setLayout(null);
		setBorder(null);
		
		addBackgroundLabel();
		addBackButton();
		addCreateButton();
		addJoinButton();
		
		add(backgroundLabel);
		
		setVisible(true);
		gameFrame.repaint();
	}
	
	private void addBackgroundLabel() {
		
		ImageIcon back = new ImageIcon(GameSelection.class.getResource("/images/create.png"));
		Image scaledBack = back.getImage().getScaledInstance((int)Math.ceil(aspectRelX*back.getIconWidth()), (int)Math.ceil(aspectRelY*back.getIconHeight()), Image.SCALE_SMOOTH);
		
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(scaledBack));
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
	}
	
	private void addBackButton() {
		ImageIcon backIcon = new ImageIcon(GameSelection.class.getResource("/images/createBack.png"));
		Image scaledBackIcon = backIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*backIcon.getIconWidth()), (int)Math.ceil(aspectRelY*backIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton backButton = new JButton();
		createButton(backButton);
		backButton.setIcon(new ImageIcon(scaledBackIcon));
		backButton.setBounds((int)Math.ceil(606*aspectRelX), (int)Math.ceil(262*aspectRelY), backButton.getIcon().getIconWidth(), backButton.getIcon().getIconHeight());
		backButton.setToolTipText("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Component comp : gameFrame.getContentPane().getComponents()) {
					gameFrame.remove(comp);
				}
				
				gameFrame.getContentPane().add(new GameSelection(gameFrame, player));
			}
		});
		add(backButton);
		
	}
	
	private void addCreateButton() {
		
		ImageIcon createIcon = new ImageIcon(GameSelection.class.getResource("/images/createGame.png"));
		Image scaledBackIcon = createIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*createIcon.getIconWidth()), (int)Math.ceil(aspectRelY*createIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton createButton = new JButton();
		createButton(createButton);
		createButton.setIcon(new ImageIcon(scaledBackIcon));
		createButton.setBounds((int)Math.ceil(798*aspectRelX), (int)Math.ceil(497*aspectRelY), createButton.getIcon().getIconWidth(), createButton.getIcon().getIconHeight());
		createButton.setToolTipText("Create");
		createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lobby = new LobbyPanel(gameFrame);
				joinLobby();
			}
		});
		add(createButton);
		
	}
	
	private void addJoinButton() {
		
		ImageIcon joinIcon = new ImageIcon(GameSelection.class.getResource("/images/joinGame.png"));
		Image scaledBackIcon = joinIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*joinIcon.getIconWidth()), (int)Math.ceil(aspectRelY*joinIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton joinButton = new JButton();
		createButton(joinButton);
		joinButton.setIcon(new ImageIcon(scaledBackIcon));
		joinButton.setBounds((int)Math.ceil(798*aspectRelX), (int)Math.ceil(595*aspectRelY), joinButton.getIcon().getIconWidth(), joinButton.getIcon().getIconHeight());
		joinButton.setToolTipText("Join");
		joinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				joinLobby();
			}
		});
		add(joinButton);
		
	}
	
	private void createButton(JButton button) {
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setIgnoreRepaint(true);
		button.setOpaque(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
	}
	
	public void joinLobby() {
		for (Component comp : gameFrame.getContentPane().getComponents()) {
			gameFrame.remove(comp);
		}
		
		lobby.addPlayer(player);
		gameFrame.getContentPane().add(lobby);
	}
	
}
