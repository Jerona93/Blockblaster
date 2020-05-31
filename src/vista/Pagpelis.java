package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class Pagpelis extends JFrame {

	public JPanel panel;	
	private JTable table_1;
	private JButton BotonReyleon;
	private JButton BotonAvatar;
	
	

	public Pagpelis() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/controlador/Blockblaster_logo_Marco.png")));
		setSize(700, 700); // Tamaño de la ventana
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
		
		colocarFotosPelis();
		
		colocarBReyleon();
		
		colocarBAvatar();
		
		colocarBInception();

	}

	private void colocarPaneles() {
		panel = new JPanel();
		panel.setBackground(new Color(46, 45, 45));

		this.getContentPane().add(panel);

		panel.setLayout(null);

	}

	private void colocarEtiquetas() {
		
	

		JLabel LogoBlockBlaster = new JLabel("BlockBlasterLogoMarco");
		LogoBlockBlaster.setBounds(202, 6, 320, 108);

		ImageIcon Logo = new ImageIcon("Blockblaster_logo_Marco.png");
		LogoBlockBlaster.setIcon(new ImageIcon(
				Logo.getImage().getScaledInstance(LogoBlockBlaster.getWidth(), LogoBlockBlaster.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(LogoBlockBlaster);

	
	
	//tabla
			table_1 = new JTable();
			table_1.setFont(new Font("Arial", Font.PLAIN, 18));
			table_1.setBounds(162, 534, 403, 102);
			panel.add(table_1);
			table_1.setBackground(new Color(46, 45, 45));		//color de fondo de la tabla
			table_1.setForeground(Color.WHITE);		//Color de la fuente
			//contentPane.add(table_1);
			
			JButton BotonInfoPelis = new JButton("Lista películas");
			BotonInfoPelis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql = "SELECT titulo, año, duración FROM `películas`";		//conectamos con php


	                DefaultTableModel model = new DefaultTableModel();

	                model.addColumn("titulo");
	                model.addColumn("año");				//columnas
	                model.addColumn("duracion");
	                
	                

	                table_1.setModel(model);

	                String[] dato = new String[3];

	                try {

	                    ResultSet result = conexion.EjecutarSentencia(sql);

	                    while (result.next()) {
	                        dato[0] = result.getString(1);
	                        dato[1] = result.getString(2);
	                        dato[2] = result.getString(3);                      
	                        model.addRow(dato);
	                    }
	                }catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
					
				}
			});
			BotonInfoPelis.setBounds(305, 493, 117, 29);
			panel.add(BotonInfoPelis);

	}
	
	private void colocarBReyleon() {

		BotonReyleon = new JButton("Ver detalles"); // Abre la Ventan2
		BotonReyleon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonReyleon.setFont(new Font("Avenir Next Condensed", Font.PLAIN, 16));
		BotonReyleon.setBounds(289, 338, 93, 29);
		panel.add(BotonReyleon);
		ReyLeon abrir = new ReyLeon(); // se crea la variable
		boolean ReyLeon;

		// El mouse listener con el clicked, se hace para que cuando pulses haga lo que
		// esté dentro del codigo
		BotonReyleon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//dispose(); // Cierra la ventana actual al abrir la de abajo
				abrir.setVisible(true); // Esto abre Ventan2
			}

		});

		// dispose(); // para cerrar un frame
		// this.setVisible(false); // para que ocultar un frame

	}
	
	private void colocarBAvatar() {

		BotonAvatar = new JButton("Ver detalles"); // Abre la Ventan2
		BotonAvatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonAvatar.setFont(new Font("Avenir Next Condensed", Font.PLAIN, 16));
		BotonAvatar.setBounds(527, 338, 97, 29);
		panel.add(BotonAvatar);
		boolean PagAvatar = true;
		Avatar abrir = new Avatar(); // se crea la variable

		// El mouse listener con el clicked, se hace para que cuando pulses haga lo que
		// esté dentro del codigo
		BotonAvatar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//dispose(); // Cierra la ventana actual al abrir la de abajo
				abrir.setVisible(true); // Esto abre Ventan2
			}

		});

		// dispose(); // para cerrar un frame
		// this.setVisible(false); // para que ocultar un frame

	}
	
	private void colocarBInception() {

		BotonAvatar = new JButton("Ver detalles"); // Abre la Ventan2
		BotonAvatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonAvatar.setFont(new Font("Avenir Next Condensed", Font.PLAIN, 16));
		BotonAvatar.setBounds(64, 338, 93, 29);
		panel.add(BotonAvatar);
		Inception abrir = new Inception(); // se crea la variable

		// El mouse listener con el clicked, se hace para que cuando pulses haga lo que
		// esté dentro del codigo
		BotonAvatar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//dispose(); // Cierra la ventana actual al abrir la de abajo
				abrir.setVisible(true); // Esto abre Ventan2
			}

		});

		// dispose(); // para cerrar un frame
		// this.setVisible(false); // para que ocultar un frame

	}
	
	private void colocarFotosPelis() {
		//avatar
		JLabel Avatar = new JLabel("Avatar");
		Avatar.setBounds(517, 126, 125, 200);

		ImageIcon fAvatar = new ImageIcon("avatarimg.png");
		Avatar.setIcon(new ImageIcon(fAvatar.getImage().getScaledInstance(Avatar.getWidth(), Avatar.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(Avatar);
		
		//rey leon
		JLabel Reyleon = new JLabel("Rey Leon");
		Reyleon.setBounds(279, 126, 125, 200);

		ImageIcon fReyleon = new ImageIcon("reyleonimg.jpg");
		Reyleon.setIcon(new ImageIcon(fReyleon.getImage().getScaledInstance(Reyleon.getWidth(), Reyleon.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(Reyleon);
		
		//inception
		JLabel Inception = new JLabel("Inception");
		Inception.setBounds(54, 126, 125, 200);

		ImageIcon fInception = new ImageIcon("origenimg.jpg");
		Inception.setIcon(new ImageIcon(fInception.getImage().getScaledInstance(Inception.getWidth(), Inception.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(Inception);
		
		


	}
}



