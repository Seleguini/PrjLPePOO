package model;

import java.util.Date;

public class Mesa {
    private int idVenda;
    private int idPedido;
    private int idFuncionario;
    private int idCliente;
    private Date dataVenda;
    private double valorTotal;

    public Mesa(int idVenda, int idPedido, int idFuncionario, int idCliente, Date dataVenda, double valorTotal) {
        this.idVenda = idVenda;
        this.idPedido = idPedido;
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}