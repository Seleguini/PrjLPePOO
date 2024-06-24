package model;

import java.util.Date;

public class Estoque {
    private int idEstoque;
    private int idProduto;
    private int idFornecedor;
    private int quantidadeTotal;
    private Date dataAtualizacao;

    public Estoque(int idEstoque, int idProduto, int idFornecedor, int quantidadeTotal, Date dataAtualizacao) {
        this.idEstoque = idEstoque;
        this.idProduto = idProduto;
        this.idFornecedor = idFornecedor;
        this.quantidadeTotal = quantidadeTotal;
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}