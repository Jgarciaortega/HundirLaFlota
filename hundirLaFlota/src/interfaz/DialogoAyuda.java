package interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
/**
 * <h2>Clase DialogoAyuda</h2>
 * 
 * Un JDialog que, dependiendo de si has elegido en el menu de Ayuda "Reglas" o "Acerca de", muestra un html con información del juego 
 * 
 * Estos son los atributos de la clase:
 * <ul>
 * <li>serialVersionUID</li>
 * <li>textoInformacion</li>
 * <li>areaScrollPane</li>
 * </ul>
 * 
 * @author Javier García y Marcel Ramírez
 * 
 */
public class DialogoAyuda extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextPane textoInformacion;
	private JScrollPane areaScrollPane;

	public DialogoAyuda(int referencia) {

		super();

		// Switch... case... en caso de que haya mÃ¡s de 3 opciones...
		if (referencia == 1) {
			this.setTitle("Acerca de");
		} else {
			this.setTitle("Reglas del Juego");
		}

		this.setModal(true);

		// Se obtienen las dimensiones en pixels de la pantalla.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = this.getSize();

		// Una cuenta para situar la ventana en el centro de la pantalla.
		this.setLocation(((pantalla.width - ventana.width) / 2) - 275, // se resta 275 porque es la mitad del ancho de la ventana
				((pantalla.height - ventana.height) / 2) - 315); // se resta 315 porque es la mitad del alto de la ventana
		
		//llama a la funcion de construir la ventana
		this.construirIGU(referencia);
	}

	/**
	 * <h2>contruirIGU</h2>
	 * 
	 * Metodo que construye la interfaz donde se expondra la información del Juego
	 * 
	 * @param referencia: es un int que dependiendo de cual opción haya escogido el usuario, pasara un 1 o un 2 
	 */
	private void construirIGU(int referencia) {
		
		//panel donde se va a guardar toda la informacion
		textoInformacion = new JTextPane();
		
		//no se puede editar
		textoInformacion.setEditable(false);
		
		//lo que va a contener este panel
		textoInformacion.setContentType("text/html");
		
		//se meto dentro del scrollPane
		areaScrollPane = new JScrollPane(textoInformacion);

		areaScrollPane.setPreferredSize(new Dimension(500, 500));
		areaScrollPane.setVisible(true);
		areaScrollPane.setBorder(BorderFactory
				.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(""),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)), areaScrollPane.getBorder()));

		// Escribir Ayuda
		this.mensajeAyuda(referencia);

		JPanel panel = new JPanel();
		this.setContentPane(panel);
		this.getContentPane().add(areaScrollPane);

		//this.setIconImage(new ImageIcon(getClass().getResource("rojo.png")).getImage());

		this.setSize(550, 630);
		this.setResizable(false);

		this.setVisible(true);
		this.pack();
	}

	/**
	 * <h2>mensajeAyuda</h2>
	 * Metodo que selecciona un html u otro dependiendo de la opción que haya elegido el usuario.
	 * 
	 * @param referencia: un int que contiene 1 o 2 dependiendo de la opcion que elija el usuario en ayuda.
	 */
	private void mensajeAyuda(int referencia) {

		switch (referencia) {

		// ACERCA_DE
		case 1:
			try {
				this.textoInformacion.setPage(getClass().getClassLoader().getResource("utilidades/acercade.html"));
			} catch (IOException e) {
				// e.printStackTrace();
			}
			break;

		// MANUAL DE USUARIO
		case 2:
			try {
				this.textoInformacion.setPage(getClass().getClassLoader().getResource("utilidades/reglas.html"));
			} catch (IOException e) {
				// e.printStackTrace();
			}
			break;

		default:
			//
			break;
		}

		// Que el scroll este arriba del todo cuando se abra la ayuda !!!!
		textoInformacion.setCaretPosition(0);
	}

}