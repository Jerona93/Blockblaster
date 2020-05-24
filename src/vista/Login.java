package vista;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;


import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField passwordInput;
	private JTextField userInput;
	/**
	 * Create the frame.
	 */
	public Login() {
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
		
		passwordInput = new JTextField();
		passwordInput.setBounds(128, 270, 190, 20);
		panel.add(passwordInput);
		passwordInput.setColumns(10);
		
		userInput = new JTextField();
		userInput.setColumns(10);
		userInput.setBounds(128, 212, 190, 20);
		panel.add(userInput);
		
		JLabel userLabel =  new JLabel("Usuario");
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(128, 190, 76, 14);
		panel.add(userLabel);
		
		JLabel passwordLabel = new JLabel("Contrase\u00F1a");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(128, 244, 76, 14);
		panel.add(passwordLabel);
		
		JButton insertButton = new JButton("Insertar");
		insertButton.setBounds(52, 397, 89, 23);
		panel.add(insertButton);
		
		JButton loginButton = new JButton("Entrar");
		loginButton.setBounds(153, 397, 89, 23);
		panel.add(loginButton);
		
		
		JButton updateButton = new JButton("Actualizar");
		updateButton.setBounds(254, 397, 101, 23);
		panel.add(updateButton);
		
		JButton deleteButton = new JButton("Eliminar");
		deleteButton.setBounds(367, 397, 89, 23);
		panel.add(deleteButton);
		
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
				new controlador.Login().insertUser(user, password);
			}
			
		});
		
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String user = userInput.getText();
					String password = passwordInput.getText();
					new controlador.Login().updateUser(user, password);
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userInput.getText();
				new controlador.Login().deleteUser(user);
			}
		});
	}
}