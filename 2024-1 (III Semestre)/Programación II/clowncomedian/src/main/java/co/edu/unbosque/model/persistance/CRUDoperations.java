package co.edu.unbosque.model.persistance;

public interface CRUDoperations {
	
	public int create(String... args);
	
	public String readAll();
	
	public int update(int id, String...args);
	
	public int delete(int id);
	
}
