package co.edu.unbosque.model;

import java.util.ArrayList;

public class LagartijaDAO implements OperacionesDAO{
	
	private ArrayList<LagartijaDTO> lista;
	
	public LagartijaDAO() {
		lista = new ArrayList<LagartijaDTO>();
	}
	
	public LagartijaDAO(ArrayList<LagartijaDTO> lista) {
		super();
		this.lista = lista;
	}



	public ArrayList<LagartijaDTO> getLista() {
		return lista;
	}
	
	public void setLista(ArrayList<LagartijaDTO> lista) {
		this.lista = lista;
	}

	//Funciones CRUD

	@Override
	public void crear(Object obj) {
		lista.add((LagartijaDTO) obj);
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
			LagartijaDTO aux = (LagartijaDTO) obj;
			
			lista.set(indx, aux);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Lagartijas---\n");
		for (LagartijaDTO a : lista) {
			sb.append(a.toString());
		}
		return sb.toString();
		
	}

}
