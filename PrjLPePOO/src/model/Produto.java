package model;

public class Produto {
    private int idProduto;
    private String nome;
    private double preco;
    private String categoria;
    private String descricao;

    public Produto(int idProduto, String nome, double preco, String categoria, String descricao) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}