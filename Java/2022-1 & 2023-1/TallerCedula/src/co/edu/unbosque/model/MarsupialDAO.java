package co.edu.unbosque.model;

import java.util.ArrayList;

public class MarsupialDAO implements OperacionesDAO{

	private ArrayList<MarsupialDTO> lista;
	
	public MarsupialDAO() {
		lista = new ArrayList<>();
	}

	public MarsupialDAO(ArrayList<MarsupialDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<MarsupialDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<MarsupialDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void crear(Object obj) {
		lista.add((MarsupialDTO) obj);
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
			lista.set(index, (MarsupialDTO) obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Marsupial---\n");
		for (MarsupialDTO m : lista) {
			sb.append(m.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	
}
