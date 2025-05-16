import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sistemadeinventario"; // Substitua pelo nome do seu banco
        String user = "Guilherme";                          // Substitua pelo seu usuário
        String password = "";                        // Substitua pela sua senha

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conexão bem-sucedida com o banco de dados!");
            conn.close();
        } catch (SQLException ex) {
            System.out.println("❌ Erro ao conectar: " + ex.getMessage());
        }
    }
}
