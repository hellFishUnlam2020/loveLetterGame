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

public class GameSelection extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4329582399066939716L;
	
	private double aspectRelX;
	private double aspectRelY;
	private Dimension screenDim;
	private JFrame gameFrame;
	private JLabel backgroundLabel;
	private Player player;
	
	public GameSelection(JFrame gameFrame, Player player) {		
		
		this.gameFrame = gameFrame;
		this.player = player;
		screenDim = gameFrame.getSize();
		
		
		aspectRelX = (double)screenDim.width/1920;
		aspectRelY = (double)screenDim.height/1080;

		setSize(screenDim);
		setLayout(null);
		setBorder(null);
		
		addBackground();
		
		addBackButton();
		addSingClass();
		addL2pButton();
		addPrivMulti();
		addPubMulti();
		
		add(backgroundLabel);
		
		setVisible(true);
		gameFrame.repaint();
	}
	
	private void addBackground() {
		
		ImageIcon back = new ImageIcon(GameSelection.class.getResource("/images/gameMode/gameMode.png"));
		Image scaledBack = back.getImage().getScaledInstance((int)Math.ceil(aspectRelX*back.getIconWidth()), (int)Math.ceil(aspectRelY*back.getIconHeight()), Image.SCALE_SMOOTH);
		
		backgroundLabel = new JLabel();
		
		backgroundLabel.setIcon(new ImageIcon(scaledBack));
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
		
	}
	
	public void addBackButton() {
		
		ImageIcon backIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/back.png"));
		Image scaledBackIcon = backIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*backIcon.getIconWidth()), (int)Math.ceil(aspectRelY*backIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton backButton = new JButton();
		createButton(backButton);
		backButton.setIcon(new ImageIcon(scaledBackIcon));
		backButton.setBounds((int)Math.ceil(621*aspectRelX), (int)Math.ceil(262*aspectRelY), backButton.getIcon().getIconWidth(), backButton.getIcon().getIconHeight());
		backButton.setToolTipText("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Component comp : gameFrame.getContentPane().getComponents()) {
					gameFrame.remove(comp);
				}
				
				gameFrame.getContentPane().add(new MainMenu(gameFrame, player));
			}
		});
		add(backButton);
	}
	
	private void addSingClass() {
		ImageIcon singIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/singleClass.png"));
		
		Image scaledSingIcon = singIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*singIcon.getIconWidth()), (int)Math.ceil(aspectRelY*singIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton singClass = new JButton();
		createButton(singClass);
		singClass.setIcon(new ImageIcon(scaledSingIcon));
		singClass.setBounds((int)Math.ceil(795*aspectRelX), (int)Math.ceil(381*aspectRelY), singClass.getIcon().getIconWidth(), singClass.getIcon().getIconHeight());
		singClass.setToolTipText("Back");
		singClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createJoin();
			}
		});
		add(singClass);
	}
	
	private void addL2pButton() {
		ImageIcon l2pIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/l2p.png"));
		
		Image scaledL2pIcon = l2pIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*l2pIcon.getIconWidth()), (int)Math.ceil(aspectRelY*l2pIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton l2pButton = new JButton();
		createButton(l2pButton);
		l2pButton.setIcon(new ImageIcon(scaledL2pIcon));
		l2pButton.setBounds((int)Math.ceil(795*aspectRelX), (int)Math.ceil(462*aspectRelY), l2pButton.getIcon().getIconWidth(), l2pButton.getIcon().getIconHeight());
		l2pButton.setToolTipText("Back");
		l2pButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createJoin();
			}
		});
		add(l2pButton);
	}
	
	private void addPrivMulti() {
		ImageIcon privIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/privateMulti.png"));
		
		Image scaledPrivIcon = privIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*privIcon.getIconWidth()), (int)Math.ceil(aspectRelY*privIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton privMulti = new JButton();
		createButton(privMulti);
		privMulti.setIcon(new ImageIcon(scaledPrivIcon));
		privMulti.setBounds((int)Math.ceil(795*aspectRelX), (int)Math.ceil(701*aspectRelY), privMulti.getIcon().getIconWidth(), privMulti.getIcon().getIconHeight());
		privMulti.setToolTipText("Back");
		privMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createJoin();
			}
		});
		add(privMulti);
	}
	private void addPubMulti() {
		ImageIcon pubIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/publicMulti.png"));
		
		Image scaledPubIcon = pubIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*pubIcon.getIconWidth()), (int)Math.ceil(aspectRelY*pubIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton pubMulti = new JButton();
		createButton(pubMulti);
		pubMulti.setIcon(new ImageIcon(scaledPubIcon));
		pubMulti.setBounds((int)Math.ceil(795*aspectRelX), (int)Math.ceil(619*aspectRelY), pubMulti.getIcon().getIconWidth(), pubMulti.getIcon().getIconHeight());
		pubMulti.setToolTipText("Back");
		pubMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				createJoin();
			}
		});
		add(pubMulti);
	}
	
	public void createJoin() {
		
		for(Component comp : gameFrame.getContentPane().getComponents()) {
			gameFrame.remove(comp);
		}
		
		gameFrame.getContentPane().add(new CreateJoin(gameFrame, player));
	}
	
	private void createButton(JButton button) {
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setIgnoreRepaint(true);
		button.setOpaque(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
	}
	
}
