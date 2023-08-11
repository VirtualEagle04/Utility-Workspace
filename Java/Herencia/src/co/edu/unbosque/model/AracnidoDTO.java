package co.edu.unbosque.model;

public class AracnidoDTO extends AnimalDTO{
	
	private boolean es_toxica;
	private String color;
	
	public AracnidoDTO() {
		// TODO Auto-generated constructor stub
	}

	public AracnidoDTO(boolean es_toxica, String color) {
		super();
		this.es_toxica = es_toxica;
		this.color = color;
	}

	public AracnidoDTO(String especie, int cantidad_ojos, boolean tiene_pelaje, String habitad, boolean es_vertebrado,
			String tipo_reproduccion, String nivel_peligro, boolean es_toxica, String color) {
		super(especie, cantidad_ojos, tiene_pelaje, habitad, es_vertebrado, tipo_reproduccion, nivel_peligro);
		this.es_toxica = es_toxica;
		this.color = color;
	}

	public boolean isEs_toxica() {
		return es_toxica;
	}

	public void setEs_toxica(boolean es_toxica) {
		this.es_toxica = es_toxica;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
