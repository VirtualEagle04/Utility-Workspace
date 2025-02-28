import java.math.BigInteger;

public class AplMain {

	public static int resRecursivo;
	public static int resCiclico;

	public static void main(String[] args) {

//		contarVocales("Hola, Mundo!");
//		contarVocales("Hola, Mundo!", 0, 0);
//		System.out.println(resRecursivo);

//		System.out.println(calcularFactorial(BigInteger.valueOf(13000)));
//		
//		masCercano(1000, 300, true, 0);
//		masCercano(1000, 300, false, 0);
//		
//		System.out.println(contAscendente);
//		System.out.println(contDescendente);
		
//		for(int i = 0; i <= 13; i++) {
//			System.out.println("Numero de Fibonacci " + i + ": " +calcularFibonacci(i) );
//		}
		
//		for(int i = 0; i <= 20; i++) {
//			System.out.println("Numero de Tribonacci " + i + ": " +calcularTribonacci(i));
//		}
		
//		for(int i = 0; i <= 20; i++) {
//				System.out.println("Numero de Catalan " + i + ": " + calcularNumerosCatalan(i));
//		}
		System.out.println("Numero de Catalan " + 10 + ": " + calcularNumerosCatalan(10));
		System.out.println(calcularTribonacci(10));
		
	}
	
	public static BigInteger calcularNumerosCatalan(int n) {
		
		if(n== 0) {
			return BigInteger.ONE;
		}
		else {
			
			BigInteger arriba = calcularFactorial(BigInteger.valueOf(2*n));
			BigInteger abajo1 = calcularFactorial(BigInteger.valueOf(n));
			BigInteger abajo2 = calcularFactorial(BigInteger.valueOf(n+1));
			
			return arriba.divide(abajo1.multiply(abajo2));
		}
		
	}
	
	public static int calcularTribonacci(int n) {
		
		if(n == 0 || n == 1) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}
		else {
			return (calcularTribonacci(n-1) + calcularTribonacci(n-2) + calcularTribonacci(n-3));
		}
		
	}
	
	public static int calcularFibonacci(int n) {
		
		if(n == 0) {
			return 0;
		}
		if(n == 1 || n== 2) {
			return 1;
		}
		else {
			return (calcularFibonacci(n-1) + calcularFibonacci(n-2));
		}
		
	}

	public static long contAscendente;
	public static long contDescendente;

	public static void masCercano(long n, long pos,  boolean ascendente, long cont) {

		if (pos >= n) {
			contAscendente = cont;
			return;
		} else if (pos <= 0) {
			contDescendente = cont;
			return;
		}
		
		if(ascendente) {
			 cont++;
			masCercano(n, pos+1, true, cont);
			
		}else if(!ascendente){
			cont++;
			masCercano(n, pos-1, false, cont);
			
		}

	}

	public static BigInteger calcularFactorial(BigInteger n) {

		if (n.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		} else {
			return n.multiply(calcularFactorial(n.subtract(BigInteger.ONE)));
		}

	}

	public static void contarVocales(String txt, int cont, int pos) {
		/**
		 * Divide y Conquista: Solucionar pequeños problemas
		 */

		if (pos == txt.length()) {
			resRecursivo = cont;
			return;
		} else {
			switch (txt.charAt(pos)) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u': {
				cont++;
			}
			}
			contarVocales(txt, cont, pos + 1);

		}

	}

	public static void contarVocales(String txt) {
		int cont = 0;

		for (int i = 0; i < txt.length(); i++) {

			switch (txt.charAt(i)) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u': {
				cont++;
			}
			}
		}

		resCiclico = cont;
		System.out.println(resCiclico);
	}

}
