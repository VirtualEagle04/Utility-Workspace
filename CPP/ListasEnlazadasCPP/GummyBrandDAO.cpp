#include "GummyBrandDTO.cpp"
#include "MyLinkedList.cpp"
using namespace std;

class GummyBrandDAO{

    private:
        MyLinkedList<GummyBrandDTO> lista;

    public:
        GummyBrandDAO() {}

        MyLinkedList<GummyBrandDTO> getLista(){
            return lista;
        }

        void setLista(MyLinkedList<GummyBrandDTO> lista){
            this->lista = lista;
        }

        void agregar(GummyBrandDTO brand){
            lista.add(brand);
        }

        void eliminar(int index) {
            lista.extract(lista.get(index));
        }

        void actualizar(int index, GummyBrandDTO brand){
            lista.get(index)->setData(brand);
        }

        string mostrar(){
            return lista.toString();
        }
};