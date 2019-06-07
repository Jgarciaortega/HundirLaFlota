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
import java.awt.Font;
import javax.swing.border.LineBorder;

public class MenuPrincipal extends JFrame {

	private PanelFondo contentPane;	

	private boolean turnoPlayer1; 

	//TODO Inicializar correctamente
	CPU cpu = new CPU();
	Jugador1 player = new Jugador1("Pepe","");


	public MenuPrincipal(String imagenRuta, String nombreJugador) {

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
		contentPane = new PanelFondo();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Hundir la Flota");

		JPanel panelNorte = new JPanel();
		panelNorte.setOpaque(false);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BoxLayout(panelNorte, BoxLayout.X_AXIS));
		
		JPanel margen1 = new JPanel();
		FlowLayout fl_margen1 = (FlowLayout) margen1.getLayout();
		fl_margen1.setHgap(-70);
		margen1.setOpaque(false);
		panelNorte.add(margen1);

		PanelMarco panel_1 = new PanelMarco();
		panel_1.setOpaque(false);
		panelNorte.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panelMarco_1 = new JPanel();
		panelMarco_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelMarco_1.setOpaque(false);
		panel_1.add(panelMarco_1);

		JLabel lblNewLabel = new JLabel();
		panelMarco_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource(imagenRuta)));

		JLabel label = new JLabel(nombreJugador);
		label.setFont(new Font("Stencil", Font.PLAIN, 13));
		panelMarco_1.add(label);
		
		JPanel margen2 = new JPanel();
		margen2.setOpaque(false);
		panelNorte.add(margen2);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panelNorte.add(panel_2);

		JLabel lblNewLabel_2 = new JLabel("Aqu\u00ED ir\u00EDa animaci\u00F3n");
		panel_2.add(lblNewLabel_2);
		
		JPanel margen3 = new JPanel();
		margen3.setOpaque(false);
		panelNorte.add(margen3);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panelNorte.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		PanelMarco panelMarco_2 = new PanelMarco();
		panelMarco_2.setBorder(new LineBorder(Color.BLACK, 2));
		panelMarco_2.setOpaque(false);
		panel_3.add(panelMarco_2);

		JLabel nombreCPU = new JLabel(this.cpu.nombreJugador);
		nombreCPU.setFont(new Font("Stencil", Font.PLAIN, 13));
		panelMarco_2.add(nombreCPU);

		JLabel lblNewLabel_1 = new JLabel("");
		panelMarco_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource(this.cpu.getImagenJugador())));
		
		JPanel margen4 = new JPanel();
		FlowLayout fl_margen4 = (FlowLayout) margen4.getLayout();
		fl_margen4.setHgap(-75);
		margen4.setOpaque(false);
		panelNorte.add(margen4);

		JPanel panelOeste = new JPanel();
		panelOeste.setOpaque(false);
		contentPane.add(panelOeste, BorderLayout.WEST);

		JPanel panelSur = new JPanel();
		panelSur.setOpaque(false);
		contentPane.add(panelSur, BorderLayout.SOUTH);

		JPanel panelTablero = new JPanel();
		panelTablero.setOpaque(false);
		contentPane.add(panelTablero, BorderLayout.CENTER);
		panelTablero.setLayout(new BoxLayout(panelTablero, BoxLayout.X_AXIS));

		JPanel panelTablero1 = new JPanel();
		panelTablero1.setOpaque(false);
		panelTablero.add(panelTablero1);
		panelTablero1.setLayout(new GridLayout(Cte.NUM_FILAS, Cte.NUM_COLUMNAS));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panelTablero.add(panel);

		JPanel panelTablero2 = new JPanel();
		panelTablero2.setOpaque(false);
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

			ataqueCPU(player.getBotonesPlayer(), null);
			turnoPlayer1 = true;

		}
	}

	private void ataqueCPU(ArrayList<BotonesTablero> botones, BotonesTablero boton) {

		//Celda que va a recibir un ataque 
		int posicionAtacada = 0;

		//Celda que ya ha recibido un impacto y se tiene en cuenta para proximo ataque
		int celdaImpactada;

		String direccionAtaque;

		//Si no hay impacto previo...
		if(cpu.getCeldaImpactada() != -1) {

			//Realizar hasta que se localice una celda valida...
			do {

				posicionAtacada = (int) (Math.random() * 99);

			}while(comprobarValidezAtaque(botones, posicionAtacada));

			//Obtenemos el boton con la posicion seleccionada
			boton = botones.get(posicionAtacada);

			//Retiramos la celda sobre la que hemos disparado para no repetir ataque en misma posicion
			botones.remove(posicionAtacada);


			//...si el ataque viene precedido de impacto
		}else {

			direccionAtaque = elegirDireccion(botones);

			if(direccionAtaque.equals("izquierda")) {

				posicionAtacada = posicionAtacada -1;
			}
			if(direccionAtaque.equals("derecha")) {

				posicionAtacada = posicionAtacada +1;
			}
			if(direccionAtaque.equals("arriba")) {

				posicionAtacada = posicionAtacada -10;
			}
			if(direccionAtaque.equals("abajo")) {

				posicionAtacada = posicionAtacada +10;
			}
		}

		//Obtenemos boton sobre el que atacar
		boton = botones.get(posicionAtacada);

		//Disparamos sobre la posicion indicada
		disparar(boton);

		//Si se produce impacto...
		boolean impacto = (boton.getValorCelda() == Cte.TOCADO) ? true : false;

		//...sigue tirando hasta que falle 
		if(impacto) {

			//Guardamos en registro cpu la celda que acabamos de alcanzar
			cpu.setCeldaImpactada(posicionAtacada);

			//Si impacta sobre barco comprobar si todos los barcos del player estan hundidos
			comprobarSiTodosHundidos(player.getFlota());

			ataqueCPU(botones,boton);		
		}
	}

	private String elegirDireccion(ArrayList<BotonesTablero> botones) {

		String direccionDisparo;
		String posicionBarco = cpu.getPosicionBarco();
		String direccionUltDisparo = cpu.getDireccionUltDisparo();
		int celdaDisparada = cpu.getCeldaImpactada();

		if(posicionBarco.equals("indefinido")) {

			if(direccionUltDisparo.equals("indefinido")) {
				
				//comprobar alrededores
				//y si impacta por segunda vez seteamos posicion barco

			}else {
				
				//partimos desde la celda que hayamos impactado y seleccionamos el mismo eje de coordenadas para atacar

			}

		}else {

			//algoritmo que decide disparar en el mismo eje de coordenadas
		}

		return null;
	}

	//Comprueba si la celda seleccionada puede recibir un ataque. No podra recibirlo si ya ha recibido un impacto...
	private boolean comprobarValidezAtaque(ArrayList<BotonesTablero> botones, int posicionAtacada) {

		boolean celdaYaAtacada = true;

		try {

			celdaYaAtacada = false;
			botones.get(posicionAtacada);


		}catch (IndexOutOfBoundsException ex) {

			celdaYaAtacada = true;

		}

		return celdaYaAtacada;

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

			Barco barco = flota.devuelveBarco(b.getPosX(), b.getPosY(),true);			
			hundido = barco.saberSiHundido();
		}

		return hundido;
	}	

	//Este metodo devolvera true cuando la flota de cualquier jugador este destruida
	private boolean comprobarSiTodosHundidos(Flota flota) {

		ArrayList <Barco> listaBarcos = flota.misBarcos;
		boolean todosHundidos = true;

		for(int i = 0; i < listaBarcos.size(); i ++) {

			Barco barco = listaBarcos.get(i);

			if(!barco.saberSiHundido()) todosHundidos = false; break;
		}


		return todosHundidos;
	}

}