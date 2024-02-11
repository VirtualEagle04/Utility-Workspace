package co.edu.unbosque.model;

public class LagartijaDTO extends AnimalDTO{

	private String comida_favorita;
	
	public LagartijaDTO() {
		// TODO Auto-generated constructor stub
	}

	public LagartijaDTO(String comida_favorita) {
		super();
		this.comida_favorita = comida_favorita;
	}

	public LagartijaDTO(String nombre, String habitad, int nvl_peligrosidad, String tipo_reproduccion,
			boolean tiene_pelaje) {
		super(nombre, habitad, nvl_peligrosidad, tipo_reproduccion, tiene_pelaje);
		// TODO Auto-generated constructor stub
	}

	public LagartijaDTO(String nombre, String habitad, int nvl_peligrosidad, String tipo_reproduccion,
			boolean tiene_pelaje, String comida_favorita) {
		super(nombre, habitad, nvl_peligrosidad, tipo_reproduccion, tiene_pelaje);
		this.comida_favorita = comida_favorita;
	}
	
	
	
	public String getComida_favorita() {
		return comida_favorita;
	}

	public void setComida_favorita(String comida_favorita) {
		this.comida_favorita = comida_favorita;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Raza: "+getComida_favorita()+"\n");
		sb.append("----------------\n");
		return sb.toString();
	}
	
	@Override
	public String hacerRuido() {
		return "Zzzzz...";
	}
	
}
