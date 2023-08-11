package co.edu.unbosque.modelo;

/**
 * Representación de los elementos de la realidad que se
 * encuentran ligados a la Papeleria.
 * @author fedeS
 * @param nombre - Nombre del producto. 
 * @param marca - Marca del producto.
 * @param precio - Precio del producto. En pesos colombianos (COP).
 * @param distribuidor - Distribuidor del producto.
 * @param cantidad - Cantidad de inventario del producto.
 * 
 * 
 *
 */

public class Material {

	
	private String nombre;

	
	private String marca;

	
	private double precio;

	
	private String distribuidor;

	
	private int cantidad;
	
	public Material() {
		
	}
	
	public Material(String nombre, String marca, double precio, String distribuidor, int cantidad) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.distribuidor = distribuidor;
		this.cantidad = cantidad;
	}

	//Getters & Setters
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
