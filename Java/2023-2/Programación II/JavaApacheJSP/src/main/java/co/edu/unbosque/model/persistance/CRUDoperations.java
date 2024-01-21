package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

public interface CRUDoperations<E> {

	public int create(String...args);
	public int create(Object o);
	
	public String readOnly();
	public ArrayList<E> read();
	
	public int update(int index, String...args);
	public int update(int index, Object o );
	
	public int delete(int index);
	public int delete(Object o);
	
}
