package co.edu.unbosque.logic;

import java.io.*;
import co.edu.unbosque.entity.Estudiante;

public class EscribeArchivo {

	public static void adicionar(Estudiante e, String path) throws IOException {
		File archivo;
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			archivo = new File(path);
			fw = new FileWriter(archivo, true); // si el archivo no existe se crea
			pw = new PrintWriter(fw);
			pw.println(e.getNombre() + "," + e.getApellidos() + "," + e.getPromedio());
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				if (pw != null) {
					pw.close();
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

}
