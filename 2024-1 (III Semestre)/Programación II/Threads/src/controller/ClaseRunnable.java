package controller;

public class ClaseRunnable implements Runnable{
	
	private String desc;
	
	public ClaseRunnable(String desc) {
		this.desc = desc;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			System.out.println(desc + ": Este es el " + Thread.currentThread().getName());
		}
		
		System.err.println("Thread Ended: " + Thread.currentThread().getName());
		
	}

	
	
}
