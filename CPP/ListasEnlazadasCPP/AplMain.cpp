#include <iostream>
#include "Node.cpp"
#include "MyLinkedList.cpp"
#include "GummyBrandDAO.cpp"
#include "GummyBrandDTO.cpp"
using namespace std;

int main(){

    MyLinkedList<int> fico;
    fico.add(18);
    fico.add(13);
    fico.add(11);
    fico.addLast(7);
    fico.addLast(69);
    fico.addLast(420);
    fico.addLast(8);

    cout << fico.toString() << endl;

    GummyBrandDAO listaDeMarcas;

    listaDeMarcas.agregar(GummyBrandDTO("Trululu", "Cocodrilo", 2.000));
    cout << listaDeMarcas.mostrar() << endl;
    
    return 0;
}