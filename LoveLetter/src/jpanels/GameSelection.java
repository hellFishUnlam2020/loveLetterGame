package jpanels;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.GameConstants;
import cliente.ConexionServidor;
import loveLetter.Player;
import view.GameFrame;

public class GameSelection extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4329582399066939716L;
	
	public GameSelection(GameFrame gameFrame) {		
		
		setSize(GameConstants.screenSize);
		setLayout(null);
		setBorder(null);
		
		addBackButton();
		addSingClass();
		addL2pButton();
		addPrivMulti();
		addPubMulti(gameFrame);
		addBackground();
		
	}
	
	private void addBackground() {
		JLabel backgroundLabel = new JLabel();
		
		backgroundLabel.setIcon(new ScaledIcon("/images/selectMode.png").getScaledIcon());
		backgroundLabel.setSize(getSize());
		add(backgroundLabel);
	}
	
	private void addSingClass() {		
		JButton singClass = new CreateButton("/images/selectClass.png", 789, 374, "/images/selectClassOver.png");
		JLabel text = new TextLabel(new Rectangle(798, 374, singClass.getIcon().getIconWidth(), singClass.getIcon().getIconHeight()), Color.black, 35f);
		text.setText("Classic");
		singClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createJoin();
			}
		});
		add(singClass);
		add(text);
	}
	
	public void addBackButton() {
//		JButton backButton = new CreateButton("/images/createBack.png", 621, 262, null);
//		backButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				JFrame frame = (JFrame)getTopLevelAncestor();
//				frame.getContentPane().removeAll();
//				frame.getContentPane().add(new MainMenu());
//				frame.repaint();
//			}
//		});
//		add(backButton);
	}
	
	
	private void addL2pButton() {				
		JButton l2pButton = new CreateButton("/images/selectLearn.png", 789, 459, "/images/selectL2pOver.png");
		l2pButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				createJoin();
			}
		});
		add(l2pButton);
	}
	
	private void addPrivMulti() {				
		JButton privMulti = new CreateButton("/images/selectPrivMulti.png", 789, 698, "/images/selectPrivOver.png");
		privMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				createJoin();
			}
		});
		add(privMulti);
	}
	private void addPubMulti(GameFrame gameFrame) {				
		JButton pubMulti = new CreateButton("/images/selectPubMulti.png", 789, 616, "/images/selectPublicOver.png");
		pubMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createJoin(gameFrame);
			}
		});
		add(pubMulti);
	}
	
	public void createJoin(GameFrame gameFrame) {
		JFrame frame = gameFrame;
		frame.getContentPane().removeAll();
		CreateGame createGame = new CreateGame(gameFrame);
		Thread hilo = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(30);
						createGame.recibirMensajeServidor();
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}

			}
		});
		hilo.start();
		
		frame.getContentPane().add(createGame);
		frame.repaint();
	}
	
	public void createJoin() {
		JFrame frame = (JFrame)getTopLevelAncestor();
		frame.getContentPane().removeAll();
		CreateGame createGame = new CreateGame();
		Thread hilo = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(30);
						createGame.recibirMensajeServidor();
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}

			}
		});
		hilo.start();
		
		frame.getContentPane().add(createGame);
		frame.repaint();
	}
}
