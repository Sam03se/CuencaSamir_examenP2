package interfaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelFiltrado extends JPanel {
    public JComboBox<String> comboFiltroPoder;
    public JButton btnFiltrar;
    public JButton btnFiltrarRecursivo;
    public JTable tablaFiltrado;
    private JPanel panelFiltrado;

    public PanelFiltrado() {
        setLayout(null);

        comboFiltroPoder = new JComboBox<>();
        comboFiltroPoder.setBounds(30, 30, 200, 25);
        add(comboFiltroPoder);

        btnFiltrar = new JButton("Filtrar y Ordenar");
        btnFiltrar.setBounds(250, 30, 160, 25);
        add(btnFiltrar);

        btnFiltrarRecursivo = new JButton("Filtrar Recursivo");
        btnFiltrarRecursivo.setBounds(420, 30, 160, 25);
        add(btnFiltrarRecursivo);

        tablaFiltrado = new JTable(new DefaultTableModel(
                new String[]{"Código", "Nombre", "Poder", "Universo", "Nivel"}, 0
        ));
        JScrollPane scroll = new JScrollPane(tablaFiltrado);
        scroll.setBounds(30, 70, 550, 200);
        add(scroll);
    }
}
