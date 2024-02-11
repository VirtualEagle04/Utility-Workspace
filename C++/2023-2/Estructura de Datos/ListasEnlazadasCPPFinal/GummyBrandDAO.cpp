#ifndef GUMMYBRANDDAO
#define GUMMYBRANDDAO

#include<iostream>

#include<sstream> //Para algo parecido a StringBuilder

#include "MyLinkedList.cpp"
#include "GummyBrandDTO.cpp"

using namespace std;

class GummyBrandDAO
{
    private:

        MyLinkedList<GummyBrandDTO> brands;

    public:
        GummyBrandDAO(){}

        void create(GummyBrandDTO newBrand){
            brands.addLast(newBrand);
        }

        void remove(int index){
            brands.remove(index);
        }

        void update(int index, GummyBrandDTO newBrand){
            brands.set(index, newBrand);
        }

        string display(){
            stringstream sb;
            string output = "Gummy Brand: \n";
            
            for(int i = 0; i < brands.size(); i++){
                output += ("-" + sb.str() + brands.get(i)->getData().toString());
                if(i+1 != brands.size()) output += "\n";
                sb.str("");
            }
            
            return output;
        }

};

#endif