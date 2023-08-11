package sincronizacion;

public class MainSincronizacion {
	
	public static void main(String[] args) {
		
		/**
		 * Un hilo debe obtener un bloqueo antes de utilizar un recurso compartido.
		 * Si un hilo ya tiene tal bloqueo, el JVM no permitira que otro hilo acceda
		 * a este recurso.
		 * 
		 * Si un hilo está intetando acceder al recurso compartido al mismo tiempo,
		 * es bloqueado por JVM y tiene que esperar hasta que el recurso esté disponible.
		 * 
		 * Solo se pueden sincronizar metodos/funciones/bloques. Las variables y clases
		 * no pueden sincronizarse.
		 * 
		 * Solo se asocia un bloqueo a cada objeto o recurso compartido.
		 */
		
		
		PeligroCuenta pc = new PeligroCuenta();
		Thread one = new Thread(pc);
		Thread two = new Thread(pc);
		one.setName("Juan");
		two.setName("Paula");
		one.start();
		two.start();
		
	}
	
}
