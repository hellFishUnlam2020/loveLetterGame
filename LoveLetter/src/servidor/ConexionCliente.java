package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

import comandos.Comando;
import loveLetter.Match;
import loveLetter.Player;
import paquetes.Paquete;

public class ConexionCliente extends Thread {
	private Socket socket;
	private DataInputStream entradaDatos;
	private DataOutputStream salidaDatos;
	private Gson gson;
	private boolean conectado;

	private Match match;
	LinkedList<Socket> clientes;

	public ConexionCliente(Socket socket, Match partida, LinkedList<Socket> clientes) {
		try {
			this.socket = socket;
			this.entradaDatos = new DataInputStream(socket.getInputStream());
			this.salidaDatos = new DataOutputStream(socket.getOutputStream());
			gson = new Gson();

			this.clientes = clientes;
			this.match = partida;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String mensajeRecibido;
		boolean conectado = true;

		while (conectado) {
			try {
				mensajeRecibido = entradaDatos.readUTF();
				System.out.println("MENSAJE RECIBIDO SERVER: " + mensajeRecibido.toString());
				Paquete paquete = gson.fromJson(mensajeRecibido, Paquete.class);
				if (paquete.getComando().equals(Comando.INGRESAR_LOBBY)) {
					this.match.agregarJugador(new Player(paquete.getNombreJugador()));
				}

				List<Player> players = this.match.getPlayers();
				Iterator<Socket> clientesIterator = clientes.iterator();
				while (clientesIterator.hasNext()) {
					Socket socket = clientesIterator.next();
					
					for(Player player : players) {
						(new DataOutputStream(socket.getOutputStream())).writeUTF(gson.toJson(new Paquete(Comando.INGRESO_JUGADOR_LOBBY, player.getName())));
					}
//					(new DataOutputStream(socket.getOutputStream())).writeUTF(gson.toJson(new Paquete(Comando.NADA,
//							"soy servidor acción producida por " + paquete.getNombreJugador())));
				}
			} catch (IOException e) {
				conectado = false;
				try {
					entradaDatos.close();
					salidaDatos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
