package co.edu.unbosque.util;

public interface CRUDoperations {

	public void create(Object o);
	
	public int delete(int index);
	
	public int update(int index, Object o);
	
	public String read();
	
}
