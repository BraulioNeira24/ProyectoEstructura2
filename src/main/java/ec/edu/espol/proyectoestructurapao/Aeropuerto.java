package ec.edu.espol.proyectoestructurapao;

import java.util.LinkedList;

public class Aeropuerto{
    private String codigo; // codigo del aeropuerto
    private String nombre; // nombre del aeropuerto
    private String ciudad; // ciudad del aeropuerto
    private String pais; // pais del aeropuerto  
    private LinkedList<Vuelos> adjacentes; // lista de vuelos adyacentes

    public Aeropuerto(String codigo, String nombre, String ciudad, String pais) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.adjacentes = new LinkedList<>();
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LinkedList<Vuelos> getAdjacentes() {
        return adjacentes;
    }

    public void setAdjacentes(LinkedList<Vuelos> adjacentes) {
        this.adjacentes = adjacentes;
    }

}