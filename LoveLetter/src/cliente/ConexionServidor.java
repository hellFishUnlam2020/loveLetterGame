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

public class ConexionServidor implements MouseListener {
	private Socket socket;
	private DataOutputStream salidaDatos;
	private DataInputStream entradaDatos;
	private Gson gson;
	private GsonBuilder builder;

	public ConexionServidor(String host, int puerto) throws UnknownHostException, IOException {
		this.socket = new Socket(host, puerto);

		builder = new GsonBuilder();
		//builder.registerTypeAdapter(PaqueteCarta.class, new PaqueteCartaDeserializer());
		gson = builder.create();

		this.entradaDatos = new DataInputStream(socket.getInputStream());
		this.salidaDatos = new DataOutputStream(socket.getOutputStream());
	}

	public void leer() throws IOException {
		String mensaje = this.entradaDatos.readUTF();
		System.out.println("leer: " + mensaje.toString());

//		PaqueteCarta paquete = gson.fromJson(mensaje, PaqueteCarta.class);
//
//		if (paquete.getComando().equals("3")) {
//			this.mesa.cartelFinDeJuego();
//			this.mesa.repaint();Match
//		} else {
//			this.mesa.addCarta(paquete.getCarta());
//			this.mesa.repaint();
//		}
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