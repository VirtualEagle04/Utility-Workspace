package co.edu.unbosque.model;

public class EstudianteForaneoDTO extends EstudianteDTO{

	private String ciudad_origen;
	
	
	public EstudianteForaneoDTO() {
		// TODO Auto-generated constructor stub
	}


	public EstudianteForaneoDTO(String ciudad_origen) {
		super();
		this.ciudad_origen = ciudad_origen;
	}

	public EstudianteForaneoDTO(String nombre, String carrera, int edad, String sexo, int materias_perdidas,
			int semestre, String universidad) {
		super(nombre, carrera, edad, sexo, materias_perdidas, semestre, universidad);
		// TODO Auto-generated constructor stub
	}


	public EstudianteForaneoDTO(String nombre, String carrera, int edad, String sexo, int materias_perdidas,
			int semestre, String universidad, String ciudad_origen) {
		super(nombre, carrera, edad, sexo, materias_perdidas, semestre, universidad);
		this.ciudad_origen = ciudad_origen;
	}
	
	
	
	public String getCiudad_origen() {
		return ciudad_origen;
	}


	public void setCiudad_origen(String ciudad_origen) {
		this.ciudad_origen = ciudad_origen;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Ciudad de Origen: "+ciudad_origen);
	
		return sb.toString();
	}
	
}
