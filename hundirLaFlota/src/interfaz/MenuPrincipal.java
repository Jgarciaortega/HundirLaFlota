package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelTablero;
	private JPanel panelTablero1;


	private boolean turnoPlayer1; 

	//TODO Inicializar correctamente
	CPU cpu = new CPU();
	Jugador1 player = new Jugador1("Pepe","");


	public MenuPrincipal(URL imagenRuta, String nombreJugador) {

		//INICIO INTERFAZ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);

		JMenuItem mntmNuevoJuego = new JMenuItem("Nuevo Juego");
		mnJuego.add(mntmNuevoJuego);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnJuego.add(mntmSalir);

		JMenu mnReglas = new JMenu("Ayuda");
		menuBar.add(mnReglas);

		JMenuItem mntmReglasDelJuego = new JMenuItem("Reglas del Juego");
		mnReglas.add(mntmReglasDelJuego);

		JMenu mnAcercaDe = new JMenu("Acerca de");
		mnReglas.add(mnAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Hundir la Flota");

		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BoxLayout(panelNorte, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panelNorte.add(panel_1);

		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/interfaz/img/JackSparrow.png")));

		JPanel panel_2 = new JPanel();
		panelNorte.add(panel_2);

		JLabel lblNewLabel_2 = new JLabel("Aqu\u00ED ir\u00EDa animaci\u00F3n");
		panel_2.add(lblNewLabel_2);

		JPanel panel_3 = new JPanel();
		panelNorte.add(panel_3);

		JLabel nombreCPU = new JLabel(this.cpu.nombreJugador);
		panel_3.add(nombreCPU);

		JLabel lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource(this.cpu.getImagenJugador())));

		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);

		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		panelTablero = new JPanel();
		contentPane.add(panelTablero, BorderLayout.CENTER);
		panelTablero.setLayout(new BoxLayout(panelTablero, BoxLayout.X_AXIS));

		panelTablero1 = new JPanel();
		panelTablero.add(panelTablero1);
		panelTablero1.setLayout(new GridLayout(Cte.NUM_FILAS, Cte.NUM_COLUMNAS));

		JPanel panel = new JPanel();
		panelTablero.add(panel);

		JPanel panelTablero2 = new JPanel();
		panelTablero.add(panelTablero2);
		panelTablero2.setLayout(new GridLayout(Cte.NUM_FILAS, Cte.NUM_COLUMNAS));

		//TODO Seleccionar jugador que comienza tirada
		turnoPlayer1= true;


		//BOTONES TABLERO
		for(int i = 0; i < 2; i++) {

			for(int x = 0; x < Cte.NUM_FILAS; x++) {
				for(int y = 0; y < Cte.NUM_COLUMNAS; y++) {

					//Asignacion al tablero mis barcos++
					if(i == 0) {

						BotonesTablero botonMisBarcos = new BotonesTablero();
						botonMisBarcos.setPosX(x);
						botonMisBarcos.setPosY(y);

						//En el momento de la creacion de los botones ya le asignamos las posiciones de los barcos del PLAYER 1
						botonMisBarcos.setValorCelda(  this.player.tablero[x][y]   );

						//Player contendra una lista de botones los cuales seran modificados en los disparos que sufra de la CPU
						player.anyadirBoton(botonMisBarcos);

						panelTablero1.add(botonMisBarcos);
					}

					//Asignacion al tablero mis ataques
					if(i == 1) {

						BotonesTablero botonMisAtaques = new BotonesTablero();
						botonMisAtaques.setPosX(x);
						botonMisAtaques.setPosY(y);
						botonMisAtaques.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								turnoPlayer(botonMisAtaques);
							}

						});						

						//En el momento de la creacion de los botones ya le asignamos las posiciones de los barcos de la CPU
						botonMisAtaques.setValorCelda(this.cpu.tablero[x][y]);

						//Anyadir boton al tablero
						panelTablero2.add(botonMisAtaques);
					}
				}
			}
		}

		iniciarPartida();

	}

	public void iniciarPartida () {

		cpu.iniciarPartida();

		//Mientras no se acabe alguna de las dos flotas la partida continua

	}


	private void turnoPlayer(BotonesTablero botonMisAtaques) {

		if(turnoPlayer1) {

			disparar(botonMisAtaques);
			turnoPlayer1 = false;
			turnoCPU();

		}
	}

	private void turnoCPU() {

		boolean todosHundidosCPU = false;
		boolean impacto = false;
		//mientras cpu y player tengan barcos la partida esta en marcha

		if(!turnoPlayer1) {

			ataqueCPU(player.getBotonesPlayer(), null, false);
			turnoPlayer1 = true;


		}
	}


	private void ataqueCPU(ArrayList<BotonesTablero> botones, BotonesTablero boton, Boolean impacto) {

		//Celda que va a recibir un ataque aleatorio
		int posicionAtacada = 0;
		//Celda que ya ha recibido un impacto y se tiene en cuenta para proximo ataque
		int celdaImpactada;
		
		//Guarda un segundo impacto seguido, ya que sabe la posicion en la que esta
		int memoriaCpu = 0;

		//Si el ataque no viene precedido de un impacto, realiza un ataque aleatorio sobre el tablero del player
		if(!impacto) {
			//Seleccion de ataque aleatorio
			posicionAtacada = (int) (Math.random() * 100);
			boton = botones.get(posicionAtacada);
			

		}else {
			
			//Si no hay nada en la memoria disparo aleatorio sobre la posicion atacada previamente
			if(memoriaCpu == 0) {
				
				//Ataque derecha
				if(posicionAtacada != 99) { 
					
					posicionAtacada = posicionAtacada +1;
					System.out.println(posicionAtacada);

				}else{

					posicionAtacada = posicionAtacada -1;
				}

				/*
				//Ataque izquierda
				if(posicionAtacada != 0) posicionAtacada = posicionAtacada -1;

				//Ataque arriba
				if(posicionAtacada < 10) posicionAtacada = posicionAtacada +10;

				//Ataque abajo
				if(posicionAtacada > 89) posicionAtacada = posicionAtacada -10;
				 */

			}
			//Si hay algo en la memoria disparar segun ella



		}

		//Disparamos sobre la posicion indicada
		disparar(boton);

		boton = botones.get(posicionAtacada);
		
		//Si se produce impacto...
		impacto = (boton.getValorCelda() == Cte.TOCADO) ? true : false;

		//...sigue tirando hasta que falle 
		if(impacto) {
			//Si impacta sobre barco comprobar si todos los barcos del player estan hundidos
			comprobarSiTodosHundidos(player.getFlota());

			ataqueCPU(botones,boton,impacto);		
		}

	}

	//Recibe el boton sobre el que se ha disparado. Segun el impacto modifica su color y valor
	private void disparar(BotonesTablero boton) {

		//Si en la celda ya se ha producido un disparo no permitimos disparo sobre ella de nuevo
		if(boton.getValorCelda() == Cte.INTACTO) {

			boton.setValorCelda(Cte.AGUA);
		}

		if(boton.getValorCelda() == Cte.HAY_BARCO) {

			boton.setValorCelda(Cte.TOCADO);

			if(comprobarSiHundido(boton)) System.out.println("HUNDIDO");;


		}		

		boton.asignarColorBoton();

		//comprobarSiTodosHundidos(player.getFlota());		

	}

	private boolean comprobarSiHundido(BotonesTablero b) {

		boolean hundido = false;
		Flota flota = null;

		//Con el turno de player1 analizamos la flota cpu para saber danyos causados
		if(turnoPlayer1) flota = cpu.getFlota();

		//Con el turno de CPU analizamos la flota cpu para saber danyos causados
		if(!turnoPlayer1) flota = player.getFlota();

		if (b.getValorCelda() == Cte.TOCADO) {

			Barco barco = flota.devuelveBarco(b.getPosX(), b.getPosY());

			hundido = barco.saberSiHundido();
		}

		return hundido;
	}	

	//Este metodo devolvera true cuando la flota de cualquier jugador este destruida
	private boolean comprobarSiTodosHundidos(Flota flota) {



		return true;
	}

}
