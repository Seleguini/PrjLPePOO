package dao;

import model.Mesa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MesaDAO {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarVenda(Mesa mesa) throws SQLException {
        String sql = "INSERT INTO Venda (idVenda, idPedido, idFuncionario, idCliente, dataVenda, valorTotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, mesa.getIdVenda());
            stmt.setInt(2, mesa.getIdPedido());
            stmt.setInt(3, mesa.getIdFuncionario());
            stmt.setInt(4, mesa.getIdCliente());
            stmt.setDate(5, new Date(mesa.getDataVenda().getTime()));
            stmt.setDouble(6, mesa.getValorTotal());
            stmt.executeUpdate();
        }
    }

    public List<Mesa> listarVendas() throws SQLException {
        List<Mesa> mesas = new ArrayList<>();
        String sql = "SELECT * FROM Venda";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idVenda = rs.getInt("idVenda");
                int idPedido = rs.getInt("idPedido");
                int idFuncionario = rs.getInt("idFuncionario");
                int idCliente = rs.getInt("idCliente");
                Date dataVenda = rs.getDate("dataVenda");
                double valorTotal = rs.getDouble("valorTotal");
                mesas.add(new Mesa(idVenda, idPedido, idFuncionario, idCliente, dataVenda, valorTotal));
            }
        }
        return mesas;
    }
}