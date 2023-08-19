package co.edu.unbosque.model;

public class HumanoDTO extends AnimalDTO{
	
	private String color_piel;
	private String nombre;
	
	public HumanoDTO() {
		
	}

	public HumanoDTO(String color_piel, String nombre) {
		super();
		this.color_piel = color_piel;
		this.nombre = nombre;
	}

	public HumanoDTO(String especie, int cantidad_ojos, boolean tiene_pelaje, String habitad, boolean es_vertebrado,
			String tipo_reproduccion, String nivel_peligro, String color_piel, String nombre) {
		super(especie, cantidad_ojos, tiene_pelaje, habitad, es_vertebrado, tipo_reproduccion, nivel_peligro);
		this.color_piel = color_piel;
		this.nombre = nombre;
	}

	public String getColor_piel() {
		return color_piel;
	}

	public void setColor_piel(String color_piel) {
		this.color_piel = color_piel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
