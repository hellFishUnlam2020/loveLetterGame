package jpanels;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.ScreenConstants;
import loveLetter.Player;
import view.GameScreen;

public class CreateGame extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3492739264759917878L;
	
	private GameScreen frame;
	private JLabel backgroundLabel;
	private Player player;
	private LobbyPanel lobby;
	private ImageIcon icon;
	private Image scaledIcon;
	
	public CreateGame(GameScreen frame, Player player){
		
		this.frame = frame;
		this.player = player;
		
		setSize(ScreenConstants.width, ScreenConstants.height);
		setLayout(null);
		setBorder(null);
		
		addBackgroundLabel();
		addBackButton();
		addCreateButton();
		addJoinButton();
		
		setComponentZOrder(backgroundLabel, getComponentCount()-1);
	}
	
	private void addBackgroundLabel() {
		
		icon = new ImageIcon(GameSelection.class.getResource("/images/create.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
		
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(scaledIcon));
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
		add(backgroundLabel);
	}
	
	private void addBackButton() {
		icon = new ImageIcon(GameSelection.class.getResource("/images/createBack.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton backButton = new CreateButton(new ImageIcon(scaledIcon), 606, 262);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.removeAll();
				frame.getContentPane().add(new GameSelection(frame, player));
			}
		});
		add(backButton);
		
	}
	
	private void addCreateButton() {
		
		icon = new ImageIcon(GameSelection.class.getResource("/images/createGame.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton createButton = new CreateButton(new ImageIcon(scaledIcon), 798, 497);
		createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				joinLobby();
			}
		});
		add(createButton);
		
	}
	
	private void addJoinButton() {
		
		icon = new ImageIcon(GameSelection.class.getResource("/images/joinGame.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton joinButton = new CreateButton(new ImageIcon(scaledIcon), 798, 595);
		joinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				joinLobby();
			}
		});
		add(joinButton);
		
	}
	
	public void joinLobby() {
		
		lobby = new LobbyPanel(frame);
		lobby.addPlayer(player);
		frame.removeAll();
		frame.getContentPane().add(lobby);
	}
	
}
