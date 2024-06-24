package model;

import java.util.Date;

public class Pagamento {
    private int idPagamento;
    private String tipo;
    private double valor;
    private Date dataHora;
    private String status;

    public Pagamento(int idPagamento, String tipo, double valor, Date dataHora, String status) {
        this.idPagamento = idPagamento;
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = dataHora;
        this.status = status;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}