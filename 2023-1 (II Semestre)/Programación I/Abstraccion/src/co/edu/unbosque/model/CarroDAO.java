package co.edu.unbosque.model;

import java.util.ArrayList;

public class CarroDAO extends OperacionesDAO{
	
	private ArrayList<CarroDTO> lista;
	
	public CarroDAO() {
		lista = new ArrayList<CarroDTO>();
	}

	@Override
	public void crear(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String read(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
