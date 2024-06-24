import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/meu_banco";
    private static final String USUARIO = "root";
    private static final String SENHA = "2424";

    private static Connection conexao;

    public static Connection obterConexao() {
        if (conexao == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                // Trate a exceção de acordo com sua aplicação
            }
        }
        return conexao;
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Trate a exceção de fechamento da conexão
            }
        }
    }
}
