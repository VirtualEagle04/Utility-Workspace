package co.edu.unbosque.model;

public abstract class OperacionesDAO {
	
	public abstract void crear(Object o);
	public abstract boolean delete(Object o);
	public abstract boolean update(Object o);
	public abstract String read(Object o);
	
}
