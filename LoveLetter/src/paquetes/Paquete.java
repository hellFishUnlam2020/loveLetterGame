package paquetes;

public class Paquete {

	protected String comando;
	protected String nombreJugador;
	
	public Paquete() {
		
	}
	
	public Paquete(String comando, String nombreJugador) {
		this.comando = comando;
		this.nombreJugador = nombreJugador;
    }

	public String getComando() {
		return comando;
	}
	
	public String getNombreJugador()
	{
		return this.nombreJugador;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}
}
