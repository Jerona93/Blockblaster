package controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class controSinopsis {
    static java.util.Date fecha = new Date();

        public static void controSinopsis(ResultSet re) throws IOException{
            File a =new File("Historial_usuario.txt");
            FileWriter es = new FileWriter(a);
            String titulo,sinopsis;

            //Las cosas que coge de la BBDD
            try {
                while(re.next()) {
                    titulo = re.getString("titutlo");
                    sinopsis = re.getString("sinopsis");
                    
                    
                    //Lo que se imprime
                    es.write("titulo: "+titulo+"" +'\n'+ "sinopsis: "+sinopsis+" ");
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