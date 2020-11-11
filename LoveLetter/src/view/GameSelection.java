package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameSelection extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4329582399066939716L;
	
	private double aspectRelX;
	private double aspectRelY;
	private JLabel backgroundLabel;
	private JButton backButton;
	private JButton singClass;
	private JButton l2pButton;
	private JButton privMulti;
	private JButton pubMulti;
	private ImageIcon back;
	private Dimension screenDim;
	private JFrame gameFrame;
	private JPanel mainMenu;
	
	public GameSelection(JFrame gameFrame) {		
		
		this.gameFrame = gameFrame;
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenDim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
		
		back = new ImageIcon(GameSelection.class.getResource("/images/gameMode/gameMode.png"));
		
		aspectRelX = (double)screenDim.width/1920;
		aspectRelY = (double)screenDim.height/1080;

		setSize(screenDim);
		setLayout(null);
		setBorder(null);
		setVisible(false);
		
		addBackground();
		
		addBackButton();
		addSingClass();
		addL2pButton();
		addPrivMulti();
		addPubMulti();
		
		add(backgroundLabel);
	}
	
	private void addBackground() {
		Image scaledBack = back.getImage().getScaledInstance((int)Math.ceil(aspectRelX*back.getIconWidth()), (int)Math.ceil(aspectRelY*back.getIconHeight()), Image.SCALE_SMOOTH);
		
		backgroundLabel = new JLabel();
		
		backgroundLabel.setIcon(new ImageIcon(scaledBack));
		backgroundLabel.setBackground(getBackground());
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
		backgroundLabel.setLocation((screenDim.width - backgroundLabel.getIcon().getIconWidth())/2, 0);
		
	}
	
	public void addBackButton() {
		
		ImageIcon backIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/back.png"));
		Image scaledBackIcon = backIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*backIcon.getIconWidth()), (int)Math.ceil(aspectRelY*backIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		backButton = new JButton();
		createButton(backButton);
		backButton.setIcon(new ImageIcon(scaledBackIcon));
		backButton.setBounds((int)Math.ceil(621*aspectRelX), (int)Math.ceil(262*aspectRelY), backButton.getIcon().getIconWidth(), backButton.getIcon().getIconHeight());
		backButton.setToolTipText("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				mainMenu.setVisible(true);
				gameFrame.repaint();
			}
		});
		add(backButton);
	}
	
	private void addSingClass() {
		ImageIcon singIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/singleClass.png"));
		
		Image scaledSingIcon = singIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*singIcon.getIconWidth()), (int)Math.ceil(aspectRelY*singIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		singClass = new JButton();
		createButton(singClass);
		singClass.setIcon(new ImageIcon(scaledSingIcon));
		singClass.setBounds((int)Math.ceil(795*aspectRelX), (int)Math.ceil(381*aspectRelY), singClass.getIcon().getIconWidth(), singClass.getIcon().getIconHeight());
		singClass.setToolTipText("Back");
		singClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				dispose();
			}
		});
		add(singClass);
	}
	
	private void addL2pButton() {
		ImageIcon l2pIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/l2p.png"));
		
		Image scaledL2pIcon = l2pIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*l2pIcon.getIconWidth()), (int)Math.ceil(aspectRelY*l2pIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		l2pButton = new JButton();
		createButton(l2pButton);
		l2pButton.setIcon(new ImageIcon(scaledL2pIcon));
		l2pButton.setBounds((int)Math.ceil(795*aspectRelX), (int)Math.ceil(462*aspectRelY), l2pButton.getIcon().getIconWidth(), l2pButton.getIcon().getIconHeight());
		l2pButton.setToolTipText("Back");
		l2pButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				dispose();
			}
		});
		add(l2pButton);
	}
	
	private void addPrivMulti() {
		ImageIcon privIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/privateMulti.png"));
		
		Image scaledPrivIcon = privIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*privIcon.getIconWidth()), (int)Math.ceil(aspectRelY*privIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		privMulti = new JButton();
		createButton(privMulti);
		privMulti.setIcon(new ImageIcon(scaledPrivIcon));
		privMulti.setBounds((int)Math.ceil(795*aspectRelX), (int)Math.ceil(701*aspectRelY), privMulti.getIcon().getIconWidth(), privMulti.getIcon().getIconHeight());
		privMulti.setToolTipText("Back");
		privMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				dispose();
			}
		});
		add(privMulti);
	}
	private void addPubMulti() {
		ImageIcon pubIcon = new ImageIcon(GameSelection.class.getResource("/images/gameMode/publicMulti.png"));
		
		Image scaledPubIcon = pubIcon.getImage().getScaledInstance((int)Math.ceil(aspectRelX*pubIcon.getIconWidth()), (int)Math.ceil(aspectRelY*pubIcon.getIconHeight()), Image.SCALE_SMOOTH);
				
		pubMulti = new JButton();
		createButton(pubMulti);
		pubMulti.setIcon(new ImageIcon(scaledPubIcon));
		pubMulti.setBounds((int)Math.ceil(795*aspectRelX), (int)Math.ceil(619*aspectRelY), pubMulti.getIcon().getIconWidth(), pubMulti.getIcon().getIconHeight());
		pubMulti.setToolTipText("Back");
		pubMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				dispose();
			}
		});
		add(pubMulti);
	}
	
	private void createButton(JButton button) {
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setIgnoreRepaint(true);
		button.setOpaque(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
	}
	
	public void setSwitchPanel(JPanel panel) {
		this.mainMenu = panel;
	}
}
