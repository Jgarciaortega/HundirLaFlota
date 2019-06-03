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

		//TODO				
		// Buscar si existe barco que contenga la coordenada (x, y)
		
		for (int i = 0; i < this.misBarcos.size(); i++) {

			//Guardamos las posiciones de cada barco en una matriz estatica con espacio de sobra para contener cualquier barco  
			posicionesBarco = new int [6][2];			
			posicionesBarco = misBarcos.get(i).getPosiciones();
			
			for(int x = 0; x < 6; x++) {

				int y = 0;

				//Busqueda si barco esta horizontal
				if((posicionesBarco[x][y] == posX) && (posicionesBarco[x][y+1] == posY)) {

					barco = misBarcos.get(i);
					System.out.println("HORIZONTAL");
					break;
				}

				//Busqueda si barco esta vertical
				if((posicionesBarco[x][y] == posX) && (posicionesBarco[x+1][y] == posY)) {

					barco = misBarcos.get(i);
					System.out.println("VERTICAL");
					break;					
				}
				
				//Si hemos analizado la posicion 5 y no localizamos barco significa que el barco analizado no ha recibido impacto y saltamos a
				//analizar otro (Si no lo hicieramos asi provocariamos INDEX OUT OF BONDS en la busqueda vertical cuando x=6
				if(x == 5) break;

			}

		}

		return barco;
	}

}
