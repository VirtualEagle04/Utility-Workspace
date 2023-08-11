package co.edu.unbosque.model;

import java.util.ArrayList;

public class HumanoideDAO implements OperacionesDAO{

	private ArrayList<HumanoideDTO> lista;
	
	public HumanoideDAO() {
		lista = new ArrayList<HumanoideDTO>();
	}
	
	public HumanoideDAO(ArrayList<HumanoideDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<HumanoideDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<HumanoideDTO> lista) {
		this.lista = lista;
	}
	
	//Funciones CRD

	@Override
	public void crear(Object obj) {
		lista.add((HumanoideDTO) obj);
		
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
		
		for (HumanoideDTO hum : lista) {
			if(hum instanceof AstronautaDTO) {
				AstronautaDTO aux = (AstronautaDTO) hum;
				sb.append("Categoria: Astronauta\n");
				sb.append(aux.toString());
				sb.append("-----------------\n");
			}
			else if (hum instanceof AlienDTO) {
				AlienDTO aux = (AlienDTO) hum;
				sb.append("Categoria: Alien\n");
				sb.append(aux.toString());
				sb.append("-----------------\n");
			}
		}
		
		return sb.toString();
	}
	
	public void agregarDeAstronautas(ArrayList<AstronautaDTO> lista_astro) {
		lista.addAll(lista_astro);
	}
	
	public void agregarDeAliens(ArrayList<AlienDTO> lista_alien) {
		lista.addAll(lista_alien);
	}

}
