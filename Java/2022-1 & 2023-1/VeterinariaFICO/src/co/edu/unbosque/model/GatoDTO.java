package co.edu.unbosque.model;

public class GatoDTO extends AnimalDTO{

	private String raza;
	private float horas_sueño;
	
	public GatoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public GatoDTO(String raza, float horas_sueño) {
		super();
		this.raza = raza;
		this.horas_sueño = horas_sueño;
	}

	public GatoDTO(String nombre, String habitad, int nvl_peligrosidad, String tipo_reproduccion,
			boolean tiene_pelaje) {
		super(nombre, habitad, nvl_peligrosidad, tipo_reproduccion, tiene_pelaje);
		// TODO Auto-generated constructor stub
	}

	public GatoDTO(String nombre, String habitad, int nvl_peligrosidad, String tipo_reproduccion, boolean tiene_pelaje,
			String raza, float horas_sueño) {
		super(nombre, habitad, nvl_peligrosidad, tipo_reproduccion, tiene_pelaje);
		this.raza = raza;
		this.horas_sueño = horas_sueño;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public float getHoras_sueño() {
		return horas_sueño;
	}

	public void setHoras_sueño(float horas_sueño) {
		this.horas_sueño = horas_sueño;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Raza: "+getRaza()+"\n");
		sb.append("Horas de Sueño: "+getHoras_sueño()+"\n");
		sb.append("----------------\n");
		return sb.toString();
	}
	
	@Override
	public String hacerRuido() {
		return "Meow meow motherfucker";
	}
	
	
}
