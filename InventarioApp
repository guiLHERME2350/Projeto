import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class InventarioApp extends JFrame {

    private JTextField idField, nomeField, quantidadeField;
    private JTextArea inventarioArea;

    public InventarioApp() {
        setTitle("Sistema de Inventário");
        setSize(450, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        idField = new JTextField(5);
        nomeField = new JTextField(20);
        quantidadeField = new JTextField(5);
        inventarioArea = new JTextArea(15, 35);
        inventarioArea.setEditable(false);

        JButton inserirButton = new JButton("Inserir Produto");
        JButton listarButton = new JButton("Listar Inventário");
        JButton alterarButton = new JButton("Alterar Produto");

        inserirButton.addActionListener(e -> inserirProduto());
        listarButton.addActionListener(e -> listarInventario());
        alterarButton.addActionListener(e -> alterarProduto());

        add(new JLabel("ID do Produto (para alterar):"));
        add(idField);
        add(new JLabel("Nome do Produto:"));
        add(nomeField);
        add(new JLabel("Quantidade:"));
        add(quantidadeField);
        add(inserirButton);
        add(alterarButton);
        add(listarButton);
        add(new JScrollPane(inventarioArea));
    }

    private void inserirProduto() {
        ConnectionDatabase db = new ConnectionDatabase();
        try (Connection conn = db.getConnection()) {
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
        ConnectionDatabase db = new ConnectionDatabase();
        try (Connection conn = db.getConnection()) {
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

    private void alterarProduto() {
        ConnectionDatabase db = new ConnectionDatabase();
        try (Connection conn = db.getConnection()) {
            String sql = "UPDATE inventario SET nome_produto = ?, quantidade = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeField.getText());
            stmt.setInt(2, Integer.parseInt(quantidadeField.getText()));
            stmt.setInt(3, Integer.parseInt(idField.getText()));
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "ID não encontrado.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventarioApp().setVisible(true));
    }
}
