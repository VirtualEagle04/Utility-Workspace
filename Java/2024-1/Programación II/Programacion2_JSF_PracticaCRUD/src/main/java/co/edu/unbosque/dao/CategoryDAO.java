package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.db.DataBase;
import co.edu.unbosque.entity.Category;

public class CategoryDAO {

	public boolean create(Category c) {
		return DataBase.categoryTable.add(c);
	}

	public ArrayList<Category> read() {
		return DataBase.categoryTable;
	}

	public boolean update(Category c) {
		for (int i = 0; i < DataBase.categoryTable.size(); i++) {
			Category tempCategory = DataBase.categoryTable.get(i);
			if (tempCategory.getId() == c.getId()) {
				DataBase.categoryTable.set(i, c);
				return true;
			}
		}
		return false;
	}

	public boolean delete(Category c) {
		for (int i = 0; i < DataBase.categoryTable.size(); i++) {
			Category tempCategory = DataBase.categoryTable.get(i);
			if (tempCategory.getId() == c.getId()) {
				DataBase.categoryTable.remove(i);
				return true;
			}
		}
		return false;
	}

}
