 	
package co.edu.unbosdque.controller;

import Util.Graph;
import co.edu.unbosdque.view.*;

public class AplMain {
    public static void main(String[] args) {
        Graph grafo = new Graph();
        GraphView vista = new GraphView();
        GraphController controlador = new GraphController(grafo, vista);

        controlador.manejarMenu();
    }
}