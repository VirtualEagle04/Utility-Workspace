package co.edu.unbosdque.view;
import java.util.Scanner;

public class GraphView {
    private Scanner scanner;

    public GraphView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("1. Agregar vértice");
        System.out.println("2. Agregar arista");
        System.out.println("3. Ver grafo");
        System.out.println("4. Salir");
        System.out.print("Ingrese su opción: ");
    }

    public void mostrarGrafo(String grafo) {
        System.out.println("Grafo:");
        System.out.println(grafo);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerEntrada() {
        return scanner.nextLine();
    }
}
