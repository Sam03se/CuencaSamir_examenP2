import interfaz.web;
import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new web().setVisible(true);
        });
    }
}
