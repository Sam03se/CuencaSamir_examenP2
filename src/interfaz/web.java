package interfaz;

import modelo.SpiderverseHero;
import estructura.ListaSimple;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class web extends JFrame {
    private JPanel contentPane;
    private JTabbedPane tabbedPane;

    private ListaSimple lista = new ListaSimple();

    public web() {
        setTitle("Sistema de Gestión Spiderverse");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Panel raíz
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);

        // TabbedPane
        tabbedPane = new JTabbedPane();
        contentPane.add(tabbedPane);

        // Paneles
        PanelRegistro panelRegistro = new PanelRegistro();
        PanelBusqueda panelBusqueda = new PanelBusqueda();
        PanelFiltrado panelFiltrado = new PanelFiltrado();

        tabbedPane.addTab("Registro", panelRegistro);
        tabbedPane.addTab("Búsqueda", panelBusqueda);
        tabbedPane.addTab("Filtrado", panelFiltrado);

        // Llenar combos
        String[] poderes = {
                "Sentido Arácnido", "Trepa Muros", "Fuerza Sobrehumana",
                "Agilidad Mejorada", "Tejido de Telaraña"
        };
        String[] universos = {
                "Tierra-616", "Tierra-1610", "Tierra-12041",
                "Tierra-90214", "Tierra-138"
        };

        for (String poder : poderes) {
            panelRegistro.comboPoder.addItem(poder);
            panelFiltrado.comboFiltroPoder.addItem(poder);
        }
        for (String universo : universos) {
            panelRegistro.comboUniverso.addItem(universo);
        }
        for (int i = 1; i <= 5; i++) {
            panelRegistro.comboNivel.addItem(i);
        }

        // === REGISTRO ===
        panelRegistro.btnAgregar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(panelRegistro.txtCodigo.getText().trim());
                String nombre = panelRegistro.txtNombre.getText().trim();
                String poder = (String) panelRegistro.comboPoder.getSelectedItem();
                String universo = (String) panelRegistro.comboUniverso.getSelectedItem();
                int nivel = (int) panelRegistro.comboNivel.getSelectedItem();

                SpiderverseHero nuevo = new SpiderverseHero(codigo, nombre, poder, universo, nivel);
                boolean agregado = lista.agregarHeroe(nuevo);

                if (agregado) {
                    JOptionPane.showMessageDialog(null, "Héroe agregado correctamente.");
                    actualizarTablaRegistro(panelRegistro);
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un héroe con ese código.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en los datos ingresados.");
            }
        });

        // === BÚSQUEDA COMPLETA ===
        panelBusqueda.btnBuscar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(panelBusqueda.txtBuscarCodigo.getText().trim());
                SpiderverseHero encontrado = lista.buscarPorCodigo(codigo);

                if (encontrado != null) {
                    panelBusqueda.txtResultadoNombre.setText(encontrado.getNombre());
                    panelBusqueda.txtResultadoPoder.setText(encontrado.getPoderEspecial());
                    panelBusqueda.txtResultadoUniverso.setText(encontrado.getUniverso());
                    panelBusqueda.txtResultadoNivel.setText(String.valueOf(encontrado.getNivelExperiencia()));
                } else {
                    JOptionPane.showMessageDialog(null, "Héroe no encontrado.");
                    limpiarCamposBusqueda(panelBusqueda);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Código inválido.");
            }
        });

        // === FILTRADO NO TIENEN PODER ===
        panelFiltrado.btnFiltrar.addActionListener(e -> {
            String poderSeleccionado = (String) panelFiltrado.comboFiltroPoder.getSelectedItem();
            ArrayList<SpiderverseHero> resultado = lista.filtrarSinPoderYOrdenar(poderSeleccionado);
            actualizarTablaFiltrado(panelFiltrado, resultado);
        });

        // === FILTRADO RECURSIVO TIENEN PODER ===
        panelFiltrado.btnFiltrarRecursivo.addActionListener(e -> {
            String poderSeleccionado = (String) panelFiltrado.comboFiltroPoder.getSelectedItem();
            ArrayList<SpiderverseHero> resultado = new ArrayList<>();
            lista.filtrarPorPoderRecursivo(lista.getCabeza(), poderSeleccionado, resultado);
            actualizarTablaFiltrado(panelFiltrado, resultado);
        });
    }

    // Método para actualizar tabla en registro
    private void actualizarTablaRegistro(PanelRegistro panel) {
        DefaultTableModel model = (DefaultTableModel) panel.tablaRegistro.getModel();
        model.setRowCount(0);
        for (SpiderverseHero h : lista.obtenerTodos()) {
            model.addRow(new Object[]{
                    h.getCodigo(), h.getNombre(), h.getPoderEspecial(),
                    h.getUniverso(), h.getNivelExperiencia()
            });
        }
    }

    // Método para actualizar tabla en filtrado
    private void actualizarTablaFiltrado(PanelFiltrado panel, ArrayList<SpiderverseHero> datos) {
        DefaultTableModel model = (DefaultTableModel) panel.tablaFiltrado.getModel();
        model.setRowCount(0);
        for (SpiderverseHero h : datos) {
            model.addRow(new Object[]{
                    h.getCodigo(), h.getNombre(), h.getPoderEspecial(),
                    h.getUniverso(), h.getNivelExperiencia()
            });
        }
    }

    // Limpiar campos si el héroe no fue encontrado
    private void limpiarCamposBusqueda(PanelBusqueda panel) {
        panel.txtResultadoNombre.setText("");
        panel.txtResultadoPoder.setText("");
        panel.txtResultadoUniverso.setText("");
        panel.txtResultadoNivel.setText("");
    }
}
