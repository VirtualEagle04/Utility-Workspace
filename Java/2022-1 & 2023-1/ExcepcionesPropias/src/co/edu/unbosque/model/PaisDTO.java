package co.edu.unbosque.model;

public class PaisDTO {

	private final int PREFIJO;
	private String nombre;
	private long poblacion;
	private String continente;
	private String idioma;
	
	public PaisDTO() {
		PREFIJO = 0;
	}

	public PaisDTO(int pREFIJO, String nombre, long poblacion, String continente, String idioma) {
		super();
		PREFIJO = pREFIJO;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.continente = continente;
		this.idioma = idioma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(long poblacion) {
		this.poblacion = poblacion;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getPREFIJO() {
		return PREFIJO;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: "+getNombre()+"\n");
		sb.append("Continente: "+getContinente()+"\n");
		sb.append("Poblacion: "+getPoblacion()+"\n");
		sb.append("Idioma: "+getIdioma()+"\n");
		sb.append("Prefijo: +"+getPREFIJO()+"\n");
		sb.append("------------------\n");
		return sb.toString();
	}
	
	
}
