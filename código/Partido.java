class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String fecha;
    private String resultado;
    private boolean finalizado;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, String fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.resultado = "Pendiente";
        this.finalizado = false;
    }

    public void finalizarPartido(String resultado) {
        this.resultado = resultado;
        this.finalizado = true;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    @Override
    public String toString() {
        return "Partido: " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() +
                " | Fecha: " + fecha + " | Resultado: " + resultado;
    }
}