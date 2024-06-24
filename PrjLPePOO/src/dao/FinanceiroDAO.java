package dao;

import model.Financeiro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceiroDAO {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarFinanceiro(Financeiro financeiro) throws SQLException {
        String sql = "INSERT INTO Financeiro (idPagamento, valor, tipo, dataHora) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, financeiro.getIdPagamento());
            stmt.setDouble(2, financeiro.getValor());
            stmt.setString(3, financeiro.getTipo());
            stmt.setDate(4, new Date(financeiro.getDataHora().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Financeiro> listarFinanceiros() throws SQLException {
        List<Financeiro> financeiros = new ArrayList<>();
        String sql = "SELECT * FROM Financeiro";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idPagamento = rs.getInt("idPagamento");
                double valor = rs.getDouble("valor");
                String tipo = rs.getString("tipo");
                Date dataHora = rs.getDate("dataHora");
                financeiros.add(new Financeiro(idPagamento, valor, tipo, dataHora));
            }
        }
        return financeiros;
    }
}