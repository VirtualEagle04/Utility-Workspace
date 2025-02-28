package co.edu.unbosque.services;

import java.util.ArrayList;

import co.edu.unbosque.dao.ProductDAO;
import co.edu.unbosque.entity.Product;

public class ProductService {
	private ProductDAO pDAO = new ProductDAO();

	public boolean create(Product p) {
		return pDAO.create(p);
	}

	public ArrayList<Product> read() {
		return pDAO.read();
	}

	public boolean update(Product p) {
		return pDAO.update(p);
	}

	public boolean delete(Product p) {
		return pDAO.delete(p);
	}
}
