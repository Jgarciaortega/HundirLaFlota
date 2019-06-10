package dominio;

import java.util.ArrayList;

import interfaz.BotonesTablero;

public abstract class Jugador {

	//****************************
	// Atributos
	//****************************

	public String nombreJugador;
	public String imagenJugador;
	protected Flota flota;
	public int tablero[][];
	public ArrayList <BotonesTablero> botonesOponente;

	//****************************
	// Constructor
	//****************************
	public Jugador() {

		this.flota   = new Flota();		
		this.tablero = new int[Cte.NUM_FILAS][Cte.NUM_COLUMNAS];
		botonesOponente = new ArrayList<BotonesTablero>();

		this.iniciarPartida();
	}

	//****************************
	// Metodos abstractos
	//****************************

	public abstract void generarBarcos();


	//****************************
	// Metodos de instancia
	//****************************

	public void iniciarPartida() {

		//1.- 
		generarBarcos();

		//2.-
		generarTablero();		
	}	

	public Flota getFlota() {

		return flota;
	}

	public ArrayList<BotonesTablero> getBotonesOponenente() {

		return this.botonesOponente;
	}

	public BotonesTablero devuelveBoton(int celdaDisparada) {

		return botonesOponente.get(celdaDisparada);
	}
	
	public void anyadirBoton (BotonesTablero botonPlayer) {

		botonesOponente.add(botonPlayer);

	}
		
	private void generarTablero() {

		//Recorrer todos los barcos
		for (int i = 0; i < this.flota.misBarcos.size(); i++) {

			//Para cada barco...
			Barco b = this.flota.misBarcos.get(i);

			//... marcar a 1 las coordenadas en el tablero			
			for (int j = 0; j < b.posiciones.length; j++) {			

				int x = b.posiciones[j][0]; 
				int y = b.posiciones[j][1];

				tablero[x][y] = Cte.HAY_BARCO;				
			}			
		}
	}

}