package modelo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbdd.conexion;
import controlador.controhistorial;
import vista.Login;

public class peliculas {
	
	static String user = Login.userInput.getText();
    public peliculas() {

    }

    public static void imprimirfactura()throws IOException{
        conexion conexion = new conexion();
        conexion.Conectar();
        ResultSet re = bbdd.conexion.EjecutarSentencia("SELECT * FROM pelicula" );
                controhistorial controlador = new controhistorial();
                controlador.controhistorial(re);

    }
    public void insertFoto(String imagen ) {
		conexion.EjecutarUpdate("SELECT imagen FROM `películas` WHERE titulo ='El Rey leon'");
	}
}