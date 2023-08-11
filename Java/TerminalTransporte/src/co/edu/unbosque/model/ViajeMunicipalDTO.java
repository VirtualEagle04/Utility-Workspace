package co.edu.unbosque.model;
/**
 * Clase que representa los Viajes Municipales, haciendo uso de los atributos extendidos de la clase ViajeDTO.
 * @author Federico Vargas Rozo
 * @param cant_peajes Cantidad de peajes por los que el Viaje Municipal pasa para llegar al destino.
 */
public class ViajeMunicipalDTO extends ViajeDTO{

	private int cant_peajes;
	
	public ViajeMunicipalDTO() {
		// TODO Auto-generated constructor stub
	}

	public ViajeMunicipalDTO(int cant_peajes) {
		super();
		this.cant_peajes = cant_peajes;
	}

	public ViajeMunicipalDTO(String origen, String destino, String[] hora_salida, int[] fecha_salida, float duracion,
			String nombre_c) {
		super(origen, destino, hora_salida, fecha_salida, duracion, nombre_c);
		// TODO Auto-generated constructor stub
	}

	public ViajeMunicipalDTO(String origen, String destino, String[] hora_salida, int[] fecha_salida, float duracion,
			String nombre_c, int cant_peajes) {
		super(origen, destino, hora_salida, fecha_salida, duracion, nombre_c);
		this.cant_peajes = cant_peajes;
	}

	public int getCant_peajes() {
		return cant_peajes;
	}

	public void setCant_peajes(int cant_peajes) {
		this.cant_peajes = cant_peajes;
	}
	/**
	 * Funcion que sobreescribe el metodo toString() de todo Objeto, utilizado para mostrar 
	 * todos los atributos del viaje.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Numero de peajes: "+getCant_peajes()+"\n");
		sb.append("-------------------\n");
		return sb.toString();
	}
	
	
}
