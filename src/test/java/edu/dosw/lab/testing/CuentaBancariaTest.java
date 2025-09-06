package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class CuentaBancariaTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("C1", "Ana", "Pérez", 1012345678, "Calle 123", 300123456);
    }

    @Test
    void crearCuenta_saldoInicialCero() {
        CuentaBancaria c = new CuentaBancaria("0112345678", "ACTIVA");
        c.setBanco(BancoExterno.BANCO1);
        c.setCliente(cliente);
        assertEquals(0.0, c.getSaldo(), 1e-9);
    }

    @Test
    void depositar_valorPositivo_incrementaSaldoYRegistraMovimiento() {
        CuentaBancaria c = new CuentaBancaria("0112345678", "ACTIVA");
        c.setBanco(BancoExterno.BANCO1);
        c.setCliente(cliente);

        c.depositar(1500.0);
        assertEquals(1500.0, c.getSaldo(), 1e-9);
        assertEquals(1, c.getHistorial().size());

        Movimiento m = c.getHistorial().get(0);

        assertEquals(1500.0, m.getMonto(), 1e-9);
        assertEquals("0112345678", m.getNumeroCuenta());
        assertNotNull(m.getFecha());
    }

    @Test
    void depositar_ceroONegativo_lanzaExcepcion() {
        CuentaBancaria c = new CuentaBancaria("0112345678", "ACTIVA");
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> c.depositar(0)),
            () -> assertThrows(IllegalArgumentException.class, () -> c.depositar(-10))
        );
    }

    @Test
    void set_y_get_banco_y_cliente_y_cambios_de_estado() {
        CuentaBancaria c = new CuentaBancaria("0199999999", "PENDIENTE");
        c.setEstado("ACTIVA");
        c.setIdCuentaBancaria("0211111111");

        assertEquals("ACTIVA", c.getEstado());
        assertEquals("0211111111", c.getIdCuentaBancaria());

        Cliente cli = new Cliente("C9", "Luz", "Diaz", 42, "X", 123);
        c.setCliente(cli);
        c.setBanco(BancoExterno.BANCO2);

        assertSame(cli, c.getCliente());
        assertEquals(BancoExterno.BANCO2, c.getBanco());
    }
}
