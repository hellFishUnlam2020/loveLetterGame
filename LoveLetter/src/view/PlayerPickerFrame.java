package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import loveLetter.Player;
import viewCommunication.PlayerElegible;

public class PlayerPickerFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1738677282630334235L;
	private Dimension screenDim;
	private List<Player>players;
	private double aspectRelX;
	private double aspectRelY;
	
	private Player player;
	private PlayerElegible playerElegible;
	private boolean val;
	public void setPlayerElegible(PlayerElegible playerEligible) {
		this.playerElegible = playerEligible;
	}
	
	
	public PlayerPickerFrame(List<Player>players, Player player, boolean val){
		
		this.players = players;
		this.player = player;
		this.val = val;
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenDim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
	
		aspectRelX = (double)screenDim.width/1920;
		aspectRelY = (double)screenDim.height/1080;
		
		setTitle("Love Letter");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameFrame.class.getResource("/images/logo.png")));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenDim.width, screenDim.height);
		setLocationRelativeTo(null);
		setBackground(new Color(0, 0, 0, 90));
		getContentPane().setLayout(null);
		
		createChoosePanel();
		
		setVisible(true);
	}
	
	public void createChoosePanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBorder(null);
		panel.setSize(screenDim);
		
		for(int i = 0; i < players.size(); i++) {
			if((player == players.get(i) && val) || player != players.get(i))
				createLabel(panel, i+1, players.get(i));
		}
		
		add(panel);
	}
	
	public void createLabel(JPanel panel, int i, Player player) {
		
		JButton button = new JButton(player.getName());
		
		button.setBounds((screenDim.width/2),(int) Math.ceil(aspectRelX * 200)*i , (int) Math.ceil(aspectRelX * 200), (int)Math.ceil(aspectRelY * 50));
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 25));
		button.setForeground(Color.black);
		button.setOpaque(false);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerElected(player);
				dispose();
			}
		});
		panel.add(button);
	}
	
	public void playerElected(Player player) {
		playerElegible.playerElected(player);
	}
}
