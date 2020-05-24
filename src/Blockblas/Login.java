package Blockblas;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Login extends JFrame {

	public JPanel panel;
	private JButton BotonSaludo;

	public Login() {
		setSize(500, 500); // Tamaño de la ventana
		setTitle("Blockblaster"); // TITULO DE LA VENTANA(EL QUE SALE ARRIBA EN LA BARRA)

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

	

		colocarBotonVentan2();

	}

	private void colocarPaneles() {
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));

		this.getContentPane().add(panel);

		panel.setLayout(null);

	}

	private void colocarEtiquetas() {

		JLabel WELCOME = new JLabel("Today is a good day!");
		WELCOME.setBounds(180, 116, 170, 16);
		panel.add(WELCOME);

		JLabel Foto = new JLabel("GuessWho");
		Foto.setBounds(74, 18, 360, 99);

		ImageIcon pingui = new ImageIcon("GuessWho.jpg");
		Foto.setIcon(new ImageIcon(
				pingui.getImage().getScaledInstance(Foto.getWidth(), Foto.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(Foto);

	}

							/*PARA ABRIR OTRA VENTANA
	 * 
	 * 
	 	private void colocarBotonVentan2() {

		BotonSaludo = new JButton("Start"); // Abre la Ventan2
		BotonSaludo.setFont(new Font("Avenir Next Condensed", Font.PLAIN, 24));
		BotonSaludo.setBounds(180, 209, 130, 56);
		panel.add(BotonSaludo);
		Ventan2 abrir = new Ventan2(); // se crea la variable

		// El mouse listener con el clicked, se hace para que cuando pulses haga lo que
		// esté dentro del codigo
		BotonSaludo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrir.setVisible(true); // Esto abre Ventan2

			}
		});

		this.setVisible(false); // para que se cierre Login cuando se pulse el boton de abrir Ventan2

	}*/

}
