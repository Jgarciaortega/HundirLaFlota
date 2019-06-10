package dominio;

public class Barco {

	//Atributos	
	public int[][] posiciones;
	private int[] valores;	
	private boolean hundido;
	private int tamanyo;
		
	// Barco de 2
	
	// posiciones  { {0,0}, 
	//       		 {0,1} 
	//				}
		
	// valores	   {  0   ,  3    }
	// hundido     false
	// tamanyo     2
	
	
	//Constructor	
	public Barco(int tamanyo) {
	
		this.tamanyo = tamanyo;
		this.hundido = false;
		
		this.valores = new int[tamanyo];
		
		this.posiciones = new int[tamanyo][2];
		
		if (tamanyo == 2) {
			//POSICION X				POSICION Y
			this.posiciones[0][0] = 0; this.posiciones[0][1] = 0;					
			this.posiciones[1][0] = 0; this.posiciones[1][1] = 1;
			
			this.valores[0] = Cte.HAY_BARCO;
			this.valores[1] = Cte.HAY_BARCO;
			
		}
		
		if (tamanyo == 2) {
			//POSICION X				POSICION Y
			this.posiciones[0][0] = 0; this.posiciones[0][1] = 0;					
			this.posiciones[1][0] = 0; this.posiciones[1][1] = 1;
			
			this.valores[0] = Cte.HAY_BARCO;
			this.valores[1] = Cte.HAY_BARCO;
			
		}
		
		
		
		if (tamanyo == 3) {
			
			//POSICION X				POSICION Y
			this.posiciones[0][0] = 3; this.posiciones[0][1] = 3;					
			this.posiciones[1][0] = 3; this.posiciones[1][1] = 4;
			this.posiciones[2][0] = 3; this.posiciones[2][1] = 5;
			
			this.valores[0] = Cte.HAY_BARCO;
			this.valores[1] = Cte.HAY_BARCO;
			this.valores[2] = Cte.HAY_BARCO;					
		}
		
		if (tamanyo == 4) {
						
			//POSICION X				POSICION Y
			this.posiciones[0][0] = 3; this.posiciones[0][1] = 7;					
			this.posiciones[1][0] = 4; this.posiciones[1][1] = 7;
			this.posiciones[2][0] = 5; this.posiciones[2][1] = 7;
			this.posiciones[3][0] = 6; this.posiciones[3][1] = 7;
			
			this.valores[0] = Cte.HAY_BARCO;
			this.valores[1] = Cte.HAY_BARCO;
			this.valores[2] = Cte.HAY_BARCO;
			this.valores[3] = Cte.HAY_BARCO;
			
			
		}		
		
		
		
	/*	if (tamanyo == 5) {
			
			//POSICION X				POSICION Y
			this.posiciones[0][0] = 3; this.posiciones[0][1] = 9;					
			this.posiciones[1][0] = 4; this.posiciones[1][1] = 9;
			this.posiciones[2][0] = 5; this.posiciones[2][1] = 9;
			this.posiciones[3][0] = 6; this.posiciones[3][1] = 9;
			this.posiciones[4][0] = 7; this.posiciones[3][1] = 9;
			
			this.valores[0] = Cte.HAY_BARCO;
			this.valores[1] = Cte.HAY_BARCO;
			this.valores[2] = Cte.HAY_BARCO;
			this.valores[3] = Cte.HAY_BARCO;
			this.valores[4] = Cte.HAY_BARCO;
			
			
		}		*/
				
	}
	
	//Getters And Setters

	public int[][] getPosiciones() {
		
		return this.posiciones;
	}

	public boolean saberSiHundido() {

		for(int i = 0; i < this.tamanyo ; i ++) {

			if (this.hundido = (this.valores[i] == Cte.HAY_BARCO)){
				
				this.hundido = false; 
				break;
				
			}else {
				
				this.hundido = true;
			}

		}

		return this.hundido;
	}
	
	public void setHundido() {
		
		for(int i = 0; i < this.valores.length; i++) {
						
			this.valores[i] = Cte.HUNDIDO;
			
		}
		
		this.hundido = true;
			
	}
		
	public int getValor(int pos) {
				
		return this.valores[pos];
		
	}
		
	
	public void setValor(int posicion, int valor) {
				
		this.valores[posicion] = valor;
	}
	
}