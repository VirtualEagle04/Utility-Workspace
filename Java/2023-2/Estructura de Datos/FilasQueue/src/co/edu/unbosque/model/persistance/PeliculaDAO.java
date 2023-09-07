package co.edu.unbosque.model.persistance;

import co.edu.unbosque.model.PeliculaDTO;
import co.edu.unbosque.util.DequeList;

public class PeliculaDAO {

	private DequeList<PeliculaDTO> lista;
	
	public PeliculaDAO() {
		lista = new DequeList<PeliculaDTO>();
	}
	
	public void agregarInicio(PeliculaDTO pelicula) {
		lista.insertFirst(pelicula);
	}
	public void agregarFinal(PeliculaDTO pelicula) {
		lista.insertLast(pelicula);
	}
	public void eliminiar() {
		lista.removeFirst();
	}
	public String mostrar() {
		return lista.toString();
	}
	
}
