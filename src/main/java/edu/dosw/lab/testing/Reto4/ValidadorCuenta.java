package edu.dosw.lab.testing.Reto4;

public class ValidadorCuenta {

    private java.util.List<String> longitudValidacion = new java.util.ArrayList<>();

    public java.util.List<String> getLongitudValidacion() {
        return longitudValidacion;
    }

    public void setLongitudValidacion(java.util.List<String> numero) {
        this.longitudValidacion = numero;
    }

    public boolean tieneFormatoCorrecto(String numero) {
        if (numero == null) return false;
        if (numero.length() != 10) return false;

        for (int i = 0; i < numero.length(); i++) {
            char c = numero.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        boolean todosCeros = true;
        for (int i = 0; i < numero.length(); i++) {
            if (numero.charAt(i) != '0') {
                todosCeros = false;
                break;
            }
        }
        if (todosCeros) return false;

        return true;
    }

    public boolean esBancoValido(String numero) {
        if (numero == null || numero.isEmpty()) return false;
        if (numero.length() < 2) return false;

        String prefijo = numero.substring(0, 2);

        for (BancoExterno b : BancoExterno.values()) {
            if (b.getCodigo().equals(prefijo)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarCuenta(String numero) {
        return tieneFormatoCorrecto(numero) && esBancoValido(numero);
    }
}