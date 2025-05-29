package interfaz;

import javax.swing.*;

public class web extends JFrame {
    private JPanel contentPane;
    private JTabbedPane tabbedPane;

    public web() {
        // Configuración base de la ventana
        setTitle("Sistema de Gestión Spiderverse");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Inicializar panel principal
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);

        // Crear y agregar el JTabbedPane
        tabbedPane = new JTabbedPane();
        contentPane.add(tabbedPane);

        // Crear paneles individuales
        PanelRegistro panelRegistro = new PanelRegistro();
        PanelBusqueda panelBusqueda = new PanelBusqueda();
        PanelFiltrado panelFiltrado = new PanelFiltrado();

        // Agregar pestañas
        tabbedPane.addTab("Registro", panelRegistro);
        tabbedPane.addTab("Búsqueda", panelBusqueda);
        tabbedPane.addTab("Filtrado", panelFiltrado);
    }
}
