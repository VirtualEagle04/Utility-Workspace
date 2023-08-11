package co.edu.unbosque.controller;

import java.util.Arrays;

import co.edu.unbosque.view.Consola;

public class Controller {
	
	private Consola con;
	
	public Controller() {
		con = new Consola();
	}
	
	public void run() {
		String contenido = FileHandler.abrirArchivoText("datos.txt");
		
		String[] separacion = contenido.split("\n");
		//con.printSalto(FileHandler.abrirArchivoText("datos.txt"));
		for (String linea : separacion) {
			con.printSalto(Arrays.asList(linea.split(" ")).toString());
	}
		
	String str = con.leerNextLine();
	contenido += str;
	FileHandler.escribirArchivo("datos.txt", contenido);
	con.printErrorSalto("Ingrese la busqueda");
	String busqueda = con.leerNextLine();
	con.printErrorSalto(contenido.indexOf(busqueda)+"");
		
	}
	
}
