package interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import dominio.Cte;

public class BotonesTablero extends JButton {

	private int posX;
	private int posY;
	private int valorCelda;
	private int id;

	//CONSTRUCTOR
	public BotonesTablero() {

		this(0, 0, Cte.INTACTO,0);

	}

	public BotonesTablero(int x, int y, int valorCelda, int id) {

		super();
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		this.posX = x;
		this.posY = y;
		this.valorCelda = valorCelda;
		this.id = id;

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

	public void setId (int id) {

		this.id = id;
	}
	
	public int getId () {
		
		return this.id;
	}


	//Funciones
	public void asignarColorBoton() {

		//Intacto
		if(this.valorCelda == Cte.INTACTO) {
			//this.setBackground(Color.BLUE);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(true);
		}

		//Agua
		if(this.valorCelda == Cte.AGUA) {

			this.setBackground(Color.CYAN);
			this.setIcon(new ImageIcon(BotonesTablero.class.getResource("/interfaz/img/bombaAgua.png")));
		}

		//Tocado
		if(this.valorCelda == Cte.TOCADO) {
			this.setOpaque(true);
			this.setBackground(Color.RED);
			this.setIcon(new ImageIcon(BotonesTablero.class.getResource("/interfaz/img/explosion.png")));
		}

		//Hundido
		if(this.valorCelda == Cte.HUNDIDO) {
			this.setOpaque(true);
			this.setBackground(Color.BLACK);
			this.setIcon(new ImageIcon(BotonesTablero.class.getResource("/interfaz/img/calavera.png")));

		}

	}	

}