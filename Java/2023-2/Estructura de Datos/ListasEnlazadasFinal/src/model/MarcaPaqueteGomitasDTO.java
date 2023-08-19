package model;

public class MarcaPaqueteGomitasDTO {

	private String marca;
	private String presentacion;
	private double precio;

	public MarcaPaqueteGomitasDTO() {
	}

	public MarcaPaqueteGomitasDTO(String marca, String presentacion, double precio) {
		super();
		this.marca = marca;
		this.presentacion = presentacion;
		this.precio = precio;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "MarcaPaqueteGomitasDTO [marca=" + marca + ", presentacion=" + presentacion + ", precio=" + precio + "]";
	}

}
