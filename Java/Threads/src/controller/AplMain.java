package controller;

public class AplMain {

	public static void main(String[] args) {
		
		ThreadHeredado th = new ThreadHeredado();
//		th.start();

		Thread ti = new Thread(new ThreadInterface());
//		ti.start();
		
		ClaseThread primerThread = new ClaseThread("CT_1");
		ClaseThread segundoThread = new ClaseThread("CT_2");
//		primerThread.start();
//		segundoThread.start();
		
		ClaseRunnable primerRunnable = new ClaseRunnable("CR_1");
		ClaseRunnable segundoRunnable = new ClaseRunnable("CR_2");
		Thread aux1 = new Thread(primerRunnable);
//		aux1.start();
		Thread aux2 = new Thread(segundoRunnable);
//		aux2.start();
		
//		new ClaseThread("CT_3").start();
//		new ClaseThread("CT_4").start();
		
		PingPong pp1 = new PingPong(1000); // 1000 milsec = 1s
		pp1.start();
		PingPong pp2 = new PingPong(1000); // 1000 milsec = 1s
//		pp2.start();
		pp1.setPriority(Thread.MAX_PRIORITY);
//		pp2.setPriority(Thread.MIN_PRIORITY);
//		pp1.interrupt(); Si el thread esta en sleep() o wait() la funcion interrupt() hace que tire la excepcion InterruptedException
		
		System.err.println("Termina Thread: " + Thread.currentThread().getName());
	}
	
	
}
