package dao;

import model.Cardapio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardapioDAO {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarAvaliacao(Cardapio cardapio) throws SQLException {
        String sql = "INSERT INTO Avaliacao (id, idProduto, idCliente, categorias) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cardapio.getIdCardapio());
            stmt.setInt(2, cardapio.getIdProduto());
            stmt.setInt(3, cardapio.getIdCliente());
            stmt.setString(4, cardapio.getCategorias());
            stmt.executeUpdate();
        }
    }

    public List<Cardapio> listarCardapio() throws SQLException {
        List<Cardapio> cardapio = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int idProduto = rs.getInt("idProduto");
                int idCliente = rs.getInt("idCliente");
                String categorias = rs.getString("categorias");
            }
        }
        return cardapio;
    }

    public List<Cardapio> listarProdutosPorCardapio(int idProduto) {
        return null;
    }


    // Métodos para atualizar e deletar avaliações podem ser adicionados aqui
}