package co.edu.unbosque.model;

public class PerroDTO extends AnimalDTO{
	
	private String raza;
	private String alimento_favorito;
	
	public PerroDTO() {
		// TODO Auto-generated constructor stub
	}

	public PerroDTO(String raza, String alimento_favorito) {
		super();
		this.raza = raza;
		this.alimento_favorito = alimento_favorito;
	}

	public PerroDTO(String nombre, String habitad, int nvl_peligrosidad, String tipo_reproduccion,
			boolean tiene_pelaje) {
		super(nombre, habitad, nvl_peligrosidad, tipo_reproduccion, tiene_pelaje);
		// TODO Auto-generated constructor stub
	}

	public PerroDTO(String nombre, String habitad, int nvl_peligrosidad, String tipo_reproduccion, boolean tiene_pelaje,
			String raza, String alimento_favorito) {
		super(nombre, habitad, nvl_peligrosidad, tipo_reproduccion, tiene_pelaje);
		this.raza = raza;
		this.alimento_favorito = alimento_favorito;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getAlimento_favorito() {
		return alimento_favorito;
	}

	public void setAlimento_favorito(String alimento_favorito) {
		this.alimento_favorito = alimento_favorito;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Raza: "+getRaza()+"\n");
		sb.append("Alimento favorito: "+getAlimento_favorito()+"\n");
		sb.append("----------------\n");
		return sb.toString();
	}
	
	@Override
	public String hacerRuido() {
		return "Guau";
	}
	
	
}
