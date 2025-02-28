package co.edu.unbosque.modulo;

public class Pan {
	private String tipo_pan;
	private int cantidad_unidades;
	private String temperatura;
	private boolean tiene_azucar;
	private boolean es_integral;
	
	public Pan() {
		// TODO Auto-generated constructor stub
	}

	public Pan(String tipo_pan, int cantidad_unidades, String temperatura, boolean tiene_azucar, boolean es_integral) {
		super();
		this.tipo_pan = tipo_pan;
		this.cantidad_unidades = cantidad_unidades;
		this.temperatura = temperatura;
		this.tiene_azucar = tiene_azucar;
		this.es_integral = es_integral;
	}

	public String getTipo_pan() {
		return tipo_pan;
	}

	public void setTipo_pan(String tipo_pan) {
		this.tipo_pan = tipo_pan;
	}

	public int getCantidad_unidades() {
		return cantidad_unidades;
	}

	public void setCantidad_unidades(int cantidad_unidades) {
		this.cantidad_unidades = cantidad_unidades;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
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
	
	public void prepararse() {}
	public void empacarse() {}
	public void comerse() {}
	public void desecharse() {}
}
