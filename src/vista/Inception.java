package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import bbdd.conexion;
import beans.User;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JTextPane;

public class Inception extends JFrame {

	public JPanel panel;
	private JButton BotonReytrailer;


	
	public Inception() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/controlador/Blockblaster_logo_Marco.png")));
		setSize(500, 350); // Tamaño de la ventana
		setTitle("BlockBlaster"); // TITULO DE LA VENTANA(EL QUE SALE ARRIBA EN LA BARRA)

		// setLocation(460, 200); //Establece posicion inicial de la ventana
		// setBounds(460, 200, 500, 500); //Este parametro engloba el size y el
		// location, los dos primeros es el location los dos ultimos el size

		setLocationRelativeTo(null); // Este parametro pone la pantalla en el centro de cualquier pantalla

		this.getContentPane().setBackground(Color.LIGHT_GRAY);

		iniciarComponentes(); // Llamamos al panel que creamos

		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Para que cierre el programa cuando le damos a la cruz
		setResizable(false); // Para que no se pueda cambiar tamaño

	}

	private void iniciarComponentes() {

		colocarPaneles();

		colocarEtiquetas();
		
		colocarFotoInception();
	}

	private void colocarPaneles() {
		getContentPane().setLayout(null);
		panel = new JPanel();
		panel.setBounds(0, 478, 499, -478);
		panel.setBackground(new Color(46, 45, 45));

		this.getContentPane().add(panel);

		panel.setLayout(null);

	}

	private void colocarEtiquetas() {
		
	
		
	}
	
	private void colocarFotoInception() {
				

				ImageIcon fInception = new ImageIcon("origenimg.jpg");
				
				JPanel panelFondo = new JPanel();
				panelFondo.setBounds(0, 0, 499, 478);
				panelFondo.setBackground(new Color(46, 45, 45));
				getContentPane().add(panelFondo);
				panelFondo.setLayout(null);
				//Foto Inception
				JLabel Inception = new JLabel("Inception");
				Inception.setBounds(30, 19, 125, 200);
				panelFondo.add(Inception);
				Inception.setIcon(new ImageIcon(fInception.getImage().getScaledInstance(Inception.getWidth(), Inception.getHeight(), Image.SCALE_SMOOTH)));
				
				JTextPane TextSinopsis = new JTextPane();
				TextSinopsis.setText("Dom Cobb es un ladrón con una extraña habilidad para entrar a los sueños de la gente y robarles los secretos de sus subconscientes. Su habilidad lo ha vuelto muy popular en el mundo del espionaje corporativo, pero ha tenido un gran costo en la gente que ama. Cobb obtiene la oportunidad de redimirse cuando recibe una tarea imposible: plantar una idea en la mente de una persona. Si tiene éxito, será el crimen perfecto, pero un enemigo se anticipa a sus movimientos.");
				TextSinopsis.setBounds(181, 67, 296, 200);
				TextSinopsis.setForeground(Color.WHITE);
				TextSinopsis.setBackground(new Color(46, 45, 45));
				panelFondo.add(TextSinopsis);
				
				//Boton enlace
				URLboton labelURL = new URLboton();
				labelURL.setBounds(40, 226, 72, 18);
				panelFondo.add(labelURL);
				labelURL.setURL("https://www.youtube.com/watch?v=8PIPJWei6Hw");
				labelURL.setText("Enlace  trailer");
				labelURL.setForeground(Color.WHITE);
				labelURL.setFont(new Font("Beirut", Font.PLAIN, 10));
	}
}