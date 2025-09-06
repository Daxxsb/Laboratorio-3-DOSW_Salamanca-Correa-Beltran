package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BancoExternoTest {

    @Test
    void enum_tiene_valores_esperados() {
        assertNotNull(BancoExterno.BANCO1);
        assertNotNull(BancoExterno.BANCO2);
        assertEquals(2, BancoExterno.values().length);
    }

    @Test
    void getters_devuelven_codigo_y_nombre_correctos() {
        assertEquals("01", BancoExterno.BANCO1.getCodigo());
        assertEquals("BANCOLOMBIA", BancoExterno.BANCO1.getNombre());

        assertEquals("02", BancoExterno.BANCO2.getCodigo());
        assertEquals("DAVIVIENDA", BancoExterno.BANCO2.getNombre());
    }

    @Test
    void toString_no_es_null_y_name_es_el_literal() {
        assertNotNull(BancoExterno.BANCO1.toString());
        assertEquals("BANCO1", BancoExterno.BANCO1.name());
    }

    @Test
    void values_y_valueOf_funcionan() {
        BancoExterno[] all = BancoExterno.values();
        assertTrue(all.length >= 2);

        for (BancoExterno b : all) {
            assertNotNull(b.getCodigo());
            assertNotNull(b.getNombre());
        }

        assertEquals(BancoExterno.BANCO1, BancoExterno.valueOf("BANCO1"));
        assertEquals(BancoExterno.BANCO2, BancoExterno.valueOf("BANCO2"));
    }

    @Test
    void valueOf_lanza_excepcion_si_no_existe() {
        assertThrows(IllegalArgumentException.class, () -> BancoExterno.valueOf("NO_SUCH_BANK"));
    }
}
