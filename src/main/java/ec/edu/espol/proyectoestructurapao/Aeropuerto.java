package ec.edu.espol.proyectoestructurapao;

import java.util.LinkedList;

public class Aeropuerto<V, E> {
    private String nombre;
    private V content; 
    private LinkedList<Vuelos<E, V>> edge; 


    public Aeropuerto(V content) {
        this.content = content;
        this.edge = new LinkedList<>(); 
    }

    public V getContent() {
        return content;
    }

    public void setContent(V content) {
        this.content = content;
    }

    public LinkedList<Vuelos<E, V>> getEdge() {
        return edge;
    }

    public void setEdge(LinkedList<Vuelos<E, V>> edge) {
        this.edge = edge;
    }
    


}