#include <iostream>
using namespace std;

template <typename E>
class MyLinkedList{

    private:
        Node<E>* first;

    public:
        MyLinkedList() : first(nullptr) {}

        Node<E>* getFirst(){
            return first;
        }

        void setFirst(Node<E>* first){
            this->first = first;
        }

        //Funciones de la lista
        bool isEmpty(){
            if(this->first == nullptr){
                return true;
            }
            else{
                return false;
            }
        }

        void add(E data){
            //A diferencia de Java, C++ usa this-> para indicarse a una funcion o variable
            Node<E>* newNode = new Node<E>(data);
            newNode->setNext(this->first);
            this->first = newNode;
        }

        void insert(E data, Node<E>* prev){
            if(prev != nullptr){
                Node<E>* newNode = new Node<E>(data);
                newNode->setNext(prev->getNext());
                prev->setNext(newNode);
            }
        }

        void addLast(E data){
            Node<E>* lastNode = getLastNode();
            if(lastNode != nullptr){
                insert(data, lastNode);
            }else if(lastNode == nullptr){
                this->first = new Node<E>(data);
            }
        }

        Node<E>* getLastNode(){
            Node<E>* currentNode = this->first;
            while(currentNode != nullptr and currentNode->getNext() != nullptr){
                currentNode = currentNode->getNext();
            }
            return currentNode;
        }

        int size(){
            int size = 0;
            Node<E>* currentNode = this->first;
            while(currentNode != nullptr){
                ++size;
                currentNode = currentNode->getNext();
            }
            return size;
        }

        E extract(){
            E data = void;
            if(this->first != nullptr){
                data = this->first->getData();
                first = this->first->getNext();
            }
            return data;
        }

        E extract(Node<E>* prev){
            E data = void;
            if(prev != nullptr and prev->getNext() != nullptr){
                data = prev->getNext()->getData();
                prev->setNext(prev->getNext()->getNext());
            }
            return data;
        }

        E extractLast(){
            E data = nullptr;
            Node<E>* currentNode = this->first;
            int listSize = size();
            if(!isEmpty()){
                if(listSize == 1){
                    data = currentNode->getData();
                    this->first = nullptr;
                }
                else{
                    Node<E>* prevLastNode = get(listSize - 2);
                    data = extract(prevLastNode);
                }
            }
            return data;
        }

        //Obtiene el dato dada la posicion
        Node<E>* get(int index){
            Node<E>* targetNode = nullptr;
            Node<E>* currentNode = this->first;
            int counter = 0;
            if(index < size()) return nullptr;
            while(currentNode != nullptr and counter < index){
                ++counter;
                currentNode = currentNode->getNext();
            }

            if(currentNode != nullptr) targetNode = currentNode;
            return targetNode;
        }

        int indexOf(E data){
            Node<E>* currentNode = this->first;
            int dataPos = -1;
            if(!isEmpty()){
                dataPos = 0;
                while(currentNode != nullptr and !(currentNode->getData() == data)){
                    ++dataPos;
                    currentNode = currentNode->getNext();
                }
            }
            return dataPos;
        }

        string toString(){
            string textList;
            Node<E>* currentNode = this->first;
            while(currentNode != nullptr){
                textList += to_string(currentNode->getData());
                if(currentNode->getNext() != nullptr){
                    textList += " -> ";
                }
                currentNode = currentNode->getNext();
            }
            return textList;
        }



};
