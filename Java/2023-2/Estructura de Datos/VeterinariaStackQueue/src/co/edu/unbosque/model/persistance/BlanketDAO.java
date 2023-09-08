package co.edu.unbosque.model.persistance;

import co.edu.unbosque.model.BlanketDTO;
import co.edu.unbosque.util.StackImp;

public class BlanketDAO {

	private StackImp<BlanketDTO> list;
	
	public BlanketDAO() {
		list = new StackImp<>();
	}

	public BlanketDAO(StackImp<BlanketDTO> list) {
		super();
		this.list = list;
	}

	public StackImp<BlanketDTO> getList() {
		return list;
	}

	public void setList(StackImp<BlanketDTO> list) {
		this.list = list;
	}
	
	public boolean insert(BlanketDTO newAnimal) {
		try {
			list.push(newAnimal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean remove() {
		try {
			list.pop();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String display() {
		return list.toString();
	}
	
}
