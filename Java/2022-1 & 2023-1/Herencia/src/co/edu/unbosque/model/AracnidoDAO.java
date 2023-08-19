package co.edu.unbosque.model;

import java.util.ArrayList;

public class AracnidoDAO {
	
	private ArrayList<AracnidoDTO> lista;
	
	public AracnidoDAO() {
		lista = new ArrayList<AracnidoDTO>();
		
	}

	public ArrayList<AracnidoDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AracnidoDTO> lista) {
		this.lista = lista;
	}
	
	//Funciones CRUD
	
	public void crear(boolean es_toxica, String color) {
		lista.add(new AracnidoDTO(es_toxica, color));
	}
	
	public boolean eliminarIndex(int index) {
		try {
			lista.remove(index);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean actualizarIndex(int index, boolean es_toxica, String color) {
		try {
			lista.get(index).setEs_toxica(es_toxica);
			lista.get(index).setColor(color);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("------Aracnidos------\n");
		for (int i = 0; i < lista.size(); i++) {
			sb.append(i+") "+lista.get(i).isEs_toxica()+"\n");
		}
		return sb.toString();
	}

}
