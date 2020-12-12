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
import view.GameFrame;
import view.MatchFrame;
import cliente.ConexionServidor;
import comandos.Comando;
import loveLetter.Player;
import paquetes.Paquete;

public class CreateGame extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3492739264759917878L;
	private LobbyPanel lobby;
	
	private ConexionServidor conexion;
	
	private GameFrame frame;
	
	public CreateGame(){

		setSize(GameConstants.screenSize);
		setLayout(null);
		setBorder(null);
		
		addCreated();
		addBackButton();
		addCreateButton();
		addJoinButton();
		addBackgroundLabel();
		
		String host = "localhost";
		int puerto = 59002;
		
		try {
			conexion = new ConexionServidor(host, puerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public CreateGame(GameFrame gameFrame){

		setSize(GameConstants.screenSize);
		setLayout(null);
		setBorder(null);
		
		addCreated();
		addBackButton();
		addCreateButton();
		addJoinButton();
		addBackgroundLabel();
		
		String host = "localhost";
		int puerto = 59002;
		frame = gameFrame;
		
		try {
			conexion = new ConexionServidor(host, puerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addBackgroundLabel() {
		
		JLabel backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ScaledIcon("/images/create.png").getScaledIcon());
		backgroundLabel.setSize(getSize());
		add(backgroundLabel);
	}
	
	private void addBackButton() {
		JButton backButton = new CreateButton("/images/createBack.png", 606, 262, null);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new GameSelection(frame));
				frame.repaint();
			}
		});
		add(backButton);		
	}
	
	private void addCreateButton() {
		JButton createButton = new CreateButton("/images/createGame.png", 794, 493, "/images/createGameOver.png");
		createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					createLobby();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(createButton);
		
	}
	
	private void addJoinButton() {
		JButton joinButton = new CreateButton("/images/joinGame.png", 794, 591, "/images/joinGameOver.png");
		joinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				joinLobby(frame);
			}
		});
		add(joinButton);
		
	}
	
	private void addCreated() {
		
		JLabel label = new JLabel();
		label.setIcon(new ScaledIcon("/images/lobbyCreated.png").getScaledIcon());
		label.setBounds(0, (int)Math.ceil(115 * GameConstants.aspectRelY), label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
		label.setVisible(false);
		add(new TextLabel(new Rectangle(75, 120, 127, 30), Color.yellow, 24));
		add(new TextLabel(new Rectangle(25, 150, 200, 30), Color.white, 20));
		add(label);
	}
	
	public void joinLobby(GameFrame frame) {
		
		if(lobby == null) {
			((JLabel)getComponent(0)).setText("Lobby");
			getComponent(2).setVisible(true);
			lobby = new LobbyPanel(frame, conexion);
		}
		

		frame.getContentPane().removeAll();
		frame.getContentPane().add(lobby);
		frame.repaint();		
		
		lobby.addPlayer(frame.getPlayer());
		
		conexion.ingresarLobby(frame.getPlayer());
	}
	
	public void recibirMensajeServidor() {
		boolean conectado = true;
		while (conectado) {
			try {
				Paquete paquete = conexion.leer();
				if(paquete.getComando().equals(Comando.INGRESO_JUGADOR_LOBBY)) {
					if(!frame.getPlayer().getName().equals(paquete.getNombreJugador())) {
						lobby.addPlayer(new Player(paquete.getNombreJugador()));
						frame.getContentPane().add(lobby);
						frame.repaint();	
					}					
				} else if(paquete.getComando().equals(Comando.COMENZO_PARTIDA)) {
					if(!frame.getPlayer().getName().equals(paquete.getNombreJugador())) {
						new MatchFrame(lobby.getPlayers(), 5, frame);
						frame.dispose();
					}	
				}
			} catch (IOException e) {
				conectado = false;
				System.out.println("conexion leer exception");
			}
		}
	}
	
	public void createLobby() throws UnknownHostException, IOException {
		((JLabel)getComponent(0)).setText("Lobby");
		((JLabel)getComponent(1)).setText("Ingresa directamente");
//		if(lobby == null) {
//			lobby = new LobbyPanel();
//			((JLabel)getComponent(0)).setText("Lobby");
//			((JLabel)getComponent(1)).setText("Game created");
//			getComponent(2).setVisible(true);
//		}
//		else {
//			((JLabel)getComponent(0)).setText("Lobby");
//			((JLabel)getComponent(1)).setText("Another Game Is Run");
//			getComponent(2).setVisible(true);
//		}
	}
}
