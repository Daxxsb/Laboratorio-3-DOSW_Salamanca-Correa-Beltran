package edu.dosw.lab.testing.Reto4;

import java.util.Objects;

public class Cliente {

    private final String idCliente;
    private String nombre;
    private String apellido;
    private int documento;
    private String direccion;
    private int telefono;

    public Cliente(String idCliente, String nombre, String apellido, int documento, String direccion, int telefono) {
        if (idCliente == null || idCliente.isBlank()) {
            throw new IllegalArgumentException("El idCliente no puede ser vacío");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El apellido no puede ser vacío");
        }
        if (documento <= 0) {
            throw new IllegalArgumentException("El documento debe ser positivo");
        }
        if (telefono <= 0) {
            throw new IllegalArgumentException("El teléfono debe ser positivo");
        }

        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.direccion = direccion != null ? direccion : "";
        this.telefono = telefono;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El apellido no puede ser vacío");
        }
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        if (documento <= 0) {
            throw new IllegalArgumentException("El documento debe ser positivo");
        }
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion != null ? direccion : "";
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        if (telefono <= 0) {
            throw new IllegalArgumentException("El teléfono debe ser positivo");
        }
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return String.format("Cliente{id='%s', nombre='%s %s', documento=%d}",
                idCliente, nombre, apellido, documento);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return idCliente.equals(cliente.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }
}
