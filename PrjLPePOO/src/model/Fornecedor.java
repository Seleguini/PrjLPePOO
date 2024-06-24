package model;

public class Fornecedor {
    private int idFornecedor;
    private String nome;
    private String endereco;
    private String telefone;

    public Fornecedor(int idFornecedor, String nome, String endereco, String telefone) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}