package controller;

public class ThreadInterface implements Runnable{
	
	/**
	 * Los clases implementadas por medio de la interfaz Runnable
	 * dependen de la clase Thread para iniciar.
	 */

	@Override
	public void run() {

		System.out.println("Esto es una clase que implementa de java.lang.Runnable");
		
	}
	
}
