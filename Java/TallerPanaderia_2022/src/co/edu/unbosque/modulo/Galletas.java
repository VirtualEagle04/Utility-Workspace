package co.edu.unbosque.modulo;

public class Galletas {
	private String marca;
	private boolean tiene_azucar;
	private boolean es_integral;
	private int unidades_por_empaque;
	private boolean de_trigo;
	
	public Galletas() {
		// TODO Auto-generated constructor stub
	}

	public Galletas(String marca, boolean tiene_azucar, boolean es_integral, int unidades_por_empaque,
			boolean de_trigo) {
		super();
		this.marca = marca;
		this.tiene_azucar = tiene_azucar;
		this.es_integral = es_integral;
		this.unidades_por_empaque = unidades_por_empaque;
		this.de_trigo = de_trigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isTiene_azucar() {
		return tiene_azucar;
	}

	public void setTiene_azucar(boolean tiene_azucar) {
		this.tiene_azucar = tiene_azucar;
	}

	public boolean isEs_integral() {
		return es_integral;
	}

	public void setEs_integral(boolean es_integral) {
		this.es_integral = es_integral;
	}

	public int getUnidades_por_empaque() {
		return unidades_por_empaque;
	}

	public void setUnidades_por_empaque(int unidades_por_empaque) {
		this.unidades_por_empaque = unidades_por_empaque;
	}

	public boolean isDe_trigo() {
		return de_trigo;
	}

	public void setDe_trigo(boolean de_trigo) {
		this.de_trigo = de_trigo;
	}
	
	public void producirse() {}
	public void distribuirse() {}
	public void consumirse() {}
	
}
