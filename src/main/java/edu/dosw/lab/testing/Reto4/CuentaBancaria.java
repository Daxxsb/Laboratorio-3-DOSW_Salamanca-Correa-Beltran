package edu.dosw.lab.testing.Reto4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CuentaBancaria {

    private String idCuentaBancaria;
    private String estado;
    private BancoExterno banco;
    private Cliente cliente;
    private double saldo = 0.0;
    private final List<Movimiento> historial = new ArrayList<>();

    public CuentaBancaria(String idCuentaBancaria, String estado) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.estado = estado;
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto debe ser > 0");
        saldo += monto;
        historial.add(new Movimiento(monto, new Date(), idCuentaBancaria));
    }

    public String getIdCuentaBancaria() { return idCuentaBancaria; }
    public void setIdCuentaBancaria(String idCuentaBancaria) { this.idCuentaBancaria = idCuentaBancaria; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public BancoExterno getBanco() { return banco; }
    public void setBanco(BancoExterno banco) { this.banco = banco; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public double getSaldo() { return saldo; }

    public List<Movimiento> getHistorial() { return Collections.unmodifiableList(historial); }
}

