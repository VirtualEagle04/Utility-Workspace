package co.edu.unbosque.model;

public class AgujeroNegroDTO {

	private String nombre;
	private double masa;
	private float momento_ang;
	private float gravedad;
	private double diametro;
	
	public AgujeroNegroDTO() {
		
	}

	public AgujeroNegroDTO(String nombre, double masa, float momento_ang, float gravedad, double diametro) {
		super();
		this.nombre = nombre;
		this.masa = masa;
		this.momento_ang = momento_ang;
		this.gravedad = gravedad;
		this.diametro = diametro;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}

	public float getMomento_ang() {
		return momento_ang;
	}

	public void setMomento_ang(float momento_ang) {
		this.momento_ang = momento_ang;
	}

	public float getGravedad() {
		return gravedad;
	}

	public void setGravedad(float gravedad) {
		this.gravedad = gravedad;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	
	
	
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Nombre: "+getNombre());
		sb.append("Masa: "+getMasa());
		sb.append("Momento Angular: "+getMomento_ang());
		sb.append("Gravedad: "+getGravedad());
		sb.append("Diametro: "+getDiametro());

		return sb.toString();
	}
	
}
