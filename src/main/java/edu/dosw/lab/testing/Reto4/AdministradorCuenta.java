package edu.dosw.lab.testing.Reto4;

import java.util.HashMap;
import java.util.Map;

public class AdministradorCuenta implements MovimientoObserver {

    private String idCuenta;
    private final Map<String, CuentaBancaria> cuentas = new HashMap<>();
    private final ValidadorCuenta validador = new ValidadorCuenta();

    public AdministradorCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
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

    // Observer: cuando un Movimiento notifica, lo aplicamos a la cuenta correspondiente
    @Override
    public void onMovimiento(Movimiento movimiento) {
        String num = movimiento.getNumeroCuenta();
        CuentaBancaria c = cuentas.get(num);
        if (c != null && movimiento.getMonto() > 0) {
            c.depositar(movimiento.getMonto());
        }
    }

    public String getIdCuenta() { return idCuenta; }
}
