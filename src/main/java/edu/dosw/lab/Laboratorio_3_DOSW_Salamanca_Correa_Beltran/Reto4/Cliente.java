package edu.dosw.lab.Laboratorio_3_DOSW_Salamanca_Correa_Beltran.Reto4;

public class Cliente {

    private String idCliente;
    private String nombre;
    private String apellido;
    private int documento;
    private String direccion;
    private int telefono;

    public Cliente(String idCliente, String nombre, String apellido, int documento, String direccion, int telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getDocumento() {
            return documento;
        }

        public void setDocumento(int documento) {
            this.documento = documento;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

}
