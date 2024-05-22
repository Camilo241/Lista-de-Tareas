package Vista;

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
    

    public void VistaAgregarTarea() {
        ventana = new JFrame("Lista de Tareas");
        ventana.setSize(300 ,200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        TituloTarea = new JTextField(10);
        TituloTarea.setBounds(170, 25, 100, 25);
        DescripcionTarea = new JTextField(10);
        DescripcionTarea.setBounds(170, 50, 100, 25);
        CategoriaTarea = new JComboBox();
        CategoriaTarea.setBounds(170, 75, 100, 25);

        panel = new JPanel();
        panel.setLayout(null);
        CrearTarea = new JButton("Agregar Tarea");
        CrearTarea.setBounds(125 ,120, 125, 25);
        Cancelar = new JButton("Cancelar");
        Cancelar.setBounds(15, 120, 100, 25);
        

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
            @Override
            public void actionPerformed(ActionEvent e) {
                String TituloTareas = TituloTarea.getText();
                String DescripcionTareas = DescripcionTarea.getText();
                String CategoriaTareas = (String) CategoriaTarea.getSelectedItem();
                
                Tarea tarea = new Tarea(TituloTareas,DescripcionTareas,CategoriaTareas);
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
}
