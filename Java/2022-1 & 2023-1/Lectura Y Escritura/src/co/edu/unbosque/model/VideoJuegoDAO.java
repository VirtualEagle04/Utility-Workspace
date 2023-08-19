package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.controller.FileHandler;

public class VideoJuegoDAO {

	private ArrayList<VideoJuegoDTO> lista;

	public VideoJuegoDAO() {


		try {
//			lista = cargarDesdeArchivo();
			lista = (ArrayList<VideoJuegoDTO>) FileHandler.leerSerializado("videojuego.fvr");
		} catch (Exception e) {

		}
//		lista = new ArrayList<>();

	}

	public ArrayList<VideoJuegoDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<VideoJuegoDTO> lista) {
		this.lista = lista;
	}

	private ArrayList<VideoJuegoDTO> cargarDesdeArchivo() {
		ArrayList<VideoJuegoDTO> desde_archivo = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoText("videojuego.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attr = linea.split(",");
			String nombre = attr[0];
			String consola = attr[1];
			String rating = attr[2];
			boolean multiplayer;
			if (attr[3].equalsIgnoreCase("si")) {
				multiplayer = true;
			} else {
				multiplayer = false;
			}
			desde_archivo.add(new VideoJuegoDTO(nombre, consola, rating, multiplayer));
		}
		return desde_archivo;
	}

	private void escribirEnArchivo() {
		StringBuilder sb = new StringBuilder();
		int indice = lista.size();
		for (VideoJuegoDTO v : lista) {
			sb.append(v.getNombre() + ",");
			sb.append(v.getConsola() + ",");
			sb.append(v.getRating() + ",");
			sb.append((v.isTiene_multijugador() ? "Si" : "No"));
			if (indice == 1) {
				continue;
			} else {
				indice--;
				sb.append("\n");
			}
		}
		FileHandler.escribirArchivo("videojuego.csv", sb.toString());
		FileHandler.escribirSerializado("videojuego.fvr", lista);
	}

	public void crear(Object obj) {
		lista.add((VideoJuegoDTO) obj);
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
			lista.set(pos, (VideoJuegoDTO) obj);
			escribirEnArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		for (VideoJuegoDTO v : lista) {
			sb.append(v.toString() + "\n");
		}
		return sb.toString();
	}

}
