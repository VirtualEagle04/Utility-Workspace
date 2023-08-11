package co.edu.unbosque.model;

import java.util.Date;
/**
 * Clase que representa los Padres, heredando atributos de todos los Ciudadanos
 * @author Federico Vargas Rozo
 *
 */
public class PadreDTO extends CiudadanoDTO{
	
	public PadreDTO() {
		// TODO Auto-generated constructor stub
	}

	public PadreDTO(String nombre, String sexo, String ciudad, Date fecha) {
		super(nombre, sexo, ciudad, fecha);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
