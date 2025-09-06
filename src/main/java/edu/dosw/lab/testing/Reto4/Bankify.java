package edu.dosw.lab.testing.Reto4;

import java.util.ArrayList;
import java.util.List;

public class Bankify {

    private List<CuentaBancaria> cuentas;
    private List<CuentaBancaria> depositos;
    private List<BancoExterno> bancosRegistrados;

    public Bankify() {
        this.cuentas = new ArrayList<>();
        this.depositos = new ArrayList<>();
        this.bancosRegistrados = new ArrayList<>();
    }

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public List<CuentaBancaria> getDepositos() {
        return depositos;
    }

    public List<BancoExterno> getBancosRegistrados() {
        return bancosRegistrados;
    }

    public void setCuentas(List<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    public void setDepositos(List<CuentaBancaria> depositos) {
        this.depositos = depositos;
    }

    public void setBancosRegistrados(List<BancoExterno> bancosRegistrados) {
        this.bancosRegistrados = bancosRegistrados;
    }
}
