package edu.dosw.lab.Laboratorio_3_DOSW_Salamanca_Correa_Beltran.Reto4;

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
