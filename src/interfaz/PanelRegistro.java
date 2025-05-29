package interfaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelRegistro extends JPanel {
    public JTextField txtCodigo;
    public JTextField txtNombre;
    public JComboBox<String> comboPoder;
    public JComboBox<String> comboUniverso;
    public JComboBox<Integer> comboNivel;
    public JButton btnAgregar;
    public JTable tablaRegistro;
    private JPanel panelRegistro;

    public PanelRegistro() {
        setLayout(null); // Puedes usar otro layout si prefieres

        txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 150, 25);
        add(txtCodigo);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 150, 25);
        add(txtNombre);

        comboPoder = new JComboBox<>();
        comboPoder.setBounds(120, 100, 150, 25);
        add(comboPoder);

        comboUniverso = new JComboBox<>();
        comboUniverso.setBounds(120, 140, 150, 25);
        add(comboUniverso);

        comboNivel = new JComboBox<>();
        comboNivel.setBounds(120, 180, 150, 25);
        add(comboNivel);

        btnAgregar = new JButton("Agregar Héroe");
        btnAgregar.setBounds(120, 220, 150, 30);
        add(btnAgregar);

        tablaRegistro = new JTable(new DefaultTableModel(
                new String[]{"Código", "Nombre", "Poder", "Universo", "Nivel"}, 0
        ));
        JScrollPane scroll = new JScrollPane(tablaRegistro);
        scroll.setBounds(300, 20, 450, 230);
        add(scroll);
    }
}
