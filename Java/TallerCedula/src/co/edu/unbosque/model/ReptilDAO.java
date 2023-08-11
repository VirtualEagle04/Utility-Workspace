package co.edu.unbosque.model;

import java.util.ArrayList;

public class ReptilDAO implements OperacionesDAO{

	private ArrayList<ReptilDTO> lista;
	
	public ReptilDAO() {
		lista = new ArrayList<>();
	}

	public ReptilDAO(ArrayList<ReptilDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<ReptilDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<ReptilDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void crear(Object obj) {
		lista.add((ReptilDTO) obj);
		
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
			lista.set(index, (ReptilDTO) obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Reptiles---\n");
		for (ReptilDTO r : lista) {
			sb.append(r.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	
}
