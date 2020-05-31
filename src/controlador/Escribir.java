package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escribir{

	public static void main(String[] args)throws IOException {
		String contenido = "Texto de pruebas";

		FileWriter fw = new FileWriter("/Users/otto/Desktop/Prueba.txt");

		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0;i < 10; i++){
			bw.write(i + "-"+ contenido);
			bw.newLine();
		}

		bw.close();
		fw.close();
		System.out.println("Fin");
	}

}