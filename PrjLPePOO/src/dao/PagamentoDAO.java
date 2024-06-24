package dao;

import model.Pagamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarPagamento(Pagamento pagamento) throws SQLException {
        String sql = "INSERT INTO Pagamento (idPagamento, tipo, valor, dataHora, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pagamento.getIdPagamento());
            stmt.setString(2, pagamento.getTipo());
            stmt.setDouble(3, pagamento.getValor());
            stmt.setDate(4, new Date(pagamento.getDataHora().getTime()));
            stmt.setString(5, pagamento.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<Pagamento> listarPagamentos() throws SQLException {
        List<Pagamento> pagamentos = new ArrayList<>();
        String sql = "SELECT * FROM Pagamento";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idPagamento = rs.getInt("idPagamento");
                String tipo = rs.getString("tipo");
                double valor = rs.getDouble("valor");
                Date dataHora = rs.getDate("dataHora");
                String status = rs.getString("status");
                pagamentos.add(new Pagamento(idPagamento, tipo, valor, dataHora, status));
            }
        }
        return pagamentos;
    }
}