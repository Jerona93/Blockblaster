package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import bbdd.conexion;
import beans.User;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;

public class Princi extends JFrame {

	public JPanel panel;
	private JButton BotonPagpelis;
	private JButton BotonPerfil;
	private JTable table;

	public Princi() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/controlador/Blockblaster_logo_Marco.png")));
		setSize(600, 400); // Tamaño de la ventana
		setTitle("BlockBlaster"); // TITULO DE LA VENTANA(EL QUE SALE ARRIBA EN LA BARRA)

		// setLocation(460, 200); //Establece posicion inicial de la ventana
		// setBounds(460, 200, 500, 500); //Este parametro engloba el size y el
		// location, los dos primeros es el location los dos ultimos el size

		setLocationRelativeTo(null); // Este parametro pone la pantalla en el centro de cualquier pantalla

		this.getContentPane().setBackground(Color.LIGHT_GRAY);

		iniciarComponentes(); // Llamamos al panel que creamos

		setDefaultCloseOperation(EXIT_ON_CLOSE); // Para que cierre el programa cuando le damos a la cruz
		setResizable(false); // Para que no se pueda cambiar tamaño
	}

	private void iniciarComponentes() {

		colocarPaneles();

		colocarEtiquetas();

		colocarPagpelis();
		colocarBperfil();

	}

	private void colocarPaneles() {
		panel = new JPanel();
		panel.setBackground(new Color(46, 45, 45));

		this.getContentPane().add(panel);

		panel.setLayout(null);

	}

	private void colocarEtiquetas() {
		String user = Login.userInput.getText();
		// int saldo = User.getSaldo();

		JLabel WELCOME = new JLabel("Bienvenido  " + user + ".");
		WELCOME.setForeground(Color.WHITE);
		WELCOME.setFont(new Font("Beirut", Font.PLAIN, 16));
		WELCOME.setBounds(385, 53, 224, 16);
		panel.add(WELCOME);

		JLabel LogoBlockBlaster = new JLabel("BlockBlasterLogoMarco");
		LogoBlockBlaster.setBounds(43, 6, 320, 108);

		ImageIcon Logo = new ImageIcon("Blockblaster_logo_Marco.png");
		LogoBlockBlaster.setIcon(new ImageIcon(Logo.getImage().getScaledInstance(LogoBlockBlaster.getWidth(),LogoBlockBlaster.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(LogoBlockBlaster);

	}

	private void colocarBperfil() {

		BotonPerfil = new JButton("Perfil"); // Abre la Ventan2
		BotonPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonPerfil.setFont(new Font("Avenir Next Condensed", Font.PLAIN, 20));
		BotonPerfil.setBounds(492, 81, 79, 29);
		panel.add(BotonPerfil);
		VerPerfil abrir = new VerPerfil(); // se crea la variable

		// El mouse listener con el clicked, se hace para que cuando pulses haga lo que
		// esté dentro del codigo
		BotonPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//dispose(); // Cierra la ventana actual al abrir la de abajo
				abrir.setVisible(true); // Esto abre Ventan2
			}

		});

		// dispose(); // para cerrar un frame
		// this.setVisible(false); // para que ocultar un frame

	}

	private void colocarPagpelis() {

		BotonPagpelis = new JButton("Peliculas"); // Abre la Ventan2
		BotonPagpelis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonPagpelis.setFont(new Font("Avenir Next Condensed", Font.PLAIN, 20));
		BotonPagpelis.setBounds(43, 188, 108, 35);
		panel.add(BotonPagpelis);
		Pagpelis abrir = new Pagpelis(); // se crea la variable

		// El mouse listener con el clicked, se hace para que cuando pulses haga lo que
		// esté dentro del codigo
		BotonPagpelis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//dispose(); // Cierra la ventana actual al abrir la de abajo
				abrir.setVisible(true); // Esto abre Ventan2
			}

		});

		// dispose(); // para cerrar un frame
		// this.setVisible(false); // para que ocultar un frame

	}

}
