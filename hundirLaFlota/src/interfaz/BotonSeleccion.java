package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



public class BotonSeleccion extends JButton{

	
	public BotonSeleccion() {
		
		Icon imgFondo = new ImageIcon(getClass().getResource("/interfaz/img/fondoazul.jpg"));
		
		
	}

	
	
	public void paintComponent(Graphics g) {
		
		Dimension tamanyo = getSize();
		
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/interfaz/img/fondoazul.jpg"));
		
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanyo.width, tamanyo.height, null);
		
		setOpaque(false);

		super.paintComponent(g);
		
	}
	
	
}