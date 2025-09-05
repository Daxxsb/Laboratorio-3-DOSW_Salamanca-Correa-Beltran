package edu.dosw.lab.testing.Reto4;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidadorCuenta {

    private java.util.List<String> longitudValidacion = new java.util.ArrayList<>();

    private static final Set<String> CODIGOS_BANCO = Arrays.stream(BancoExterno.values())
            .map(BancoExterno::getCodigo)
            .collect(Collectors.toUnmodifiableSet());

    public java.util.List<String> getLongitudValidacion() {
        return longitudValidacion;
    }

    public void setLongitudValidacion(java.util.List<String> numero) {
        this.longitudValidacion = numero;
    }

    public boolean tieneFormatoCorrecto(String numero) {
        if (numero == null || numero.length() != 10) return false;

        boolean soloDigitos = numero.chars().allMatch(Character::isDigit);
        if (!soloDigitos) return false;

        boolean todosCeros = numero.chars().allMatch(ch -> ch == '0');
        return !todosCeros;
    }

    public boolean esBancoValido(String numero) {
        if (numero == null || numero.isEmpty() || numero.length() < 2) return false;
        String prefijo = numero.substring(0, 2);
        return CODIGOS_BANCO.contains(prefijo);
    }

    public boolean validarCuenta(String numero) {
        return tieneFormatoCorrecto(numero) && esBancoValido(numero);
    }
}
