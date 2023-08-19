package co.edu.unbosque.model;

public class AnimalDTO {

	private String especie;
	private int cantidad_ojos;
	private boolean tiene_pelaje;
	private String habitad;
	private boolean es_vertebrado;
	private String tipo_reproduccion;
	private String nivel_peligro;

	public AnimalDTO() {
		// TODO Auto-generated constructor stub
	}

	public AnimalDTO(String especie, int cantidad_ojos, boolean tiene_pelaje, String habitad, boolean es_vertebrado,
			String tipo_reproduccion, String nivel_peligro) {
		super();
		this.especie = especie;
		this.cantidad_ojos = cantidad_ojos;
		this.tiene_pelaje = tiene_pelaje;
		this.habitad = habitad;
		this.es_vertebrado = es_vertebrado;
		this.tipo_reproduccion = tipo_reproduccion;
		this.nivel_peligro = nivel_peligro;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getCantidad_ojos() {
		return cantidad_ojos;
	}

	public void setCantidad_ojos(int cantidad_ojos) {
		this.cantidad_ojos = cantidad_ojos;
	}

	public boolean isTiene_pelaje() {
		return tiene_pelaje;
	}

	public void setTiene_pelaje(boolean tiene_pelaje) {
		this.tiene_pelaje = tiene_pelaje;
	}

	public String getHabitad() {
		return habitad;
	}

	public void setHabitad(String habitad) {
		this.habitad = habitad;
	}

	public boolean isEs_vertebrado() {
		return es_vertebrado;
	}

	public void setEs_vertebrado(boolean es_vertebrado) {
		this.es_vertebrado = es_vertebrado;
	}

	public String getTipo_reproduccion() {
		return tipo_reproduccion;
	}

	public void setTipo_reproduccion(String tipo_reproduccion) {
		this.tipo_reproduccion = tipo_reproduccion;
	}

	public String getNivel_peligro() {
		return nivel_peligro;
	}

	public void setNivel_peligro(String nivel_peligro) {
		this.nivel_peligro = nivel_peligro;
	}

	public String comer() {

		return "Este animal come";
	}

	public String dormir() {
		return "Este animal duerme";
	}

	public String reproducirse() {
		return "Este animal se reproduce";
	}

	public String morirse() {
		return "Este animal se puede morir";

	}
}
