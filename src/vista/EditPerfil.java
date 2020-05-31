package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import bbdd.conexion;
import beans.User;
import modelo.Historial;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;

public class EditPerfil extends JFrame {

	public JPanel panel;
	private JLabel saludo;
	public static JTextField userInput;
	public static JTextField telefonoInput;
	private JPasswordField passwordInput;
	private JLabel lblTelefono;
	private JLabel lblContrasea;

	public EditPerfil() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Login.class.getResource("/controlador/Blockblaster_logo_Marco.png")));
		setSize(500, 300); // Tamaño de la ventana
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

		colocarEdit();

	}

	private void colocarPaneles() {
		panel = new JPanel();
		panel.setBackground(new Color(46, 45, 45));

		this.getContentPane().add(panel);

		panel.setLayout(null);

	}

	private void colocarEtiquetas() {
		String user = Login.userInput.getText();

		JLabel LogoBlockBlaster = new JLabel("BlockBlasterLogoMarco");
		LogoBlockBlaster.setBounds(91, 6, 320, 108);

		ImageIcon Logo = new ImageIcon("Blockblaster_logo_Marco.png");
		LogoBlockBlaster.setIcon(new ImageIcon(Logo.getImage().getScaledInstance(LogoBlockBlaster.getWidth(),
				LogoBlockBlaster.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(LogoBlockBlaster);

	}

	private void colocarEdit() {

		JLabel userLabel = new JLabel("Usuario:");
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(23, 148, 76, 14);
		panel.add(userLabel);

		userInput = new JTextField();
		userInput.setColumns(10);
		userInput.setBounds(101, 145, 190, 20);
		panel.add(userInput);

		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setBounds(23, 180, 76, 14);
		panel.add(lblTelefono);
		
		telefonoInput = new JTextField();
		telefonoInput.setColumns(10);
		telefonoInput.setBounds(101, 177, 190, 20);
		panel.add(telefonoInput);
		
		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(23, 209, 76, 14);
		panel.add(lblContrasea);

		passwordInput = new JPasswordField(); // Con esto se oculta la contraseña
		passwordInput.setBounds(101, 203, 190, 26);
		panel.add(passwordInput);

		JButton updateButton = new JButton("Actualizar");
		updateButton.setBounds(367, 177, 101, 23);
		panel.add(updateButton);

		

	

		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userInput.getText();
				String password = passwordInput.getText();
				String telefono = telefonoInput.getText();
				new controlador.Login().updateUser(user, password, telefono);
			}
		});
		
		
	}

}
