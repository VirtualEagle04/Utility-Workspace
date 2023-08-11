package co.edu.unbosque.model;

import java.util.ArrayList;

public class PaisDAO {

	private ArrayList<PaisDTO> lista;
	
	public PaisDAO() {
		lista = new ArrayList<PaisDTO>();
	}

	public PaisDAO(ArrayList<PaisDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<PaisDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<PaisDTO> lista) {
		this.lista = lista;
	}
	
	//Funciones CRUD
	
	public void crear(Object obj) {
		lista.add((PaisDTO) obj);
	}
	
	public boolean eliminar(int indice) {
		try {
			lista.remove(indice);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean actualizar(int indice, Object obj) {
		try {
			lista.set(indice, (PaisDTO) obj);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lista.size(); i++) {
			sb.append("Posicion: "+i+"\n");
			sb.append(lista.get(i).toString());
		}
		return sb.toString();
	}
}

