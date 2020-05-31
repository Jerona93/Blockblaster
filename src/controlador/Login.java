package controlador;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import bbdd.conexion;
import beans.User;

public class Login { //Controladorr
	
	public void insertUser(String user, String password,String telefono) {
		new modelo.Users().insertUser(user,password, telefono);
	}
	
	public void updateUser(String user, String password, String telefono) {
		new modelo.Users().insertUser(user,password,telefono);
	}
	
	public void deleteUser(String user) {
		new modelo.Users().deleteUser(user);
	}
	
	
	
	public void checkUser(String user, String password) {
		//Recoge los usuarios
		boolean check = new modelo.Users().checkUserAndPass(user, password, 0, 0);
		if(check) {
			/*PRueba icono pantalla usuario correcto
			Icon icono = (Icon) new ImageIcon(getClass().getResource("src/controlador/Blockblaster_logo_Marco.png")).getImage();
			JOptionPane.showMessageDialog(null, "Usuario correcto","imagen_LOGO", JOptionPane.DEFAULT_OPTION,icono);
			*/
			

			JOptionPane.showMessageDialog(null, "Usuario correcto");
			new vista.Princi().setVisible(true); //PAra abrir la ventana principal

			
		}else { // Sino error
			JOptionPane.showMessageDialog(null, "Usuario no encontrado");
		}
	}
	
	public boolean checkUserOld(String user, String password) {
		// Recoger los usuarios
		ArrayList<User> usuarios = new modelo.Users().getAllUsers();
		// Comprobar si usuario y contrase�a son correctos
		for(User usuario : usuarios) {
			if(user.equals(usuario.getUser()) && password.equals(usuario.getPassword())) {
				JOptionPane.showMessageDialog(null, "Usuario correcto"); //Pantalla de usuario correcto
				
			}else { // Sino error
				JOptionPane.showMessageDialog(null, "Usuario no encontrado");
			}
		}
		return true;
	}
	
}
