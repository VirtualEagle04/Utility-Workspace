package co.edu.unbosque.model;

import java.util.ArrayList;

public class AgujeroDAO {
	
	private static ArrayList<AgujeroDTO> lista;
	
	public AgujeroDAO() {
		lista = new ArrayList<AgujeroDTO>();
		lista.add(new AgujeroDTO(1235, 123123, "Sexo"));
		lista.add(new AgujeroDTO(67123, 1234, "Hola"));
		lista.add(new AgujeroDTO(51632, 5131, "Mundo"));
		lista.add(new AgujeroDTO(16323, 4223, "Marte"));
		lista.add(new AgujeroDTO(154, 1682, "Tuano"));
		
	}

	public ArrayList<AgujeroDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AgujeroDTO> lista) {
		this.lista = lista;
	}
	
	
	
}
