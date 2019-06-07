package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel{
	
	public PanelFondo() {
		
		Icon imgFondo = new ImageIcon(getClass().getResource("/interfaz/img/fondoTablero.jpg"));
		
		
	}

	public void paintComponent(Graphics g) {
		
		Dimension tamanyo = getSize();
		
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/interfaz/img/fondoTablero.jpg"));
		
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanyo.width, tamanyo.height, null);
		
		setOpaque(false);

		super.paintComponent(g);
		
	}
	
	
}
