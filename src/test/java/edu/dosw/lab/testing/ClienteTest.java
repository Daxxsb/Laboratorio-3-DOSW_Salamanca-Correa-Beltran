package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void constructor_valido_y_getters() {
        Cliente c = new Cliente("C1", "Ana", "Pérez", 123, "Calle 1", 300111222);
        assertEquals("C1", c.getIdCliente());
        assertEquals("Ana", c.getNombre());
        assertEquals("Pérez", c.getApellido());
        assertEquals(123, c.getDocumento());
        assertEquals("Calle 1", c.getDireccion());
        assertEquals(300111222, c.getTelefono());
    }

    @Test
    void constructor_falla_si_id_null_o_blanco() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente(null, "A", "B", 1, "X", 1));
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("  ", "A", "B", 1, "X", 1));
    }

    @Test
    void constructor_falla_si_nombre_null_o_blanco() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("C1", null, "B", 1, "X", 1));
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("C1", "   ", "B", 1, "X", 1));
    }

    @Test
    void constructor_falla_si_apellido_null_o_blanco() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("C1", "A", null, 1, "X", 1));
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("C1", "A", "   ", 1, "X", 1));
    }

    @Test
    void constructor_falla_si_documento_no_positivo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("C1", "A", "B", 0, "X", 1));
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("C1", "A", "B", -5, "X", 1));
    }

    @Test
    void constructor_falla_si_telefono_no_positivo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("C1", "A", "B", 1, "X", 0));
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("C1", "A", "B", 1, "X", -7));
    }

    @Test
    void constructor_convierte_direccion_null_a_vacia() {
        Cliente c = new Cliente("C1", "A", "B", 1, null, 10);
        assertEquals("", c.getDireccion());
    }

    @Test
    void setters_validos_actualizan_campos() {
        Cliente c = new Cliente("C1", "A", "B", 1, "X", 10);

        c.setNombre("Ana");
        c.setApellido("López");
        c.setDocumento(999);
        c.setDireccion("Nueva Dir");
        c.setTelefono(555);

        assertEquals("Ana", c.getNombre());
        assertEquals("López", c.getApellido());
        assertEquals(999, c.getDocumento());
        assertEquals("Nueva Dir", c.getDireccion());
        assertEquals(555, c.getTelefono());
    }

    @Test
    void setNombre_falla_si_null_o_blanco() {
        Cliente c = new Cliente("C1", "A", "B", 1, "X", 10);
        assertThrows(IllegalArgumentException.class, () -> c.setNombre(null));
        assertThrows(IllegalArgumentException.class, () -> c.setNombre("   "));
    }

    @Test
    void setApellido_falla_si_null_o_blanco() {
        Cliente c = new Cliente("C1", "A", "B", 1, "X", 10);
        assertThrows(IllegalArgumentException.class, () -> c.setApellido(null));
        assertThrows(IllegalArgumentException.class, () -> c.setApellido("   "));
    }

    @Test
    void setDocumento_falla_si_no_positivo() {
        Cliente c = new Cliente("C1", "A", "B", 1, "X", 10);
        assertThrows(IllegalArgumentException.class, () -> c.setDocumento(0));
        assertThrows(IllegalArgumentException.class, () -> c.setDocumento(-1));
    }

    @Test
    void setTelefono_falla_si_no_positivo() {
        Cliente c = new Cliente("C1", "A", "B", 1, "X", 10);
        assertThrows(IllegalArgumentException.class, () -> c.setTelefono(0));
        assertThrows(IllegalArgumentException.class, () -> c.setTelefono(-10));
    }

    @Test
    void setDireccion_admite_null_y_lo_convierte_a_vacio() {
        Cliente c = new Cliente("C1", "A", "B", 1, "X", 10);
        c.setDireccion(null);
        assertEquals("", c.getDireccion());
    }

    @Test
    void toString_contiene_campos_clave() {
        Cliente c = new Cliente("C1", "Ana", "Pérez", 123, "X", 10);
        String s = c.toString();
        assertTrue(s.contains("C1"));
        assertTrue(s.contains("Ana"));
        assertTrue(s.contains("Pérez"));
        assertTrue(s.contains("123"));
    }

    @Test
    void equals_y_hashCode_se_basan_en_idCliente() {
        Cliente c1 = new Cliente("ID", "A", "B", 1, "X", 10);
        Cliente c2 = new Cliente("ID", "Otro", "Ap", 2, "Y", 20);
        Cliente c3 = new Cliente("ID2", "A", "B", 1, "X", 10);

        assertEquals(c1, c1);
        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
        assertNotEquals(c1, c3);
        assertNotEquals(c1, null);
        assertNotEquals(c1, "no-es-cliente");
    }
}
