package umg.progra2.reportes;

import umg.progra2.BaseDatos.Service.ProductoService;
import umg.progra2.BaseDatos.model.Producto;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class pruebas {

    private static final String COUNTER_FILE = "C:\\ReportesDePrueba\\counter.txt";

    public static void main(String[] args) {
        try {
            int reportNumber = getReportNumber();
            List<Producto> prod = new ProductoService().obtenerProductoMenoresA30("existencia < 30");
            String reportFileName = "C:\\ReportesDePrueba\\reporte" + reportNumber + ".pdf";
            new PdfReport().generateProductReport(prod, reportFileName);
            JOptionPane.showMessageDialog(null, "Reporte guardado en " + reportFileName);
            updateReportNumber(reportNumber + 1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        }

    private static int getReportNumber() {
        try (BufferedReader reader = new BufferedReader(new FileReader(COUNTER_FILE))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return 1; // Si el archivo no existe, empezamos con 1
        }
    }

    private static void updateReportNumber(int newNumber) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COUNTER_FILE))) {
            writer.write(String.valueOf(newNumber));
        } catch (IOException e) {
            System.out.println("Error al actualizar el contador: " + e.getMessage());
        }
    }

    }
