package interfaz;

import java.awt.Color;
import javax.swing.JButton;

import dominio.Cte;

public class BotonesTablero extends JButton {

	private int posX;
	private int posY;
	private int valorCelda;

	//CONSTRUCTOR
	public BotonesTablero() {

		this(0, 0, Cte.INTACTO);

	}

	public BotonesTablero(int x, int y, int valorCelda) {

		super();
		this.posX = x;
		this.posY = y;
		this.valorCelda = valorCelda;

		asignarColorBoton();
	}

	//Setters And Getters
	public void setPosX(int valor) {
		this.posX = valor;
	}

	public void setPosY(int valor) {
		this.posY = valor;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setValorCelda(int valor) {
		this.valorCelda = valor;
	}

	public int getValorCelda() {
		return this.valorCelda;
	}

	//Funciones
	public void asignarColorBoton() {

		//Intacto
		if(this.valorCelda == Cte.INTACTO) this.setBackground(Color.BLUE);

		//Agua
		if(this.valorCelda == Cte.AGUA) this.setBackground(Color.GREEN); 

		//Tocado
		if(this.valorCelda == Cte.TOCADO) this.setBackground(Color.RED);
		
		//Hundido
		if(this.valorCelda == Cte.HUNDIDO) this.setBackground(Color.BLACK);

	}	

}