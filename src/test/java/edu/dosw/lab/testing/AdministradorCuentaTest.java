package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AdministradorCuentaTest {

    private AdministradorCuenta admin;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        admin = new AdministradorCuenta("admin-01");
        cliente = new Cliente("C1","Ana","Pérez",1012345678,"Calle 123",300123456);
    }

    @Test
    void crearCuenta_conNumeroValido_creaYGuarda() {
        CuentaBancaria c = admin.crearCuenta(cliente, "0112345678", BancoExterno.BANCO1, "ACTIVA");
        assertNotNull(c);
        assertEquals(0.0, admin.consultarSaldo("0112345678"), 1e-9);
    }

    @Test
    void crearCuenta_conNumeroInvalido_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () ->
            admin.crearCuenta(cliente, "9912345678", BancoExterno.BANCO1, "ACTIVA"));
    }

    @Test
    void depositar_actualizaSaldoYRegistraMovimiento() {
        admin.crearCuenta(cliente, "0112345678", BancoExterno.BANCO1, "ACTIVA");
        admin.depositar("0112345678", 2000.0);
        assertEquals(2000.0, admin.consultarSaldo("0112345678"), 1e-9);
        assertEquals(1, admin.obtenerCuenta("0112345678").getHistorial().size());
    }
}
