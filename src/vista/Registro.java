package vista;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;


import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField passwordInput;
	public static JTextField userInput;
	public static JTextField telefonoInput;
	private JPasswordField passwordField;
	/**
	 * Create the frame.
	 */
	public Registro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/controlador/Blockblaster_logo_Marco.png")));
		setTitle("BLOCKBLASTER"); // TITULO DE LA VENTANA(EL QUE SALE ARRIBA EN LA BARRA)
		setSize(500, 500); // Tamaño de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null); // Este parametro pone la pantalla en el centro de cualquier pantalla
		setContentPane(contentPane);
		setResizable(false); // Para que no se pueda cambiar tamaño
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 45, 45));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel LogoBlockBlaster = new JLabel("BlockBlasterLogoMarco");
		LogoBlockBlaster.setForeground(Color.WHITE);
		LogoBlockBlaster.setBounds(93, 34, 320, 108);

		ImageIcon Logo = new ImageIcon("Blockblaster_logo_Marco.png");
		LogoBlockBlaster.setIcon(new ImageIcon(
				Logo.getImage().getScaledInstance(LogoBlockBlaster.getWidth(), LogoBlockBlaster.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(LogoBlockBlaster);
		
		/*passwordInput = new JTextField();
		passwordInput.setBounds(128, 270, 190, 20);
		panel.add(passwordInput);
		passwordInput.setColumns(10);*/
		
		passwordInput = new JPasswordField(); //Con esto se oculta la contraseña 
		passwordInput.setBounds(128, 241, 190, 26);
		panel.add(passwordInput);
		
		userInput = new JTextField();
		userInput.setColumns(10);
		userInput.setBounds(128, 184, 190, 20);
		panel.add(userInput);
		
		telefonoInput = new JTextField();
		telefonoInput.setColumns(10);
		telefonoInput.setBounds(128, 298, 190, 20);
		panel.add(telefonoInput);
		
		JLabel userLabel =  new JLabel("Usuario:");
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(128, 169, 76, 14);
		panel.add(userLabel);
		
		JLabel passwordLabel = new JLabel("Contraseña:");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(128, 227, 76, 14);
		panel.add(passwordLabel);
		
		JButton insertButton = new JButton("Crear");
		insertButton.setBounds(177, 329, 89, 23);
		//insertButton.setBorder((Border) Color.yellow);
		panel.add(insertButton);
		
		JButton loginButton = new JButton("Entrar");
		loginButton.setBounds(177, 387, 89, 23);
		panel.add(loginButton);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setBounds(128, 279, 76, 14);
		panel.add(lblTelefono);
		
		
		
		// Acciones
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Llamar al controlador
				String user = userInput.getText();
				String password = passwordInput.getText();
			
				
				new controlador.Login().checkUser(user, password);
				dispose();
				//new vista.Princi().setVisible(true); //PAra abrir la ventana principal

			}
			
			
		});
		
		
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userInput.getText();
				String password = passwordInput.getText();
				String telefono = telefonoInput.getText();
				new controlador.Login().insertUser(user, password, telefono);
				JOptionPane.showMessageDialog(null, "Usuario creado");
			}
			
		});
		
		
		
	}
}
