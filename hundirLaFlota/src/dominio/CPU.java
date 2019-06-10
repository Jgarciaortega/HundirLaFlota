package dominio;

import java.net.URL;
import java.util.ArrayList;

public class CPU extends Jugador {

	//ATRIBUTOS

	//Nombres de piratas famosos
	private static final String listaNombres[] = {"Barbanegra","Jack Sparrow","Capitan Barbosa","Capitan Garfio"};

	//La CPU debe tener un registro de memoria para desarrollar su inteligencia:

	//1.- Guarda el numero de celda que ha impactado
	private int celdaImpactada;
	//2.-Guarda (si la conoce) la posicion en la que esta el barco ("horizontal" , "vertical")
	private String posicionBarco;
	//3.-Guarda (si lo hay) la direccion del ultimo disparo realizado ("derecha","izquierda","abajo","arriba")
	private String direccionUltDisparo;

	//Constructor	

	public CPU() { 

		this.nombreJugador = generaNombreCPU();
		this.celdaImpactada = -1;
		this.posicionBarco = "indefinido";
		this.direccionUltDisparo = "indefinido";

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

	public int getCeldaImpactada() {
		return celdaImpactada;
	}

	public void setCeldaImpactada(int celdaImpactada) {
		this.celdaImpactada = celdaImpactada;
	}

	public String getPosicionBarco() {
		return posicionBarco;
	}

	public void setPosicionBarco(String posicionBarco) {
		this.posicionBarco = posicionBarco;
	}

	public String getDireccionUltDisparoFallado() {
		return direccionUltDisparo;
	}

	public void setDireccionUltDisparoFallado(String direccionUltDisparo) {
		this.direccionUltDisparo = direccionUltDisparo;
	}


	//Metodos

	@Override
	public void generarBarcos() {
						
		Barco b = new Barco(2,"cpu");		
		this.flota.insertarBarco(b);

		b = new Barco(3,"cpu");
		this.flota.insertarBarco(b);

		b = new Barco(4,"cpu");
		this.flota.insertarBarco(b);

		b = new Barco(5,"cpu");
		this.flota.insertarBarco(b);

	}
	
	public boolean comprobarSiCeldasEstanDisponibles(Barco barco) {
		
		Flota flota = this.getFlota();
		
		ArrayList <Barco> listaBarcos = flota.misBarcos;
				
		for(int i = 0; i < listaBarcos.size(); i++) {
			
			Barco barco2 = listaBarcos.get(i);
			
			int posicionesBarco[][]= barco.getPosiciones();
			int posicionesBarco2[][]= barco.getPosiciones();
			
			for(int y = 0; y < posicionesBarco.length; y++) {
				
				for(int z = 0; z < 1; z++) {
					
					
					if(posicionesBarco[y][z] == posicionesBarco2[y][z]) {
						
						
					}
					
				}
								
			}			
			
		}
			
		return true;
	}
	

	//para generar la foto de la CPU
	public String generarFoto(int nombreCPU) {

		String imagen = null;

		//dependiendo del nombre que tenga se la pasara una imagen 
		switch (nombreCPU) {

		case 0: imagen = "/interfaz/img/Barba_negra.png";
		break;

		case 1:	imagen = "/interfaz/img/JackSparrow.png";
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