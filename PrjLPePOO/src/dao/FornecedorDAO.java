package dao;

import model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarFornecedor(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO Fornecedor (idFornecedor, nome, endereco, telefone) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fornecedor.getIdFornecedor());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.executeUpdate();
        }
    }

    public List<Fornecedor> listarFornecedores() throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedor";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idFornecedor = rs.getInt("idFornecedor");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                fornecedores.add(new Fornecedor(idFornecedor, nome, endereco, telefone));
            }
        }
        return fornecedores;
    }
}