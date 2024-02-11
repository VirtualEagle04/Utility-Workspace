package co.edu.unbosque.model;

public class BicicletaDTO extends VehiculoDTO{
	
	private String tipo;
	
	public BicicletaDTO() {
		// TODO Auto-generated constructor stub
	}

	public BicicletaDTO(String tipo) {
		super();
		this.tipo = tipo;
	}

	public BicicletaDTO(int num_llantas, float peso, String medio, int cant_pasajeros, String nombre,
			String forma_potencia, String tipo) {
		super(num_llantas, peso, medio, cant_pasajeros, nombre, forma_potencia);
		this.tipo = tipo;
	}

	@Override
	public boolean estaEncendido() {
		return false;
	}

	@Override
	public void cargarEnergia() {
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}
	
	

	
	
}
