package dominio;

import java.util.ArrayList;

import interfaz.BotonesTablero;

public class Jugador1 extends Jugador{

	private ArrayList <BotonesTablero> botonesPlayer; 

	public Jugador1(String nombreJugador, String imagen) {

		super();

		this.nombreJugador = nombreJugador;
		this.imagenJugador = imagen;
		this.botonesPlayer = new ArrayList<BotonesTablero>();

	}

	@Override
	public void generarBarcos() {

		// TODO		
		Barco b = new Barco(3);		
		this.flota.insertarBarco(b);


	}

	//Getters And Setters

	public ArrayList<BotonesTablero> getBotonesPlayer() {
		
		return botonesPlayer;
	}

	//METODOS

	public void anyadirBoton (BotonesTablero botonPlayer) {

		botonesPlayer.add(botonPlayer);

	}

	public void setBotonesPlayer(ArrayList<BotonesTablero> botonesPlayer) {
		
		this.botonesPlayer = botonesPlayer;
	}

	public BotonesTablero devuelveBoton(int celdaDisparada) {

		return botonesPlayer.get(celdaDisparada);
	}


}
