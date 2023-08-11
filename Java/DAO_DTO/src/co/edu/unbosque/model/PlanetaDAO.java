package co.edu.unbosque.model;

import java.util.ArrayList;

public class PlanetaDAO {

	private ArrayList<PlanetaDTO> lista;

	public PlanetaDAO() {
		lista = new ArrayList<PlanetaDTO>();
	}

	public ArrayList<PlanetaDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<PlanetaDTO> lista) {
		this.lista = lista;
	}

	// Funciones crudas (CRUD)

	public void crear(String nombre, float tamano, boolean es_habitable, float gravedad,
			double distancia_desde_tierra) {
		lista.add(new PlanetaDTO(nombre, tamano, es_habitable, gravedad, distancia_desde_tierra));
	}

	public boolean eliminarPorNombre(String nombre_eliminar) {
		try {
			for (int i = 0; i < lista.size(); i++){
				if (lista.get(i).getNombre().equalsIgnoreCase(nombre_eliminar)){
					lista.remove(lista.get(i));
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean eliminarPorIndex(int index) {
		try {
			lista.remove(index);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lista.size(); i++){
			sb.append(i+") "+lista.get(i).getNombre().toString()+"\n");
		}
		return sb.toString();
	}

	public boolean actualizarPorNombre(String nombre_viejo, String nombre_nuevo, float tamano, boolean es_habitable, float gravedad, double distancia_desde_tierra) {
		try {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().equals(nombre_viejo)) {
					lista.get(i).setNombre(nombre_nuevo);
					lista.get(i).setTamano(tamano);
					lista.get(i).setEs_habitable(es_habitable);
					lista.get(i).setGravedad(gravedad);
					lista.get(i).setDistancia_desde_tierra(distancia_desde_tierra);
					return true;
				}
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public int devolverIndiceNombre(String nombre_viejo){
		try{
			for (int i = 0; i < lista.size(); i++){
				if(lista.get(i).getNombre().equalsIgnoreCase(nombre_viejo)){
					return i;
				}
			}
		} catch (Exception e){
			return 1000;
		}
		return 1000;
	}

	public boolean actualizarPorIndex(int index, String nombre_nuevo, float tamano, boolean es_habitable, float gravedad, double distancia_desde_tierra) {
		try {
			lista.get(index).setNombre(nombre_nuevo);
			lista.get(index).setTamano(tamano);
			lista.get(index).setEs_habitable(es_habitable);
			lista.get(index).setGravedad(gravedad);
			lista.get(index).setDistancia_desde_tierra(distancia_desde_tierra);
			
			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
