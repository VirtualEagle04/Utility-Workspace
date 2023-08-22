#include <iostream>
using namespace std;

class GummyBrandDTO{

    private:
        string marca;
        string presentacion;
        double precio;

    public:
        GummyBrandDTO(){}

        GummyBrandDTO(string marca, string presentacion, double precio) : marca(marca), presentacion(presentacion), precio(precio) {}

        void setMarca(string marca){
            this->marca = marca;
        }

        string getMarca(){
            return marca;
        }

        void setPresentacion(string presentacion){
            this->presentacion = presentacion;
        }

        string getPresentacion(){
            return presentacion;
        }

        void setPrecio(double precio){
            this->precio = precio;
        }

        double getPrecio(){
            return precio;
        }

        string toString(){
            return "GummyBrandDTO(" + marca + ", " + presentacion +", " + to_string(precio) + ")";
        }

};
