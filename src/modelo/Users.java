package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbdd.conexion;
import beans.User;

public class Users {
	
	public ArrayList<User> getAllUsers() {
		ResultSet resultados = conexion.EjecutarSentencia("SELECT * FROM usuarios");
		ArrayList<User> usuarios = new controlador.Helper().ResultSet2ArrayList(resultados);
		return usuarios;
	}
	
	public boolean checkUserAndPass(String user, String password, int saldo, int PelisAlquiladas) {
		

		ResultSet usuarioBD = conexion.EjecutarSentencia("SELECT * FROM usuarios WHERE user='"+user+"' AND password='"+password+"'");
			
		
		try {
			return usuarioBD.next();
		} catch (SQLException e) {
			return false;
		}
	}
	

	
	public void insertUser(String user, String password,String telefono) {
		conexion.EjecutarUpdate("INSERT INTO usuarios ( user, password, telefono) VALUES ( '"+user+"', '"+password+"', '"+telefono+"');");
	}
	
	public void updateUser(String user, String password, String telefono) {
		conexion.EjecutarUpdate("UPDATE usuarios SET password='"+password+"' WHERE user='"+user+"', '"+telefono+"');");
	}
	
	public void deleteUser(String user) {
		conexion.EjecutarUpdate("DELETE FROM usuarios WHERE user = '"+user+"';");
	}
	
	public void actualizarUser(String user, String telefono) {
		conexion.EjecutarUpdate("UPDATE FROM usuarios WHERE user = '"+user+"'AND telefono='"+telefono+"';");
	}
	
}
