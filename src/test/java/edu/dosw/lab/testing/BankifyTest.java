package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class BankifyTest {

    @Test
    void constructor_inicializa_listas_vacias() {
        Bankify b = new Bankify();
        assertNotNull(b.getCuentas());
        assertNotNull(b.getDepositos());
        assertNotNull(b.getBancosRegistrados());
        assertTrue(b.getCuentas().isEmpty());
        assertTrue(b.getDepositos().isEmpty());
        assertTrue(b.getBancosRegistrados().isEmpty());
    }

    @Test
    void setters_y_getters_funcionan_con_referencias() {
        Bankify b = new Bankify();

        List<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(new CuentaBancaria("0112345678", "ACTIVA"));

        List<CuentaBancaria> depositos = new ArrayList<>();
        depositos.add(new CuentaBancaria("0211111111", "ACTIVA"));

        List<BancoExterno> bancos = new ArrayList<>();
        bancos.add(BancoExterno.BANCO1);
        bancos.add(BancoExterno.BANCO2);

        b.setCuentas(cuentas);
        b.setDepositos(depositos);
        b.setBancosRegistrados(bancos);

        assertSame(cuentas, b.getCuentas());
        assertSame(depositos, b.getDepositos());
        assertSame(bancos, b.getBancosRegistrados());

        assertEquals(1, b.getCuentas().size());
        assertEquals("0112345678", b.getCuentas().get(0).getIdCuentaBancaria());
        assertEquals(2, b.getBancosRegistrados().size());
        assertTrue(b.getBancosRegistrados().contains(BancoExterno.BANCO1));
        assertTrue(b.getBancosRegistrados().contains(BancoExterno.BANCO2));
    }

    @Test
    void listas_son_mutables_tras_set() {
        Bankify b = new Bankify();
        List<CuentaBancaria> cuentas = new ArrayList<>();
        b.setCuentas(cuentas);
        cuentas.add(new CuentaBancaria("0199999999", "ACTIVA"));

        assertEquals(1, b.getCuentas().size());
        assertEquals("0199999999", b.getCuentas().get(0).getIdCuentaBancaria());
    }

    @Test
    void setters_aceptan_null_y_los_getters_reflejan_null() {
        Bankify b = new Bankify();
        b.setCuentas(null);
        b.setDepositos(null);
        b.setBancosRegistrados(null);

        assertNull(b.getCuentas());
        assertNull(b.getDepositos());
        assertNull(b.getBancosRegistrados());
    }

    @Test
    void listas_siguen_siendo_mutables_despues_de_set() {
        Bankify b = new Bankify();
        List<CuentaBancaria> cuentas = new ArrayList<>();
        b.setCuentas(cuentas);

        cuentas.add(new CuentaBancaria("0112345678", "ACTIVA"));
        assertEquals(1, b.getCuentas().size());
        assertEquals("0112345678", b.getCuentas().get(0).getIdCuentaBancaria());
    }
}
