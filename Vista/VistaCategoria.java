package Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Controlador.Controlador;
import Modelo.Categoria;


public class VistaCategoria extends JFrame {
    private Controlador controlador;
    private JFrame ventana;
    private JPanel panel;
    private JButton CrearCategoria;
    private JButton Cancelar;
    private JTextField NombreCategoria;

    
    public VistaCategoria(Controlador controlador) {
        this.controlador = controlador;
    }
    public void VistaAgregarCategoria() {
        ventana = new JFrame("Categorias");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(new JLabel("Titulo de la Tarea")).setBounds(30, 25, 100, 25);
        NombreCategoria = new JTextField(20);
        NombreCategoria.setBounds(170, 25, 100, 25);
        CrearCategoria = new JButton("Crear Categoria");
        CrearCategoria.setBounds(125 ,120, 125, 25);
        Cancelar = new JButton("Cancelar");
        Cancelar.setBounds(15 ,120, 125, 25);

        panel = new JPanel();
        panel.setLayout(null);
        panel.add(NombreCategoria);
        panel.add(CrearCategoria);
        panel.add(Cancelar);
        ventana.add(panel);


        CrearCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCategoria();
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
    private void agregarCategoria() {
        String categoria = NombreCategoria.getText();

        if (!categoria.isEmpty()) {
            controlador.agregarCategoria(new Categoria(categoria));
            JOptionPane.showMessageDialog(this, "Categoría agregada correctamente");
            limpiarCampo();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingresa el nombre de la categoría");
        }
    }
    private void limpiarCampo() {
        NombreCategoria.setText("");
    }

}
