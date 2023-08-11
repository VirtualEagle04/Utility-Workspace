package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistance.FileHandler;

public class Si {

	private ArrayList<String> lista_municipios;
	private ArrayList<String> lista_paises;
	private ArrayList<String> lista_estudiantes;

	public Si() {
		lista_municipios = cargarDesdeArchivo("municipios.csv");
		lista_paises = cargarDesdeArchivo("paises.csv");
		lista_estudiantes = cargarDesdeArchivo("datosEst.csv");
	}

	public ArrayList<String> getLista_estudiantes() {
		return lista_estudiantes;
	}

	public void setLista_estudiantes(ArrayList<String> lista_estudiantes) {
		this.lista_estudiantes = lista_estudiantes;
	}

	public ArrayList<String> getLista_municipios() {
		return lista_municipios;
	}

	public void setLista_municipios(ArrayList<String> lista_municipios) {
		this.lista_municipios = lista_municipios;
	}

	public ArrayList<String> getLista_paises() {
		return lista_paises;
	}

	public void setLista_paises(ArrayList<String> lista_paises) {
		this.lista_paises = lista_paises;
	}

	private ArrayList<String> cargarDesdeArchivo(String nombre) {
		ArrayList<String> desde_archivo = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoText(nombre);
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			desde_archivo.add(linea);
		}
		return desde_archivo;
	}

	public String mostrarMunicipios() {
		StringBuilder sb = new StringBuilder();
		for (String s : lista_municipios) {
			sb.append(s.toString() + "\n");
		}
		return sb.toString();
	}

	public String mostrarPaises() {
		StringBuilder sb = new StringBuilder();
		for (String s : lista_paises) {
			sb.append(s.toString() + "\n");
		}
		return sb.toString();
	}
	public String mostrarEstudiantes() {
		StringBuilder sb = new StringBuilder();
		for (String s : lista_estudiantes) {
			sb.append(s.toString() + "\n");
		}
		return sb.toString();
	}

}
