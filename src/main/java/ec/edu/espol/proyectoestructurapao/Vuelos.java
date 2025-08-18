package ec.edu.espol.proyectoestructurapao;

public class Vuelos {
    private Aeropuerto source; // vertice origen
    private Aeropuerto target; // vertice destino
    private int minuto; // minuto de vuelo
    private int distancia; // distancia de la arista
    private double precio; // contenido de la arista
    private String aerolinea; // aerolinea del vuelo

    // Constructor
    public Vuelos(Aeropuerto source, Aeropuerto target, int minuto, int distancia, double precio, String aerolinea){
        this.source = source;
        this.target = target;
        this.minuto = minuto;
        this.distancia = distancia;
        this.precio = precio;
        this.aerolinea = aerolinea;
    }

    public Vuelos(Aeropuerto source, Aeropuerto target, int minuto, int distancia, double precio){
        this(source, target, minuto, distancia, precio, null);
    }

    public Vuelos(Aeropuerto source, Aeropuerto target, int minuto, int distancia){
        this(source, target, minuto, distancia, 0, null);
    }

    public Vuelos(Aeropuerto source, Aeropuerto target, int minuto){
        this(source, target, minuto, -1, 0, null);
    }

    public Vuelos(Aeropuerto source, Aeropuerto target){
        this(source, target, 0, -1, 0, null);
    }

    // Getters y Setters
    public Aeropuerto getSource() {
        return source;
    }

    public void setSource(Aeropuerto source) {
        this.source = source;
    }

    public Aeropuerto getTarget() {
        return target;
    }

    public void setTarget(Aeropuerto target) {
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

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
}
