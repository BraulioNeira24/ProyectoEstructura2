package ec.edu.espol.proyectoestructurapao;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ToExcel {

    // Exporta la red a un archivo Excel
    public static void exportarRed(Red red, String nombreArchivo) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Vuelos");

        // Encabezados
        String[] encabezados = {
                "Codigo Origen", "Nombre Origen", "Ciudad Origen", "País Origen",
                "Codigo Destino", "Nombre Destino", "Ciudad Destino", "País Destino",
                "Minutos", "Distancia", "Precio", "Aerolínea"
        };

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < encabezados.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(encabezados[i]);
        }

        // Llenar datos de vuelos
        int rowNum = 1;
        for (Aeropuerto origen : red.getVertices()) {
            for (Vuelos vuelo : origen.getAdyacentes()) {
                Row row = sheet.createRow(rowNum++);

                Aeropuerto destino = vuelo.getTarget();

                row.createCell(0).setCellValue(origen.getCodigo());
                row.createCell(1).setCellValue(origen.getNombre());
                row.createCell(2).setCellValue(origen.getCiudad());
                row.createCell(3).setCellValue(origen.getPais());

                row.createCell(4).setCellValue(destino.getCodigo());
                row.createCell(5).setCellValue(destino.getNombre());
                row.createCell(6).setCellValue(destino.getCiudad());
                row.createCell(7).setCellValue(destino.getPais());

                row.createCell(8).setCellValue(vuelo.getMinuto());
                row.createCell(9).setCellValue(vuelo.getDistancia());
                row.createCell(10).setCellValue(vuelo.getPrecio());
                row.createCell(11).setCellValue(vuelo.getAerolinea() != null ? vuelo.getAerolinea() : "N/A");
            }
        }

        // Ajustar el tamaño de las columnas automáticamente
        for (int i = 0; i < encabezados.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Guardar el archivo
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo)) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("Archivo Excel generado: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
