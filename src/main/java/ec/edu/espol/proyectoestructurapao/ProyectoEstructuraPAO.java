package ec.edu.espol.proyectoestructurapao;
import java.util.Comparator;
/**
 *
 * @author equipo Estructura de Datos
 */
public class ProyectoEstructuraPAO {
    public static void main(String[] args) {
        Aeropuerto aerDaxing = new Aeropuerto("PKX", "Daxing","Pekín","China",39.511944, 116.410556);
        Aeropuerto aerCapital = new Aeropuerto("PEK", "Capital","Pekín","China",40.0801, 116.585);
        Aeropuerto aerPudong = new Aeropuerto("PVG", "Pudong","Shangai","China",31.143333, 121.805278);
        Aeropuerto aerQuito = new Aeropuerto("UIO", "Quito","Quito","Ecuador",-0.13555556, -78.36555556);
        Aeropuerto aerTokyo = new Aeropuerto("NRT", "Narita","Tokyo","Japón",35.7649, 140.38845);
        Aeropuerto aerInglaterra = new Aeropuerto("LHR", "Heathrow","Londres","Inglaterra",51.4775, -0.461389);
        Aeropuerto aerGuayaquil = new Aeropuerto("GYE", "José Joaquín de Olmedo", "Guayaquil", "Ecuador", -2.1575, -79.883611);
        Aeropuerto aerChangi = new Aeropuerto("SIN", "Changi", "Singapur", "Singapur", 1.3644, 103.9915);
        Aeropuerto aerDXB = new Aeropuerto("DXB", "Dubai International", "Dubái", "Emiratos Árabes Unidos", 25.2532, 55.3657);
        Aeropuerto aerJFK = new Aeropuerto("JFK", "John F. Kennedy International", "Nueva York", "Estados Unidos", 40.6413, -73.7781);
        
        
        Comparator<String> comparador = (String s1, String s2) -> s1.compareTo(s2);
        Red RedVuelos = new Red(comparador);
        RedVuelos.addAeropuerto(aerDaxing);
        RedVuelos.addAeropuerto(aerCapital);
        RedVuelos.addAeropuerto(aerPudong);
        RedVuelos.addAeropuerto(aerQuito); 
        RedVuelos.addAeropuerto(aerTokyo); 
        RedVuelos.addAeropuerto(aerInglaterra);
        RedVuelos.addAeropuerto(aerGuayaquil);
        RedVuelos.addAeropuerto(aerChangi);
        RedVuelos.addAeropuerto(aerDXB);
        RedVuelos.addAeropuerto(aerJFK);

        RedVuelos.addVuelo("PKX", "PEK", 120, 200.15,"China Airlines");
        RedVuelos.addVuelo("PKX", "PVG", 110, 153.12,"China Eastern Airlines");
        RedVuelos.addVuelo("GYE", "UIO", 40, 60.54,"Avianca");
        RedVuelos.addVuelo("UIO", "LHR", 634, 412.23,"Avianca");
        RedVuelos.addVuelo("UIO", "NRT", 1440, 615.23,"Avianca");
        RedVuelos.addVuelo("LHR", "PKX" , 542, 438,"Avianca");

        for (Vuelos v: aerQuito.getAdyacentes()){
            System.out.println(v.getDistancia());
        }

        for(String s: RedVuelos.dijkstra("GYE","PKX")){
            System.out.println(s);
        }


    }
}
