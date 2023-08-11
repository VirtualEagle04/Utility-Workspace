package co.edu.unbosque.model;

public class EstudianteCitadinoDTO extends EstudianteDTO{

	private String barrio;
	
	public EstudianteCitadinoDTO() {
		// TODO Auto-generated constructor stub
	}

	public EstudianteCitadinoDTO(String barrio) {
		super();
		this.barrio = barrio;
	}

	public EstudianteCitadinoDTO(String nombre, String carrera, int edad, String sexo, int materias_perdidas,
			int semestre, String universidad) {
		super(nombre, carrera, edad, sexo, materias_perdidas, semestre, universidad);
		// TODO Auto-generated constructor stub
	}

	public EstudianteCitadinoDTO(String nombre, String carrera, int edad, String sexo, int materias_perdidas,
			int semestre, String universidad, String barrio) {
		super(nombre, carrera, edad, sexo, materias_perdidas, semestre, universidad);
		this.barrio = barrio;
	}
	
	
	
	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Barrio: "+barrio);
		
		return sb.toString();
	}
	
	
	
}
