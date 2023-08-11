package co.edu.unbosque.model;

import java.util.ArrayList;

public class AsteroideDAO {

    private ArrayList<AsteroideDTO> a_lista;

    public AsteroideDAO(){
        a_lista = new ArrayList<AsteroideDTO>();
    }

    public ArrayList<AsteroideDTO> getA_lista() {
        return a_lista;
    }

    public void setA_lista(ArrayList<AsteroideDTO> a_lista) {
        this.a_lista = a_lista;
    }

    //Funciones crudas (CRUD)

    public void aCrear(String nombre, float velocidad, float tamano, String material, boolean contiene_minerales){
        a_lista.add(new AsteroideDTO(nombre, velocidad, tamano, material, contiene_minerales));
    }

    public boolean aEliminarPorNombre(String a_nombre_eliminar){
        try {
			for (int i = 0; i < a_lista.size(); i++){
				if (a_lista.get(i).getNombre().equalsIgnoreCase(a_nombre_eliminar)){
					a_lista.remove(a_lista.get(i));
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
    }

    public boolean aEliminarPorIndex(int a_index){
        try {
			a_lista.remove(a_index);
			return true;
		} catch (Exception e) {
			return false;
		}
    }

    public String aMostrarTodo(){
        StringBuilder sb = new StringBuilder();
        for (AsteroideDTO a : a_lista){
            sb.append(a.getNombre().toString()+"");
        }
        return sb.toString();
    }

    public boolean aActualizarPorNombre(String a_nombre_viejo, String nombre_nuevo, float velocidad, float tamano, String material, boolean contiene_minerales){
        try {
			for (int i = 0; i < a_lista.size(); i++) {
				if (a_lista.get(i).getNombre().equals(a_nombre_viejo)) {
					a_lista.get(i).setNombre(nombre_nuevo);
                    a_lista.get(i).setVelocidad(velocidad);
                    a_lista.get(i).setTamano(tamano);
                    a_lista.get(i).setMaterial(material);
                    a_lista.get(i).setContiene_minerales(contiene_minerales);


					return true;
				}
			}

		} catch (Exception e) {
			return false;
		}
		return false;
    }

    public int devolverIndiceNombre(String nombre_viejo){
		try{
			for (int i = 0; i < a_lista.size(); i++){
				if(a_lista.get(i).getNombre().equalsIgnoreCase(nombre_viejo)){
					return i;
				}
			}
		} catch (Exception e){
			return 1000;
		}
		return 1000;
	}

    public boolean aActualizarPorIndex(int a_index, String nombre_nuevo, float velocidad, float tamano, String material, boolean contiene_minerales){
        try {
            a_lista.get(a_index).setNombre(nombre_nuevo);
            a_lista.get(a_index).setVelocidad(velocidad);
            a_lista.get(a_index).setTamano(tamano);
            a_lista.get(a_index).setMaterial(material);
            a_lista.get(a_index).setContiene_minerales(contiene_minerales);
			
			return true;

		} catch (Exception e) {
			return false;
		}
    }
   

    

}
