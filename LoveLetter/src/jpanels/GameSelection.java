package jpanels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.ScreenConstants;

public class GameSelection extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4329582399066939716L;
	
	public GameSelection() {		
		
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
		JLabel backgroundLabel = new JLabel();
		
		backgroundLabel.setIcon(new ScaledIcon("/images/selectMode.png").getScaledIcon());
		backgroundLabel.setSize(getSize());
		add(backgroundLabel);
	}
	
	private void addSingClass() {		
		JButton singClass = new CreateButton(new ScaledIcon("/images/selectClass.png").getScaledIcon(), 795, 381);
		singClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createJoin();
			}
		});
		add(singClass);
	}
	
	public void addBackButton() {
		JButton backButton = new CreateButton(new ScaledIcon("/images/createBack.png").getScaledIcon(), 621, 262);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame)getTopLevelAncestor();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new MainMenu());
				frame.repaint();
			}
		});
		add(backButton);
	}
	
	
	private void addL2pButton() {				
		JButton l2pButton = new CreateButton(new ScaledIcon("/images/selectLearn.png").getScaledIcon(), 795, 462);
		l2pButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				createJoin();
			}
		});
		add(l2pButton);
	}
	
	private void addPrivMulti() {				
		JButton privMulti = new CreateButton(new ScaledIcon("/images/selectPrivMulti.png").getScaledIcon(), 795, 701);
		privMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				createJoin();
			}
		});
		add(privMulti);
	}
	private void addPubMulti() {				
		JButton pubMulti = new CreateButton(new ScaledIcon("/images/selectPubMulti.png").getScaledIcon(), 795, 619);
		pubMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				createJoin();
			}
		});
		add(pubMulti);
	}
	
	public void createJoin() {
		JFrame frame = (JFrame)getTopLevelAncestor();
		frame.getContentPane().removeAll();
		frame.getContentPane().add(new CreateGame());
		frame.repaint();
	}
	
}
