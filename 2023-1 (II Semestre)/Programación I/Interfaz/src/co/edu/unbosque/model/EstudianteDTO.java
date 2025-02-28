package co.edu.unbosque.model;

public class EstudianteDTO {

	private String nombre;
	private String carrera;
	private int edad;
	private String sexo;
	private int materias_perdidas;
	private int semestre;
	private String universidad;
	
	
	public EstudianteDTO() {
		// TODO Auto-generated constructor stub
	}

	public EstudianteDTO(String nombre, String carrera, int edad, String sexo, int materias_perdidas, int semestre,
			String universidad) {
		super();
		this.nombre = nombre;
		this.carrera = carrera;
		this.edad = edad;
		this.sexo = sexo;
		this.materias_perdidas = materias_perdidas;
		this.semestre = semestre;
		this.universidad = universidad;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCarrera() {
		return carrera;
	}


	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public int getMaterias_perdidas() {
		return materias_perdidas;
	}


	public void setMaterias_perdidas(int materias_perdidas) {
		this.materias_perdidas = materias_perdidas;
	}


	public int getSemestre() {
		return semestre;
	}


	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}


	public String getUniversidad() {
		return universidad;
	}


	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: "+nombre);
		sb.append("Carrera: "+carrera);
		sb.append("Sexo: "+sexo);
		sb.append("Edad: "+edad);
		sb.append("Materias Perdidas: "+materias_perdidas);
		sb.append("Semestre: "+semestre);
		sb.append("Universidad: "+universidad);
		return sb.toString();
	}
	
}
