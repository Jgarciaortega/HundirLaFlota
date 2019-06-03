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


	public Barco devuelveBarco(int posX, int posY) {

		int posicionesBarco [][]; 
		Barco barco = null;

		for (int i = 0; i < this.misBarcos.size(); i++) {
			//Guardamos las posiciones de cada barco en una matriz

			posicionesBarco = misBarcos.get(i).getPosiciones();

			for(int x = 0, y = 0; x < posicionesBarco.length; x++) {

				//Si... coordenadas de disparo coinciden con posicion barco
				if((posicionesBarco[x][y] == posX) && (posicionesBarco[x][y+1] == posY)) {		

					//Obtenemos el barco que ha recibido el disparo
					barco = misBarcos.get(i);
					//Aplicamos el danyo correspondiente al barco
					barco.setValorATocado(x);
					break;
				}			

			}

		}

		return barco;
	}

}
