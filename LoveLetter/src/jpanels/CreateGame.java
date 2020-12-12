package jpanels;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.GameConstants;
import view.GameFrame;

public class CreateGame extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3492739264759917878L;
	private LobbyPanel lobby;
	
	public CreateGame(){

		setSize(GameConstants.screenSize);
		setLayout(null);
		setBorder(null);
		
		addCreated();
		addBackButton();
		addCreateButton();
		addJoinButton();
		addBackgroundLabel();
	}
	
	private void addBackgroundLabel() {
		
		JLabel backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ScaledIcon("/images/create.png").getScaledIcon());
		backgroundLabel.setSize(getSize());
		add(backgroundLabel);
	}
	
	private void addBackButton() {
		JButton backButton = new CreateButton("/images/createBack.png", 606, 262, null);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame)getTopLevelAncestor();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new GameSelection());
				frame.repaint();
			}
		});
		add(backButton);
		
	}
	
	private void addCreateButton() {
		JButton createButton = new CreateButton("/images/createGame.png", 794, 493, "/images/createGameOver.png");
		createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createLobby();
			}
		});
		add(createButton);
		
	}
	
	private void addJoinButton() {
		JButton joinButton = new CreateButton("/images/joinGame.png", 794, 591, "/images/joinGameOver.png");
		joinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				joinLobby();
			}
		});
		add(joinButton);
		
	}
	
	private void addCreated() {
		
		JLabel label = new JLabel();
		label.setIcon(new ScaledIcon("/images/lobbyCreated.png").getScaledIcon());
		label.setBounds(0, (int)Math.ceil(115 * GameConstants.aspectRelY), label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
		label.setVisible(false);
		add(new TextLabel(new Rectangle(75, 120, 127, 30), Color.yellow, 24));
		add(new TextLabel(new Rectangle(25, 150, 200, 30), Color.white, 20));
		add(label);
	}
	
	public void joinLobby() {
		
		if(lobby == null) {
			((JLabel)getComponent(0)).setText("Lobby");
			((JLabel)getComponent(1)).setText("Create Game First");
			getComponent(2).setVisible(true);
		} else {
			GameFrame frame = (GameFrame)getTopLevelAncestor();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(lobby);
			frame.repaint();
			
			lobby.addPlayer(frame.getPlayer());
		}
	}
	
	public void createLobby() {
		if(lobby == null) {
			lobby = new LobbyPanel();
			((JLabel)getComponent(0)).setText("Lobby");
			((JLabel)getComponent(1)).setText("Game created");
			getComponent(2).setVisible(true);
		}
		else {
			((JLabel)getComponent(0)).setText("Lobby");
			((JLabel)getComponent(1)).setText("Another Game Is Run");
			getComponent(2).setVisible(true);
		}
	}
}
