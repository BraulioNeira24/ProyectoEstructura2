package ec.edu.espol.proyectoestructurapao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 
 */

public class Red {
    private LinkedList<Aeropuerto> vertices;
    private boolean isDirected;
    private Comparator cmp;


    public Red(boolean isDirected, Comparator cmp) {
        this.isDirected = isDirected;
        this.cmp = cmp;
    }
    public boolean addAeropuerto(Aeropuerto nuevo){
        
        if (nuevo == null || findAeropuerto(nuevo.getCodigo()) != null){
            return false;
        }

        this.vertices.add(nuevo);
        
        return true;
    }
    private Aeropuerto findAeropuerto(String Codigo) {
        for (Aeropuerto v : vertices){
            String c = v.getCodigo();
            
            if (this.cmp.compare(c, Codigo) == 0){
                return v;
            }
        }
        return null;
    }

    public boolean connect(String codigo1, String codigo2, int minuto, int distancia, double precio){

        if (codigo1==null || codigo2==null){
            return false;
        }
        
        Aeropuerto v1= findAeropuerto(codigo1);
        Aeropuerto v2= findAeropuerto(codigo2);
        
        if (v1==null || v2 == null){
            return false;
        }

        Vuelos newEdge = new Vuelos(v1, v2, minuto, distancia, precio);
        v1.getAdjacentes().add(newEdge);
        
        return true;
    }




    public Map<String, Integer> Dijkstra(String Inicio){
        Map<String, Integer> dist = new HashMap<>();
        PriorityQueue<Vuelos> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.getDistancia()));
        for (Aeropuerto v : vertices) {
            dist.put(v.getNombre(), Integer.MAX_VALUE);
        }



        return dist;


    }
    





}