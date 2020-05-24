package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class Princi extends JFrame {

	public JPanel panel;
	private JTextField cajaTexto;
	private JLabel saludo;
	private JButton BotonSaludo;

	public Princi() {
		setSize(1000, 1000); // Tamaño de la ventana
		setTitle("GUESS WHO"); // TITULO DE LA VENTANA(EL QUE SALE ARRIBA EN LA BARRA)

		// setLocation(460, 200); //Establece posicion inicial de la ventana
		// setBounds(460, 200, 500, 500); //Este parametro engloba el size y el
		// location, los dos primeros es el location los dos ultimos el size

		setLocationRelativeTo(null); // Este parametro pone la pantalla en el centro de cualquier pantalla

		this.getContentPane().setBackground(Color.LIGHT_GRAY);

		iniciarComponentes(); // Llamamos al panel que creamos

		setDefaultCloseOperation(EXIT_ON_CLOSE); // Para que cierre el programa cuando le damos a la cruz
	}

	private void iniciarComponentes() {

		colocarPaneles();

		colocarEtiquetas();

		colocarBotonSaludoes();

		colocarCajaTexto();
		
		colocarBotonVentanPerson();


	}

	private void colocarPaneles() {
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));

		this.getContentPane().add(panel);

		panel.setLayout(null);

	}

	private void colocarEtiquetas() {

		JLabel WELCOME = new JLabel("Welcome! ");
		WELCOME.setFont(new Font("Beirut", Font.PLAIN, 16));
		WELCOME.setBounds(212, 111, 83, 16);
		panel.add(WELCOME);

		JLabel LogoBlockBlaster = new JLabel("BlockBlasterLogoMarco");
		LogoBlockBlaster.setBounds(86, 6, 320, 108);

		ImageIcon Logo = new ImageIcon("Blockblaster_logo_Marco.png");
		LogoBlockBlaster.setIcon(new ImageIcon(
				Logo.getImage().getScaledInstance(LogoBlockBlaster.getWidth(), LogoBlockBlaster.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(LogoBlockBlaster);

	}

	private void colocarCajaTexto() {
		cajaTexto = new JTextField();
		cajaTexto.setBounds(60, 240, 195, 26);
		panel.add(cajaTexto);
		cajaTexto.setColumns(10);
	}

	private void colocarBotonSaludoes() {
		
		//Boton para para el saludo
		
		BotonSaludo = new JButton("Ok!");
		BotonSaludo.setBounds(252, 240, 83, 29);
		panel.add(BotonSaludo);

		saludo = new JLabel();
		saludo.setFont(new Font("Beirut", Font.PLAIN, 14));
		saludo.setBounds(60, 272, 370, 40);
		panel.add(saludo);

		// Agregando evento de tipo ActionListener

		ActionListener oyenteDeAccion = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				saludo.setText("Hi "+ cajaTexto.getText() + ", how are you?");
			}
		
		};

		BotonSaludo.addActionListener(oyenteDeAccion);

	}
	private void colocarBotonVentanPerson() {

		BotonSaludo = new JButton("Go!"); // Abre la Ventan2
		BotonSaludo.setFont(new Font("Avenir Next Condensed", Font.PLAIN, 24));
		BotonSaludo.setBounds(347, 335, 83, 40);
		panel.add(BotonSaludo);
		
		JLabel lblDoYouWant = new JLabel("Do you want to see the characters?");
		lblDoYouWant.setFont(new Font("Beirut", Font.PLAIN, 13));
		lblDoYouWant.setBounds(103, 351, 232, 16);
		panel.add(lblDoYouWant);
		
		JLabel lblWhatsYourName = new JLabel("What's your name?");
		lblWhatsYourName.setBounds(62, 212, 124, 16);
		panel.add(lblWhatsYourName);
		
		Login abrir = new Login(); // se crea la variable para abrir la otra ventana

		// El mouse listener con el clicked, se hace para que cuando pulses haga lo que
		// esté dentro del codigo
		BotonSaludo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrir.setVisible(true); // Esto abre VentanPerson

			}
		});

		this.setVisible(false); // para que se cierre Ventan cuando se pulse el boton de abrir Ventan2

	}
}








