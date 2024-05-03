import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListaEstudiante listaEstudiante = new ListaEstudiante();
        ListaCarrera listaCarrera = new ListaCarrera();

        // Generar reportes de carrera
        List<GeneradorReportes.ReporteCarrera> reportes = GeneradorReportes.generarReportes(listaEstudiante.estudiantes, listaCarrera.carreras);

        // Mostrar los reportes
        GeneradorReportes.mostrarReportes(reportes);
    }
}
