package edu.dosw.lab.testing.Reto4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Movimiento {

    private double monto;
    private final Date fecha;
    private final String numeroCuenta;

    private final List<MovimientoObserver> observadores = new ArrayList<>();

    public Movimiento(double monto, Date fecha, String numeroCuenta) {
        this.monto = monto;
        this.fecha = Objects.requireNonNullElseGet(fecha, Date::new);
        this.numeroCuenta = Objects.requireNonNull(numeroCuenta, "numeroCuenta");
    }

    public void agregarObservador(MovimientoObserver obs) {
        if (obs != null) observadores.add(obs);
    }

    private void notificar() {
        observadores.forEach(o -> o.onMovimiento(this));
    }

    public void setMonto(double monto) {
        this.monto = monto;
        notificar();
    }

    public double getMonto() { return monto; }
    public Date getFecha() { return fecha; }
    public String getNumeroCuenta() { return numeroCuenta; }
}
