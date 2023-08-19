package co.edu.unbosque.model;

import java.util.ArrayList;

public class AgujeroNegroDAO {

    private ArrayList<AgujeroNegroDTO> bh_lista;

    public AgujeroNegroDAO(){
        bh_lista = new ArrayList<AgujeroNegroDTO>();
    }

    public ArrayList<AgujeroNegroDTO> getBh_lista() {
        return bh_lista;
    }

    public void setBh_lista(ArrayList<AgujeroNegroDTO> bh_lista) {
        this.bh_lista = bh_lista;
    }

    //Funciones curdas (CRUD)

    public void bhCrear(String nombre, double masa, float momento_ang, float gravedad, double diametro){
        bh_lista.add(new AgujeroNegroDTO(nombre, masa, momento_ang, gravedad, diametro));
    }

    public boolean bhEliminarPorNombre(String bh_nombre_eliminar){
        try {
			for (int i = 0; i < bh_lista.size(); i++){
				if (bh_lista.get(i).getNombre().equalsIgnoreCase(bh_nombre_eliminar)){
					bh_lista.remove(bh_lista.get(i));
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
    }

    public boolean bhEliminarPorIndex(int bh_index){
        try {
			bh_lista.remove(bh_index);
			return true;
		} catch (Exception e) {
			return false;
		}
    }

    public String bhMostrarTodo(){
        StringBuilder sb = new StringBuilder();
        for (AgujeroNegroDTO bh : bh_lista) {
            sb.append(bh.getNombre().toString()+"");
        }
        return sb.toString();
    }

    public boolean bhActualizarPorNombre(String bh_nombre_viejo, String nombre_nuevo, double masa, float momento_ang, float gravedad, double diametro){
        try {
			for (int i = 0; i < bh_lista.size(); i++) {
				if (bh_lista.get(i).getNombre().equals(bh_nombre_viejo)) {
					bh_lista.get(i).setNombre(nombre_nuevo);
                    bh_lista.get(i).setMasa(masa);
                    bh_lista.get(i).setMomento_ang(momento_ang);
                    bh_lista.get(i).setGravedad(gravedad);
                    bh_lista.get(i).setDiametro(diametro);

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
			for (int i = 0; i < bh_lista.size(); i++){
				if(bh_lista.get(i).getNombre().equalsIgnoreCase(nombre_viejo)){
					return i;
				}
			}
		} catch (Exception e){
			return 1000;
		}
		return 1000;
	}

    public boolean bhActualizarPorIndex(int bh_index, String nombre_nuevo, double masa, float momento_ang, float gravedad, double diametro){
        try {
            bh_lista.get(bh_index).setNombre(nombre_nuevo);
            bh_lista.get(bh_index).setMasa(masa);
            bh_lista.get(bh_index).setMomento_ang(momento_ang);
            bh_lista.get(bh_index).setGravedad(gravedad);
            bh_lista.get(bh_index).setDiametro(diametro);
			
			return true;

		} catch (Exception e) {
			return false;
		}
    }

}
