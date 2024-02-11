package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * Al implementar la interfaz OperacionesDAO, obliga a darle funcionalidad a los metodos por medio de la palabra clave Override.
 * @author Federico Vargas Rozo
 * @param lista ArrayList de tipo ViajeDTO que contiene la informacion general de todos los Viajes.
 *
 */

public class ViajeDAO implements OperacionesDAO{

	private ArrayList<ViajeDTO> lista;
	
	public ViajeDAO() {
		lista = new ArrayList<ViajeDTO>();
	}

	public ViajeDAO(ArrayList<ViajeDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<ViajeDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<ViajeDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void crear(Object obj) {
		lista.add((ViajeDTO) obj);
	}

	@Override
	public boolean eliminar(int index) {
		try {
			lista.remove(index);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean actualizar(int index, Object obj) {
		try {
			lista.set(index, (ViajeDTO) obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		for (ViajeDTO v : lista) {
			if(v instanceof ViajeMunicipalDTO) {
				ViajeMunicipalDTO aux = (ViajeMunicipalDTO) v;
				sb.append("Tipo: Viaje Municipal\n");
				sb.append(aux.toString());
			}
			else if(v instanceof ViajeDepartamentalDTO) {
				ViajeDepartamentalDTO aux = (ViajeDepartamentalDTO) v;
				sb.append("Tipo: Viaje Departamental\n");
				sb.append(aux.toString());
			}
			else if(v instanceof ViajeInternacionalDTO) {
				ViajeInternacionalDTO aux = (ViajeInternacionalDTO) v;
				sb.append("Tipo: Viaje Internacional\n");
				sb.append(aux.toString());
			}
		}
		return sb.toString();
	}
	/**
	 * Funcion que se llama al momento de mostrar todos los viajes. Agrega a la lista general de ViajeDAO la lista de ViajeMunicipalDAO.
	 * @param lista_mun Lista de ViajeMunicipalDAO.
	 */
	public void agregarMunicipal(ArrayList<ViajeMunicipalDTO> lista_mun) {
		lista.addAll(lista_mun);
	}
	/**
	 * Funcion que se llama al momento de mostrar todos los viajes. Agrega a la lista general de ViajeDAO la lista de ViajeDepartamentalDAO.
	 * @param lista_mun Lista de ViajeDepartamentalDAO.
	 */
	public void agregarDepartamental(ArrayList<ViajeDepartamentalDTO> lista_dep) {
		lista.addAll(lista_dep);
	}
	/**
	 * Funcion que se llama al momento de mostrar todos los viajes. Agrega a la lista general de ViajeDAO la lista de ViajeInternacionalDAO.
	 * @param lista_mun Lista de ViajeInternacionalDAO.
	 */
	public void agregarInternacional(ArrayList<ViajeInternacionalDTO> lista_inter) {
		lista.addAll(lista_inter);
	}
	
	
	
}
