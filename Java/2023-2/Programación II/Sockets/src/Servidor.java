import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Servidor extends Conexion {
	
	private Scanner sc; 

	public Servidor() {
		super("servidor");
		sc = new Scanner(System.in);
	}

	public void startServer() {
		// Espera hasta que un cliente solicite la conexion
		System.err.println("Esperando...");

		try {
			// Acepta la solicitud del cliente
			cs = ss.accept();
			System.err.println("Cliente en linea! "+ cs.getInetAddress() + ":"+cs.getPort());

			// Creando objeto de serializados
			salidaCliente = new DataOutputStream(cs.getOutputStream());

			salidaCliente.writeUTF("Peticion recibida y aceptada!");

			//Lectura de cliente
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

			while ((mensajeServidor = entrada.readLine()) != null) {
				while(!mensajeServidor.equals("close server")) {
					System.out.println(mensajeServidor);
				}
			}
			System.err.println("<-Fin de la conexion->");

			// Cierre de Socket
			ss.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
