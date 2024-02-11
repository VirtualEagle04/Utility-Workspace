package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * Al implemental la interfaz OperacionesDAO, obliga a darle funcionalidad a los metodos por medio de la palabra clave Override.
 * @author Federico Vargas Rozo
 * @param lista ArrayList de tipo ViajeDepartamentalDTO que contiene la informacion general de todos los ViajeDepartamentalDTO.
 *
 */
public class ViajeDepartamentalDAO implements OperacionesDAO{

	private ArrayList<ViajeDepartamentalDTO> lista;
	
	public ViajeDepartamentalDAO() {
		lista = new ArrayList<ViajeDepartamentalDTO>();
	}

	public ViajeDepartamentalDAO(ArrayList<ViajeDepartamentalDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<ViajeDepartamentalDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<ViajeDepartamentalDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void crear(Object obj) {
		lista.add((ViajeDepartamentalDTO) obj);
		
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
			lista.set(index, (ViajeDepartamentalDTO) obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lista.size(); i++) {
			sb.append("Tiquete No° "+i+"\n");
			sb.append(lista.get(i).toString());
		}
		return sb.toString();
		
	}
	
	
	
}
