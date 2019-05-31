package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Barco;
import dominio.CPU;
import dominio.Cte;
import dominio.Flota;
import dominio.Jugador1;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;	

	//TODO Inicializar correctamente
	CPU cpu = new CPU("");
	Jugador1 player = new Jugador1("Pepe","");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Hundir la Flota");

		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaz/img/Avatar1.png")));
		panelNorte.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Aqu\u00ED ir\u00EDa animaci\u00F3n");
		panelNorte.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaz/img/Avatar 2.jpg")));
		panelNorte.add(lblNewLabel_1);

		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);

		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		JPanel panelTablero = new JPanel();
		contentPane.add(panelTablero, BorderLayout.CENTER);
		panelTablero.setLayout(new BoxLayout(panelTablero, BoxLayout.X_AXIS));

		JPanel panelTablero1 = new JPanel();
		panelTablero.add(panelTablero1);
		panelTablero1.setLayout(new GridLayout(Cte.NUM_FILAS, Cte.NUM_COLUMNAS));

		JPanel panel = new JPanel();
		panelTablero.add(panel);

		JPanel panelTablero2 = new JPanel();
		panelTablero.add(panelTablero2);
		panelTablero2.setLayout(new GridLayout(Cte.NUM_FILAS, Cte.NUM_COLUMNAS));

		for(int i = 0; i < 2; i++) {

			for(int x = 0; x < Cte.NUM_FILAS; x++) {
				for(int y = 0; y < Cte.NUM_COLUMNAS; y++) {

					//Asignacion al tablero mis barcos++
					if(i == 0) {

						BotonesTablero botonMisBarcos = new BotonesTablero();
						botonMisBarcos.setPosX(x);
						botonMisBarcos.setPosY(y);
						botonMisBarcos.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								disparar(botonMisBarcos);
							}
						});						

						//En el momento de la creacion de los botones ya le asignamos las posiciones de los barcos del PLAYER 1
						botonMisBarcos.setValorCelda(  this.player.tablero[x][y]   );

						panelTablero1.add(botonMisBarcos);
					}

					//Asignacion al tablero mis ataques
					if(i == 1) {

						BotonesTablero botonMisAtaques = new BotonesTablero();
						botonMisAtaques.setPosX(x);
						botonMisAtaques.setPosY(y);
						botonMisAtaques.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								disparar(botonMisAtaques);
							}
						});						

						//En el momento de la creacion de los botones ya le asignamos las posiciones de los barcos de la CPU
						botonMisAtaques.setValorCelda(  this.cpu.tablero[x][y]   );

						//Anyadir boton al tablero
						panelTablero2.add(botonMisAtaques);
					}
				}
			}
		}

		iniciarPartida();

	}

	private void disparar(BotonesTablero b) {

		//Si en la celda ya se ha producido un disparo no permitimos disparo sobre ella de nuevo
		if(b.getValorCelda() == Cte.INTACTO) {

			b.setValorCelda(Cte.AGUA);
		}

		if(b.getValorCelda() == Cte.HAY_BARCO) {

			b.setValorCelda(Cte.TOCADO);
		}		

		b.asignarColorBoton();

		//
		comprobarSiHundido(b);
	}


	public void iniciarPartida () {

		cpu.iniciarPartida();

	}

	private boolean comprobarSiHundido(BotonesTablero b) {

		boolean hundido = false;

		Flota f = new Flota();

		if (b.getValorCelda() == Cte.TOCADO) {

			Barco barco = f.devuelveBarco(b.getPosX(), b.getPosY());

		}

		return hundido;
	}	


}
