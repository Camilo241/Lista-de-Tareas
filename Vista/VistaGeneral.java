package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Tarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



public class VistaGeneral extends JFrame {
    private Controlador controlador;
    private JTable tablaTareas;
    private DefaultTableModel modeloTabla;
    private JButton AgregarTarea, AgregarCategoria;

    public VistaGeneral(Controlador controlador) {
        this.controlador = controlador;

        setTitle("Lista de Tareas");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarComponentes();
        actualizarTabla();
    }

    private void inicializarComponentes() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);

        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Categoria");

        tablaTareas = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tablaTareas);
        scrollPane.setBounds(30, 30, 550, 300);
        panelPrincipal.add(scrollPane);
        
        
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
    }

    private void actualizarTabla() {
        
        List<Tarea> tareas = controlador.obtenerTareas();
        for (Tarea tarea : tareas) {
            modeloTabla.addRow(new Object[]{tarea.getFecha(), tarea.getTitulo(), tarea.getDescripcion(), tarea.getCategoria()});
        }
    }

    

    private void abrirVistaTarea() {
        VistaTarea vistaTarea = new VistaTarea(controlador);
        vistaTarea.setVisible(true);
        
    }

    private void abrirVistaCategoria() {
        VistaCategoria vistaCategoria = new VistaCategoria(controlador);
        vistaCategoria.setVisible(true);
    }
}