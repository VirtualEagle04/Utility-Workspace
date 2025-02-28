package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.controller.FileHandler;
/**
 * Al implenetar la interfaz OperacionesDAO, obliga a darle funcionalidad a los metodos por medio de la palabra clase 'Override'
 * @author Federico Vargas Rozo
 * @param lista ArrayList de tipo NeonatoDTO que contiene la informacion de todos los Neonatos
 *
 */
public class NeonatoDAO implements OperacionesDAO {

	private ArrayList<NeonatoDTO> lista;

	public NeonatoDAO() {
		lista = new ArrayList<>();
	}

	public NeonatoDAO(ArrayList<NeonatoDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<NeonatoDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<NeonatoDTO> lista) {
		this.lista = lista;
	}

	// Read /Write
	/**
	 * Permite ingresar todos los ciudadanos a la lista general por medio de la lectura del archivo
	 * @return Retorna la lista con todos los ciudadanos
	 */
	public ArrayList<TemporalNeonatos> cargarDesdeArchivo() {
		ArrayList<TemporalNeonatos> desde_archivo = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoText("neonato.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attr = linea.split(",");
			String nombre = attr[0];
			String sexo = attr[1];
			String ciudad = attr[2];
			Date fecha = new Date(attr[3]);
			String nombre_p = attr[4];
			String nombre_m = attr[5];
			desde_archivo.add(new TemporalNeonatos(nombre, sexo, ciudad, fecha, nombre_p, nombre_m));

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
		for (NeonatoDTO n : lista) {
			sb.append(n.getNombre() + ",");
			sb.append(n.getSexo() + ",");
			sb.append(n.getCiudad() + ",");
			sb.append(date_format.format(n.getFecha()) + ",");
			sb.append(n.getPadre().getNombre() + ",");
			sb.append(n.getMadre().getNombre());

			if (index == 1) {
				continue;
			} else {
				index--;
				sb.append("\n");
			}
		}
		FileHandler.escribirArchivo("neonato.csv", sb.toString());
	}

	@Override
	public void crear(Object obj) {
		lista.add((NeonatoDTO) obj);
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
			lista.set(index, (NeonatoDTO) obj);
			escribirArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		if (lista.isEmpty()) {
			return "No existen Neonatos";
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
