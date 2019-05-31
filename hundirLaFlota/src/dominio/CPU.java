package dominio;

public class CPU extends Jugador {

	//ATRIBUTOS


	//Nombres de piratas famosos
	private static final String listaNombres[] = {"Barbanegra","Jack Sparrow","Capitan Barbosa","Capitan Garfio"};

	

	//Constructor	

	public CPU(String imagen) { 

		this.nombreJugador = generaNombreCPU();
		this.imagenJugador = imagen;
	}

	//Getters and Setters

	public String generaNombreCPU() {

		int aleatorio = (int) (Math.random() * 3);		
		return listaNombres[aleatorio];
	}

	@Override
	public void generarBarcos() {
					
			Barco b = new Barco(2);		
			this.flota.insertarBarco(b);
			
			b = new Barco(3);		
			this.flota.insertarBarco(b);
		
				
	}



}
