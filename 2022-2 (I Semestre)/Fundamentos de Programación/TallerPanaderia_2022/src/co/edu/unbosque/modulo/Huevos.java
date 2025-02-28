package co.edu.unbosque.modulo;

public class Huevos {
	private String tipo_de_huevo;
	private int unidades_por_caja;
	private boolean a_domicilio;
	private String distribuidor;
	private String tamano;
	
	public Huevos() {
		// TODO Auto-generated constructor stub
	}

	public Huevos(String tipo_de_huevo, int unidades_por_caja, boolean a_domicilio, String distribuidor,
			String tamano) {
		super();
		this.tipo_de_huevo = tipo_de_huevo;
		this.unidades_por_caja = unidades_por_caja;
		this.a_domicilio = a_domicilio;
		this.distribuidor = distribuidor;
		this.tamano = tamano;
	}

	public String getTipo_de_huevo() {
		return tipo_de_huevo;
	}

	public void setTipo_de_huevo(String tipo_de_huevo) {
		this.tipo_de_huevo = tipo_de_huevo;
	}

	public int getUnidades_por_caja() {
		return unidades_por_caja;
	}

	public void setUnidades_por_caja(int unidades_por_caja) {
		this.unidades_por_caja = unidades_por_caja;
	}

	public boolean isA_domicilio() {
		return a_domicilio;
	}

	public void setA_domicilio(boolean a_domicilio) {
		this.a_domicilio = a_domicilio;
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	
	public void recolectarse() {}
	public void almacenarse() {}
	public void distribuirse() {}
	public void consumirse() {}
	public void caducarse() {}
}
