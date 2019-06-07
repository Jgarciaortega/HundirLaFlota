package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelTablero extends JPanel{
	
	public PanelTablero() {
		
		Icon imgFondo = new ImageIcon(getClass().getResource("/interfaz/img/mar.jpg"));
		
		
	}

	public void paintComponent(Graphics g) {
		
		Dimension tamanyo = getSize();
		
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/interfaz/img/mar.jpg"));
		
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanyo.width, tamanyo.height, null);
		
		setOpaque(false);

		super.paintComponent(g);
		
	}
	
	
}
