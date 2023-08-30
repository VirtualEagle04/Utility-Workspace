
public class NascarCarDAO {

	private MyDoubleLinkedList<NascarCarDTO> lista;
	
	public NascarCarDAO() {
		lista = new MyDoubleLinkedList<NascarCarDTO>();
	}

	public MyDoubleLinkedList<NascarCarDTO> getLista() {
		return lista;
	}

	public void setLista(MyDoubleLinkedList<NascarCarDTO> lista) {
		this.lista = lista;
	}
	
	public void create(NascarCarDTO newCar) {
		lista.insert(newCar);
	}
	
	public void remove() {
		lista.extract();
	}
	
	public void goFront() {
		lista.forward(1);
	}
	
	public void goBack() {
		lista.backward(1);
	}
	
	public String display() {
		return lista.toString();
	}
}
