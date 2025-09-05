package edu.dosw.lab.testing.Reto4;

public enum BancoExterno {
    BANCO1("01", "BANCOLOMBIA"),
    BANCO2("02", "DAVIVIENDA");

    private final String codigo;
    private final String nombre;

    BancoExterno(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}
