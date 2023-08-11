package co.edu.unbosque.model;

public interface OperacionesEstudianteDAO extends OperacionesDAO{
	//Las interfaces solo pueden heredar de otras Interfaces.
	//Segun GRASP: En qué momento es adecuado utilizar una interfaz y una clase abstracta.
	
	public String listarPorMateriasPerdidas();
	
	
}
