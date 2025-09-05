package edu.dosw.lab.testing.Reto4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AdministradorCuenta implements MovimientoObserver {

    private final String idCuenta;
    private final Map<String, CuentaBancaria> cuentas = new HashMap<>();
    private final ValidadorCuenta validador = new ValidadorCuenta();

    public AdministradorCuenta(String idCuenta) {
        this.idCuenta = Objects.requireNonNull(idCuenta, "idCuenta");
    }

    public CuentaBancaria crearCuenta(Cliente cliente, String numeroCuenta, BancoExterno banco, String estado) {
        if (!validador.validarCuenta(numeroCuenta)) {
            throw new IllegalArgumentException("Número de cuenta inválido");
        }
        CuentaBancaria c = new CuentaBancaria(numeroCuenta, estado);
        c.setBanco(banco);
        c.setCliente(cliente);
        cuentas.put(numeroCuenta, c);
        return c;
    }

    public void depositar(String numeroCuenta, double monto) {
        CuentaBancaria c = cuentas.get(numeroCuenta);
        if (c == null) throw new IllegalArgumentException("Cuenta no existe");
        c.depositar(monto);
    }

    public double consultarSaldo(String numeroCuenta) {
        CuentaBancaria c = cuentas.get(numeroCuenta);
        if (c == null) throw new IllegalArgumentException("Cuenta no existe");
        return c.getSaldo();
    }

    public CuentaBancaria obtenerCuenta(String numeroCuenta) {
        return cuentas.get(numeroCuenta);
    }

    @Override
    public void onMovimiento(Movimiento movimiento) {
        CuentaBancaria c = cuentas.get(movimiento.getNumeroCuenta());
        if (c != null && movimiento.getMonto() > 0) {
            c.depositar(movimiento.getMonto());
        }
    }

    public String getIdCuenta() { return idCuenta; }
}
