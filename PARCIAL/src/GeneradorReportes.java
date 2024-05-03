import java.util.ArrayList;
import java.util.List;

public class GeneradorReportes {
    public static class ReporteCarrera {
        Carrera carrera;
        double promedioNotas;
        double promedioEdad;

        public ReporteCarrera(Carrera carrera, double promedioNotas, double promedioEdad) {
            this.carrera = carrera;
            this.promedioNotas = promedioNotas;
            this.promedioEdad = promedioEdad;
        }

        public String toString() {
            return "Reporte de Carrera: " + carrera.nombre + "\n" +
                    "Promedio de notas: " + promedioNotas + "\n" +
                    "Promedio de edad de estudiantes: " + promedioEdad + "\n";
        }
    }

    // Método para generar los reportes de carrera
    public static List<ReporteCarrera> generarReportes(List<Estudiante> estudiantes, List<Carrera> carreras) {
        List<ReporteCarrera> reportes = new ArrayList<>();

        for (Carrera carrera : carreras) {
            List<Estudiante> estudiantesCarrera = new ArrayList<>();
            double sumaNotas = 0;
            double sumaEdades = 0;
            int contadorEstudiantes = 0;

            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getCarrera().equals(carrera.getCodigo())) {
                    estudiantesCarrera.add(estudiante);
                    sumaNotas += estudiante.getPromedio();
                    sumaEdades += estudiante.getEdad();
                    contadorEstudiantes++;
                }
            }

            double promedioNotas = contadorEstudiantes > 0 ? sumaNotas / contadorEstudiantes : 0;
            double promedioEdad = contadorEstudiantes > 0 ? sumaEdades / contadorEstudiantes : 0;

            reportes.add(new ReporteCarrera(carrera, promedioNotas, promedioEdad));
        }

        return reportes;
    }

    // Método para mostrar los reportes
    public static void mostrarReportes(List<ReporteCarrera> reportes) {
        System.out.println("Reportes de Carrera:");
        for (ReporteCarrera reporte : reportes) {
            System.out.println(reporte);
        }
    }
}
