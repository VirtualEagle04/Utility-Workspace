package controller;

public class ClaseThread extends Thread{

	private String desc;
	
	public ClaseThread(String desc) {
		this.desc = desc;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			System.out.println(desc + ": Este es el " + getName());
		}
		
		System.err.println("Thread Ended: " + getName());
		
	}
	
}
