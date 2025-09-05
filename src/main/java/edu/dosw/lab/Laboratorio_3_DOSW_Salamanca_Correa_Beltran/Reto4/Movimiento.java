package edu.dosw.lab.Laboratorio_3_DOSW_Salamanca_Correa_Beltran.Reto4;

import java.util.*;

public class Movimiento {
    public double monto;
    public Date fecha;
    public String numeroCuenta;

    public Movimiento(double monto, Date fecha, String numeroCuenta) {
        this.monto = monto;
        this.fecha = fecha;
        this.numeroCuenta = numeroCuenta;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
