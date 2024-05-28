package Arboles;

public class Nodo {
int dato;

Nodo izq;
Nodo der;
Nodo Padre;

public Nodo(int dato) {
	this.dato=dato;
	izq=null;
	der=null;
	Padre=null;
}

public Nodo(int dato, Nodo padre) {
	this.dato=dato;
	izq=null;
	der=null;
	this.Padre=padre;
}
	}
