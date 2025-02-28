#ifndef NODE_H
#define NODE_H

template <typename E>

class Node {
    private:
        E data;
        Node<E>* next;

    public:
        Node() {}
        
        Node(E data, Node<E>* next){
            this->data = data;
            this->next = next;
        }
        
        Node(E data){
            this->data = data;
            this->next=nullptr;
        }

        E getData(){
            return data;
        }

        void setData(E data) {
            this->data = data;
        }

        Node<E>* getNext(){
            return next;
        }

        void setNext(Node<E>* next) {
            this->next = next;
        }

};

#endif