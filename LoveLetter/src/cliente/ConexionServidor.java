package cliente;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import comandos.Comando;
import loveLetter.Player;
import paquetes.Paquete;

public class ConexionServidor implements MouseListener {
	private Socket socket;
	private DataOutputStream salidaDatos;
	private DataInputStream entradaDatos;
	private Gson gson;
	private GsonBuilder builder;
	private Player player;

	public ConexionServidor(String host, int puerto) throws UnknownHostException, IOException {
		this.socket = new Socket(host, puerto);

		builder = new GsonBuilder();
		//builder.registerTypeAdapter(PaqueteCarta.class, new PaqueteCartaDeserializer());
		gson = builder.create();

		this.entradaDatos = new DataInputStream(socket.getInputStream());
		this.salidaDatos = new DataOutputStream(socket.getOutputStream());
	}
	
	public void comenzarPartida()
	{
		try {
			this.salidaDatos.writeUTF(gson.toJson(new Paquete(Comando.COMENZAR_PARTIDA, player.getName())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ingresarLobby(Player player) 
	{
		this.player = player;
		
		try {
			this.salidaDatos.writeUTF(gson.toJson(new Paquete(Comando.INGRESAR_LOBBY, player.getName())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Paquete leer() throws IOException {
		String mensajeRecibido = this.entradaDatos.readUTF();
		Paquete paquete = gson.fromJson(mensajeRecibido, Paquete.class);
		return paquete;
	}
	
	public void escribir() {
		try {
			this.salidaDatos.writeUTF("envio algo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//this.salidaDatos.writeUTF(gson.toJson(new PaqueteCarta(Comando.JUGAR, this.mesa.getCarta()[0]), PaqueteCarta.class));
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}