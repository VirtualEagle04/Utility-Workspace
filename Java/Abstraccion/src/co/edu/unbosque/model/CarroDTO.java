package co.edu.unbosque.model;

public class CarroDTO extends VehiculoDTO{
	
	private String marca;

	@Override
	public boolean estaEncendido() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cargarEnergia() {
		// TODO Auto-generated method stub
		
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	
	
}
