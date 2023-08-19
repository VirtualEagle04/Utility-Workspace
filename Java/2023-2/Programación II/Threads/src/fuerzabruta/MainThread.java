package fuerzabruta;

public class MainThread extends Thread{
	
	@Override
	public void run() {
		
		Cuenta c = new Cuenta();
		Thread tdescendente = new Thread(new HiloDescendente(c.getClave(),"Descendente"));
		HiloAscendente tascendente = new HiloAscendente(c.getClave(),"Ascendente");
		tascendente.start();
		tdescendente.start();
		
		try {
			tascendente.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
