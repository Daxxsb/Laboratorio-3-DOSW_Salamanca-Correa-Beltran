package edu.dosw.lab.agilismo.Solid;

public class HistoriaUsuario {
    private final String descripcion;
    private int puntaje;

    public HistoriaUsuario(String descripcion) {
        this.descripcion = descripcion;
        this.puntaje = 0;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}