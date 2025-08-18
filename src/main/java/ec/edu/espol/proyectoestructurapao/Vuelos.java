package ec.edu.espol.proyectoestructurapao;

public class Vuelos<E,V> {
    private Aeropuerto<V, E> source; // vertice origen
    private Aeropuerto<V,E> target; // vertice destino
    private int minuto; // minuto de vuelo
    private int distancia; // distancia de la arista
    private double precio; // contenido de la arista

    // Constructor
    public Vuelos(Aeropuerto<V,E> source, Aeropuerto<V,E> target, int minuto, int distancia, double precio){
        this.source = source;
        this.target = target;
        this.minuto = minuto;
        this.distancia = distancia;
        this.precio = precio;
    }

    public Vuelos(Aeropuerto<V,E> source, Aeropuerto<V,E> target, int minuto, int distancia){
        this(source, target, minuto, distancia, 0);
    }

    public Vuelos(Aeropuerto<V,E> source, Aeropuerto<V,E> target, int minuto){
        this(source, target, minuto, -1, 0);
    }

    public Vuelos(Aeropuerto<V,E> source, Aeropuerto<V,E> target){
        this(source, target, 0, -1, 0);
    }

    // Getters y Setters
    public Aeropuerto<V, E> getSource() {
        return source;
    }

    public void setSource(Aeropuerto<V, E> source) {
        this.source = source;
    }

    public Aeropuerto<V, E> getTarget() {
        return target;
    }

    public void setTarget(Aeropuerto<V, E> target) {
        this.target = target;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
