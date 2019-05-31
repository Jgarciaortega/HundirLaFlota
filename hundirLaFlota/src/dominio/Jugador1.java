package dominio;

public class Jugador1 extends Jugador{
	
	
	public Jugador1(String nombreJugador, String imagen) {
		
		super();
		
		this.nombreJugador = nombreJugador;
		this.imagenJugador = imagen;
		
	}

	@Override
	public void generarBarcos() {

		// TODO		
		Barco b = new Barco(3);		
		this.flota.insertarBarco(b);
		
		
	}

}
