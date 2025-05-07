package dao;
import java.sql.*;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/nome_do_banco";
    private static final String USER = "usuario";
    private static final String PASSWORD = "senha";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
