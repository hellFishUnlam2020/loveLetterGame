package jpanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import interfaces.ScreenConstants;
import view.GameScreen;

public class CreateGame extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3492739264759917878L;
	private LobbyPanel lobby;
	
	public CreateGame(){

		setSize(ScreenConstants.width, ScreenConstants.height);
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
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
		add(backgroundLabel);
	}
	
	private void addBackButton() {
		JButton backButton = new CreateButton(new ScaledIcon("/images/createBack.png").getScaledIcon(), 606, 262);
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
		JButton createButton = new CreateButton(new ScaledIcon("/images/createGame.png").getScaledIcon(), 798, 497);
		createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createLobby();
			}
		});
		add(createButton);
		
	}
	
	private void addJoinButton() {
		JButton joinButton = new CreateButton(new ScaledIcon("/images/joinGame.png").getScaledIcon(), 798, 595);
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
		label.setBounds(0, (int)Math.ceil(115 * ScreenConstants.aspectRelY), label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
		label.setVisible(false);
		add(new TextLabel(new Rectangle(75, 120, 127, 30), Color.yellow, 24));
		add(new TextLabel(new Rectangle(25, 150, 200, 30), Color.white, 20));
		add(label);
	}
	
	public void joinLobby() {
		
		GameScreen frame = (GameScreen)getTopLevelAncestor();
		frame.getContentPane().removeAll();
		frame.getContentPane().add(lobby);
		frame.repaint();
		
		lobby.addPlayer(frame.getPlayer());
	}
	
	public void createLobby() {
		lobby = new LobbyPanel();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((JLabel)getComponent(0)).setText("Lobby");
		((JLabel)getComponent(1)).setText("Game created");
		getComponent(2).setVisible(true);
	}
}
