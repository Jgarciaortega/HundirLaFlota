package dominio;

/**
 * 
 * <h2>PosicionesBarco</h2>
 * 
 * Esta clase crea un objeto de las diferentes posiciones (coordenadas) que puede
 * tomar un barco sobre el tablero. Su constructor recibira el tamanyo y posicion
 * que tendra un barco.
 * @author Javier Garcia & Marcel
 *
 */

public class PosicionesBarco {

	//Atributos

	private int posX;
	private int posY;
	private String posicion;
	private int tamanyo;

	public PosicionesBarco(String posicion, int tamanyo) {

		this.tamanyo = tamanyo;
		this.posicion = posicion;
		generarCoordenadas(tamanyo, posicion);


	}

	private void generarCoordenadas(int tamanyo, String posicion) {
		
		//Esta sera la coordenada en la que esta el barco. 
		//Si es x el barco esta horizontal. Si es y el barco esta vertical
		int coordenadaFija;
		//Coordenada sobre la que se extiende el barco
		int coordenadaCreciente;
		//Creacion de una coordenada aleatoria
		coordenadaFija = (int) (Math.random()*9);
		
		do {
			
			coordenadaCreciente = (int) (Math.random()*9);
			
		//Si la coordenada creciente mas tamanyo es mas grande que el tamanyo 
		//columnas supone que se saldria del tablero.
		//Generamos uno nuevo hasta que cuadre con medidas.
			
		}while((coordenadaCreciente + tamanyo) > Cte.NUM_COLUMNAS);
		
		for(int i = 0; i < tamanyo; i++) {
			
			if(posicion.equals("horizontal")) {
				
				this.posX = i;
				this.posY = coordenadaFija;
			}
			
			if(posicion.equals("vertical")) {
				
				this.posX = coordenadaFija;
				this.posY = i;				
				
			}
			
		}

	}
}
