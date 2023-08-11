package co.edu.unbosque.model;

public interface OperacionesDAO {
	
	
	

	public void crear(Object obj);
	
	public boolean eliminar(int indx, Object obj);
	
	public boolean actualizar(int indx, Object obj);
	
	public String mostrarTodo();
	
}
