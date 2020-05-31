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
import javax.swing.JTextPane;

import java.awt.Font;
import javax.swing.JTable;

import java.io.IOException;
import java.net.URISyntaxException;

public class Avatar extends JFrame {

	public JPanel panel;
	private JButton BotonReytrailer;

	public Avatar() {
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

		colocarFotoAvatar();
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

		JLabel LogoBlockBlaster = new JLabel("BlockBlasterLogoMarco");
		LogoBlockBlaster.setBounds(91, 6, 320, 108);

		ImageIcon Logo = new ImageIcon("Blockblaster_logo_Marco.png");
		LogoBlockBlaster.setIcon(new ImageIcon(Logo.getImage().getScaledInstance(LogoBlockBlaster.getWidth(),
				LogoBlockBlaster.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(LogoBlockBlaster);

		// Boton enlace
		URLboton labelURL = new URLboton();
		labelURL.setBounds(40, 226, 72, 18);
		labelURL.setURL("https://www.youtube.com/watch?v=_Tmz_ot3nnY");
		labelURL.setText("Enlace  trailer");
		labelURL.setForeground(Color.white);
		labelURL.setFont(new Font("Beirut", Font.PLAIN, 10));
		getContentPane().add(labelURL);

		//

		/*
		 * JPanel panelFondo = new JPanel(); panelFondo.setBounds(0, 0, 499, 478);
		 * panelFondo.setBackground(new Color(46, 45, 45));
		 * getContentPane().add(panelFondo); panelFondo.setLayout(null);
		 */

	}

	private void colocarFotoAvatar() {

		ImageIcon fAvatar = new ImageIcon("avatarimg.png");

		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 499, 478);
		panelFondo.setBackground(new Color(46, 45, 45));
		getContentPane().add(panelFondo);
		panelFondo.setLayout(null);
		// rey leon
		JLabel Avatar = new JLabel("Avatar");
		Avatar.setBounds(30, 19, 125, 200);
		panelFondo.add(Avatar);
		Avatar.setIcon(new ImageIcon(
				fAvatar.getImage().getScaledInstance(Avatar.getWidth(), Avatar.getHeight(), Image.SCALE_SMOOTH)));

		JTextPane TextSinopsis = new JTextPane();
		TextSinopsis.setText("En un exuberante planeta llamado Pandora viven los Na'vi, seres que aparentan ser primitivos pero que en realidad son muy evolucionados. Debido a que el ambiente de Pandora es venenoso, los híbridos humanos/Na'vi, llamados Avatares, están relacionados con las mentes humanas, lo que les permite moverse libremente por Pandora. Jake Sully, un exinfante de marina paralítico se transforma a través de un Avatar, y se enamora de una mujer Na'vi.");
		TextSinopsis.setBounds(181, 67, 296, 185);
		TextSinopsis.setForeground(Color.WHITE);
		TextSinopsis.setBackground(new Color(46, 45, 45));
		panelFondo.add(TextSinopsis);
	}

}