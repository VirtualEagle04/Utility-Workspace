package co.edu.unbosque.model;

import java.util.ArrayList;

public class AstronutaDAO implements OperacionesDAO{
	
	private ArrayList<AstronautaDTO> lista;
	
	public AstronutaDAO() {
		lista = new ArrayList<AstronautaDTO>();
	}

	public AstronutaDAO(ArrayList<AstronautaDTO> lista) {
		super();
		this.lista = lista;
	}
	
	public ArrayList<AstronautaDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AstronautaDTO> lista) {
		this.lista = lista;
	}

	//Funciones CRD

	@Override
	public void crear(Object obj) {
		lista.add((AstronautaDTO) obj);
		
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
		sb.append("---Astronautas---\n");
		if(lista.isEmpty()) {
			return "No existen Astronautas";
		}else {
			for (AstronautaDTO a : lista) {
				sb.append(a.toString());
				sb.append("-----------------\n");
			}
		}
		
		return sb.toString();
	}

}
