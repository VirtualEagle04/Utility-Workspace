package co.edu.unbosque.model;

import java.util.ArrayList;

public class TiburonDAO {

	private ArrayList<TiburonDTO> lista;
	
	public TiburonDAO() {
		lista = new ArrayList<TiburonDTO>();
	}

	public ArrayList<TiburonDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<TiburonDTO> lista) {
		this.lista = lista;
	}
	
	//Funciones CRUD
	
	public void crear(String subespecie, int cant_dientes, String tipo_mandibula) {
		lista.add(new TiburonDTO(subespecie, cant_dientes, tipo_mandibula));
	}
	
	public boolean eliminarIndex(int index) {
		try{
			lista.remove(index);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean actualizarIndex(int index, String subespecie, int cant_dientes, String tipo_mandibula) {
		try {
			lista.get(index).setSubespecie(subespecie);
			lista.get(index).setCant_dientes(cant_dientes);
			lista.get(index).setTipo_mandibula(tipo_mandibula);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("------Tiburones------\n");
		for (int i = 0; i < lista.size(); i++) {
			sb.append(i+") "+lista.get(i).getSubespecie()+"\n");
		}
		return sb.toString();
	}
	
}
