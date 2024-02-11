package co.edu.unbosque.model;

import java.util.ArrayList;

public class GatoDAO implements OperacionesDAO{

	private ArrayList<GatoDTO> lista;
	
	public GatoDAO() {
		lista = new ArrayList<GatoDTO>();
	}

	public GatoDAO(ArrayList<GatoDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<GatoDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<GatoDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void crear(Object obj) {
		lista.add((GatoDTO) obj);
		
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
			GatoDTO aux = (GatoDTO) obj;
			
			lista.set(indx, aux);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Gatos---\n");
		for (GatoDTO a : lista) {
			sb.append(a.toString());
		}
		return sb.toString();
	}
	
	
	
	
	
}
