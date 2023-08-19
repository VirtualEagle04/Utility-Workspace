package model;

public class MarcaPaqueteGomitasDAO {

	private MyLinkedList<MarcaPaqueteGomitasDTO> lista;
	
	public MarcaPaqueteGomitasDAO() {
		lista = new MyLinkedList<>();
	}

	public MyLinkedList<MarcaPaqueteGomitasDTO> getLista() {
		return lista;
	}

	public void setLista(MyLinkedList<MarcaPaqueteGomitasDTO> lista) {
		this.lista = lista;
	}
	
	public void agregar(MarcaPaqueteGomitasDTO marca) {
		lista.addLast(marca);
	}
	
	public void eliminar(int index) {
		lista.extract(lista.get(index));
	}
	
	public void actualizar() {
		
	}
	
	
}
