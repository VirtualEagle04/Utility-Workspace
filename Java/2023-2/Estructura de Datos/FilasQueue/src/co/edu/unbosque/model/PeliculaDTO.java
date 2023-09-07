package co.edu.unbosque.model;

public class PeliculaDTO {
	
	private String nombre;
	private int año;
	private int duracion;
	private String director;
	private String studio;
	private int rating;
	
	public PeliculaDTO() {
		
	}

	public PeliculaDTO(String nombre, int año, int duracion, String director, String studio, int rating) {
		super();
		this.nombre = nombre;
		this.año = año;
		this.duracion = duracion;
		this.director = director;
		this.studio = studio;
		this.rating = rating;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "[" + getNombre() + ", " + getAño() + ", " + getDuracion() + ", " + getDirector() + ", " + getStudio() + ", " + getRating() + "]";
	}
	
}

