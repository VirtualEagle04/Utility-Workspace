package co.edu.unbosque.model.persistance;

import co.edu.unbosque.model.AnimalDTO;
import co.edu.unbosque.util.QueueImp;

public class AnimalDAO {

	private QueueImp<AnimalDTO> list;

	public AnimalDAO() {
		list = new QueueImp<>();
	}

	public AnimalDAO(QueueImp<AnimalDTO> list) {
		super();
		this.list = list;
	}

	public QueueImp<AnimalDTO> getList() {
		return list;
	}

	public void setList(QueueImp<AnimalDTO> list) {
		this.list = list;
	}

	public boolean insert(AnimalDTO newAnimal) {
		try {
			list.enqueue(newAnimal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public AnimalDTO remove() {
		return list.dequeue();
	}

	public String display() {
		return list.toString();
	}

}