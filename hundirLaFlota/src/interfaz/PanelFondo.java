package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * <h2>Clase PanelFondo</h2>
 * Un JFrame modificado y propio que sirve para poner una imagen de fondo al frame 
 * 
 * @author Javier García y Marcel Ramírez
 *
 */
public class PanelFondo extends JPanel{
	
	public PanelFondo() {
		
		Icon imgFondo = new ImageIcon(getClass().getResource("/interfaz/img/fondo-madera.jpg"));
		
		
	}

	/**
	 * <h2>paintComponent</h2>
	 * 
	 * Metodo que "pinta" el frame con una imagen. Para ponerle un fondo 
	 * 
	 * @param g: un Graphico que ayuda a "repintar" el fondo del JFrame
	 */
	public void paintComponent(Graphics g) {
		
		Dimension tamanyo = getSize();
		
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/interfaz/img/fondo-madera.jpg"));
		
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanyo.width, tamanyo.height, null);
		
		setOpaque(false);

		super.paintComponent(g);
		
	}
	
	
}
