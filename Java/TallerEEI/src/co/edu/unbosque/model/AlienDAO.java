package co.edu.unbosque.model;

import java.util.ArrayList;

public class AlienDAO implements OperacionesDAO{

	private ArrayList<AlienDTO> lista;
	
	public AlienDAO() {
		lista = new ArrayList<AlienDTO>();
	}

	public AlienDAO(ArrayList<AlienDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<AlienDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AlienDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void crear(Object obj) {
		lista.add((AlienDTO) obj);
		
	}

	@Override
	public boolean eliminar(int indx) {
		try {
			lista.remove(indx);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Aliens---\n");
		if(lista.isEmpty()) {
			return "No existen Aliens";
		}else {
			for (AlienDTO a : lista) {
				sb.append(a.toString());
				sb.append("-----------------\n");
			}
		}
		return sb.toString();
	}
	
}
