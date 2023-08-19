import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cliente extends Conexion{
	
	private Scanner sc;

	public Cliente() {
		super("cliente");
		sc = new Scanner(System.in);
	}
	
	public void startClient() {
		try {
			salidaServidor = new DataOutputStream(ss.getOutputStream());
			
//			BufferedReader entrada = new BufferedReader(new InputStreamReader(ss.getInputStream()));
			//Lectura de servidor
			BufferedReader entrada = new BufferedReader(new InputStreamReader(ss.getInputStream()));

			while ((mensajeServidor = entrada.readLine()) != null) {
				while(!mensajeServidor.equals("exit")) {
					System.out.println(mensajeServidor);
				}
			}
			
			//Cierre de Socket
			cs.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
