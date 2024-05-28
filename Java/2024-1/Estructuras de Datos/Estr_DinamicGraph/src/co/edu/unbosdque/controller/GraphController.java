package co.edu.unbosdque.controller;

import Util.*;
import co.edu.unbosdque.view.*;
import java.util.Scanner;

public class GraphController {
    private Graph grafo;
    private GraphView vista;

    public GraphController(Graph grafo, GraphView vista) {
        this.grafo = grafo;
        this.vista = vista;
    }

    public void manejarMenu() {
        boolean continuar = true;

        while (continuar) {
            vista.mostrarMenu();
            int opcion = Integer.parseInt(vista.leerEntrada());

            switch (opcion) {
                case 1:
                    vista.mostrarMensaje("Ingrese el vértice: ");
                    String vertice = vista.leerEntrada();
                    grafo.addVertex(new Vertex<String>(vertice));
                    break;
                case 2:
                    vista.mostrarMensaje("Origen: ");
                    String origen = vista.leerEntrada();
                    vista.mostrarMensaje("Destino: ");
                    String destino = vista.leerEntrada();
                    vista.mostrarMensaje("Valor/Peso: ");
                    double peso = Double.parseDouble(vista.leerEntrada());

                    Vertex<?> sourceVertex = null;
                    Vertex<?> destinationVertex = null;

                    for (Vertex<?> vertex : grafo.getListOfNodes()) {
                        if (vertex.getInfo().equals(origen)) {
                            sourceVertex = vertex;
                        }
                        if (vertex.getInfo().equals(destino)) {
                            destinationVertex = vertex;
                        }
                    }

                    if (sourceVertex != null && destinationVertex != null) {
                        sourceVertex.addEdge(new Edge(sourceVertex, destinationVertex, peso));
                        destinationVertex.addEdge(new Edge(destinationVertex, sourceVertex, peso));
                    } else {
                        vista.mostrarMensaje("Error: Los vértices de la arista no fueron encontrados.");
                    }
                    break;
                case 3:
                    vista.mostrarGrafo(grafo.toString());
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
    }
}