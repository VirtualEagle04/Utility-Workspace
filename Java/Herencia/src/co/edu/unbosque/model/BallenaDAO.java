package co.edu.unbosque.model;

import java.util.ArrayList;

public class BallenaDAO {

	private ArrayList<BallenaDTO> lista;
	
	public BallenaDAO() {
		lista = new ArrayList<BallenaDTO>();
	}

	public ArrayList<BallenaDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<BallenaDTO> lista) {
		this.lista = lista;
	}
	
	//Funciones CRUD
	
	public void crear(String oceano_precedencia, float duracion_migracion) {
		lista.add(new BallenaDTO(oceano_precedencia, duracion_migracion));
	}
	
	public boolean eliminarIndex(int index) {
		try {
			lista.remove(index);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean actualizarIndex(int index, String oceano_procedencia, float duracion_migracion) {
		try {
			lista.get(index).setOceano_procedencia(oceano_procedencia);
			lista.get(index).setDuracion_migracion(duracion_migracion);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("------Ballenas------\n");
		for (int i = 0; i < lista.size(); i++) {
			sb.append(i+") "+lista.get(i).getOceano_procedencia()+"\n");
		}
		return sb.toString();
	}
	
}
