package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class SeleccionarAvatar extends JFrame {

	private JPanel contentPane;
	private JButton btnAvatar1;
	private JButton btnAvatar2;
	private JButton btnAvatar3;
	private JButton btnAvatar4;
	private JButton btnAvatar5;
	private JButton btnAvatar6;
	private JButton btnAvatar7;
	private JButton btnAvatar8;
	
	private MenuPrincipal juego;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField textNombre;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JButton btnIniciarPartida;
	private URL imagenAvatar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionarAvatar frame = new SeleccionarAvatar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SeleccionarAvatar() {
		setTitle("Hundir la flota");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSeleccioneUnAvatar = new JButton("Seleccione un Avatar");
		btnSeleccioneUnAvatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aparecerAvatares();
			}

		
		});
		
		panel = new JPanel();
		panel.setBounds(0, 212, 623, 229);
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(SeleccionarAvatar.class.getResource("/interfaz/img/transparente1.png")));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);
		
		btnAvatar1 = new JButton("Avatar 1");
		GridBagConstraints gbc_btnAvatar1 = new GridBagConstraints();
		gbc_btnAvatar1.insets = new Insets(0, 0, 5, 5);
		gbc_btnAvatar1.gridx = 1;
		gbc_btnAvatar1.gridy = 1;
		panel_1.add(btnAvatar1, gbc_btnAvatar1);
		 
		 label = new JLabel("");
		 label.setIcon(new ImageIcon(SeleccionarAvatar.class.getResource("/interfaz/img/transparente1.png")));
		 GridBagConstraints gbc_label = new GridBagConstraints();
		 gbc_label.insets = new Insets(0, 0, 5, 5);
		 gbc_label.gridx = 2;
		 gbc_label.gridy = 1;
		 panel_1.add(label, gbc_label);
		 
		 btnAvatar2 = new JButton("Avatar 2");
		 GridBagConstraints gbc_btnAvatar2 = new GridBagConstraints();
		 gbc_btnAvatar2.insets = new Insets(0, 0, 5, 5);
		 gbc_btnAvatar2.gridx = 3;
		 gbc_btnAvatar2.gridy = 1;
		 panel_1.add(btnAvatar2, gbc_btnAvatar2);
		 btnAvatar2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		pasarImagen(2);
		 	}
		 });
		 btnAvatar2.setVisible(false);
		 
		 label_1 = new JLabel("");
		 label_1.setIcon(new ImageIcon(SeleccionarAvatar.class.getResource("/interfaz/img/transparente1.png")));
		 GridBagConstraints gbc_label_1 = new GridBagConstraints();
		 gbc_label_1.insets = new Insets(0, 0, 5, 5);
		 gbc_label_1.gridx = 4;
		 gbc_label_1.gridy = 1;
		 panel_1.add(label_1, gbc_label_1);
		
		 btnAvatar3 = new JButton("Avatar 3");
		 GridBagConstraints gbc_btnAvatar3 = new GridBagConstraints();
		 gbc_btnAvatar3.insets = new Insets(0, 0, 5, 5);
		 gbc_btnAvatar3.gridx = 5;
		 gbc_btnAvatar3.gridy = 1;
		 panel_1.add(btnAvatar3, gbc_btnAvatar3);
		 btnAvatar3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		pasarImagen(3);
		 	}
		 });
		 btnAvatar3.setVisible(false);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SeleccionarAvatar.class.getResource("/interfaz/img/transparente1.png")));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 6;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);
		
		btnAvatar4 = new JButton("Avatar 4");
		GridBagConstraints gbc_btnAvatar4 = new GridBagConstraints();
		gbc_btnAvatar4.insets = new Insets(0, 0, 5, 5);
		gbc_btnAvatar4.gridx = 7;
		gbc_btnAvatar4.gridy = 1;
		panel_1.add(btnAvatar4, gbc_btnAvatar4);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(SeleccionarAvatar.class.getResource("/interfaz/img/transparente1.png")));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 2;
		panel_1.add(label_4, gbc_label_4);
		
		btnAvatar5 = new JButton("Avatar 5");
		btnAvatar5.setVisible(false);
		btnAvatar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAvatar5 = new GridBagConstraints();
		gbc_btnAvatar5.insets = new Insets(0, 0, 0, 5);
		gbc_btnAvatar5.gridx = 1;
		gbc_btnAvatar5.gridy = 3;
		panel_1.add(btnAvatar5, gbc_btnAvatar5);
		
		btnAvatar6 = new JButton("Avatar 6");
		btnAvatar6.setVisible(false);
		btnAvatar6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAvatar6 = new GridBagConstraints();
		gbc_btnAvatar6.insets = new Insets(0, 0, 0, 5);
		gbc_btnAvatar6.gridx = 3;
		gbc_btnAvatar6.gridy = 3;
		panel_1.add(btnAvatar6, gbc_btnAvatar6);
		
		btnAvatar7 = new JButton("Avatar 7");
		btnAvatar7.setVisible(false);
		btnAvatar7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAvatar7 = new GridBagConstraints();
		gbc_btnAvatar7.insets = new Insets(0, 0, 0, 5);
		gbc_btnAvatar7.gridx = 5;
		gbc_btnAvatar7.gridy = 3;
		panel_1.add(btnAvatar7, gbc_btnAvatar7);
		
		btnAvatar8 = new JButton("Avatar 8");
		btnAvatar8.setVisible(false);
		btnAvatar8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAvatar8 = new GridBagConstraints();
		gbc_btnAvatar8.insets = new Insets(0, 0, 0, 5);
		gbc_btnAvatar8.gridx = 7;
		gbc_btnAvatar8.gridy = 3;
		panel_1.add(btnAvatar8, gbc_btnAvatar8);
		btnAvatar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarImagen(4);
			}
		});
		btnAvatar4.setVisible(false);
		btnAvatar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarImagen(1);
			}

			
		});
		btnAvatar1.setVisible(false);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(20);
		panel.add(panel_2, BorderLayout.WEST);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(20);
		panel.add(panel_3, BorderLayout.EAST);
		
		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_4.add(panel_5);
		
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_4.add(panel_6);
		
		btnIniciarPartida = new JButton("Iniciar Partida");
		btnIniciarPartida.setEnabled(false);
		btnIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarPartida(imagenAvatar);
			}

		});
		panel_6.add(btnIniciarPartida);
		
		panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_4.add(panel_7);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setBounds(216, 110, 172, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		textNombre.getText();
		
		btnSeleccioneUnAvatar.setForeground(new Color(255, 0, 0));
		btnSeleccioneUnAvatar.setFont(new Font("Stencil", Font.PLAIN, 16));
		btnSeleccioneUnAvatar.setBounds(181, 178, 243, 23);
		contentPane.add(btnSeleccioneUnAvatar);
		
		JLabel lblIntroduzcaUnNombre = new JLabel("Introduzca un nombre");
		lblIntroduzcaUnNombre.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblIntroduzcaUnNombre.setBounds(33, 106, 173, 29);
		contentPane.add(lblIntroduzcaUnNombre);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(SeleccionarAvatar.class.getResource("/interfaz/img/logo.png")));
		logo.setBounds(69, 0, 483, 61);
		contentPane.add(logo);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(SeleccionarAvatar.class.getResource("/interfaz/img/fondo seleccion.png")));
		fondo.setBounds(0, 0, 623, 441);
		contentPane.add(fondo);
	}
	
	//metodo para hacre que aparezcan los botones
	private void aparecerAvatares() {
		
		btnAvatar1.setVisible(true);
		btnAvatar2.setVisible(true);
		btnAvatar3.setVisible(true);
		btnAvatar4.setVisible(true);
		btnAvatar5.setVisible(true);
		btnAvatar6.setVisible(true);
		btnAvatar7.setVisible(true);
		btnAvatar8.setVisible(true);
		
	}
	
	
	//TODO Cambiar lo de las imagenes del avatar
	//metodo para hacer que los botones pasen su imagen al otro frame
	private void pasarImagen(int numeroAvatar) {
		
		String imagen;
		URL rutaAvatar = null;
		
		switch(numeroAvatar) {
		
		case 1 : imagen = "/interfaz/img/Barba_negra.png";
				 rutaAvatar =getClass().getResource(imagen);
				 break;
		
		case 2 : imagen = "/interfaz/img/barbosa.png";
				 rutaAvatar =getClass().getResource(imagen);
				 break;
		
		case 3 : imagen = "/interfaz/img/capitanGarfio.png";
		 		 rutaAvatar =getClass().getResource(imagen);
		 		 break;
			
		case 4 : imagen = "/interfaz/img/jacksparrow.png";
		 		 rutaAvatar =getClass().getResource(imagen);
		 		 break;	
		 		 
		case 5: imagen = "/interfaz/img/jacksparrow.png";
		 		rutaAvatar =getClass().getResource(imagen);
		 		break;
		 		
		case 6: imagen = "/interfaz/img/jacksparrow.png";
		 		rutaAvatar =getClass().getResource(imagen);
		 		break;
		 		
		case 7: imagen = "/interfaz/img/jacksparrow.png";
		 		rutaAvatar =getClass().getResource(imagen);
		 		break;
		 		
		case 8: imagen = "/interfaz/img/jacksparrow.png";
		 		rutaAvatar =getClass().getResource(imagen);
		 		break; 		
		}
		
		this.imagenAvatar = rutaAvatar;
		this.btnIniciarPartida.setEnabled(true);
		
	}
	
	private void iniciarPartida(URL imagenRuta) {
		
		this.juego = new MenuPrincipal(imagenRuta, this.textNombre.getText());
		this.juego.setVisible(true);
		this.juego.setExtendedState(MAXIMIZED_BOTH);
		
		
	}
}

