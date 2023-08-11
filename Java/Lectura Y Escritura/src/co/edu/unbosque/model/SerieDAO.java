package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.controller.FileHandler;

public class SerieDAO {

	private ArrayList<SerieDTO> lista;

	public SerieDAO() {


		try {
//			lista = cargarDesdeArchivo();
			lista = (ArrayList<SerieDTO>) FileHandler.leerSerializado("serie.fvr");
		} catch (Exception e) {

		}
//		lista = new ArrayList<>();

	}

	public ArrayList<SerieDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<SerieDTO> lista) {
		this.lista = lista;
	}

	private ArrayList<SerieDTO> cargarDesdeArchivo() {
		ArrayList<SerieDTO> desde_archivo = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoText("serie.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attr = linea.split(",");
			String nombre = attr[0];
			String genero = attr[1];
			int año = Integer.parseInt(attr[2]);
			String calificacion = attr[3];
			desde_archivo.add(new SerieDTO(nombre, genero, año, calificacion));
		}
		return desde_archivo;

	}

	private void escribirEnArchivo() {
		StringBuilder sb = new StringBuilder();
		int indice = lista.size();
		for (SerieDTO s : lista) {
			sb.append(s.getNombre() + ",");
			sb.append(s.getGenero() + ",");
			sb.append(s.getAño() + ",");
			sb.append(s.getCalificacion());
			if (indice == 1) {
				continue;
			} else {
				indice--;
				sb.append("\n");
			}
		}
		FileHandler.escribirArchivo("serie.csv", sb.toString());
		FileHandler.escribirSerializado("serie.fvr", lista);
	}

	public void crear(Object obj) {
		lista.add((SerieDTO) obj);
		escribirEnArchivo();
	}

	public boolean eliminar(int pos) {
		try {
			lista.remove(pos);
			escribirEnArchivo();
			return true;

		} catch (Exception e) {
			return false;

		}

	}

	public boolean actualizar(int pos, Object obj) {
		try {
			lista.set(pos, (SerieDTO) obj);
			escribirEnArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		for (SerieDTO s : lista) {
			sb.append(s.toString() + "\n");
		}
		return sb.toString();
	}

}
