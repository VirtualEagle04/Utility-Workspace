package co.edu.unbosque.services;

import java.util.ArrayList;

import co.edu.unbosque.dao.CategoryDAO;
import co.edu.unbosque.entity.Category;

public class CategoryService {
	private CategoryDAO cDAO = new CategoryDAO();

	public boolean create(Category c) {
		return cDAO.create(c);
	}

	public ArrayList<Category> read() {
		return cDAO.read();
	}

	public boolean update(Category c) {
		return cDAO.update(c);
	}

	public boolean delete(Category c) {
		return cDAO.delete(c);
	}
}
