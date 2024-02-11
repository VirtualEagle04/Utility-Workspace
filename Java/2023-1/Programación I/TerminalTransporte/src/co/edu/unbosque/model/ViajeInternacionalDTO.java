package co.edu.unbosque.model;
/**
 * Clase que representa los Viajes Internacionales, haciendo uso de los atributos extendidos de la clase ViajeDTO.
 * @author Federico Vargas Rozo
 * @param cant_peajes Cantidad de aduanas por los que el Viaje Internacional pasa para llegar al destino.
 */
public class ViajeInternacionalDTO extends ViajeDTO{

	private int cant_aduanas;
	
	public ViajeInternacionalDTO() {
		// TODO Auto-generated constructor stub
	}

	public ViajeInternacionalDTO(int cant_aduanas) {
		super();
		this.cant_aduanas = cant_aduanas;
	}

	public ViajeInternacionalDTO(String origen, String destino, String[] hora_salida, int[] fecha_salida, float duracion,
			String nombre_c) {
		super(origen, destino, hora_salida, fecha_salida, duracion, nombre_c);
		// TODO Auto-generated constructor stub
	}

	public ViajeInternacionalDTO(String origen, String destino, String[] hora_salida, int[] fecha_salida, float duracion,
			String nombre_c, int cant_aduanas) {
		super(origen, destino, hora_salida, fecha_salida, duracion, nombre_c);
		this.cant_aduanas = cant_aduanas;
	}

	public int getCant_aduanas() {
		return cant_aduanas;
	}

	public void setCant_aduanas(int cant_aduanas) {
		this.cant_aduanas = cant_aduanas;
	}
	
	/**
	 * Funcion que sobreescribe el metodo toString() de todo Objeto, utilizado para mostrar 
	 * todos los atributos del viaje.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Numero de Aduanas: "+getCant_aduanas()+"\n");
		sb.append("-------------------\n");
		return sb.toString();
	}
	
}
