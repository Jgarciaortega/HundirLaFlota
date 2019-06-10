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
	
	
	
	//GETTERS AND SETTERS
	public ArrayList<Barco> getMisBarcos() {
		return misBarcos;
	}


	//Esta funcion devuelve un barco en las posiciones seleccionados. Si ademas ese barco tiene que recibir un impacto se modificara en esta misma funcion.
	//Para impactar el barco debera llegar a esta funcion un true en el boolean impacto
	public Barco devuelveBarco(int posX, int posY, Boolean impacto) {

		int posicionesBarco [][]; 
		Barco barco = null;

		for (int i = 0; i < this.misBarcos.size(); i++) {
			//Guardamos las posiciones de cada barco en una matriz

			posicionesBarco = misBarcos.get(i).getPosiciones();

			for(int x = 0, y = 0; x < posicionesBarco.length; x++) {

				//Si... coordenadas de disparo coinciden con posicion barco
				if((posicionesBarco[x][y] == posX) && (posicionesBarco[x][y+1] == posY)) {		

					//Obtenemos el barco que coincide con las coordenadas
					barco = misBarcos.get(i);
					//Si ha de recibir impacto se setea en este if
					if(impacto) barco.setValor(x,Cte.TOCADO);
					
					break;
				}			

			}

		}

		return barco;
	}

}
