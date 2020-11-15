package jpanels;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
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

public class GameSelection extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4329582399066939716L;
	
	private GameScreen frame;
	private Player player;
	private ImageIcon icon;
	private Image scaledIcon;
	
	public GameSelection(GameScreen frame, Player player) {		
		
		this.frame = frame;
		this.player = player;
		
		setSize(ScreenConstants.width, ScreenConstants.height);
		setLayout(null);
		setBorder(null);
		
		addBackButton();
		addSingClass();
		addL2pButton();
		addPrivMulti();
		addPubMulti();
		addBackground();
	}
	
	private void addBackground() {
		
		icon = new ImageIcon(GameSelection.class.getResource("/images/selectMode.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
		
		JLabel backgroundLabel = new JLabel();
		
		backgroundLabel.setIcon(new ImageIcon(scaledIcon));
		backgroundLabel.setSize(getSize());
		add(backgroundLabel);
	}
	
	private void addSingClass() {
		icon = new ImageIcon(GameSelection.class.getResource("/images/selectClass.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
		
		JButton singClass = new CreateButton(new ImageIcon(scaledIcon), 795, 381);
		singClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createJoin();
			}
		});
		add(singClass);
	}
	
	public void addBackButton() {
		
		icon = new ImageIcon(GameSelection.class.getResource("/images/createBack.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton backButton = new CreateButton(new ImageIcon(scaledIcon), 621, 262);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.removeAll();
				frame.getContentPane().add(new MainMenu(frame, player));
			}
		});
		add(backButton);
	}
	
	
	private void addL2pButton() {
		icon = new ImageIcon(GameSelection.class.getResource("/images/selectLearn.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton l2pButton = new CreateButton(new ImageIcon(scaledIcon), 795, 462);
		l2pButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				createJoin();
			}
		});
		add(l2pButton);
	}
	
	private void addPrivMulti() {
		icon = new ImageIcon(GameSelection.class.getResource("/images/selectPrivMulti.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton privMulti = new CreateButton(new ImageIcon(scaledIcon), 795, 701);
		privMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				createJoin();
			}
		});
		add(privMulti);
	}
	private void addPubMulti() {
		icon = new ImageIcon(GameSelection.class.getResource("/images/selectPubMulti.png"));
		scaledIcon = icon.getImage().getScaledInstance((int)Math.ceil(ScreenConstants.aspectRelX*icon.getIconWidth()), (int)Math.ceil(ScreenConstants.aspectRelY*icon.getIconHeight()), Image.SCALE_SMOOTH);
				
		JButton pubMulti = new CreateButton(new ImageIcon(scaledIcon), 795, 619);
		pubMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				createJoin();
			}
		});
		add(pubMulti);
	}
	
	public void createJoin() {
		frame.removeAll();
		frame.getContentPane().add(new CreateGame(frame, player));
	}
	
}
