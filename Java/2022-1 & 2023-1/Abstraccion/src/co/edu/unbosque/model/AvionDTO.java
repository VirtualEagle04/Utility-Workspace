package co.edu.unbosque.model;

public class AvionDTO extends VehiculoDTO{
	
	private String aerolinea;

	@Override
	public boolean estaEncendido() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cargarEnergia() {
		// TODO Auto-generated method stub
		
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	
	
}
