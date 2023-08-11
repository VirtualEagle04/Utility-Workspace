package co.edu.unbosque.model;

import java.util.ArrayList;

public class HumanoDAO {

	private ArrayList<HumanoDTO> lista;
	
	
	public HumanoDAO() {
		lista = new ArrayList<HumanoDTO>();
	}


	public ArrayList<HumanoDTO> getLista() {
		return lista;
	}


	public void setLista(ArrayList<HumanoDTO> lista) {
		this.lista = lista;
	}
	
	//Funciones CRUD
	
	public void crear(String color_piel, String nombre) {
		lista.add(new HumanoDTO(color_piel, nombre));
	}
	
	public boolean eliminarIndex(int index) {
		try {
			lista.remove(index);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean actualizarIndex(int index, String color_piel, String nombre) {
		try {
			lista.get(index).setColor_piel(color_piel);
			lista.get(index).setNombre(nombre);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("------Humanos------\n");
		for (int i = 0; i < lista.size(); i++) {
			sb.append(i+") "+lista.get(i).getNombre()+"\n");
		}
		return sb.toString();
	}
}
