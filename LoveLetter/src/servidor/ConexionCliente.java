package servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Timer;

import com.google.gson.Gson;

public class ConexionCliente extends Thread implements Observer {
	private Socket socket;
	private DataInputStream entradaDatos;
	private DataOutputStream salidaDatos;
	private Gson gson;
	private boolean conectado;

	public ConexionCliente(Socket socket) {
		try {
			this.socket = socket;
			this.entradaDatos = new DataInputStream(socket.getInputStream());
			this.salidaDatos = new DataOutputStream(socket.getOutputStream());
			gson = new Gson();

			salidaDatos.writeUTF(gson.toJson("asdasd"));
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

				salidaDatos.writeUTF("lalalallala");
				// accion
				refrescar();
			} catch (IOException e) {
				conectado = false;
				// JOptionPane.showMessageDialog(null, "El cliente ha salido del servidor");
				try {
					entradaDatos.close();
					salidaDatos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private synchronized void refrescar() {
		Timer timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				/*
				 * mensaje.setMensaje( gson.toJson(new PaqueteCarta(Comando.MESA, );
				 */
			}
		});

		timer.start();
		timer.setRepeats(false);
	}

	@Override
	public void update(Observable o, Object arg) {
//		try {
		System.out.println("UPDATE" + arg.toString());
//			salidaDatos.writeUTF(arg.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
