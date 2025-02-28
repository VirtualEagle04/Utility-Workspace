package co.edu.unbosque.model;

/**
 * Clase base que contiene todos los atributos que comparten los Viajes.
 * @author Federico Vargas Rozo
 * @param origen Origen del Viaje.
 * @param destino Destino del Viaje.
 * @param hora_salida Hora de salida del Viaje.
 * @param fecha_salida Fecha de salida del Viaje.
 * @param duracion Duracion del Viaje, en horas.
 * @param nombre_c Nombre del conductor o piloto del Viaje.
 *
 */
public class ViajeDTO {

	private String origen;
	private String destino;
	private String[] hora_salida;
	private int[] fecha_salida;
	private float duracion;
	private String nombre_c;
	
	public ViajeDTO() {
		hora_salida = new String[2];
		fecha_salida = new int[3];
	}

	public ViajeDTO(String origen, String destino, String[] hora_salida, int[] fecha_salida, float duracion, String nombre_c) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.hora_salida = hora_salida;
		this.fecha_salida = fecha_salida;
		this.duracion = duracion;
		this.nombre_c = nombre_c;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String[] getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String[] hora_salida) {
		this.hora_salida = hora_salida;
	}

	public int[] getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(int[] fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public String getNombre_c() {
		return nombre_c;
	}

	public void setNombre_c(String nombre_c) {
		this.nombre_c = nombre_c;
	}
	/**
	 * Funcion que sobreescribe el metodo toString() de todo Objeto, utilizado para mostrar 
	 * todos los atributos del viaje.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Origen: "+getOrigen()+"\n");
		sb.append("Destino: "+getDestino()+"\n");
		sb.append("Fecha de Salida: "+getFecha_salida()[0]+"/"+getFecha_salida()[1]+"/"+getFecha_salida()[2]+"\n");
		sb.append("Hora de Salida: "+getHora_salida()[0]+":"+getHora_salida()[1]+"\n");
		sb.append("Duracion: "+getDuracion()+" Horas\n");
		sb.append("Nombre del Conductor: "+getNombre_c()+"\n");
		return sb.toString();
	}
	
}
