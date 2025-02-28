package co.edu.unbosque.model;

public class PeliculaDTO {
	
	private String nombre;
	private int a�o;
	private int duracion;
	private String director;
	private String studio;
	private int rating;
	
	public PeliculaDTO() {
		
	}

	public PeliculaDTO(String nombre, int a�o, int duracion, String director, String studio, int rating) {
		super();
		this.nombre = nombre;
		this.a�o = a�o;
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

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
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
		return "[" + getNombre() + ", " + getA�o() + ", " + getDuracion() + ", " + getDirector() + ", " + getStudio() + ", " + getRating() + "]";
	}
	
}

