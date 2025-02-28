#ifndef GUMMYBRANDDTO
#define GUMMYBRANDDTO

#include<iostream>

#include<sstream>

using namespace std;

class GummyBrandDTO
{
    private:
        string brand;
        string presentation;
        double price;
    public:
        GummyBrandDTO() {}

        GummyBrandDTO(string brand, string presentation, double price){
            this->brand = brand;
            this->presentation = presentation;
            this->price = price;
        }

        
        string getBrand(){
            return brand;
        }

        void setBrand(string brand){
            this->brand = brand;
        }

        string getPresentation(){
            return presentation;
        }

        void setPresentation(string presentation){
            this->presentation = presentation;
        }
        
        double getPrice(){
            return price;
        }
        
        void setPrice(double price){
            this->price = price;
        }
        
        string toString(){
            stringstream output;
            output<<price;
            return "(" + brand + ", " + presentation + ", " + output.str() + ")";
        }


};

#endif