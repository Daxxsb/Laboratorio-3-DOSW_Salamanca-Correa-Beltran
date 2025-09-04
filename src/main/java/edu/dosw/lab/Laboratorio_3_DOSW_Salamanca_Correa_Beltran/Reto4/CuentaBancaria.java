package edu.dosw.lab.Laboratorio_3_DOSW_Salamanca_Correa_Beltran.Reto4;

public class CuentaBancaria {

    private String idCuentaBancaria;
    private String estado;
    private BancoExterno banco;
    private Cliente cliente;

    public CuentaBancaria(String idCuentaBancaria, String estado) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.estado = estado;
    }

    public String getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(String idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BancoExterno getBanco() {
        return banco;
    }

    public void setBanco(BancoExterno banco) {
        this.banco = banco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
