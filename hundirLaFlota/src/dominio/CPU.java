package dominio;

import java.net.URL;

public class CPU extends Jugador {

	//ATRIBUTOS


	//Nombres de piratas famosos
	private static final String listaNombres[] = {"Barbanegra","Jack Sparrow","Capitan Barbosa","Capitan Garfio"};

	

	//Constructor	

	public CPU() { 
		
		this.nombreJugador = generaNombreCPU();
		
	}

	//Getters and Setters

	public String generaNombreCPU() {

		int aleatorio = (int) (Math.random() * 4);		
		
		this.imagenJugador = generarFoto(aleatorio);
		
		return listaNombres[aleatorio];
		
	}
	
	//GETTERS Y SETTERS
	public String getNombreJugador() {
		
		return this.nombreJugador;
	}
	
	public String getImagenJugador() {
		
		return this.imagenJugador;
		
	}
	//Metodos
	

	@Override
	public void generarBarcos() {
					
			Barco b = new Barco(2);		
			this.flota.insertarBarco(b);
			
			b = new Barco(3);		
			this.flota.insertarBarco(b);
						
	}
	
	//para generar la foto de la CPU
	public String generarFoto(int nombreCPU) {
		
		String imagen = null;
		
		//dependiendo del nombre que tenga se la pasara una imagen 
		switch (nombreCPU) {
		
		case 0: imagen = "/interfaz/img/Barba_negra.png";
 				break;
 				
		case 1:	imagen = "/interfaz/img/jacksparrow.png";
				break;
				
		case 2: imagen = "/interfaz/img/barbosa.png";
				break;	
		
		case 3: imagen = "/interfaz/img/capitanGarfio.png";
				break;	

		default:
			break;
		}
		
		return imagen;
		
	}
}