package co.edu.unbosque.model;

import java.util.ArrayList;

public class PerroDAO implements OperacionesDAO{

	private ArrayList<PerroDTO> lista;
	
	public PerroDAO() {
		lista = new ArrayList<PerroDTO>();
	}

	public PerroDAO(ArrayList<PerroDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<PerroDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<PerroDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void crear(Object obj) {
		lista.add((PerroDTO) obj);
		
	}

	@Override
	public boolean eliminar(int indx, Object obj) {
		try {
			
			lista.remove(indx);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean actualizar(int indx, Object obj) {
		try {
			PerroDTO aux = (PerroDTO) obj;
			
			lista.set(indx, aux);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Perros---\n");
		for (PerroDTO a : lista) {
			sb.append(a.toString());
		}
		return sb.toString();
	}
	
	
	
}
