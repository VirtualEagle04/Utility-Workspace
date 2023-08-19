package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.controller.FileHandler;
/**
 * Al implenetar la interfaz OperacionesDAO, obliga a darle funcionalidad a los metodos por medio de la palabra clase 'Override'
 * @author Federico Vargas Rozo
 * @param lista ArrayList de tipo PadreDTO que contiene la informacion de todos los Padres
 *
 */
public class PadreDAO implements OperacionesDAO {

	private ArrayList<PadreDTO> lista;

	public PadreDAO() {
		lista = new ArrayList<>();
	}

	public PadreDAO(ArrayList<PadreDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<PadreDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<PadreDTO> lista) {
		this.lista = lista;
	}

	// Read /Write
	/**
	 * Permite ingresar todos los ciudadanos a la lista general por medio de la lectura del archivo
	 * @return Retorna la lista con todos los ciudadanos
	 */
	public ArrayList<TemporalPadres> cargarDesdeArchivo() {
		ArrayList<TemporalPadres> desde_archivo = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoText("padre.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attr = linea.split(",");
			String nombre = attr[0];
			String sexo = attr[1];
			String ciudad = attr[2];
			Date fecha = new Date(attr[3]);
			desde_archivo.add(new TemporalPadres(nombre, sexo, ciudad, fecha));

		}
		return desde_archivo;
	}
	/**
	 * Sobreescribe el archivo de general por toda la informacion de cada Ciudadano de la lista general
	 */
	public void escribirArchivo() {
		StringBuilder sb = new StringBuilder();
		int index = lista.size();
		SimpleDateFormat date_format = new SimpleDateFormat("MM/dd/yyyy");
		for (PadreDTO p : lista) {
			sb.append(p.getNombre() + ",");
			sb.append(p.getSexo() + ",");
			sb.append(p.getCiudad() + ",");
			sb.append(date_format.format(p.getFecha()));
			if (index == 1) {
				continue;
			} else {
				index--;
				sb.append("\n");
			}
		}
		FileHandler.escribirArchivo("padre.csv", sb.toString());
	}

	@Override
	public void crear(Object obj) {
		lista.add((PadreDTO) obj);
		escribirArchivo();
	}

	@Override
	public boolean eliminar(int index) {
		try {
			lista.remove(index);
			escribirArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean actualizar(int index, Object obj) {
		try {
			lista.set(index, (PadreDTO) obj);
			escribirArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		if (lista.isEmpty()) {
			return "No existen Padres";
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < lista.size(); i++) {
				sb.append("No°" + i + "\n");
				sb.append(lista.get(i).toString());
				sb.append("\n");
			}

			return sb.toString();
		}
	}

}
