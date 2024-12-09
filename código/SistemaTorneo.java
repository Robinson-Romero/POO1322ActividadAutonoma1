import java.util.ArrayList;
import java.util.List;

class SistemaTorneo {
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public SistemaTorneo() {
        equipos = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public void registrarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void crearPartido(Partido partido) {
        partidos.add(partido);
    }

    public void listarEquipos() {
        for (Equipo equipo : equipos) {
            System.out.println("Equipo: " + equipo.getNombre() + ", Entrenador: " + equipo.getEntrenador());
            System.out.print("Jugadores: ");
            for (Jugador jugador : equipo.getJugadores()) {
                System.out.print(jugador.getNombre() + " \n");
            }
            System.out.println();
        }
    }

    public void mostrarHistorialPartidos() {
        for (Partido partido : partidos) {
            System.out.println(partido);
        }
    }

    public void actualizarResultado(int indicePartido, String resultado) {
        if (indicePartido >= 0 && indicePartido < partidos.size()) {
            partidos.get(indicePartido).finalizarPartido(resultado);
        } else {
            System.out.println("Índice de partido no válido.");
        }
    }
}