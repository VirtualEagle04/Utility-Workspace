package co.edu.unbosque.model;

public class AnimalDTO {

	private String nombre;
	private String habitad;
	private int nvl_peligrosidad;
	private String tipo_reproduccion;
	private boolean tiene_pelaje;
	
	public AnimalDTO() {
		
	}

	public AnimalDTO(String nombre, String habitad, int nvl_peligrosidad, String tipo_reproduccion,
			boolean tiene_pelaje) {
		super();
		this.nombre = nombre;
		this.habitad = habitad;
		this.nvl_peligrosidad = nvl_peligrosidad;
		this.tipo_reproduccion = tipo_reproduccion;
		this.tiene_pelaje = tiene_pelaje;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHabitad() {
		return habitad;
	}

	public void setHabitad(String habitad) {
		this.habitad = habitad;
	}

	public int getNvl_peligrosidad() {
		return nvl_peligrosidad;
	}

	public void setNvl_peligrosidad(int nvl_peligrosidad) {
		this.nvl_peligrosidad = nvl_peligrosidad;
	}

	public String getTipo_reproduccion() {
		return tipo_reproduccion;
	}

	public void setTipo_reproduccion(String tipo_reproduccion) {
		this.tipo_reproduccion = tipo_reproduccion;
	}

	public boolean isTiene_pelaje() {
		return tiene_pelaje;
	}

	public void setTiene_pelaje(boolean tiene_pelaje) {
		this.tiene_pelaje = tiene_pelaje;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: "+getNombre()+"\n");
		sb.append("Habitad: "+getHabitad()+"\n");
		sb.append("Nivel de Peligro: "+getNvl_peligrosidad()+"\n");
		sb.append("Tipo de Reproduccion: "+getTipo_reproduccion()+"\n");
		sb.append("Tiene pelaje: "+isTiene_pelaje()+"\n");
		return sb.toString();
	}
	
	public String hacerRuido() {
		return "Cualquier animal hace ruido";
	}
	
}
