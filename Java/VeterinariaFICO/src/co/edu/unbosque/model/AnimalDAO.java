package co.edu.unbosque.model;

import java.util.ArrayList;

public class AnimalDAO implements OperacionesDAO{

	private ArrayList<AnimalDTO> lista;
	
	public AnimalDAO() {
		lista = new ArrayList<AnimalDTO>();
	}

	public AnimalDAO(ArrayList<AnimalDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<AnimalDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AnimalDTO> lista) {
		this.lista = lista;
	}
	
	//Funciones CRUD

	@Override
	public void crear(Object obj) {
		lista.add((AnimalDTO) obj);
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
			AnimalDTO aux = (AnimalDTO) obj;
			
			lista.set(indx, aux);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		
		StringBuilder sb = new StringBuilder();
		
		for (AnimalDTO a : lista) {
			if(a instanceof PerroDTO) {
				PerroDTO aux = (PerroDTO) a;
				sb.append(aux.toString());
			}
			else if (a instanceof GatoDTO) {
				GatoDTO aux = (GatoDTO) a;
				sb.append(aux.toString());
			}
			else if (a instanceof LagartijaDTO) {
				LagartijaDTO aux = (LagartijaDTO) a;
				sb.append(aux.toString());
			}
		}
		
		return sb.toString();
	}
	
	public void agregarDePerros(ArrayList<PerroDTO> lista_perros) {
		lista.addAll(lista_perros);
	}
	
	public void agregarDeGatos(ArrayList<GatoDTO> lista_gatos) {
		lista.addAll(lista_gatos);
	}
	
	public void agregarDeLagartijas(ArrayList<LagartijaDTO> lista_lagartijas) {
		lista.addAll(lista_lagartijas);
	}
	
	
	
}
