package co.edu.unbosque.modulo;

public class Leche {
	private String marca;
	private int litros_enteros;
	private boolean es_entera;
	private boolean tiene_lactosa;
	private String empaque;
	
	public Leche() {
		// TODO Auto-generated constructor stub
	}
	


	public Leche(String marca, int litros_enteros, boolean es_entera, boolean tiene_lactosa, String empaque) {
		super();
		this.marca = marca;
		this.litros_enteros = litros_enteros;
		this.es_entera = es_entera;
		this.tiene_lactosa = tiene_lactosa;
		this.empaque = empaque;
	}

	

	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public int getLitros_enteros() {
		return litros_enteros;
	}



	public void setLitros_enteros(int litros_enteros) {
		this.litros_enteros = litros_enteros;
	}



	public boolean isEs_entera() {
		return es_entera;
	}



	public void setEs_entera(boolean es_entera) {
		this.es_entera = es_entera;
	}



	public boolean isTiene_lactosa() {
		return tiene_lactosa;
	}



	public void setTiene_lactosa(boolean tiene_lactosa) {
		this.tiene_lactosa = tiene_lactosa;
	}



	public String getEmpaque() {
		return empaque;
	}



	public void setEmpaque(String empaque) {
		this.empaque = empaque;
	}



	public void sacarseDelAlmacen() {}
	public void entregarseCliente() {}
	public void consumirse() {}
	public void expirarse() {}
}
