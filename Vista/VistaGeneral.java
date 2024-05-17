package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Tarea;

public class VistaGeneral {
    private JFrame ventana;
    private JPanel panel;
    private JButton boton;
    private JTextField campoTexto;
    private Tarea tarea;

    public void Vista() {
        ventana = new JFrame("Lista de Tareas");
        ventana.setSize(800 ,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        boton = new JButton("Agregar Tarea");
        boton.setBounds(300 ,150, 50, 50);
        campoTexto = new JTextField(20);

        panel.add(boton);
        panel.add(campoTexto);

        ventana.add(panel);

        ventana.setVisible(true);
    }
}
