#ifndef MYLINKEDLIST_H
#define MYLINKEDLIST_H

#include "Node.cpp"

using namespace std;

template<class E>
class MyLinkedList {

    private:
        Node<E>* first; 

    public:
        MyLinkedList() {
           this->first = nullptr; 
        }

        Node<E>* getFirst() {
            return this->first;
        }

        void add(E data){
            Node<E>* newNode = new Node<E>(data, first);
            this->first = newNode;
        }

        Node<E>* getLast() {
            Node<E>* current = this->first;
            while (!isEmpty() && current->getNext() != nullptr) {
                current = current->getNext();
            }
            return current;
        }

        void addLast(E data) {
            Node<E>* newNode= new Node<E>(data); 
            if (isEmpty()) {
                this->first = newNode;
            } else {
                getLast()->setNext(newNode);
            }
        }

        Node<E>* get(int index){
            Node<E>* current = this->first;
            int count=0;
            if(index<0 || index>=size()) throw "Index doesnt exists";
            while (!isEmpty() && count<index) {
                current = current->getNext();
                count++;
            }
            return current;

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

        void remove(int index){
            if(index<0 || index>=size())throw "Index doesnt exists";
            if(index==0){
                if(this->first->getNext()!=nullptr) this->first = this->first->getNext();
                else this->first = nullptr;
            }
            else{
                get(index-1)->setNext(get(index)->getNext());
            }
        }
        
        E extract(){
            E data = nullptr;
            if(this->first != nullptr){
                data = this->first->getData();
                first = this->first->getNext();
            }
            return data;
        }

        E extract(Node<E>* prev){
            E data = nullptr;
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

        void set(int index, E data){
            if(index<0 || index>=size())throw "Index doesnt exists";
            Node<E>* newNode= new Node<E>(data,get(index)->getNext());
            if(index==0)this->first=newNode;
            else get(index-1)->setNext(newNode);
        }

        bool isEmpty(){
            if(this->first == nullptr){
                return true;
            }
            else{
                return false;
            }
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

};

#endif