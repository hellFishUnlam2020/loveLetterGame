package jpanels;

import java.awt.Color;
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

import interfaces.ScreenConstants;
import loveLetter.Player;
import view.MatchFrame;

public class LobbyPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2816319407817472061L;
	
	private JButton invalidButton;
	private JButton validButton;
	private JLabel backgroundLabel;
	private List<Player>players;
	
	public LobbyPanel() {
		
		players = new ArrayList<Player>(3);
		
		setSize(ScreenConstants.width, ScreenConstants.height);
		setLayout(null);
		setBorder(null);
		
		addInvalidStart();
		addValidStart();
		addBackButton();
		addConfigButton();
		addPlayer(1254, 530);
		addBackgroundLabel();
	}
	
	private void addBackgroundLabel() {
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ScaledIcon("/images/lobby.png").getScaledIcon());
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
		add(backgroundLabel);
	}
	
	private void addInvalidStart() {
		invalidButton = new CreateButton(new ScaledIcon("/images/lobbyinvalid.png").getScaledIcon(), 860, 820);
		add(invalidButton);
	}
	
	private void addValidStart() {
		validButton = new CreateButton(new ScaledIcon("/images/lobbyValid.png").getScaledIcon(), 860, 820);
		validButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MatchFrame(players, 5);
				((JFrame)getTopLevelAncestor()).dispose();
			}
		});
		add(validButton);
	}
	
	private void addBackButton() {
		JButton backButton = new CreateButton(new ScaledIcon("/images/back.png").getScaledIcon(), 606, 262);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame)getTopLevelAncestor();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new CreateGame());
				frame.repaint();
			}
		});
		add(backButton);	
	}
	
	private void addConfigButton() {
		JButton configButton = new CreateButton(new ScaledIcon("/images/config2.png").getScaledIcon(), 1254, 268);
		configButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
		add(configButton);	
	}
	
	private void addPlayer(int x, int y) {
		String nombre = "Matias";
		
		JButton addButton = new CreateButton(new ScaledIcon("/images/back.png").getScaledIcon(), x, y);
		addButton.setText(nombre);
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addPlayer(new Player(nombre));
			}
		});
		add(addButton);
	}
	
	private void add1stPlayer() {
										
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ScaledIcon("/images/lobbyP1.png").getScaledIcon());
		backLabel.setBounds((int)Math.ceil(759*ScreenConstants.aspectRelX), (int)Math.ceil(412*ScreenConstants.aspectRelY), backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		
		JLabel nombreLabel = new JLabel(players.get(0).getName());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		nombreLabel.setForeground(Color.black);
		nombreLabel.setBounds((int)Math.ceil(858*ScreenConstants.aspectRelX), (int)Math.ceil(436*ScreenConstants.aspectRelY), (int)Math.ceil(288*ScreenConstants.aspectRelY), (int)Math.ceil(37*ScreenConstants.aspectRelY));
		
		add(nombreLabel);
		add(backLabel);
		
	}
	
	private void add2ndPlayer() {
		
		ImageIcon im2 = new ImageIcon(LobbyPanel.class.getResource("/images/lobbyP2.png"));
		Image scaled2 = im2.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*im2.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*im2.getIconHeight()), Image.SCALE_SMOOTH);
		
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(scaled2));
		backLabel.setBounds((int)Math.ceil(759*ScreenConstants.aspectRelX), (int)Math.ceil(506*ScreenConstants.aspectRelY), backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		
		JLabel nombreLabel = new JLabel(players.get(1).getName());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		nombreLabel.setForeground(Color.black);
		nombreLabel.setBounds((int)Math.ceil(858*ScreenConstants.aspectRelX), (int)Math.ceil(530*ScreenConstants.aspectRelY), (int)Math.ceil(288*ScreenConstants.aspectRelY), (int)Math.ceil(37*ScreenConstants.aspectRelY));
		
		add(nombreLabel);
		add(backLabel);
		
		validButton.setVisible(true);
		invalidButton.setVisible(false);
	}
	
	public void refresh() {
		
		if(players.size() == 1)
			add1stPlayer();
		else {
			add2ndPlayer();			
		}
		setComponentZOrder(backgroundLabel, getComponentCount()-1);
		repaint();
		((JFrame)getTopLevelAncestor()).repaint();
	}
	
	public void addPlayer(Player player) {
		players.add(player);
		refresh();
	}
}
