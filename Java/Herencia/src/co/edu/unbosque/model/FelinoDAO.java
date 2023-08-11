package co.edu.unbosque.model;

import java.util.ArrayList;

public class FelinoDAO {
	
	private ArrayList<FelinoDTO> lista;
	
	public FelinoDAO() {
		lista = new ArrayList<FelinoDTO>();
	}

	public ArrayList<FelinoDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<FelinoDTO> lista) {
		this.lista = lista;
	}
	
	//Funciones CRUD
	
	public void crear(boolean es_domestico, String tipo_morfologia) {
		lista.add(new FelinoDTO(es_domestico, tipo_morfologia));
		
	}
	
	public boolean eliminarIndex(int index) {
		try {
			lista.remove(index);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean actualizarIndex(int index, boolean es_domestico, String tipo_morfologia) {
		try {
			lista.get(index).setEs_domestico(es_domestico);
			lista.get(index).setTipo_morfologia(tipo_morfologia);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("------Felinos------\n");
		for (int i = 0; i < lista.size(); i++) {
			sb.append(i+") "+lista.get(i).getTipo_morfologia()+"\n");
		}
		return sb.toString();
	}
	
	

}
