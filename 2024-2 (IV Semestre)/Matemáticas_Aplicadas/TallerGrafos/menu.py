#///////////////////////////////////////////////////////////////////////////////
#//
#//	  Autores     : Jaime Alonso y Federico Vargas
#//	  Fecha       : Ago 29, 2024
#//	  Descripción : Este programa muestra el desarrollo de la práctica 2
#//                 para la asignatura Matemáticas Aplicadas
#//
#//////////////////////////////////////////////////////////////////////////////
import networkx as nx
import matplotlib.pyplot as plt

def punto_01():
	"Descripción del problema"

	# Crear un grafo dirigido
	grafoDir = nx.DiGraph()

	# Añadir nodos
	grafoDir.add_nodes_from([1, 2, 3, 4])

	# Añadir aristas con dirección
	grafoDir.add_edges_from([(1, 2), (2, 3), (3, 4), (4, 1)])

	# Dibujar el grafo
	nx.draw(grafoDir, with_labels=True, node_color='lightblue', edge_color='gray', node_size=500)
	plt.show()

	# Crear un grafo no dirigido
	G_u = nx.Graph()

	# Añadir nodos
	G_u.add_nodes_from([1, 2, 3, 4])

	# Añadir aristas sin dirección
	G_u.add_edges_from([(1, 2), (2, 3), (3, 4), (4, 1)])

	# Dibujar el grafo
	nx.draw(G_u, with_labels=True, node_color='lightgreen', edge_color='black', node_size=500)
	plt.show()


def punto_02():
	print("Grado de un Nodo: En un grafo, el grado de un nodo es el número de aristas que están conectadas a ese nodo.")

	print("Centralidad de Grado: Es una medida que indica la importancia de un nodo en un grafo basándose en su grado.")


def punto_03():
	"Descripción del problema"

	# Crear un grafo dirigido
	grafoDir = nx.DiGraph()

	# Añadir nodos
	grafoDir.add_nodes_from([1, 2, 3, 4])

	# Añadir aristas con dirección
	grafoDir.add_edges_from([(1, 2), (2, 3), (3, 4), (4, 1)])

	# Mostrar la centralidad de grado de cada nodo
	print(f"La centralidad de grado de cada nodo del grafo dirigido es: {nx.degree_centrality(grafoDir)}")

	# Dibujar el grafo
	nx.draw(grafoDir, with_labels=True, node_color='lightblue', edge_color='gray', node_size=500)
	plt.show()

	# Crear un grafo no dirigido
	grafoNoDir = nx.Graph()

	# Añadir nodos
	grafoNoDir.add_nodes_from([1, 2, 3, 4])

	# Añadir aristas sin dirección
	grafoNoDir.add_edges_from([(1, 2), (2, 3), (3, 4), (4, 1)])

	# Mostrar la centralidad de grado de cada nodo
	print(f"La centralidad de grado de cada nodo del grafo no dirigido es: {nx.degree_centrality(grafoNoDir)}")

	# Dibujar el grafo
	nx.draw(grafoNoDir, with_labels=True, node_color='lightgreen', edge_color='black', node_size=500)
	plt.show()

	

def punto_04():
	"Descripción del problema"


		# Crear un grafo no dirigido
	grafoNoDir = nx.Graph()

	# Añadir nodos
	grafoNoDir.add_nodes_from([1, 2, 3, 4])

	# Añadir aristas sin dirección
	grafoNoDir.add_weighted_edges_from([(1, 2, 4), (2, 3, 5), (3, 4, 6), (4, 1, 7)])

	pos = nx.spring_layout(grafoNoDir, seed=4)

	# Dibujar el grafo
	nx.draw_networkx_nodes(grafoNoDir, pos, node_size=500)

	nx.draw_networkx_edges(grafoNoDir, pos, width = 3)

	nx.draw_networkx_labels(grafoNoDir, pos, font_size = 10)

	edge_labels = nx.get_edge_attributes(grafoNoDir, "weight")

	nx.draw_networkx_edge_labels(grafoNoDir, pos, edge_labels)
	plt.show()

def punto_05():
	"Descripción del problema"

	g = nx.Graph()

	g.add_edge("A", "B", weight=5)
	g.add_edge("A", "D", weight=4)
	g.add_edge("A", "E", weight=7)

	g.add_edge("C", "B", weight=7)
	g.add_edge("C", "F", weight=9)
	g.add_edge("C", "I", weight=12)

	g.add_edge("D", "H", weight=3)
	g.add_edge("D", "I", weight=9)

	g.add_edge("E", "G", weight=5)

	g.add_edge("F", "G", weight=6)
	g.add_edge("F", "H", weight=8)

	g.add_edge("G", "H", weight=1)
	g.add_edge("G", "I", weight=5)
	g.add_edge("G", "K", weight=4)

	g.add_edge("H", "J", weight=7)

	g.add_edge("K", "I", weight=2)
	g.add_edge("K", "J", weight=9)

	pos = nx.spring_layout(g)

	nx.draw_networkx_nodes(g, pos, node_size=600)
	nx.draw_networkx_labels(g, pos, font_size=10)

	nx.draw_networkx_edges(g, pos, width=1)

	edge_labels = nx.get_edge_attributes(g, "weight")

	nx.draw_networkx_edge_labels(g, pos, edge_labels)

	caminoMasCorto = nx.dijkstra_path(g, "B", "K", weight = 'weight')

	print(f"El camino más corto de 'B' a 'K' usando el algoritmo Dijkstra es: {caminoMasCorto}")

	plt.show()



while True:
	print("    MENÚ PRINCIPAL ")
	print()
	print("1. Solución punto 1")
	print("2. Solución punto 2")
	print("3. Solución punto 3")
	print("4. Solución punto 4")
	print("5. Solución punto 5")
	print("6. Salir")
	print()
	opc = input("Seleccione una opción: ")

	if opc == "1":
		punto_01()
	elif opc == "2":
		punto_02()
	elif opc == "3":
		punto_03()
	elif opc == "4":
		punto_04()
	elif opc == "5":
		punto_05()
	elif opc == "6":
		break # Sale del menú

print("Gracias por usar este programa")
