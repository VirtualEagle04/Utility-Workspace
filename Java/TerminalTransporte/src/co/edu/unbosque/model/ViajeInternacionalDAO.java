package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * Al implemental la interfaz OperacionesDAO, obliga a darle funcionalidad a los metodos por medio de la palabra clave Override.
 * @author Federico Vargas Rozo
 * @param lista ArrayList de tipo ViajeInternacionalDTO que contiene la informacion general de todos los ViajeInternacionalDTO.
 *
 */
public class ViajeInternacionalDAO implements OperacionesDAO{

	private ArrayList<ViajeInternacionalDTO> lista;
	
	public ViajeInternacionalDAO() {
		lista = new ArrayList<ViajeInternacionalDTO>();
	}

	public ViajeInternacionalDAO(ArrayList<ViajeInternacionalDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<ViajeInternacionalDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<ViajeInternacionalDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void crear(Object obj) {
		lista.add((ViajeInternacionalDTO) obj);
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
			lista.set(index, (ViajeInternacionalDTO) obj);
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
