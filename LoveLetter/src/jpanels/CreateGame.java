package jpanels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.ScreenConstants;

public class CreateGame extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3492739264759917878L;
	
	public CreateGame(){

		setSize(ScreenConstants.width, ScreenConstants.height);
		setLayout(null);
		setBorder(null);
		
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
				joinLobby();
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
	
	public void joinLobby() {
		JFrame frame = (JFrame)getTopLevelAncestor();
		frame.getContentPane().removeAll();
		frame.getContentPane().add(new LobbyPanel());
		frame.repaint();
	}
	
}
