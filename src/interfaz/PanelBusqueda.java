package interfaz;

import javax.swing.*;

public class PanelBusqueda extends JPanel {
    public JTextField txtBuscarCodigo;
    public JButton btnBuscar;
    public JTextField txtResultadoNombre;
    private JTextField txtResultadoPoder;
    private JTextField txtResultadoUniverso;
    private JTextField txtResultadoNivel;
    private JPanel panelBusqueda;

    public PanelBusqueda() {
        setLayout(null);

        txtBuscarCodigo = new JTextField();
        txtBuscarCodigo.setBounds(30, 30, 150, 25);
        add(txtBuscarCodigo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(200, 30, 100, 25);
        add(btnBuscar);

        txtResultadoNombre = new JTextField();
        txtResultadoNombre.setBounds(30, 70, 270, 25);
        txtResultadoNombre.setEditable(false);
        add(txtResultadoNombre);
    }
}
