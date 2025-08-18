package ec.edu.espol.proyectoestructurapao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 
 */
//Aristas dirigidas?
public class Red {
    private LinkedList<Aeropuerto> vertices = new LinkedList<>();
    private boolean isDirected;
    private Comparator cmp;


    public Red(boolean isDirected, Comparator cmp) {
        this.isDirected = isDirected;
        this.cmp = cmp;
    }

    // Agregar un aeropuerto
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

    // Eliminar Aeropuerto
    public boolean eliminarAeropuerto(String codigo){
        Aeropuerto aeropuertoxEliminar = findAeropuerto(codigo);
        if (aeropuertoxEliminar==null){
            return false; //no se puede eliminar un aeropuerto que no se encuentra
        }
        
        // Eliminar el aeropuerto de la lista de aeropuertos
        this.vertices.remove(aeropuertoxEliminar);

        // Eliminar los vuelos que tenían este aeropuerto como origen o destino
        for (Aeropuerto aeropuerto : vertices) {
            // Eliminar vuelos donde este aeropuerto sea el origen
            aeropuerto.getAdyacentes().removeIf(vuelo -> vuelo.getSource().equals(aeropuertoxEliminar));
            //se hace uso de una funcion lambda 
            // Eliminar vuelos donde este aeropuerto sea el destino
            aeropuerto.getAdyacentes().removeIf(vuelo -> vuelo.getTarget().equals(aeropuertoxEliminar));
        }
        
        return true;

    }
    

    // Conectar Aeropuertos "Crear Vuelo"
    public boolean addVuelo(String codigo1, String codigo2, int minuto, int distancia, double precio){
        if (codigo1==null || codigo2==null){
            return false;
        }
        
        Aeropuerto v1= findAeropuerto(codigo1);
        Aeropuerto v2= findAeropuerto(codigo2);
        
        if (v1==null || v2 == null){
            return false;
        }

        Vuelos newEdge = new Vuelos(v1, v2, minuto, distancia, precio);
        v1.getAdyacentes().add(newEdge);
        
        return true;
    } 
    
    // Eliminar Vuelo 
    public boolean deleteVuelo(String codigo1, String codigo2){
        Aeropuerto origen = findAeropuerto(codigo1);
        Aeropuerto destino = findAeropuerto(codigo2);
        // Existen los Aeropuertos?
        if(origen == null || destino == null){
            return false;
        }
        // Buscar y eliminar en la lista de vuelos 
        boolean eliminado = origen.getAdyacentes().removeIf(vuelo -> vuelo.getTarget().equals(destino));
        return eliminado;
    }

    
    // Encontrar ruta mas corta 
    public List<String> dijkstra(String inicio, String fin) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<Nodo<String>> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));

        for (Aeropuerto v : vertices) {
            dist.put(v.getCodigo(), Integer.MAX_VALUE);
            prev.put(v.getCodigo(), null);
        }
        dist.put(inicio, 0);
        pq.add(new Nodo<>(inicio, 0));

        while (!pq.isEmpty()) {
            Nodo<String> actual = pq.poll();
            String u = actual.getCodigo();

            if (u.equals(fin)) break;

            Aeropuerto aeropuertoU = findAeropuerto(u);

            for (Vuelos vuelo : aeropuertoU.getAdyacentes()) {
                String v = vuelo.getTarget().getCodigo();
                int nuevaDist = dist.get(u) + vuelo.getMinuto();

                if (nuevaDist < dist.get(v)) {
                    dist.put(v, nuevaDist);
                    prev.put(v, u);
                    pq.add(new Nodo<>(v, nuevaDist));
                }
            }
        }

        List<String> camino = new ArrayList<>();
        String actual = fin;
        while (actual != null) {
            camino.add(0, actual);
            actual = prev.get(actual);
        }

        if (dist.get(fin) == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }
        
        return camino;
    }
    

    

    





}