package dao;

import model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO Pedido (idPedido, idProduto, quantidade, precoUnitario) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getIdPedido());
            stmt.setInt(2, pedido.getIdProduto());
            stmt.setInt(3, pedido.getQuantidade());
            stmt.setDouble(4, pedido.getPrecoUnitario());
            stmt.executeUpdate();
        }
    }

    public List<Pedido> listarPedidos() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM Pedido";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idPedido = rs.getInt("idPedido");
                int idProduto = rs.getInt("idProduto");
                int quantidade = rs.getInt("quantidade");
                double precoUnitario = rs.getDouble("precoUnitario");
                pedidos.add(new Pedido(idPedido, idProduto, quantidade, precoUnitario));
            }
        }
        return pedidos;
    }

    public void setDatabaseConnection(DatabaseMetaData databaseConnection) {
        DatabaseConnection = databaseConnection;
    }
}