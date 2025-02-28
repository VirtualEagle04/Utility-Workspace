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
		lista.remove(index);
	}

	public void actualizar(int index, MarcaPaqueteGomitasDTO marca) {
		lista.replace(index, marca);
	}

	public String mostrar() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lista.size(); i++) {

			sb.append(i + ") " + lista.get(i).getData().toString() + "\n");

		}
		return sb.toString();

	}

}
