package co.edu.unbosque.model;

public interface OperacionesDAO {

	public void crear(Object obj);
	
	public boolean eliminar(Object obj);
	
	public boolean actualizar(Object obj);
	
	public String mostrarTodo();
	
	
}
