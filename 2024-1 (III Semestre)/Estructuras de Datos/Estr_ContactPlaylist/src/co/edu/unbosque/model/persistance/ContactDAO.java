package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.model.ContactDTO;
import co.edu.unbosque.util.CRUDoperations;

public class ContactDAO implements CRUDoperations {

	private ArrayList<ContactDTO> list;

	public ContactDAO() {
		list = new ArrayList<ContactDTO>();
	}

	@Override
	public void create(Object o) {
		list.add((ContactDTO) o);
	}

	@Override
	public int delete(int index) {
		try {
			list.remove(index);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			return -1;
		}
	}

	public int delete(String name) {
		try {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().equals(name)) {
					list.remove(i);
					return 0;
				}
			}
			return -1;
		} catch (IndexOutOfBoundsException e) {
			return -1;
		}
	}

	@Override
	public int update(int index, Object o) {
		try {
			list.set(index, (ContactDTO) o);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			return -1;
		}
	}

	@Override
	public String read() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(i + ": " + list.get(i).toString() + "\n");
		}
		return sb.toString();
	}

	public String read(String name) {
		try {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().equals(name)) {
					return i + ": " + list.get(i).toString() + "\n";
				}
			}
			return "-1";
		} catch (IndexOutOfBoundsException e) {
			return "-1";
		}
	}

}
