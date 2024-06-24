package dao;

import model.Estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarEstoque(Estoque estoque) throws SQLException {
        String sql = "INSERT INTO Estoque (idEstoque, idProduto, idFornecedor, quantidadeTotal, dataAtualizacao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, estoque.getIdEstoque());
            stmt.setInt(2, estoque.getIdProduto());
            stmt.setInt(3, estoque.getIdFornecedor());
            stmt.setInt(4, estoque.getQuantidadeTotal());
            stmt.setDate(5, new Date(estoque.getDataAtualizacao().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Estoque> listarEstoques() throws SQLException {
        List<Estoque> estoques = new ArrayList<>();
        String sql = "SELECT * FROM Estoque";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idEstoque = rs.getInt("idEstoque");
                int idProduto = rs.getInt("idProduto");
                int idFornecedor = rs.getInt("idFornecedor");
                int quantidadeTotal = rs.getInt("quantidadeTotal");
                Date dataAtualizacao = rs.getDate("dataAtualizacao");
                estoques.add(new Estoque(idEstoque, idProduto, idFornecedor, quantidadeTotal, dataAtualizacao));
            }
        }
        return estoques;
    }
}