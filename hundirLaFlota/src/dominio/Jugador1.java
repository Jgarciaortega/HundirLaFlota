package dominio;

import java.util.ArrayList;

import interfaz.BotonesTablero;

public class Jugador1 extends Jugador{

	private ArrayList <BotonesTablero> botonesPlayer; 

	public Jugador1(String nombreJugador, String imagen) {

		super();

		this.nombreJugador = nombreJugador;
		this.imagenJugador = imagen;

	}

	@Override
	public void generarBarcos() {

		// TODO

		Barco b = new Barco(2,"player");		
		this.flota.insertarBarco(b);

		b = new Barco(3,"player");
		this.flota.insertarBarco(b);

		b = new Barco(4,"player");
		this.flota.insertarBarco(b);

		b = new Barco(5,"player");
		this.flota.insertarBarco(b);

	}

	//Getters And Setters


	//METODOS


	public void setBotonesPlayer(ArrayList<BotonesTablero> botonesPlayer) {

		this.botonesPlayer = botonesPlayer;
	}

}
