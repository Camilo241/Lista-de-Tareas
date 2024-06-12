package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controlador.ControladorCategoria;
import Controlador.ControladorTarea;
import Modelo.Categoria;
import Modelo.Tarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



public class VistaGeneral extends JFrame {
    private ControladorTarea controladorTarea;
    private ControladorCategoria controladorCategoria;
    private VistaTarea vistaTarea;
    private JFrame ventana;
    private JTable tablaTareas;
    private DefaultTableModel modeloTabla;
    private JButton AgregarTarea, AgregarCategoria;


    public VistaGeneral(ControladorTarea controladorTarea,ControladorCategoria controladorCategoria,VistaTarea vistaTarea) {
        this.vistaTarea = vistaTarea;
        this.controladorTarea = controladorTarea;
        this.controladorCategoria = controladorCategoria;
        
    }
    public  void VistaGeneralListar() {
        setLocationRelativeTo(null);

        ventana = new JFrame("Lista de Tareas");
        ventana.setSize(800, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarComponentes();
        actualizarTabla();
    }

    private void inicializarComponentes() {
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);

        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Titulo");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Categoria");
        modeloTabla.addColumn("Estado");

        tablaTareas = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tablaTareas);
        scrollPane.setBounds(30, 30, 550, 300);
        panelPrincipal.add(scrollPane);
        
        TableColumn categoriaColumn = tablaTareas.getColumnModel().getColumn(3);
        JComboBox<String> comboBoxCategorias = new JComboBox<>();
        List<Categoria> categorias = controladorCategoria.cargarCategorias();
        for (Categoria categoria : categorias) {
            comboBoxCategorias.addItem(categoria.getNombreCategoria());
        }
        categoriaColumn.setCellEditor(new DefaultCellEditor(comboBoxCategorias));

        AgregarTarea = new JButton("Agregar Tarea");
        AgregarTarea.setBounds(600 ,50, 165, 25);
        AgregarTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVistaTarea();
                
            }
        });
        panelPrincipal.add(AgregarTarea);

        
        AgregarCategoria = new JButton("Agregar Categoría");
        AgregarCategoria.setBounds(600, 80, 165, 25);
        AgregarCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVistaCategoria();
            }
        });
        panelPrincipal.add(AgregarCategoria);

        setContentPane(panelPrincipal);
        ventana.add(panelPrincipal);

        ventana.setVisible(true);
    }

    private void actualizarTabla() {
        List<Tarea> tareas = controladorTarea.obtenerTareas();
        for (Tarea tarea : tareas) {
            modeloTabla.addRow(new Object[]{tarea.getFecha(), tarea.getTitulo(), tarea.getDescripcion(), tarea.getCategoria(), tarea.isEstado()});
        }
    }

    

    private void abrirVistaTarea() {
        VistaTarea vistaTarea = new VistaTarea(controladorTarea,controladorCategoria);
        vistaTarea.VistaAgregarTarea();
        
        
    }

    private void abrirVistaCategoria() {
        VistaCategoria vistaCategoria = new VistaCategoria(controladorCategoria, vistaTarea);
        vistaCategoria.VistaAgregarCategoria();
    }
}