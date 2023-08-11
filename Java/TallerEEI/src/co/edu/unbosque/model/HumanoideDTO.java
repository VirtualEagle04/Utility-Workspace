package co.edu.unbosque.model;

public class HumanoideDTO {
	
	private String nombre;
	private int edad;
	private String nacionalidad;
	private String alimento_fav;
	
	public HumanoideDTO() {
		// TODO Auto-generated constructor stub
	}

	public HumanoideDTO(String nombre, int edad, String nacionalidad, String alimento_fav) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.alimento_fav = alimento_fav;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getAlimento_fav() {
		return alimento_fav;
	}

	public void setAlimento_fav(String alimento_fav) {
		this.alimento_fav = alimento_fav;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: "+getNombre()+"\n");
		sb.append("Edad: "+getEdad()+"\n");
		sb.append("Nacionalidad: "+getNacionalidad()+"\n");
		sb.append("Alimento Favorito: "+getAlimento_fav()+"\n");
		return sb.toString();
	}

}
