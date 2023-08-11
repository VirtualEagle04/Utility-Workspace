package co.edu.unbosque.model;

public class TiburonDTO extends AnimalDTO {

	private String subespecie;
	private int cant_dientes;
	private String tipo_mandibula;

	public TiburonDTO() {

	}

	public TiburonDTO(String subespecie, int cant_dientes, String tipo_mandibula) {
		super();
		this.subespecie = subespecie;
		this.cant_dientes = cant_dientes;
		this.tipo_mandibula = tipo_mandibula;
	}

	public TiburonDTO(String especie, int cantidad_ojos, boolean tiene_pelaje, String habitad, boolean es_vertebrado,
			String tipo_reproduccion, String nivel_peligro, String subespecie, int cant_dientes,
			String tipo_mandibula) {
		super(especie, cantidad_ojos, tiene_pelaje, habitad, es_vertebrado, tipo_reproduccion, nivel_peligro);
		this.subespecie = subespecie;
		this.cant_dientes = cant_dientes;
		this.tipo_mandibula = tipo_mandibula;
	}

	public String getSubespecie() {
		return subespecie;
	}

	public void setSubespecie(String subespecie) {
		this.subespecie = subespecie;
	}

	public int getCant_dientes() {
		return cant_dientes;
	}

	public void setCant_dientes(int cant_dientes) {
		this.cant_dientes = cant_dientes;
	}

	public String getTipo_mandibula() {
		return tipo_mandibula;
	}

	public void setTipo_mandibula(String tipo_mandibula) {
		this.tipo_mandibula = tipo_mandibula;
	}

	@Override
	public String comer() {
		// TODO Auto-generated method stub
		return "Los tiburones se alimentan principalmente de carne";
	}

	@Override
	public String dormir() {
		// TODO Auto-generated method stub
		return "Los tiburones no duermen, dormitan";
	}

	@Override
	public String reproducirse() {
		// TODO Auto-generated method stub
		return "Los tiburones son ovopiviparos";
	}

	@Override
	public String morirse() {
		// TODO Auto-generated method stub
		return "Los tiburones pueden llegar a ser inmortales";
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Especie: " + getEspecie() + "\n");
		sb.append("Tiene pelaje: " + (isTiene_pelaje() ? "Si" : "No"));
		sb.append("Cantidad de ojos: " + getCant_dientes());
		sb.append("Habitad: " + getHabitad());
		sb.append("Es vertebrado? " + (isEs_vertebrado() ? "Si" : "No"));
		sb.append("Tipo de reproduccion: " + getTipo_reproduccion());
		sb.append("Nivel de peligro: " + getNivel_peligro());
		sb.append("Subespecie: " + getSubespecie());
		sb.append("Tipo de mandibula: " + getTipo_mandibula());
		sb.append("Cantidad de dientes: " + getCant_dientes());

		return super.toString();
	}

}
