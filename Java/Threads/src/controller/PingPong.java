package controller;

public class PingPong extends Thread{
	
	//Sleeping Threads
	
	private String ping = "Ping!", pong = "Pong!";
	private int sleepTime;
	
	public PingPong(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			System.out.println(ping);
			try { sleep(sleepTime); } catch (InterruptedException e) {}
			System.out.println(pong);
			System.out.println("---------");
			try { sleep(sleepTime); } catch (InterruptedException e) {}
		}
		
		System.err.println("Thread Ended: " + getName());
		
	}

}
