package co.edu.unbosque.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.model.Categoria;

public class EscribeLeeArchivo {
	

	public static void escribir(Categoria c, String path) throws IOException {
		File archivo;
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			archivo = new File(path);
			fw = new FileWriter(archivo, true);
			pw = new PrintWriter(fw);
			pw.println(c.getId() + "><" + c.getDesc() + "><" + c.getEstado()); // Se usa >< como separador, porque la descripcion puede tener comas y la lectura divide con la coma.
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				if (pw != null) {
					pw.close();
				}
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
	
	public static ArrayList<Categoria> leer(String path) throws IOException {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		File archivo;
		Scanner lector;
		try {
			archivo = new File(path);
			if (!archivo.exists()) {
	            archivo.createNewFile(); // Crea el archivo si no existe
	        }
			lector = new Scanner(archivo);
			
			while(lector.hasNext()) {
				String[] content = lector.nextLine().split("><");
				int id = Integer.parseInt(content[0]);
				String desc = content[1];
				String estado = content[2];
				
				categorias.add(new Categoria(id, desc, estado));
			}
			lector.close();
			return categorias;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return categorias; 
		
		
	}
	
	public static void actualizar(ArrayList<Categoria> categorias, String path) throws IOException {
		File archivo = new File(path);
		archivo.delete();
		archivo.createNewFile();
		for(Categoria c : categorias) {
			escribir(c, path);
		}
	}

}
