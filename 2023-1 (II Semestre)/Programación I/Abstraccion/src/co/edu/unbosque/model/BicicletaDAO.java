package co.edu.unbosque.model;

import java.util.ArrayList;

public class BicicletaDAO extends OperacionesDAO{
	
	private ArrayList<BicicletaDTO> lista;
	
	public BicicletaDAO() {
		lista = new ArrayList<BicicletaDTO>();
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
