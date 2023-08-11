package co.edu.unbosque.model;

import java.util.ArrayList;

public class AguilaDAO {
	
	private ArrayList<AguilaDTO> lista;
	
	public AguilaDAO() {
		lista = new ArrayList<AguilaDTO>();
	}

	public ArrayList<AguilaDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AguilaDTO> lista) {
		this.lista = lista;
	}
	
	//Funciones CRUD
	
	public void crear(float longitud_alas, String tipo_pico) {
		lista.add(new AguilaDTO(longitud_alas, tipo_pico));
	}
	
	public boolean eliminarIndex(int index) {
		try {
			lista.remove(index);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean actualizarIndex(int index, float longitud_alas, String tipo_pico) {
		try {
			
			lista.get(index).setLongitud_alas(longitud_alas);
			lista.get(index).setTipo_pico(tipo_pico);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("------Aguilas------\n");
		for (int i = 0; i < lista.size(); i++) {
			sb.append(i+") "+lista.get(i).getTipo_pico()+"\n");
		}
		return sb.toString();
	}

}
