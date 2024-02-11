package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.controller.FileHandler;

/**
 * Al implenetar la interfaz OperacionesDAO, obliga a darle funcionalidad a los
 * metodos por medio de la palabra clase 'Override'
 * 
 * @author Federico Vargas Rozo
 * @param lista ArrayList de tipo CiudadanoDTO que contiene la informacion de
 *              todos los Ciudadanos
 *
 */
public class CiudadanoDAO implements OperacionesDAO {

	private ArrayList<CiudadanoDTO> lista;

	public CiudadanoDAO() {
		lista = new ArrayList<>();
	}

	public CiudadanoDAO(ArrayList<CiudadanoDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<CiudadanoDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<CiudadanoDTO> lista) {
		this.lista = lista;
	}
	// Read / Write

	/**
	 * Permite ingresar todos los ciudadanos a la lista general por medio de la
	 * lectura del archivo
	 * 
	 * @return Retorna la lista con todos los ciudadanos
	 */
	public ArrayList<TemporalGeneral> cargarDesdeArchivo() {
		ArrayList<TemporalGeneral> desde_archivo = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoText("general.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attr = linea.split(",");
			String nombre = attr[0];
			String sexo = attr[1];
			String ciudad = attr[2];
			Date fecha = new Date(attr[3]);
			String padre = attr[4];
			String madre = attr[5];
			String tipo = attr[6];

			desde_archivo.add(new TemporalGeneral(nombre, sexo, ciudad, fecha, padre, madre, tipo));
		}
		return desde_archivo;
	}

	/**
	 * Sobreescribe el archivo de general por toda la informacion de cada Ciudadano
	 * de la lista general
	 */
	public void escribirArchivo() {
		StringBuilder sb = new StringBuilder();
		int index = lista.size();
		SimpleDateFormat date_format = new SimpleDateFormat("MM/dd/yyyy");
		for (CiudadanoDTO a : lista) {
			sb.append(a.getNombre() + ",");
			sb.append(a.getSexo() + ",");
			sb.append(a.getCiudad() + ",");
			sb.append(date_format.format(a.getFecha()) + ",");
			if (a instanceof NeonatoDTO) {
				NeonatoDTO aux = (NeonatoDTO) a;
				sb.append((aux.getPadre().getNombre()) + ",");
				sb.append((aux.getMadre().getNombre()) + ",");
				sb.append("Neonato");
			} else if (a instanceof PadreDTO) {
				sb.append("Padre");
			} else if (a instanceof MadreDTO) {
				sb.append("Madre");
			}

			if (index == 1) {
				continue;
			} else {
				index--;
				sb.append("\n");
			}
		}
		FileHandler.escribirArchivo("general.csv", sb.toString());
	}

	// Funciones CRUD
	/**
	 * Agrega la lista de neonatos a la lista general
	 * 
	 * @param lista_neo Lista de NeonatosDTO
	 */
	public void agregarNeonato(ArrayList<NeonatoDTO> lista_neo) {
		lista.addAll(lista_neo);
		escribirArchivo();
	}

	/**
	 * Agrega la lista de padres a la lista general
	 * 
	 * @param lista_p Lista de PadreDTO
	 */
	public void agregarPadre(ArrayList<PadreDTO> lista_p) {
		lista.addAll(lista_p);
		escribirArchivo();
	}

	/**
	 * Agrega la lista de madres a la lista general
	 * 
	 * @param lista_m Lista de MadreDTO
	 */
	public void agregarMadre(ArrayList<MadreDTO> lista_m) {
		lista.addAll(lista_m);
		escribirArchivo();
	}

	@Override
	public void crear(Object obj) {
		lista.add((CiudadanoDTO) obj);
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
			lista.set(index, (CiudadanoDTO) obj);
			escribirArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		if (lista.isEmpty()) {
			return "No existen Ciudadanos";
		} else {
			StringBuilder sb = new StringBuilder();
			for (CiudadanoDTO a : lista) {
				if (a instanceof NeonatoDTO) {
					sb.append("-> Neonato\n");
					sb.append(a.toString());
				} else if (a instanceof PadreDTO) {
					sb.append("-> Padre\n");
					sb.append(a.toString());
				} else if (a instanceof MadreDTO) {
					sb.append("-> Madre\n");
					sb.append(a.toString());
				}
			}
			return sb.toString();
		}
	}

}
