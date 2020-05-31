package modelo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbdd.conexion;
import controlador.controhistorial;
import vista.Login;

public class Historial {
	
	static String user = Login.userInput.getText();
    public Historial() {

    }

    public static void imprimirfactura()throws IOException{
        conexion conexion = new conexion();
        conexion.Conectar();
        ResultSet re = bbdd.conexion.EjecutarSentencia("SELECT * FROM usuarios WHERE user= '"+user+"'" );
                controhistorial controlador = new controhistorial();
                controlador.controhistorial(re);

    }
    
}