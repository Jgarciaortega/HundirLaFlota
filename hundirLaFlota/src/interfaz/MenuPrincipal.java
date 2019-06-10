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
/**
 * <h2>Clase MenuPrincipal</h2>
 * 
 * Un JFrame en el cual se desarrolla la partida entre el jugador y la CPU
 * Estos los atributos de esta clase:
 * <ul>
 * <li>imagenRuta</li>
 * <li>nombreJugador</li>
 * <li>turnoPlayer1</li>
 * <li>cpu</li>
 * <li>player</li>
 * </ul>
 * @author Javier García y Marcel Ramírez
 *
 */
public class MenuPrincipal extends JFrame {

	private PanelFondo contentPane;	
	private String imagenRuta;
	private String nombreJugador;
	private boolean turnoPlayer1; 

	//TODO Inicializar correctamente
	CPU cpu = new CPU();
	Jugador1 player = new Jugador1("Pepe","");


	public MenuPrincipal(String imagenRuta, String nombreJugador) {

		//INICIO INTERFAZ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		this.imagenRuta = imagenRuta;
		this.nombreJugador = nombreJugador;
		setExtendedState(MAXIMIZED_BOTH);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);

		JMenuItem mntmNuevoJuego = new JMenuItem("Nuevo Juego");
		mntmNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarPartida();

			}
		});
		mnJuego.add(mntmNuevoJuego);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnJuego.add(mntmSalir);

		JMenu mnReglas = new JMenu("Ayuda");
		menuBar.add(mnReglas);

		JMenuItem mntmReglasDelJuego = new JMenuItem("Reglas del Juego");
		mntmReglasDelJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamarVentanaAyuda(2);
			}
		});
		mnReglas.add(mntmReglasDelJuego);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamarVentanaAyuda(1);
			}
		});
		mnReglas.add(mntmAcercaDe);
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
		panelMarco_1.setBorder(new LineBorder(new Color(222, 184, 135), 3, true));
		panelMarco_1.setOpaque(false);
		panel_1.add(panelMarco_1);

		JLabel lblNewLabel = new JLabel();
		panelMarco_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource(this.imagenRuta)));

		JLabel label = new JLabel(this.nombreJugador);
		label.setFont(new Font("Stencil", Font.PLAIN, 21));
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
		panelMarco_2.setBorder(new LineBorder(new Color(222, 184, 135), 3));
		panelMarco_2.setOpaque(false);
		panel_3.add(panelMarco_2);

		JLabel nombreCPU = new JLabel(this.cpu.nombreJugador);
		nombreCPU.setFont(new Font("Stencil", Font.PLAIN, 19));
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

		PanelTablero panelTablero1 = new PanelTablero();
		panelTablero1.setOpaque(true);
		panelTablero.add(panelTablero1);
		panelTablero1.setLayout(new GridLayout(Cte.NUM_FILAS, Cte.NUM_COLUMNAS));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panelTablero.add(panel);

		PanelTablero panelTablero2 = new PanelTablero();
		panelTablero2.setOpaque(false);
		panelTablero.add(panelTablero2);
		panelTablero2.setLayout(new GridLayout(Cte.NUM_FILAS, Cte.NUM_COLUMNAS));

		//TODO Seleccionar jugador que comienza tirada
		turnoPlayer1= true;


		//BOTONES TABLERO
		for(int i = 0; i < 2; i++) {

			int cont = 0;

			for(int x = 0; x < Cte.NUM_FILAS; x++) {
				for(int y = 0; y < Cte.NUM_COLUMNAS; y++) {

					//Asignacion al tablero mis barcos++
					if(i == 0) {

						BotonesTablero botonMisBarcos = new BotonesTablero();
						botonMisBarcos.setPosX(x);
						botonMisBarcos.setPosY(y);
						botonMisBarcos.setId(cont);

						//En el momento de la creacion de los botones ya le asignamos las posiciones de los barcos del PLAYER 1
						botonMisBarcos.setValorCelda(this.player.tablero[x][y]);

						//Player contendra una lista de botones los cuales seran modificados en los disparos que sufra de la CPU
						player.anyadirBoton(botonMisBarcos);

						panelTablero1.add(botonMisBarcos);
					}

					//Asignacion al tablero mis ataques
					if(i == 1) {

						BotonesTablero botonMisAtaques = new BotonesTablero();
						botonMisAtaques.setPosX(x);
						botonMisAtaques.setPosY(y);
						botonMisAtaques.setId(cont);

						botonMisAtaques.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								turnoPlayer(botonMisAtaques);
							}

						});		


						//CPU contendra una lista de botones los cuales seran modificados en los disparos que sufra de la CPU
						cpu.anyadirBoton(botonMisAtaques);

						//En el momento de la creacion de los botones ya le asignamos las posiciones de los barcos de la CPU
						botonMisAtaques.setValorCelda(this.cpu.tablero[x][y]);

						//Anyadir boton al tablero
						panelTablero2.add(botonMisAtaques);
					}

					cont++;
				}
			}
		}

		iniciarPartida();

	}
	/**
	 * <h2>iniciarPartida</h2>
	 * Metodo que inicia la partida
	 */
	public void iniciarPartida () {

		cpu.iniciarPartida();

		//Mientras no se acabe alguna de las dos flotas la partida continua

	}

	/**
	 * <h2>turnoPlayer</h2>
	 * Metodo que le da el turno al Jugador_1. Durante este turno puede realizar acciones
	 * @param botonMisAtaques: es el boton que ha atacado el jugador 1 
	 */
	private void turnoPlayer(BotonesTablero botonMisAtaques) {

		if(turnoPlayer1) {
			//La funcion disparar devuelve un boolean cuando se dispara sobre una celda que no contiene un impacto previo
			if (disparar(botonMisAtaques)) {

				turnoPlayer1 = false;
				turnoCPU();
			}
		}
	}
	/**
	 * <h2>turnoCPU</h2>
	 * Metodo que le da el turno a la CPU. Durante este turno la CPU realizara una accion
	 * 
	 * 
	 */
	private void turnoCPU() {

		//mientras cpu y player tengan barcos la partida esta en marcha

		if(!turnoPlayer1) {
			
			ataqueCPU(player.getBotonesOponenente(), null);
			turnoPlayer1 = true;

		}
	}
	/**
	 * <h2>ataqueCPU</h2>
	 * Es el algoritmo principal que sigue la cpu para elegir la mejor opción a la hora de atacar
	 * @param botones: un arraylist de botones
	 * @param boton: un boton para aplicar los cambios en ese boton
	 */
	private void ataqueCPU(ArrayList<BotonesTablero> botones, BotonesTablero boton) {

		//Celda que va a recibir un ataque 
		int posicionAtacada = 0;

		//Celda que ya ha recibido un impacto y se tiene en cuenta para proximo ataque
		int celdaImpactada;

		//La direccion que tomara el ataque con respecto a la celda previamente impactada
		String direccionAtaque = "";

		//Si no hay impacto previo...
		if(cpu.getCeldaImpactada() == -1) {

			//Realizar hasta que se localice una celda valida...
			do {

				posicionAtacada = (int) (Math.random() * 99);

			}while(!comprobarSiCeldaEsAtacable(botones, posicionAtacada));

			//Obtenemos el boton con la posicion seleccionada
			boton = botones.get(posicionAtacada);

			//...si el ataque viene precedido de impacto
		}else {

			posicionAtacada = cpu.getCeldaImpactada();			
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
		boolean impacto = (boton.getValorCelda() == Cte.TOCADO)  ? true : false;

		//Si hunde barco reiniciamos memoria y disparamos de nuevo
		if(boton.getValorCelda() == Cte.HUNDIDO) {
			
			reiniciarMemoriaCPU();
			ataqueCPU(player.getBotonesOponenente(), null);
			
			
		}
		
		//...sigue tirando hasta que falle 
		if(impacto) {
			
			//Si entra aqui es porque ha habido mas de un impacto.Ya podemos averiguar la posicion en la que esta(vertical-horizontal)
			if(cpu.getCeldaImpactada() != -1) {

				cpu.setPosicionBarco(averiguarPosicionBarco(boton));  

			}

			//Guardamos en registro cpu la celda que acabamos de alcanzar
			cpu.setCeldaImpactada(posicionAtacada);

			//Comprobar si hundido
			if(comprobarSiHundido(boton)) {

				reiniciarMemoriaCPU();
				//Comprobamos si aun quedan barcos en la flota del player
				if(comprobarSiTodosHundidos(player.getFlota())) {

					//TODO programar fin de juego
					System.out.println("FIN DE JUEGO");
				}

			}

			//CPU vuelve a atacar
			ataqueCPU(botones,boton);

		}else {

			//Falla pero ha habido un impacto previo...
			if(cpu.getCeldaImpactada() != -1) {
				//...si ya sabe la posicion del barco guardamos la posicion fallada para tenerla en cuenta en la eleccion proximo disparo
				if(cpu.getPosicionBarco() != "indefinido") {

					cpu.setDireccionUltDisparoFallado(direccionAtaque);

				}
				
				
			}
		}
	}
	/**
	 * <h2>avariguarPosicionBarco</h2>
	 * Un metodo para que la cpu sepa en que posicion se encuentra los barcos del jugador
	 * @param boton: un boton qque le indica la posicion a la cpu
	 * @return
	 * <ul>
	 * <li>devuelve la poscion en la que se encuentra el barco</li>
	 * </ul>
	 */
	private String averiguarPosicionBarco(BotonesTablero boton) {

		Flota flota = player.getFlota();
		Barco barco;
		String posicion;
		int [][] posiciones;
		int x = boton.getPosX();
		int y = boton.getPosY();

		barco = flota.devuelveBarco(x, y, false);
		posiciones = barco.posiciones;

		if (posiciones[0][0] == posiciones[1][0]) posicion = "horizontal";

		else posicion = "vertical";		

		return posicion;
	}
	/**
	 * <h2>reiniciarMemoriaCPU</h2>
	 * Metodo que reinicia la memoria de la CPU
	 * 
	 */
	private void reiniciarMemoriaCPU() {

		cpu.setCeldaImpactada(-1);
		cpu.setPosicionBarco("indefinido");
		cpu.setDireccionUltDisparoFallado("indefinido");

	}
	/**
	 * <h2>elegirDireccion</h2>
	 * Metodo que utiliza la cpu para elegir la dirreccion del siguiente disparo
	 * @param botones: un ArrayList de botones
	 * @return
	 * <ul>
	 * <li>devulve la direccion donde va disparar la CPU </li>
	 * </ul>
	 */
	private String elegirDireccion(ArrayList<BotonesTablero> botones) {

		String direccionDisparo = "";

		direccionDisparo = obtenerDireccion(botones);

		return direccionDisparo;
	}

	/**
	 * <h2>obtenerDireccion</h2>
	 * Metodo que obtiene la direccioon en la que va dispara la CPU
	 * @param botones: un arrayList de botones
	 * @return
	 *<ul>
	 *<li>la direccion de donde va a disparar<li>
	 *</ul>
	 */
	private String obtenerDireccion(ArrayList<BotonesTablero> botones) {

		int celdaDisparada = cpu.getCeldaImpactada();
		BotonesTablero boton;
		ArrayList <String> direccionesPosibles = new ArrayList <String>();
		String direccionDisparo ="";

		//segun la celda sobre la que se haya hecho impacto deberemos analizar los alrededores
		direccionesPosibles = comprobarAlrededores(celdaDisparada);

		for(int i = 0; i < direccionesPosibles.size(); i++) {

			direccionDisparo = direccionesPosibles.get(i);
			//Aqui obtenemos los botones que estan junto a la celda seleccionada
			boton = botones.get(cpu.getCeldaImpactada() + devolverValorDireccion(direccionDisparo));
			if ((boton.getValorCelda() == Cte.HAY_BARCO) || (boton.getValorCelda() == Cte.INTACTO)) {

				//Si no hay un disparo previo fallado nos vale la direccion de disparo seleccionada...
				if(cpu.getDireccionUltDisparoFallado().equals("indefinido")) {

					break;
					//...si hay fallo en la direccion del ultimo disparo comprobamos...
				}else {
					//...si no coincide con la direccion de disparo fallada aceptamos la direccion, si no continua bucle hasta seleccionar otra opcion
					if(!cpu.getDireccionUltDisparoFallado().equals(direccionDisparo)) {

						break;

					}

				}

			}

		}


		return direccionDisparo;
	}

	/**
	 * <h2>devolverValorDIreccion</h2>
	 * Metodo que devuelve el valor de la direccion de donde ha disparado la cPU
	 * 
	 * @param direccionDisparo: un String que tiene la direccion del disparo
	 * @return
	 * <ul>
	 * <li>el valor de la direccion</li>
	 * </ul>
	 */
	//Segun la direccion equivaldra a restar o sumar al valor de celda actual
	private int devolverValorDireccion(String direccionDisparo) {

		int[] valorDireccion = new int [4];
		int valor = 0;

		valorDireccion[0] = -1;
		valorDireccion[1] = +1;
		valorDireccion[2] = -10;
		valorDireccion[3] = +10;

		if(direccionDisparo.equals("izquierda")) valor = valorDireccion[0];
		if(direccionDisparo.equals("derecha")) valor = valorDireccion[1];
		if(direccionDisparo.equals("arriba")) valor = valorDireccion[2];
		if(direccionDisparo.equals("abajo")) valor = valorDireccion[3];


		return valor;
	}
	/**
	 * <h2>comprobarAlrededores</h2>
	 * Metodo que comprueba los alrededores de donde ha disparado la CPU
	 * @param celdaDisparada: un int que tiene el numero de la celda disparada
	 * @return
	 * <ul>
	 * <li>devuelve las direcciones posibles en las que se encuetra la cpu</li>
	 * </ul>
	 */
	//Para analizar la celda sobre la que disparar hay que analizar sus digitos:
	// 0 o 9 suponen fin de eje X o Y. 
	private ArrayList<String> comprobarAlrededores(int celdaDisparada) {

		String celdaDisparadaStr = null;
		char caracter;
		char coordenadaX = 'a';
		char coordenadaY = 'a' ;
		ArrayList <String> direccionesPosibles = new ArrayList <String>();

		celdaDisparadaStr = Integer.toString(celdaDisparada);

		for (int i = 0; i < celdaDisparadaStr.length(); i++) {

			caracter = celdaDisparadaStr.charAt(i);

			if (i == 0) coordenadaY = caracter;
			if (i == 1) coordenadaX = caracter;

		}

		//Direcciones posibles que puede tomar la cpu

		if(cpu.getPosicionBarco() == "indefinido") {

			direccionesPosibles.add("izquierda");
			direccionesPosibles.add("derecha");
			direccionesPosibles.add("arriba");
			direccionesPosibles.add("abajo");

		}else {

			if(cpu.getPosicionBarco() == "horizontal") {

				direccionesPosibles.add("izquierda");
				direccionesPosibles.add("derecha");

			}

			if(cpu.getPosicionBarco() == "vertical") {

				direccionesPosibles.add("arriba");
				direccionesPosibles.add("abajo");

			}			

		}		

		//Eliminamos las posibles direcciones que no se pueden tomar dependiendo de su posicion

		//Si Y vale 0 anulamos direccion izquierda
		if(coordenadaY == '0') direccionesPosibles.remove(0);

		//Si Y vale 9 anulamos direccion derecha
		if(coordenadaY == '9') direccionesPosibles.remove(1);

		//Si X vale 9 anulamos direccion abajo
		if(coordenadaX == '0') direccionesPosibles.remove(4);


		return direccionesPosibles;


	}
	/**
	 * <h2>comprobarSiCeldaEsAtacable</h2>
	 *Metodo que comprueba si la cpu puede atacar ahi o no
	 *
	 * @param botones: un arrayList de botones
	 * @param posicionAtacada: un int que tiene la posicion atacada
	 * @return
	 * <ul>
	 * <li>devuelve un boolean que indica si la celda se puede atacar</li>
	 * </ul>
	 */
	//Comprueba si la celda seleccionada puede recibir un ataque. No podra recibirlo si su estado es diferente a intacto o hay barco
	private boolean comprobarSiCeldaEsAtacable(ArrayList<BotonesTablero> botones, int posicionAtacada) {

		boolean atacable = false;
		BotonesTablero boton;

		boton = botones.get(posicionAtacada);

		if (boton.getValorCelda() == Cte.INTACTO) atacable = true;

		if (boton.getValorCelda() == Cte.HAY_BARCO) atacable = true;

		return atacable;

	}

	/**
	 * <h2>disparar</h2>
	 * Metodo que utilizan la CPU y el Jugador para dispara y para que cambie el valor de las celdas
	 * @param boton: un boton qe contiene el estado de este
	 * @return
	 * <ul>
	 * <li>devuelve un boolean que indica si se ha efectuado el disparo</li>
	 * </ul>
	 */
	//Recibe el boton sobre el que se ha disparado. Segun el impacto modifica su color y valor
	private boolean disparar(BotonesTablero boton) {

		boolean disparoEfectuado = false;
		Flota flota = null;
		ArrayList <BotonesTablero> botones = new ArrayList <BotonesTablero>();
		Barco barco;

		//Con el turno de player1 analizamos la flota cpu para saber danyos causados
		if(turnoPlayer1) flota = cpu.getFlota(); botones = cpu.getBotonesOponenente();

		//Con el turno de CPU analizamos la flota cpu para saber danyos causados
		if(!turnoPlayer1) flota = player.getFlota(); botones = player.getBotonesOponenente();

		//Si en la celda ya se ha producido un disparo no permitimos disparo sobre ella de nuevo
		if(boton.getValorCelda() == Cte.INTACTO) {

			boton.setValorCelda(Cte.AGUA);					
			disparoEfectuado = true;

		}

		if(boton.getValorCelda() == Cte.HAY_BARCO) {

			boton.setValorCelda(Cte.TOCADO);
			barco = flota.devuelveBarco(boton.getPosX(), boton.getPosY(),false);
			comprobarSiHundido(boton);
			disparoEfectuado = true;

			if(comprobarSiHundido(boton)) {

				//Marcamos barco como hundido
				barco.setHundido();

				//Despues de hundir todos los botones de ese barco deben cambiar su imagen
				modificarBotonesAlrededor(botones,boton);
				System.out.println("SI");

			}

		}		

		boton.asignarColorBoton();



		return disparoEfectuado;

		//comprobarSiTodosHundidos(player.getFlota());		

	}


	//Al hundir un barco todos los botones de alrededor deben cambiar su imagen
	private void modificarBotonesAlrededor(ArrayList<BotonesTablero> botones, BotonesTablero boton) {

		//Comprueba en sus alrededores si hay mas celdas tocadas
		boolean izquierda =false;
		boolean derecha =false;
		boolean arriba =false;
		boolean abajo =false;

		boton.setValorCelda(Cte.HUNDIDO);

		while(!izquierda) izquierda = mirarA("izquierda",botones,boton);
		while(!derecha) derecha = mirarA("derecha",botones,boton);
		while(!arriba) arriba = mirarA("arriba",botones,boton);	
		while(!abajo) abajo = mirarA("abajo",botones,boton);
	}
	

	//Observa el estado de los botones de alrededor para saber si el barco esta hundido
	private boolean mirarA(String direccion, ArrayList<BotonesTablero> botones, BotonesTablero boton) {

		int idBoton = boton.getId();	
		boolean fin = false;
		int valor = 0;

		//Valores que incrementamos o restamos a idboton para obtener botones alrededor
		if(direccion.equals("izquierda")) valor = -1;
		if(direccion.equals("derecha"))   valor =  1;
		if(direccion.equals("arriba"))    valor = -10;
		if(direccion.equals("abajo"))     valor =  10;

		while(!fin) {

			idBoton = idBoton + valor;

			if ((direccion.equals("izquierda")) && (idBoton < 0)) {

				fin = true; break;
			}

			if ((direccion.equals("derecha"))   && (idBoton > 99)) {


				fin = true; break;    
			}


			if ((direccion.equals("arriba"))   && (idBoton < 9)) {


				fin = true; break;    
			}

			if ((direccion.equals("abajo"))   && (idBoton > 89)) {


				fin = true; break;    
			}

			boton = botones.get(idBoton);

			System.out.println(boton.getValorCelda());
			if(boton.getValorCelda() == Cte.TOCADO) {

				System.out.println(boton.getId());
				boton.setValorCelda(Cte.HUNDIDO);
				boton.asignarColorBoton();

			}else {

				fin = true;
				break;
			}

		}
		return fin;

	}
	/**
	 * <h2>comprobarSiHundido</h2>
	 * Metodo que comprueba si el barco esta hundido
	 * @param b: un barco para mirar si esta hundido o no
	 * @return
	 * <ul>
	 * <li>devuelve un boolean que indica si se hundido o no</li>
	 * </ul>
	 */
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
	/**
	 * <h2>comprobarSiTodosHundidos</h2>
	 * Metodo que comprueba si todos los barcos de la flota estan hundidos
	 * @param flota: una flota que contiene todos los barcos de la CPU o del Jugador
	 * @return 
	 * <ul>
	 * <li>devuelve un boolean indicando si estan todos los barcos hundidos</li>
	 * </ul>
	 */
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
	/**
	 * <h2>llamarVentanaAyuda</h2>
	 * Metodo  que llama a la Ventana ayuda si has seleccionado en el menu las reglas o el Acerca de
	 * @param referencia: un int que indica cual de las dos has llamado
	 */
	private void llamarVentanaAyuda(int referencia) {

		DialogoAyuda informacion = new DialogoAyuda(referencia);

		informacion.setVisible(true);

	}

	/**
	 * <h2>reniciarPartida</h2>
	 * Metodo que reinicia la partida si se le da en el menu a Nuevo Juego
	 */
	private void reiniciarPartida() {
		dispose();
		MenuPrincipal juego = new MenuPrincipal(this.imagenRuta, this.nombreJugador);
		juego.setVisible(true);

	}

}