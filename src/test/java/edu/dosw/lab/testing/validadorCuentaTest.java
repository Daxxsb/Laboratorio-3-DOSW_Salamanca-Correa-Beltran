package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.ValidadorCuenta;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class validadorCuentaTest {

    private ValidadorCuenta validador;

    @BeforeEach
    void setUp() {
        validador = new ValidadorCuenta();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0123456789", "0200000000", "0199999999"})
    void formatoValido(String numero) {
        assertTrue(validador.tieneFormatoCorrecto(numero));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "12345", "00123456789", "01A2345678", "01-2345678", "ABCDEFGHIJ"})
    void formatoInvalido(String numero) {
        assertFalse(validador.tieneFormatoCorrecto(numero));
    }

    @Test
    void formatoNull() {
        assertFalse(validador.tieneFormatoCorrecto(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0112345678", "0211111111"})
    void bancoValido(String numero) {
        assertTrue(validador.esBancoValido(numero));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0012345678", "0912345678", "9912345678"})
    void bancoInvalido(String numero) {
        assertFalse(validador.esBancoValido(numero));
    }

    @Test
    void bancoNullOVacio() {
        assertAll(
            () -> assertFalse(validador.esBancoValido(null)),
            () -> assertFalse(validador.esBancoValido(""))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0112345678", "0211111111"})
    void cuentaValida(String numero) {
        assertTrue(validador.validarCuenta(numero));
    }

    @ParameterizedTest
    @ValueSource(strings = {"9912345678", "01A2345678", "012345678", "00123456789"})
    void cuentaInvalida(String numero) {
        assertFalse(validador.validarCuenta(numero));
    }

    @Test
    void cuentaNullOVacia() {
        assertAll(
            () -> assertFalse(validador.validarCuenta(null)),
            () -> assertFalse(validador.validarCuenta(""))
        );
    }
}


