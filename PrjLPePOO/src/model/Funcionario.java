package model;

import java.util.Date;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String cargo;
    private Date dataContratacao;

    public Funcionario(int idFuncionario, String nome, String cpf, String telefone, String email, String cargo, Date dataContratacao) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}