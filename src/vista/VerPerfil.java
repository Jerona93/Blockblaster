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

public class VerPerfil extends JFrame {

	public JPanel panel;
	private JLabel saludo;
	private JButton BotonPerfil;
	private JButton BotonFactura;
	private JButton BotonEditPerfil;
	
	private JTable table;
	private Container contentPane;
	private JTable table_1;

	public VerPerfil() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/controlador/Blockblaster_logo_Marco.png")));
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

		colocarBeditPerfil();


	}

	private void colocarPaneles() {
		panel = new JPanel();
		panel.setBackground(new Color(46, 45, 45));

		this.getContentPane().add(panel);

		panel.setLayout(null);

	}
	
	private void colocarBeditPerfil() {

		BotonEditPerfil = new JButton(" Edit Perfil"); // Abre la Ventan2
		BotonEditPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonEditPerfil.setFont(new Font("Avenir Next Condensed", Font.PLAIN, 16));
		BotonEditPerfil.setBounds(78, 143, 92, 29);
		panel.add(BotonEditPerfil);
		EditPerfil abrir = new EditPerfil(); // se crea la variable

		// El mouse listener con el clicked, se hace para que cuando pulses haga lo que
		// esté dentro del codigo
		BotonEditPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//dispose(); // Cierra la ventana actual al abrir la de abajo
				abrir.setVisible(true); // Esto abre Ventan2
			}

		});
	}

	private void colocarEtiquetas() {
		String user = Login.userInput.getText();
		
		

		JLabel LogoBlockBlaster = new JLabel("BlockBlasterLogoMarco");
		LogoBlockBlaster.setBounds(91, 6, 320, 108);

		ImageIcon Logo = new ImageIcon("Blockblaster_logo_Marco.png");
		LogoBlockBlaster.setIcon(new ImageIcon(
				Logo.getImage().getScaledInstance(LogoBlockBlaster.getWidth(), LogoBlockBlaster.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(LogoBlockBlaster);
		
		//tabla
		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setFont(new Font("Arial", Font.PLAIN, 18));
		table_1.setBounds(23, 199, 455, 46);
		panel.add(table_1);
		table_1.setBackground(new Color(46, 45, 45));		//color de fondo de la tabla
		table_1.setForeground(Color.WHITE);		//Color de la fuente
		//contentPane.add(table_1);
		
		JButton BotonPerfil = new JButton("Info perfil");
		BotonPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT user, telefono, Saldo, PelisAlquiladas FROM `usuarios` WHERE user='"+user+"'";		//conectamos con php
				//SELECT user, telefono, Saldo FROM

                DefaultTableModel model = new DefaultTableModel();

                model.addColumn("user");
                model.addColumn("telefono");				//columnas
                model.addColumn("saldo");
                model.addColumn("P.Alquiladas");
                
                

                table_1.setModel(model);

                String[] dato = new String[4];

                try {

                    ResultSet result = conexion.EjecutarSentencia(sql);

                    while (result.next()) {
                        dato[0] = result.getString(1);
                        dato[1] = result.getString(2);
                        dato[2] = result.getString(3);  
                        dato[3] = result.getString(4);  
                        model.addRow(dato);
                    }
                }catch (SQLException e1) {
                    e1.printStackTrace();
                }
				
			}
		});
			
		
		BotonPerfil.setBounds(184, 143, 117, 29);
		panel.add(BotonPerfil);
		
		JButton BotonFactura = new JButton("Historial");
		BotonFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Historial factura = new Historial();
	                try {
	                    Historial.imprimirfactura();
	                } catch (IOException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
			}
		});
		BotonFactura.setBounds(345, 143, 117, 29);
		panel.add(BotonFactura);
		
		/*Boton para sacar factura
		JButton BotonFactura = new JButton("Imprimir Factura");
        BotonFactura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Factura factura = new Factura();
                try {
                    Factura.imprimirfactura();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });*/
		
	}
}
