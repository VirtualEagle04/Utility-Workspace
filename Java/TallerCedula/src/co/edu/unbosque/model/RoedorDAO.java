package co.edu.unbosque.model;

import java.util.ArrayList;

public class RoedorDAO implements OperacionesDAO{

	private ArrayList<RoedorDTO> lista;
	
	public RoedorDAO() {
		lista = new ArrayList<>();
	}

	public RoedorDAO(ArrayList<RoedorDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<RoedorDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<RoedorDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void crear(Object obj) {
		lista.add((RoedorDTO) obj);
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
			lista.set(index, (RoedorDTO) obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Roedor---\n");
		for (RoedorDTO r : lista) {
			sb.append(r.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	
}
