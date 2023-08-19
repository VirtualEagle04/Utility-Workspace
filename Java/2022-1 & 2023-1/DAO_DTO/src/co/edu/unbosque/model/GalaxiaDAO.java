package co.edu.unbosque.model;

import java.util.ArrayList;

public class GalaxiaDAO {
	
	private ArrayList<GalaxiaDTO> g_lista;
	
	public GalaxiaDAO() {
		g_lista = new ArrayList<GalaxiaDTO>();
	}

	public ArrayList<GalaxiaDTO> getG_lista() {
		return g_lista;
	}

	public void setG_lista(ArrayList<GalaxiaDTO> g_lista) {
		this.g_lista = g_lista;
	}

	//Funciones crudas (CRUD)

	public void gCrear(String nombre, int cant_planetas, int cant_estrellas, float radio){
		g_lista.add(new GalaxiaDTO(nombre, cant_planetas, cant_estrellas, radio));
	}

	public boolean gEliminarPorNombre(String g_nombre_eliminar){
		try {
			for (int i = 0; i < g_lista.size(); i++){
				if (g_lista.get(i).getNombre().equalsIgnoreCase(g_nombre_eliminar)){
					g_lista.remove(g_lista.get(i));
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean eliminarGalPorIndex(int g_index){
		try {
			g_lista.remove(g_index);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String gMostrarTodo(){
		StringBuilder sb = new StringBuilder();
		for (GalaxiaDTO g : g_lista){
			sb.append(g.getNombre().toString()+"");
		}
		return sb.toString();
	}

	public boolean gActualizarPorNombre(String g_nombre_viejo, String nombre_nuevo, int cant_planetas, int cant_estrellas, float radio){
		try {
			for (int i = 0; i < g_lista.size(); i++) {
				if (g_lista.get(i).getNombre().equals(g_nombre_viejo)) {
					g_lista.get(i).setNombre(nombre_nuevo);
					g_lista.get(i).setCant_planetas(cant_planetas);
					g_lista.get(i).setCant_estrellas(cant_estrellas);
					g_lista.get(i).setRadio(radio);

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
			for (int i = 0; i < g_lista.size(); i++){
				if(g_lista.get(i).getNombre().equalsIgnoreCase(nombre_viejo)){
					return i;
				}
			}
		} catch (Exception e){
			return 1000;
		}
		return 1000;
	}

	public boolean gActualizarPorIndex(int g_index, String nombre_nuevo, int cant_planetas, int cant_estrellas, float radio){
		try {
			g_lista.get(g_index).setNombre(nombre_nuevo);
			g_lista.get(g_index).setCant_planetas(cant_planetas);
			g_lista.get(g_index).setCant_estrellas(cant_estrellas);
			g_lista.get(g_index).setRadio(radio);	
			
			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
