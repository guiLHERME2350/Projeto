import dao.FerramentaDAO;
import model.Ferramenta;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FerramentaDAO ferramentaDAO = new FerramentaDAO();
        List<Ferramenta> ferramentas = ferramentaDAO.listarFerramentas();

        System.out.println("=== FERRAMENTAS DISPONÍVEIS ===");
        for (Ferramenta f : ferramentas) {
            System.out.println(f);
        }
    }
}
