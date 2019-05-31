package dominio;

import java.util.ArrayList;

public class Flota {


	public ArrayList<Barco> misBarcos;

	private boolean todosHundidos;


	public Flota() {

		super();

		this.misBarcos     = new ArrayList<Barco>(Cte.NUM_BARCOS);
		this.todosHundidos = false;
	}


	public void insertarBarco(Barco b) {

		this.misBarcos.add(b);
	}


	public Barco devuelveBarco(int x, int y) {

		int posicionesBarco [][] = new int [5][5];
		//TODO				
		// Buscar si existe barco que contenga la coordenada (x, y)

		for (int i = 0; i < this.misBarcos.size(); i++) {

			posicionesBarco = misBarcos.get(i).getPosiciones();

			for(int z = 0; z < posicionesBarco.length; z++) {

				

			}

		}

		return null;
	}


}
