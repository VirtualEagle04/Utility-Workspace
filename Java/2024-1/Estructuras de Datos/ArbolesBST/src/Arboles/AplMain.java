package Arboles;

public class AplMain {
	  public static void main(String[] args) {
		  Arbol BST =new Arbol();
		  BST.insertar(34);
		  BST.insertar(21);
		  BST.insertar(56);
		  
		  System.out.println(BST.Buscar(34));
		  
		  BST.imprimirArbol();
	  }
}
