import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class InventarioApp extends JFrame {

    private JTextField nomeField, quantidadeField;
    private JTextArea inventarioArea;

    public InventarioApp() {
        setTitle("Sistema de Inventário");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        nomeField = new JTextField(20);
        quantidadeField = new JTextField(5);
        inventarioArea = new JTextArea(10, 30);
        inventarioArea.setEditable(false);

        JButton inserirButton = new JButton("Inserir Produto");
        JButton listarButton = new JButton("Listar Inventário");

        inserirButton.addActionListener(e -> inserirProduto());
        listarButton.addActionListener(e -> listarInventario());

        add(new JLabel("Nome do Produto:"));
        add(nomeField);
        add(new JLabel("Quantidade:"));
        add(quantidadeField);
        add(inserirButton);
        add(listarButton);
        add(new JScrollPane(inventarioArea));
    }

    private void inserirProduto() {
        try (Connection conn = ConnectionDatabase.getConnection()) {
            String sql = "INSERT INTO inventario (nome_produto, quantidade) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeField.getText());
            stmt.setInt(2, Integer.parseInt(quantidadeField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Produto inserido!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void listarInventario() {
        try (Connection conn = ConnectionDatabase.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventario");
            inventarioArea.setText("");
            while (rs.next()) {
                inventarioArea.append("ID: " + rs.getInt("id") +
                        ", Produto: " + rs.getString("nome_produto") +
                        ", Quantidade: " + rs.getInt("quantidade") + "\n");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventarioApp().setVisible(true));
    }
}
