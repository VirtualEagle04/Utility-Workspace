package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistance.FileHandler;

public class CarroDAO {
	private ArrayList<CarroDTO> lista;

	public CarroDAO() {
		
		try {
			
//			lista = (ArrayList<CarroDTO>) FileHandler.leerSerializado("carros.txt");
			
		}catch (Exception e) {
			
		}
		
		lista = new ArrayList<CarroDTO>();
	}

	public CarroDAO(ArrayList<CarroDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<CarroDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<CarroDTO> lista) {
		this.lista = lista;
	}
	
	//
	private void escribirEnArchivo() {
		StringBuilder sb = new StringBuilder();
		int indice = lista.size();
		for (CarroDTO c : lista) {
			sb.append(c.getMarca() + ",");
			sb.append(c.getModelo() + ",");
			sb.append(c.getVmax());
			if (indice == 1) {
				continue;
			} else {
				indice--;
				sb.append("\n");
			}
		}
		FileHandler.escribirSerializado("carros.txt", lista);
	}
	
	

	public void crear(Object o) {
		lista.add((CarroDTO) o);
		escribirEnArchivo();
	}

	public boolean eliminar(int index) {
		try {
			lista.remove(index);
			escribirEnArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean actualizar(int index, Object o) {
		try {
			lista.set(index, (CarroDTO) o);
			escribirEnArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		for (CarroDTO carro : lista) {
			sb.append(carro.toString());
		}
		return sb.toString();
	}

}
