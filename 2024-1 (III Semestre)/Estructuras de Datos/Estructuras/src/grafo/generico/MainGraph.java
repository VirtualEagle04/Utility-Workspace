package grafo.generico;

import grafo.algoritmos.AbstractSearch;
import grafo.algoritmos.BreadthFirstSearch;
import grafo.algoritmos.DepthFirstSearch;

public class MainGraph {

	public static void doGraph1() {
		Graph g1 = new Graph();

		Vertex<City> bog = new Vertex<City>(new City("BOG", 90));
		Vertex<City> med = new Vertex<City>(new City("MED", 45));
		Vertex<City> cal = new Vertex<City>(new City("CAL", 13));
		Vertex<City> let = new Vertex<City>(new City("LET", 7));
		Vertex<City> buc = new Vertex<City>(new City("BUC", 8));

		bog.addEdge(new Edge(bog, med, 50));
		bog.addEdge(new Edge(bog, cal, 50));
		buc.addEdge(new Edge(buc, med, 50));
		cal.addEdge(new Edge(cal, let, 50));

		g1.addVertex(bog);
		g1.addVertex(med);
		g1.addVertex(cal);
		g1.addVertex(let);
		g1.addVertex(buc);

		System.out.println(g1);

		AbstractSearch dfs = new DepthFirstSearch(bog, let);
		if (!dfs.runSearch()) {
			System.out.println("ruta no encontrada");
		}

	}

	public static void doGraph2() {
		Graph g1 = new Graph();

		Vertex<City> bog = new Vertex<City>(new City("BOG", 90));
		Vertex<City> med = new Vertex<City>(new City("MED", 45));
		Vertex<City> cal = new Vertex<City>(new City("CAL", 13));
		Vertex<City> let = new Vertex<City>(new City("LET", 7));
		Vertex<City> buc = new Vertex<City>(new City("BUC", 8));

		bog.addEdge(new Edge(bog, med, 50));
		bog.addEdge(new Edge(bog, cal, 50));
		buc.addEdge(new Edge(buc, med, 50));
		cal.addEdge(new Edge(cal, let, 50));

		g1.addVertex(bog);
		g1.addVertex(med);
		g1.addVertex(cal);
		g1.addVertex(let);
		g1.addVertex(buc);

		System.out.println(g1);

		AbstractSearch dfs = new DepthFirstSearch(bog, buc);
		if (!dfs.runSearch()) {
			System.out.println("ruta no encontrada\n");
		}

	}

	public static void doGraph3() {
		Graph g1 = new Graph();

		Vertex<City> bog = new Vertex<City>(new City("BOG", 90));
		Vertex<City> med = new Vertex<City>(new City("MED", 45));
		Vertex<City> cal = new Vertex<City>(new City("CAL", 13));
		Vertex<City> let = new Vertex<City>(new City("LET", 7));
		Vertex<City> buc = new Vertex<City>(new City("BUC", 8));

		bog.addEdge(new Edge(bog, med, 50));
		bog.addEdge(new Edge(bog, cal, 50));
		buc.addEdge(new Edge(buc, med, 50));
		cal.addEdge(new Edge(cal, let, 50));

		g1.addVertex(bog);
		g1.addVertex(med);
		g1.addVertex(cal);
		g1.addVertex(let);
		g1.addVertex(buc);

		System.out.println(g1);

		AbstractSearch bfs = new BreadthFirstSearch(bog, let);
		if (!bfs.runSearch()) {
			System.out.println("ruta no encontrada\n");
		}
	}
	
	public static void doBF() {
		Graph grafo = new Graph();
		
		Vertex<String> pNorte = new Vertex<String>("P. Norte");
		Vertex<String> pSur= new Vertex<String>("P. Sur");
		Vertex<String> heroes = new Vertex<String>("Heroes");
		Vertex<String> pDorado = new Vertex<String>("P. Dorado");
		Vertex<String> suba = new Vertex<String>("Suba");
		Vertex<String> cll76 = new Vertex<String>("Cll. 76");
		Vertex<String> cll80 = new Vertex<String>("Cll. 80");
		Vertex<String> sMateo = new Vertex<String>("S. Mateo");
		
		pNorte.addEdge(new Edge(pNorte, pSur, 8));
		pNorte.addEdge(new Edge(pNorte, heroes, 2));
		pNorte.addEdge(new Edge(pNorte, suba, 10));
		
		pSur.addEdge(new Edge(pSur, pDorado, 3));
		
		heroes.addEdge(new Edge(heroes, cll76, 1));
		
		pDorado.addEdge(new Edge(pDorado, sMateo, 5));
		
		suba.addEdge(new Edge(suba, cll80, 3));
		
		cll76.addEdge(new Edge(cll76, suba, 5));
		cll76.addEdge(new Edge(cll76, pDorado, 4));
		
		cll80.addEdge(new Edge(cll80, sMateo, 2));
		
		grafo.addVertex(pNorte);
		grafo.addVertex(pSur);
		grafo.addVertex(heroes);
		grafo.addVertex(pDorado);
		grafo.addVertex(suba);
		grafo.addVertex(cll76);
		grafo.addVertex(cll80);
		grafo.addVertex(sMateo);
		
		System.out.println(grafo);
	}

	public static void main(String[] args) {
		doBF();

	}

}
