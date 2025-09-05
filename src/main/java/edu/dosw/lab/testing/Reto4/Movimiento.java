package edu.dosw.lab.testing.Reto4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movimiento {
    public double monto;
    public Date fecha;
    public String numeroCuenta;

    private final List<MovimientoObserver> observadores = new ArrayList<>();

    public Movimiento(double monto, Date fecha, String numeroCuenta) {
        this.monto = monto;
        this.fecha = fecha;
        this.numeroCuenta = numeroCuenta;
    }

    public void agregarObservador(MovimientoObserver obs) {
        if (obs != null) observadores.add(obs);
    }

    private void notificar() {
        for (MovimientoObserver o : observadores) {
            o.onMovimiento(this);
        }
    }

    public void setMonto(double monto) {
        this.monto = monto;
        notificar();
    }

    // Getters básicos para tests
    public double getMonto() { return monto; }
    public Date getFecha() { return fecha; }
    public String getNumeroCuenta() { return numeroCuenta; }
}
