package model;

public class Cardapio {
    private int idCardapio;
    private int idProduto;
    private int idCliente;
    private String categorias;

    public Cardapio(int idCardapio, int idProduto, int idCliente, String categorias, String comentario) {
        this.idCardapio = idCardapio;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.categorias = categorias;
    }

    public int getIdCardapio() {
        return idCardapio;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setIdCardapio(int idCardapio) {
        this.idCardapio = idCardapio;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

}