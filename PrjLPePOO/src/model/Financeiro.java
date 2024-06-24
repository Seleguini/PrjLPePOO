package model;

import java.util.Date;

public class Financeiro {
    private int idPagamento;
    private double valor;
    private String tipo;
    private Date dataHora;

    public Financeiro(int idPagamento, double valor, String tipo, Date dataHora) {
        this.idPagamento = idPagamento;
        this.valor = valor;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}