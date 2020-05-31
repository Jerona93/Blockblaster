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
import javax.swing.AbstractButton;
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

public class ReyLeon extends JFrame {

	public JPanel panel;
	private JButton BotonReytrailer;
	private JTable table_1;



	
	public ReyLeon() {
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

		colocarUrl();
		
		colocarFotoReyleon();
	}

	private void colocarPaneles() {
		getContentPane().setLayout(null);
		panel = new JPanel();
		panel.setBounds(0, 478, 499, -478);
		panel.setBackground(new Color(46, 45, 45));

		this.getContentPane().add(panel);

		panel.setLayout(null);

	}

	private void colocarUrl() {
		
		//Boton enlace
		URLboton labelURL = new URLboton();
		labelURL.setBounds(40, 226, 72, 18);
		labelURL.setURL("https://www.youtube.com/watch?v=7rxwEfFMbaY");
		labelURL.setText("Enlace  trailer");
		labelURL.setForeground(Color.WHITE);
		labelURL.setFont(new Font("Beirut", Font.PLAIN, 10));		
		getContentPane().add(labelURL);
		
	
		
	}
	
	private void colocarFotoReyleon() {
				

				
				
				JPanel panelFondo = new JPanel();
				panelFondo.setBounds(0, 0, 499, 478);
				panelFondo.setBackground(new Color(46, 45, 45));
				getContentPane().add(panelFondo);
				panelFondo.setLayout(null);
				//rey leon
				ImageIcon fReyleon = new ImageIcon("reyleonimg.jpg");
				JLabel Reyleon = new JLabel("Rey Leon");
				Reyleon.setBounds(30, 19, 125, 200);
				panelFondo.add(Reyleon);
				Reyleon.setIcon(new ImageIcon(fReyleon.getImage().getScaledInstance(Reyleon.getWidth(), Reyleon.getHeight(), Image.SCALE_SMOOTH)));
				
				//sinpopsis en jtexpanel
				JTextPane TextSinopsis = new JTextPane();
				
				TextSinopsis.setText("Tras el asesinato de su padre, Simba, un joven león es apartado su reino y tendrá que descubrir con ayuda de amigos de la sabana africana el significado de la responsabilidad y la valentía. Más tarde volverá para recuperar el control de su reino.");
				TextSinopsis.setBounds(181, 67, 296, 119);
				TextSinopsis.setForeground(Color.WHITE);
				TextSinopsis.setBackground(new Color(46, 45, 45));
				panelFondo.add(TextSinopsis);
				
				
				//Prueba boton con tabla sinopsiss
				
				JButton btnNewButton = new JButton("Ver Sinopsis");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sql = "SELECT sinopsis FROM `películas` WHERE titulo='El Rey leon'";		//conectamos con php
						//SELECT user, telefono, Saldo FROM

		                DefaultTableModel model = new DefaultTableModel();

		                model.addColumn("sinopsis"); 

		                table_1.setModel(model);

		                String[] sinop = new String[1];

		                try {

		                    ResultSet result = conexion.EjecutarSentencia(sql);

		                    while (result.next()) {
		                        sinop[0] = result.getString(1);  
		                        model.addRow(sinop);
		                    }
		                }catch (SQLException e1) {
		                    e1.printStackTrace();
		                }
						
					}
				});
				btnNewButton.setBounds(296, 216, 117, 29);
				panelFondo.add(btnNewButton);
				
				//tabla
				table_1 = new JTable();
				table_1.setBounds(146, 257, 315, 57);
				table_1.setFillsViewportHeight(true);
				table_1.setColumnSelectionAllowed(true);
				table_1.setFont(new Font("Arial", Font.PLAIN, 18));
				table_1.setBackground(new Color(46, 45, 45));		//color de fondo de la tabla
				table_1.setForeground(Color.WHITE);		//Color de la fuente
				panelFondo.add(table_1);
				
				
				//Prueba fotoBBDD
				JLabel lblNewLabel = new JLabel("Ver imagen");
				lblNewLabel.setBounds(191, 165, 61, 49);
				panelFondo.add(lblNewLabel);
				String fotoleon = "SELECT imagen FROM `películas` WHERE titulo ='El Rey leon'";	
				ImageIcon fotoReyleon = new ImageIcon("fotoleon");
				
				Reyleon.setBounds(30, 19, 125, 200);
				panelFondo.add(Reyleon);
				Reyleon.setIcon(new ImageIcon(fReyleon.getImage().getScaledInstance(Reyleon.getWidth(), Reyleon.getHeight(), Image.SCALE_SMOOTH)));
				
				//PRueba tabla sinopsis
				
	}
}
