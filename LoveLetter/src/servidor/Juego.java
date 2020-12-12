package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

import loveLetter.Match;

public class Juego {
	private static ServerSocket servidor = null;
	private static Match partida;
	private static LinkedList<Socket> clientes = new LinkedList<Socket>();
	
	public static void main(String[] args) {
		Socket socket = null;

		try {
			int puerto = 59002;
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor funcionando en el puerto: " + puerto);

			partida = new Match();
			
			while (true) {
				socket = servidor.accept();
				System.out.println("Nuevo usuario se ha conectado");
				clientes.add(socket);
				ConexionCliente cc = new ConexionCliente(socket, partida, clientes);
				cc.start();
			}
		} catch (IOException e) {
			System.err.println("Error en el servidor");
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				servidor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
