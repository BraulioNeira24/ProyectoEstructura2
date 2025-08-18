package ec.edu.espol.proyectoestructurapao;

import java.util.Comparator;
import java.util.LinkedList;

/*
 * 
 */

public class Red<V, E> {
    private LinkedList<Aeropuerto<V, E>> vertices;
    private boolean isDirected;
    private Comparator<V> cmp;

    public Red(boolean isDirected, Comparator<V> cmp) {
        this.isDirected = isDirected;
        this.cmp = cmp;
    }
    public boolean addAeropuerto(V content){
        
        if (content == null || findAeropuerto(content) != null){
            return false;
        }
        Aeropuerto<V, E> newVertex = new Aeropuerto<>(content);
        this.vertices.add(newVertex);
        
        return true;
    }
    private Aeropuerto<V, E> findAeropuerto(V content) {
        for (Aeropuerto<V, E> v : vertices){
            V c = v.getContent();
            
            if (this.cmp.compare(c, content) == 0){
                return v;
            }
        }
        return null;
    }

    public boolean connect(V content1, V content2, int minuto, int distancia, double precio){

        if (content1==null || content2==null){
            return false;
        }
        
        Aeropuerto<V, E> v1= findAeropuerto(content1);
        Aeropuerto<V, E> v2= findAeropuerto(content2);
        
        if (v1==null || v2 == null){
            return false;
        }

        Vuelos<E, V> newEdge = new Vuelos<>(v1, v2, minuto, distancia, precio);
        v1.getEdge().add(newEdge);
        
        return true;
    }

    




}