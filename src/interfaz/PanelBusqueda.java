package interfaz;

import javax.swing.*;

public class PanelBusqueda extends JPanel {

    public JTextField txtBuscarCodigo;
    public JButton btnBuscar;
    public JTextField txtResultadoNombre;
    public JTextField txtResultadoPoder;
    public JTextField txtResultadoUniverso;
    public JTextField txtResultadoNivel;

    public PanelBusqueda() {
        setLayout(null); // Puedes cambiarlo por otro layout si prefieres

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 20, 100, 25);
        add(lblCodigo);

        txtBuscarCodigo = new JTextField();
        txtBuscarCodigo.setBounds(140, 20, 150, 25);
        add(txtBuscarCodigo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(310, 20, 100, 25);
        add(btnBuscar);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 60, 100, 25);
        add(lblNombre);

        txtResultadoNombre = new JTextField();
        txtResultadoNombre.setBounds(140, 60, 270, 25);
        txtResultadoNombre.setEditable(false);
        add(txtResultadoNombre);

        JLabel lblPoder = new JLabel("Poder Especial:");
        lblPoder.setBounds(30, 100, 100, 25);
        add(lblPoder);

        txtResultadoPoder = new JTextField();
        txtResultadoPoder.setBounds(140, 100, 270, 25);
        txtResultadoPoder.setEditable(false);
        add(txtResultadoPoder);

        JLabel lblUniverso = new JLabel("Universo:");
        lblUniverso.setBounds(30, 140, 100, 25);
        add(lblUniverso);

        txtResultadoUniverso = new JTextField();
        txtResultadoUniverso.setBounds(140, 140, 270, 25);
        txtResultadoUniverso.setEditable(false);
        add(txtResultadoUniverso);

        JLabel lblNivel = new JLabel("Nivel de Experiencia:");
        lblNivel.setBounds(30, 180, 150, 25);
        add(lblNivel);

        txtResultadoNivel = new JTextField();
        txtResultadoNivel.setBounds(180, 180, 230, 25);
        txtResultadoNivel.setEditable(false);
        add(txtResultadoNivel);
    }
}
