package sincronizacion;

public class CuentaBanco {

	private int saldo = 50;
	
	public void retirar(int monto) {
		saldo -= monto;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
}
