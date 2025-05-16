import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sistemadeinventario";
        String user = "root";                          
        String password = "";                        

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conexão bem-sucedida com o banco de dados!");
            conn.close();
        } catch (SQLException ex) {
            System.out.println("❌ Erro ao conectar: " + ex.getMessage());
        }
    }
}
