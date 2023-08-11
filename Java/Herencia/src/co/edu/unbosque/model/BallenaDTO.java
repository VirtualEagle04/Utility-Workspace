package co.edu.unbosque.model;

public class BallenaDTO extends AnimalDTO{
	
	private String oceano_procedencia;
	private float duracion_migracion;
	
	public BallenaDTO() {
		// TODO Auto-generated constructor stub
	}

	public BallenaDTO(String oceano_procedencia, float duracion_migracion) {
		super();
		this.oceano_procedencia = oceano_procedencia;
		this.duracion_migracion = duracion_migracion;
	}

	public BallenaDTO(String especie, int cantidad_ojos, boolean tiene_pelaje, String habitad, boolean es_vertebrado,
			String tipo_reproduccion, String nivel_peligro, String oceano_procedencia, float duracion_migracion) {
		super(especie, cantidad_ojos, tiene_pelaje, habitad, es_vertebrado, tipo_reproduccion, nivel_peligro);
		this.oceano_procedencia = oceano_procedencia;
		this.duracion_migracion = duracion_migracion;
	}

	public String getOceano_procedencia() {
		return oceano_procedencia;
	}

	public void setOceano_procedencia(String oceano_procedencia) {
		this.oceano_procedencia = oceano_procedencia;
	}

	public float getDuracion_migracion() {
		return duracion_migracion;
	}

	public void setDuracion_migracion(float duracion_migracion) {
		this.duracion_migracion = duracion_migracion;
	}
	
	

}
