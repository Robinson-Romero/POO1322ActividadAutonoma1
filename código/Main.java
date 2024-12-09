import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaTorneo sistema = new SistemaTorneo();

        // Registrar equipos
        System.out.print("Introduce el nombre del equipo local: ");
        String equipol = scanner.nextLine();
        System.out.print("Introduce el nombre del entrenador: ");
        String entrenadorl = scanner.nextLine();
        Equipo equipo1 = new Equipo(equipol, entrenadorl);
        for (int i = 1; i < 12; i++) {
            System.out.print("Introduce el nombre del jugador "+i+" : ");
        String jugador = scanner.nextLine();
        equipo1.agregarJugador(new Jugador(jugador));
        }
        sistema.registrarEquipo(equipo1);
        
        System.out.print("Introduce el nombre del equipo visitante: ");
        String equipov = scanner.nextLine();
        System.out.print("Introduce el nombre del entrenador: ");
        String entrenadorv = scanner.nextLine();
        Equipo equipo2 = new Equipo(equipov, entrenadorv);
        for (int i = 1; i < 12; i++) {
            System.out.print("Introduce el nombre del jugador "+i+" : ");
        String jugador = scanner.nextLine();
        equipo2.agregarJugador(new Jugador(jugador));
        }
        sistema.registrarEquipo(equipo2);

        // Crear partido
        System.out.print("Introduce la fecha del partido: ");
        String fecha = scanner.nextLine();
        Partido partido = new Partido(equipo1, equipo2, fecha);
        sistema.crearPartido(partido);

        // Listar equipos
        sistema.listarEquipos();

        // Mostrar historial de partidos
        sistema.mostrarHistorialPartidos();

        // Actualizar resultados
        System.out.print("Introduce el resultado del partido: ");
        String resultado = scanner.nextLine();
        sistema.actualizarResultado(0, resultado);
        
        // Mostrar historial de partidos después de actualizar
        sistema.mostrarHistorialPartidos();

        scanner.close();
    }
}
