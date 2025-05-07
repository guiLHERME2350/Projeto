package dao;

import model.Ferramenta;
import java.sql.*;
import java.util.*;

public class FerramentaDAO {
    public List<Ferramenta> listarFerramentas() {
        List<Ferramenta> lista = new ArrayList<>();
        String sql = "SELECT id_ferramenta, nome, marca, preco_custo FROM Ferramentas";

        try (Connection conn = Conexao.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ferramenta f = new Ferramenta(
                    rs.getInt("id_ferramenta"),
                    rs.getString("nome"),
                    rs.getString("marca"),
                    rs.getDouble("preco_custo")
                );
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
