#include <iostream>
using namespace std;

template <typename E>

class Node{
    
    public:
        E data;
        Node<E>* next;
    
    public:
        //No se usa this.first = null;
        //Como es un puntero a un Objecto Node, toca ponerle null-pointer (nullptr)
        Node() : next(nullptr) {}

        Node(E data) : data(data), next(nullptr) {}
    
        Node(E data, Node<E>* next) : data(data), next(next) {}

        E getData(){
            return data;
        }

        void setData(E data){
            this->data = data;
        }

        Node<E>* getNext(){
            return next;
        }

        void setNext(Node<E>* next){
            this->next = next;
        }

        string toString(){
            //No se puede concatenar integers con cadenas, toca usar:
            //to_string(data);
           return "Node(data: " + to_string(data) + ")";
        }
};