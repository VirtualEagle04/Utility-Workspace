package co.edu.unbosque.model;

public class AlienDTO extends HumanoideDTO{

	private String tipo_reproduccion;
	private int cant_dedos;
	
	public AlienDTO() {
		// TODO Auto-generated constructor stub
	}

	public AlienDTO(String tipo_reproduccion, int cant_dedos) {
		super();
		this.tipo_reproduccion = tipo_reproduccion;
		this.cant_dedos = cant_dedos;
	}

	public AlienDTO(String nombre, int edad, String nacionalidad, String alimento_fav) {
		super(nombre, edad, nacionalidad, alimento_fav);
		// TODO Auto-generated constructor stub
	}

	public AlienDTO(String nombre, int edad, String nacionalidad, String alimento_fav, String tipo_reproduccion,
			int cant_dedos) {
		super(nombre, edad, nacionalidad, alimento_fav);
		this.tipo_reproduccion = tipo_reproduccion;
		this.cant_dedos = cant_dedos;
	}

	public String getTipo_reproduccion() {
		return tipo_reproduccion;
	}

	public void setTipo_reproduccion(String tipo_reproduccion) {
		this.tipo_reproduccion = tipo_reproduccion;
	}

	public int getCant_dedos() {
		return cant_dedos;
	}

	public void setCant_dedos(int cant_dedos) {
		this.cant_dedos = cant_dedos;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Tipo de Reproduccion: "+getTipo_reproduccion()+"\n");
		sb.append("Cantidad de Dedos: "+getCant_dedos()+"\n");
		return sb.toString();
	}
	
	
}
