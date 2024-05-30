package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.*;

import Controlador.Controlador;
import Modelo.Categoria;
import Modelo.Tarea;

public class VistaTarea extends JFrame{
    private Controlador controlador;
    private JFrame ventana;
    private JPanel panel;
    private JButton CrearTarea;
    private JButton Cancelar;
    private JTextField TituloTarea;
    private JTextField DescripcionTarea;
    private JComboBox<String> CategoriaTarea;
    
    public VistaTarea(Controlador controlador) {
        this.controlador = controlador;
    }

    public void VistaAgregarTarea() {
        ventana = new JFrame("Lista de Tareas");
        ventana.setSize(300 ,200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        cargarCategorias();
        setLocationRelativeTo(null);
    }


    private void inicializarComponentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        CrearTarea = new JButton("Agregar Tarea");
        CrearTarea.setBounds(125 ,120, 125, 25);
        Cancelar = new JButton("Cancelar");
        Cancelar.setBounds(15, 120, 100, 25);
        TituloTarea = new JTextField(10);
        TituloTarea.setBounds(170, 25, 100, 25);
        DescripcionTarea = new JTextField(10);
        DescripcionTarea.setBounds(170, 50, 100, 25);
        CategoriaTarea = new JComboBox<>();
        CategoriaTarea.setBounds(170, 75, 100, 25);


        panel.add(new JLabel("Titulo de la Tarea")).setBounds(30, 25, 100, 25);
        panel.add(TituloTarea);
        panel.add(new JLabel("Descripcion de la Tarea")).setBounds(30, 50, 150, 25);
        panel.add(DescripcionTarea);
        panel.add(new JLabel("Categoria de la Tarea")).setBounds(30, 75, 150, 25);
        panel.add(CategoriaTarea);

        panel.add(CrearTarea);
        panel.add(Cancelar);

        ventana.add(panel);

        CrearTarea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarTarea();
            }
        });
        Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
            }
        });

        ventana.setVisible(true);
    }

    private void cargarCategorias() {

        if (CategoriaTarea == null) {
            System.out.println("comboBoxCategorias es null en cargarCategorias");
            return;
        }

        List<Categoria> categorias = controlador.obtenerCategorias();
        
        for (Categoria categoria : categorias) {
            CategoriaTarea.addItem(categoria.getNombreCategoria());
        }
        

    }

    public void actualizarCategorias() {
        cargarCategorias(); 
    }

    private void agregarTarea() {
        
        String titulo = TituloTarea.getText();
        String descripcion = DescripcionTarea.getText();
        String categoria = (String) CategoriaTarea.getSelectedItem();
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!titulo.isEmpty() && !descripcion.isEmpty()) {
            controlador.agregarTarea(new Tarea(fechaActual, titulo, descripcion, categoria));
            JOptionPane.showMessageDialog(this, "Tarea agregada correctamente");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos");
        }
    }

    private void limpiarCampos() {
        TituloTarea.setText("");
        DescripcionTarea.setText("");
        CategoriaTarea.setSelectedIndex(0);
    }

    
}
