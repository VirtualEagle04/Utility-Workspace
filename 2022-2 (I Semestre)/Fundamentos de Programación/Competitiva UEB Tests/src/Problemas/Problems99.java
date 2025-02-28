package Problemas;
import java.util.Scanner;

public class Problems99 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int hacia_arriba = N;
		int hacia_abajo = N;
		while(true) {
			
			if (hacia_arriba % 100 == 99) {
				System.out.println(hacia_arriba); 
				break;
			}if (hacia_abajo % 100 == 99){
				System.out.println(hacia_abajo);
				break;
			}
			hacia_arriba++;
			hacia_abajo--;
			
			
			
		}
		
	}
}
