package sincronizacion;

public class PeligroCuenta implements Runnable{
	
	private CuentaBanco cuenta = new CuentaBanco();
	
	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			realizarRetiro();
			if(cuenta.getSaldo() < 0) {
				System.out.println(Thread.currentThread().getName() + " debe: " + cuenta.getSaldo());
			}
		}
		
	}
	
	//Sincronizado (keyword synchronized)
	public synchronized void realizarRetiro() {
		if(cuenta.getSaldo() >= 10) {
			System.out.println(Thread.currentThread().getName() + " tiene: " + cuenta.getSaldo() + ". Va a retirar 10.");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			cuenta.retirar(10);
			System.out.println("** " + Thread.currentThread().getName() + " ha retirado 10. Nuevo saldo: " + cuenta.getSaldo());
			
		}
		else {
			System.out.println(Thread.currentThread().getName() + " no tiene saldo.");
		}
		
	}
	
	//No Sincronizado
	/*
	public void realizarRetiro() {
		if(cuenta.getSaldo() >= 10) {
			System.out.println(Thread.currentThread().getName() + " tiene: " + cuenta.getSaldo() + ". Va a retirar 10.");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			cuenta.retirar(10);
			System.out.println("** " + Thread.currentThread().getName() + " ha retirado 10. Nuevo saldo: " + cuenta.getSaldo());
			
		}
		else {
			System.out.println(Thread.currentThread().getName() + " no tiene saldo.");
		}
		
	}
	*/
	

}
