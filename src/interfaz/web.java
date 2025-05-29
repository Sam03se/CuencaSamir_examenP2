package interfaz;

import estructura.ListaSimple;
import modelo.SpiderverseHero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class web extends JFrame {
    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JComboBox<String> comboPoder;
    private JComboBox<String> comboUniverso;
    private JComboBox<Integer> comboNivel;
    private JButton btnAgregar;
    private JTable tablaRegistro;

    private JTextField txtBuscarCodigo;
    private JButton btnBuscar;
    private JTextField txtResultadoNombre;
    private JTable tablaFiltrado;
    private JComboBox<String> comboFiltroPoder;
    private JButton btnFiltrar;
    private JButton btnFiltrarRecursivo;

    private ListaSimple lista = new ListaSimple();

    public web() {
        setContentPane(contentPane);
        setTitle("Gestión Spiderverse");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar combos
        inicializarCombos();

        // Modelo para la tabla principal
        DefaultTableModel modeloTabla = new DefaultTableModel(new String[]{
                "Código", "Nombre", "Poder", "Universo", "Nivel"
        }, 0);
        tablaRegistro.setModel(modeloTabla);

        // Evento agregar
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(txtCodigo.getText());
                String nombre = txtNombre.getText();
                String poder = (String) comboPoder.getSelectedItem();
                String universo = (String) comboUniverso.getSelectedItem();
                int nivel = (int) comboNivel.getSelectedItem();

                SpiderverseHero heroe = new SpiderverseHero(codigo, nombre, poder, universo, nivel);
                boolean agregado = lista.agregarHeroe(heroe);

                if (agregado) {
                    JOptionPane.showMessageDialog(null, "Héroe agregado correctamente.");
                    actualizarTablaRegistro();
                } else {
                    JOptionPane.showMessageDialog(null, "Código ya registrado.");
                }
            }
        });

        // Evento buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(txtBuscarCodigo.getText());
                SpiderverseHero h = lista.buscarPorCodigo(codigo);
                if (h != null) {
                    txtResultadoNombre.setText(h.getNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el héroe.");
                    txtResultadoNombre.setText("");
                }
            }
        });

        // Filtrar SIN el poder y ordenar por experiencia
        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String poder = (String) comboFiltroPoder.getSelectedItem();
                var resultado = lista.filtrarSinPoderYOrdenar(poder);
                mostrarTablaFiltrado(resultado);
            }
        });

        // Filtrar CON el poder usando recursividad
        btnFiltrarRecursivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String poder = (String) comboFiltroPoder.getSelectedItem();
                var resultado = new java.util.ArrayList<SpiderverseHero>();
                lista.filtrarPorPoderRecursivo(lista.getCabeza(), poder, resultado);
                mostrarTablaFiltrado(resultado);
            }
        });
    }

    private void inicializarCombos() {
        String[] poderes = {
                "Sentido Arácnido", "Trepa Muros", "Fuerza Sobrehumana", "Agilidad Mejorada", "Tejido de Telaraña"
        };
        String[] universos = {
                "Tierra-616", "Tierra-1610", "Tierra-12041", "Tierra-90214", "Tierra-138"
        };

        for (String poder : poderes) {
            comboPoder.addItem(poder);
            comboFiltroPoder.addItem(poder);
        }

        for (String universo : universos) {
            comboUniverso.addItem(universo);
        }

        for (int i = 1; i <= 5; i++) {
            comboNivel.addItem(i);
        }
    }

    private void actualizarTablaRegistro() {
        DefaultTableModel modelo = (DefaultTableModel) tablaRegistro.getModel();
        modelo.setRowCount(0); // limpiar tabla

        for (SpiderverseHero h : lista.obtenerTodos()) {
            modelo.addRow(new Object[]{
                    h.getCodigo(), h.getNombre(), h.getPoderEspecial(),
                    h.getUniverso(), h.getNivelExperiencia()
            });
        }
    }

    private void mostrarTablaFiltrado(java.util.ArrayList<SpiderverseHero> datos) {
        DefaultTableModel modelo = new DefaultTableModel(new String[]{
                "Código", "Nombre", "Poder", "Universo", "Nivel"
        }, 0);
        for (SpiderverseHero h : datos) {
            modelo.addRow(new Object[]{
                    h.getCodigo(), h.getNombre(), h.getPoderEspecial(),
                    h.getUniverso(), h.getNivelExperiencia()
            });
        }
        tablaFiltrado.setModel(modelo);
    }
}
