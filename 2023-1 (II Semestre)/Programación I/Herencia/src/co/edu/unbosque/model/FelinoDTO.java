package co.edu.unbosque.model;

public class FelinoDTO extends AnimalDTO{
	
	private boolean es_domestico;
	private String tipo_morfologia;
	
	public FelinoDTO() {
		// TODO Auto-generated constructor stub
	}

	public FelinoDTO(boolean es_domestico, String tipo_morfologia) {
		super();
		this.es_domestico = es_domestico;
		this.tipo_morfologia = tipo_morfologia;
	}

	public FelinoDTO(String especie, int cantidad_ojos, boolean tiene_pelaje, String habitad, boolean es_vertebrado,
			String tipo_reproduccion, String nivel_peligro, boolean es_domestico, String tipo_morfologia) {
		super(especie, cantidad_ojos, tiene_pelaje, habitad, es_vertebrado, tipo_reproduccion, nivel_peligro);
		this.es_domestico = es_domestico;
		this.tipo_morfologia = tipo_morfologia;
	}

	public boolean isEs_domestico() {
		return es_domestico;
	}

	public void setEs_domestico(boolean es_domestico) {
		this.es_domestico = es_domestico;
	}

	public String getTipo_morfologia() {
		return tipo_morfologia;
	}

	public void setTipo_morfologia(String tipo_morfologia) {
		this.tipo_morfologia = tipo_morfologia;
	}
	
	

}
