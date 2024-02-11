package co.edu.unbosque.model;

public interface OperacionesDAO {

	public void crear(Object obj);
	
	public boolean eliminar(int indx);
	
	public String mostrarTodo();
	
}
