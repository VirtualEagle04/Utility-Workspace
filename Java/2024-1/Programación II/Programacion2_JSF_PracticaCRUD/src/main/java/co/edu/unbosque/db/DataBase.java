package co.edu.unbosque.db;

import java.util.ArrayList;
import co.edu.unbosque.entity.Category;
import co.edu.unbosque.entity.Product;
import co.edu.unbosque.entity.State;

public class DataBase {

	public static ArrayList<Category> categoryTable = new ArrayList<>();
	public static ArrayList<Product> productTable = new ArrayList<>();

	static {
		// Debug Category
		Category c = new Category();
		c.setId(1);
		c.setDesc("Category A");
		c.setState(State.Enabled);
		categoryTable.add(c);

		// Debug Product
		Product p = new Product();
		p.setId(1);
		p.setName("Product A");
		p.setPrice(1500);
		p.setDesc("This is Product A description.");
		p.setState(State.Enabled);
		productTable.add(p);
	}

}
