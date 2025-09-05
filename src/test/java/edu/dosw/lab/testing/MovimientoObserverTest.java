package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MovimientoObserverTest {

    private AdministradorCuenta admin;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        admin = new AdministradorCuenta("admin-01");
        cliente = new Cliente("C1","Ana","Pérez",1012345678,"Calle 123",300123456);
        admin.crearCuenta(cliente, "0112345678", BancoExterno.BANCO1, "ACTIVA");
    }

    @Test
    void movimientoNotificaAdministrador_ySeAplicaAlSaldo() {
        Movimiento mov = new Movimiento(500.0, new java.util.Date(), "0112345678");
        mov.agregarObservador(admin);

        mov.setMonto(500.0);
        assertEquals(500.0, admin.consultarSaldo("0112345678"), 1e-9);
    }
}
