package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.controller.FileHandler;

public class AnimalDAO implements OperacionesDAO{

	private ArrayList<AnimalDTO> lista;
	
	public AnimalDAO() {
		lista = new ArrayList<>();
	}

	public AnimalDAO(ArrayList<AnimalDTO> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<AnimalDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AnimalDTO> lista) {
		this.lista = lista;
	}
	//Read / Write

	public ArrayList<Temporal> cargarDesdeArchivo() {
		ArrayList<Temporal> desde_archivo = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoText("animales.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attr = linea.split(",");
			String especie = attr[0];
			String habitad = attr[1];
			String tipo = attr[2];
			desde_archivo.add(new Temporal(especie, habitad, tipo));
		}
		return desde_archivo;
	}

	public void escribirArchivo() {
		StringBuilder sb = new StringBuilder();
		int index = lista.size();
		for (AnimalDTO a : lista) {
			sb.append(a.getEspecie()+",");
			sb.append(a.getHabitad()+",");
			if (a instanceof ReptilDTO) {
				sb.append("Reptil");
			}
			else if(a instanceof MarsupialDTO) {
				sb.append("Marsupial");
			}
			else if(a instanceof RoedorDTO) {
				sb.append("Roedor");
			}
			
			
			if(index == 1) {
				continue;
			} else {
				index--;
				sb.append("\n");
			}
		}
		FileHandler.escribirArchivo("animales.csv", sb.toString());
	}
	
	//Funciones CRUD
	
	public void agregarReptil(ArrayList<ReptilDTO> lista_rep) {
		lista.addAll(lista_rep);
		escribirArchivo();
	}
	
	public void agregarMarsupial(ArrayList<MarsupialDTO> lista_m) {
		lista.addAll(lista_m);
		escribirArchivo();
	}
	
	public void agregarRoedor(ArrayList<RoedorDTO> lista_roe) {
		lista.addAll(lista_roe);
		escribirArchivo();
	}
	
	@Override
	public void crear(Object obj) {
		lista.add((AnimalDTO) obj);
		escribirArchivo();
	}

	@Override
	public boolean eliminar(int index) {
		try {
			lista.remove(index);
			escribirArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean actualizar(int index, Object obj) {
		try {
			lista.set(index, (AnimalDTO) obj);
			escribirArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		StringBuilder sb = new StringBuilder();
		for (AnimalDTO a : lista) {
			if (a instanceof ReptilDTO) {
				sb.append(" Reptil\n");
				sb.append(a.toString());
			}
			else if(a instanceof MarsupialDTO) {
				sb.append("-> Marsupial\n");
				sb.append(a.toString());
			}
			else if(a instanceof RoedorDTO) {
				sb.append("-> Roedor\n");
				sb.append(a.toString());
			}
		}
		return sb.toString();
		
	}

	
	
	
}
