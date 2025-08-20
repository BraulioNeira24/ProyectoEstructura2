package ec.edu.espol.proyectoestructurapao;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Comparator;
/**
 *
 * @author equipo Estructura de Datos
 */
public class ProyectoEstructuraPAO extends Application {
    private Red redVuelos;
    @Override
    public void start(Stage primaryStage) {
        // Inicializa la red y algunos aeropuertos/vuelos de ejemplo
        inicializarRed();

        Pane root = new Pane();
        Canvas canvas = new Canvas(1200, 600);
        root.getChildren().add(canvas);

        dibujarAeropuertos(canvas.getGraphicsContext2D());

        Scene scene = new Scene(root, 1200, 600);
        primaryStage.setTitle("Red de Aeropuertos - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void inicializarRed() {
       
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
        redVuelos = new Red(comparador);
        redVuelos.addAeropuerto(aerDaxing);
        redVuelos.addAeropuerto(aerCapital);
        redVuelos.addAeropuerto(aerPudong);
        redVuelos.addAeropuerto(aerQuito); 
        redVuelos.addAeropuerto(aerTokyo); 
        redVuelos.addAeropuerto(aerInglaterra);
        redVuelos.addAeropuerto(aerGuayaquil);
        redVuelos.addAeropuerto(aerChangi);
        redVuelos.addAeropuerto(aerDXB);
        redVuelos.addAeropuerto(aerJFK);

        redVuelos.addVuelo("PKX", "PEK", 120, 200.15,"China Airlines");
        redVuelos.addVuelo("PKX", "PVG", 110, 153.12,"China Eastern Airlines");
        redVuelos.addVuelo("GYE", "UIO", 40, 60.54,"Avianca");
        redVuelos.addVuelo("UIO", "LHR", 634, 412.23,"Avianca");
        redVuelos.addVuelo("UIO", "NRT", 1440, 615.23,"Avianca");
        redVuelos.addVuelo("LHR", "PKX" , 542, 438,"Avianca");

    }

    private void dibujarAeropuertos(GraphicsContext gc) {
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, 1200, 600);

        for (Aeropuerto aeropuerto : redVuelos.getVertices()) {
            double x = convertirLongitudAX(aeropuerto.getLongitud());
            double y = convertirLatitudAY(aeropuerto.getLatitud());
            gc.setFill(Color.RED);
            gc.fillOval(x - 5, y - 5, 10, 10);
            gc.setFill(Color.BLACK);
            gc.fillText(aeropuerto.getCodigo(), x + 8, y);
        }
    }

    private double convertirLongitudAX(double longitud) {
        // Mapea de -180 a 180 a 0 a 1200
        return ((longitud + 180) / 360.0) * 1200;
    }

    private double convertirLatitudAY(double latitud) {
        // Mapea de 90 a -90 a 0 a 600 (latitud positiva arriba)
        return ((90 - latitud) / 180.0) * 600;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
