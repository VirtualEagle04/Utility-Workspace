package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.db.DataBase;
import co.edu.unbosque.entity.Product;

public class ProductDAO {

	public boolean create(Product p) {
		return DataBase.productTable.add(p);
	}

	public ArrayList<Product> read() {
		return DataBase.productTable;
	}

	public boolean update(Product p) {
		for (int i = 0; i < DataBase.productTable.size(); i++) {
			Product tempProduct = DataBase.productTable.get(i);
			if (tempProduct.getId() == p.getId()) {
				DataBase.productTable.set(i, p);
				return true;
			}
		}
		return false;
	}

	public boolean delete(Product p) {
		for (int i = 0; i < DataBase.productTable.size(); i++) {
			Product tempProduct = DataBase.productTable.get(i);
			if (tempProduct.getId() == p.getId()) {
				DataBase.productTable.remove(i);
				return true;
			}
		}
		return false;
	}

}
