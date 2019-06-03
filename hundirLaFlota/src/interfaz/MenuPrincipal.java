package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;	

	private boolean turnoPlayer1; 

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

		//INICIO INTERFAZ
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

			try {
				Thread.sleep(1000*5);
				disparar(botonMisAtaques);
				turnoPlayer1 = false;
				turnoCPU();

			} catch (InterruptedException e) {

				e.printStackTrace();
			}			

		}
	}

	private void turnoCPU() {

		boolean todosHundidosCPU = false;
		boolean impacto = false;
		//mientras cpu y player tengan barcos la partida esta en marcha

		if(!turnoPlayer1) {
			

			ataque(player.getBotonesPlayer(), null);
			turnoPlayer1 = true;


		}
	}


	private void ataque(ArrayList<BotonesTablero> botones, BotonesTablero boton) {

		//Celda que va a recibir un ataque aleatorio
		int posicionAtacada;
		//Celda que ya ha recibido un impacto y se tiene en cuenta para proximo ataque
		int celdaImpactada;
		boolean impacto = false;

		//Si el ataque no viene precedido de un impacto, realiza un ataque aleatorio sobre el tablero del player
		if(!impacto) {
			//Seleccion de ataque aleatorio
			posicionAtacada = (int) (Math.random() * 100);
			boton = botones.get(posicionAtacada);

		}else {

			//TODO Crear la inteligencia artificial CPU tras impactar en un barco del player

		}

		//Disparamos sobre la posicion indicada
		disparar(boton);

		//Si se produce impacto...
		impacto = (boton.getValorCelda() == Cte.TOCADO) ?true:false;

		//...sigue tirando hasta que falle 
		if(impacto) {

			//Si impacta sobre barco comprobar si todos los barcos del player estan hundidos
			comprobarSiTodosHundidos(player.getFlota());

			ataque(botones,boton);		
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

		}		

		boton.asignarColorBoton();

		comprobarSiHundido(boton);

		comprobarSiTodosHundidos(player.getFlota());		

	}

	private boolean comprobarSiHundido(BotonesTablero b) {

		boolean hundido = false;

		Flota f = new Flota();

		if (b.getValorCelda() == Cte.TOCADO) {

			Barco barco = f.devuelveBarco(b.getPosX(), b.getPosY());
		}

		return hundido;
	}	

	//Este metodo devolvera true cuando la flota de cualquier jugador este destruida
	private boolean comprobarSiTodosHundidos(Flota flota) {


		return true;
	}

}
