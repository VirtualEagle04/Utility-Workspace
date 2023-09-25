package co.edu.unbosque.model.persistance;

public interface CRUDoperations {

	public int create(Object o);
	
	public String read();
	
	public String readIndex(int index);
	
	public int update(int index, Object o);
	
	public int delete(int index);
	
}
