package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Modelo.Categorias;
import Modelo.Tarea;

public class VistaInterna {
    private JFrame ventana;
    private JPanel panel;
    private JButton CrearTarea;
    private JButton Cancelar;
    private JTextField TituloTarea;
    private JTextField DescripcionTarea;
    private JComboBox CategoriaTarea;
    

    public void Vista() {
        ventana = new JFrame("Lista de Tareas");
        ventana.setSize(200 ,200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ventana.setLayout(new BorderLayout());

        TituloTarea = new JTextField(20);
        TituloTarea.setBounds(300, 150, 50, 50);
        DescripcionTarea = new JTextField(20);
        DescripcionTarea.setBounds(300, 150, 50, 50);
        CategoriaTarea = new JComboBox();
        CategoriaTarea.setBounds(300, 150, 100, 50);

        panel = new JPanel();
        CrearTarea = new JButton("Agregar Tarea");
        CrearTarea.setBounds(300 ,150, 5, 25);
        // panel.setLayout(new GridLayout(2, 1, 10, 10));

        panel.add(new JLabel("Titulo de la Tarea"));
        panel.add(TituloTarea);
        panel.add(new JLabel("Descripcion de la Tarea"));
        panel.add(DescripcionTarea);
        panel.add(new JLabel("Categoria de la Tarea"));
        panel.add(CategoriaTarea);

        panel.add(CrearTarea);
        panel.add(Cancelar);

        ventana.add(panel);

        CrearTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TituloTareas = TituloTarea.getText();
                String DescripcionTareas = DescripcionTarea.getText();
                String CategoriaTareas = (String) CategoriaTarea.getSelectedItem();
                
                Tarea tarea = new Tarea(TituloTareas,DescripcionTareas,CategoriaTareas);
            }
        });

        ventana.setVisible(true);
    }
}
