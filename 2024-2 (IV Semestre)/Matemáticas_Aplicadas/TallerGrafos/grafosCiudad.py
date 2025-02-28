import networkx as nx
import matplotlib.pyplot as plt

L = []
E = []
G = nx.Graph()

def crear_ciudad():
    print("CREAR CIUDAD".center(20, '-'))
    while True:
        ciudad = input("Ingrese el nombre de una ciudad: ")
        G.add_node(ciudad)
        L.append(ciudad)
        res = input("Desea crear otra ciudad? (s/n): ")
        if res == 's':
            crear_ciudad()
            break
        elif res == 'n':
            return

def crear_conexion():
    print("CREAR CONEXIÓN".center(20, '-'))
    while True:
        print("CIUDADES".center(5, '-'))
        for i in range(0, len(L)):
            print(f"[{i}] {L[i]}")
        ciudad_o = int(input("Ingrese el indice de la Ciudad Origen: "))
        ciudad_d = int(input("Ingrese el indice de la Ciudad Destíno: "))
        dist = int(input("Ingrese la distancia en Km entre las Ciudades: "))

        G.add_edge(L[ciudad_o], L[ciudad_d], w = dist)
        E.append((ciudad_o, ciudad_d))

        res = input("Desea crear otra Conexión? (s/n): ")
        if res == 's':
            crear_conexion()
            break
        elif res == 'n':
            return

def ver_grafo():
    pos = nx.spring_layout(G)
    nx.draw_networkx_nodes(G, pos, node_size=600)
    nx.draw_networkx_labels(G, pos, font_size=10)

    nx.draw_networkx_edges(G, pos, width=1)

    edge_labels = nx.get_edge_attributes(G, "w")

    nx.draw_networkx_edge_labels(G, pos, edge_labels)
    plt.show()


while True:
    print("MENU".center(20, '-'))
    print("[1] Crear Ciudad")
    print("[2] Crear Conexión")
    print("[3] Ver Grafo")

    op = int(input("Ingrese una opción: "))

    if op == 1:
        crear_ciudad()
    elif op == 2:
        crear_conexion()
    elif op == 3:
        ver_grafo()

print("xd")