package co.edu.unbosque.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Facilita la lectura y escritura de archivos
 * @author Federico Vargas Rozo
 *
 */
public class FileHandler {
	
	private static Scanner lector;
	private static File archivo;
	private static PrintWriter escritor;
	
	public FileHandler() {
		//Rutas relativas: Dependen desde el archivo actual.
		//Rutas absolutas: Empiezan desde el origen del disco.
	}
	/**
	 * Permite la lectura del archivo ingresado.
	 * @param nombre_archivo String que contiene el nombre del archivo a editar
	 * @return Retorna el contenido del archivo .csv en forma de un String
	 */
	public static String abrirArchivoText(String nombre_archivo) {
		
		archivo = new File("src/co/edu/unbosque/model/persistance/"+nombre_archivo);
		StringBuilder contenido = new StringBuilder();
		try {
			lector = new Scanner(archivo);
			while(lector.hasNext()) {
				contenido.append(lector.nextLine()+"\n");
			}
			lector.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error de Lectura: Archivo no encontrado.");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Error de Lectura: Revise permisos.");
			e1.printStackTrace();
		}
		
		
		return contenido.toString();
	}
	/**
	 * Permite la escritura del archivo ingresado, para almacenar la informacion ingresada durante la ejecucion del programa.
	 * @param nombre_archivo String que contiene el nombre del archivo a editar
	 * @param contenido El contenido a escribir con un formato reativo al tipo de archivo.
	 */
	public static void escribirArchivo(String nombre_archivo, String contenido) {
		archivo = new File("src/co/edu/unbosque/model/persistance/"+nombre_archivo);
		try {
			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error de Escritura: Archivo no encontrado.");
			e.printStackTrace();
			try {
				archivo.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e2) {
			System.out.println("Error de Escritura: Revise permisos.");
			e2.printStackTrace();
		}
	}
	
	
}
