package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Clase que representa los Neonatos, heredando atributos de todos los Ciudadanos
 * @author Federico Vargas Rozo
 * @param padre Objeto de la clase PadreDTO 
 * @param madre Objeto de la clase MadreDTO
 *
 */
public class NeonatoDTO extends CiudadanoDTO{
	
	private PadreDTO padre;
	private MadreDTO madre;
	
	public NeonatoDTO() {
		// TODO Auto-generated constructor stub
	}

	public NeonatoDTO(PadreDTO padre, MadreDTO madre) {
		super();
		this.padre = padre;
		this.madre = madre;
	}

	public NeonatoDTO(String nombre, String sexo, String ciudad, Date fecha) {
		super(nombre, sexo, ciudad, fecha);
		// TODO Auto-generated constructor stub
	}
	
	//Padre y Madre
	public NeonatoDTO(String nombre, String sexo, String ciudad, Date fecha, PadreDTO padre, MadreDTO madre) {
		super(nombre, sexo, ciudad, fecha);
		this.padre = padre;
		this.madre = madre;
	}
	
	//Solo Madre
	public NeonatoDTO(String nombre, String sexo, String ciudad, Date fecha, MadreDTO madre) {
		super(nombre, sexo, ciudad, fecha);
		this.madre = madre;
	}
	
	//Solo Padre
	public NeonatoDTO(String nombre, String sexo, String ciudad, Date fecha, PadreDTO padre) {
		super(nombre, sexo, ciudad, fecha);
		this.padre = padre;
	}

	public PadreDTO getPadre() {
		return padre;
	}

	public void setPadre(PadreDTO padre) {
		this.padre = padre;
	}

	public MadreDTO getMadre() {
		return madre;
	}

	public void setMadre(MadreDTO madre) {
		this.madre = madre;
	}
	/**
	 * Funcion que sobreescribe el metodo toString() de todo Objeto, utilizado para mostrar 
	 * todos los atributos del viaje.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat date_format = new SimpleDateFormat("MM/dd/yyyy");
		sb.append("Nombre: "+getNombre()+"\n");
		sb.append("Sexo: "+getSexo()+"\n");
		sb.append("Ciudad de Nacimiento: "+getCiudad()+"\n");
		sb.append("Fecha de Nacimieto: "+date_format.format(getFecha())+"\n");
		sb.append("Nombre del Padre: "+getPadre().getNombre()+"\n");
		sb.append("Nombre de la Madre: "+getMadre().getNombre()+"\n");
		sb.append("----------\n");
		return sb.toString();
	}
	
	
	
}
