package co.edu.unbosque.model.persitance;

public interface CRUDoperation {

	public void create(Object o);
	
	public void create(String ...args);
	
	public String readAll();
	
	public String readByName(String name);
	
	public int updateById(int id, String ...args);
	
	public int deleteById(int id);
}
