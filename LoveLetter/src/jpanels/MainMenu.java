package jpanels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.GameConstants;
import view.GameFrame;

public class MainMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8521929087087608231L;
	private JLabel background;
	
	public MainMenu(GameFrame gameFrame) {
		
		setSize(GameConstants.screenSize);
		setLayout(null);
		
		addPlayButton(gameFrame);		
		addShowCardsButton(gameFrame);
		addProfileButton();
		addStatsButton();
		addConfigButton();
		addExitButon();
		addBackground();
	}
	
	private void addBackground() {
		
		background = new JLabel();
		background.setIcon(new ScaledIcon("/images/main.png").getScaledIcon());
		background.setSize(getSize());
		
		add(background);
	}
	
	private void addShowCardsButton(GameFrame gameFrame) {
		
		JButton showCardsButton = new CreateButton("/images/mainCards.png", 748, 966, null);
		showCardsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame)getTopLevelAncestor();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new CardPickerPanel(gameFrame));
				frame.getContentPane().add(background);
				frame.repaint();
			}
		});
		add(showCardsButton);
	}
	
	private void addPlayButton(GameFrame gameFrame) {
		JButton playButton = new CreateButton("/images/mainPlay.png", 840, 746, "/images/mainPlayClicked.png");
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame)getTopLevelAncestor();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new GameSelection(gameFrame));
				frame.repaint();
			}
		});
		add(playButton);
	}
	
	private void addProfileButton() {
		JButton profileButton = new CreateButton("/images/mainProfile.png", 860, 966, null);

		add(profileButton);

	}	
	
	private void addStatsButton() {		
		JButton statsButton = new CreateButton("/images/mainStats.png", 969, 964, null);
		
		add(statsButton);
	}

	private void addConfigButton() {
		JButton configButton = new CreateButton("/images/mainConfig.png", 1083, 966, null);
		configButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				frame.add(new configPanel(this));
			}
		});
		add(configButton);
	} 
	
	private void addExitButon() {
		JButton exitButton = new CreateButton("/images/mainExit.png", 1726, 84, null);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTopLevelAncestor().dispatchEvent(new WindowEvent((JFrame)getTopLevelAncestor(), WindowEvent.WINDOW_CLOSING));
			}
		});
		add(exitButton);
	}
	
}
