package co.edu.unbosque.model;

import java.util.ArrayList;

public class EstudianteDAO implements OperacionesEstudianteDAO {

	private ArrayList<EstudianteDTO> lista;

	public EstudianteDAO() {
		lista = new ArrayList<EstudianteDTO>();
		lista.add(new EstudianteForaneoDTO());
		lista.add(new EstudianteCitadinoDTO());
	}

	public ArrayList<EstudianteDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<EstudianteDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void crear(Object obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean eliminar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();

		return null;
	}

	@Override
	public String listarPorMateriasPerdidas() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Polimorfismo de Funciones
	 * 
	 * public int suma(int num1, int num2) { return num1+num2; }
	 * 
	 * public float suma(float num1, float num2) { return num1+num2; }
	 * 
	 */

	public void imprimirPorTipo() {
		// instanceof -> Verificar si un Objeto es instancia de una clase.
		for (EstudianteDTO es : lista) {
			if (es instanceof EstudianteForaneoDTO) {
				System.out.println(es.getNombre() + " es Foraneo.");

				// Casteo -> Recobrar atributos y Funciones propias.
				EstudianteForaneoDTO aux = (EstudianteForaneoDTO) es;
				aux.toString();
				System.out.println("Ciudad de Origen: " + aux.getCiudad_origen());
			} else if (es instanceof EstudianteCitadinoDTO) {
				System.out.println(es.getNombre() + " es Citadino.");
				EstudianteCitadinoDTO aux = (EstudianteCitadinoDTO) es;
				aux.toString();
				System.out.println("Barrio: " + aux.getBarrio());
			}
		}
	}
	
//	public void agregarLista(Object es_lista) {
//		if(es_lista instanceof ArrayList<EstudianteForaneoDTO>) {
//			
//		lista.addAll((ArrayList<EstudianteForaneoDTO>) es_lista);
//		}
//		
//	}
	
	

}
