package controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class controhistorial {
    static java.util.Date fecha = new Date();

        public static void controhistorial(ResultSet re) throws IOException{
            File a =new File("Historial_usuario.txt");
            FileWriter es = new FileWriter(a);
            String user,PelisAlquiladas,saldo;

            //Las cosas que coge de la BBDD
            try {
                while(re.next()) {
                    user = re.getString("user");
                    PelisAlquiladas = re.getString("PelisAlquiladas");
                    saldo = re.getString("saldo");
                    
                    //Lo que se imprime
                    es.write("Usuario: "+user+"" +'\n'+ "Pelis alquiladas: "+PelisAlquiladas+" " +'\n'+ "Saldo: "+saldo+"€");
                }
            }catch (SQLException e1) {
                e1.printStackTrace();
            }finally {
                es.close();
                Desktop fichero = Desktop.getDesktop();
                fichero.open(new File("Historial_usuario.txt"));
            }

        }
}