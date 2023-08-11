package co.edu.unbosque.model;

import java.util.ArrayList;

public class EstudianteForaneoDAO implements OperacionesEstudianteDAO {

	private ArrayList<EstudianteForaneoDTO> lista;

	public EstudianteForaneoDAO() {
		lista = new ArrayList<EstudianteForaneoDTO>();
	}

	@Override
	public void crear(Object obj) {

		lista.add((EstudianteForaneoDTO) obj);

	}

	@Override
	public boolean eliminar(Object obj) {
		try {
			lista.remove(obj);
			return true;
		}catch (NullPointerException e1) {
			return false;
		}
	}

	@Override
	public boolean actualizar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String mostrarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listarPorMateriasPerdidas() {
		// TODO Auto-generated method stub
		return null;
	}

}
