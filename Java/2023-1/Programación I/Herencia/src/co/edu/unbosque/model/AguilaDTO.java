package co.edu.unbosque.model;

public class AguilaDTO extends AnimalDTO{

	private float longitud_alas;
	private String tipo_pico;
	
	public AguilaDTO() {
		
	}

	public AguilaDTO(float longitud_alas, String tipo_pico) {
		super();
		this.longitud_alas = longitud_alas;
		this.tipo_pico = tipo_pico;
	}
	
	public AguilaDTO(String especie, int cantidad_ojos, boolean tiene_pelaje, String habitad, boolean es_vertebrado,
			String tipo_reproduccion, String nivel_peligro, float longitud_alas, String tipo_pico) {
		super(especie, cantidad_ojos, tiene_pelaje, habitad, es_vertebrado, tipo_reproduccion, nivel_peligro);
		this.longitud_alas = longitud_alas;
		this.tipo_pico = tipo_pico;
	}

	public float getLongitud_alas() {
		return longitud_alas;
	}

	public void setLongitud_alas(float longitud_alas) {
		this.longitud_alas = longitud_alas;
	}

	public String getTipo_pico() {
		return tipo_pico;
	}

	public void setTipo_pico(String tipo_pico) {
		this.tipo_pico = tipo_pico;
	}
	
	
}
