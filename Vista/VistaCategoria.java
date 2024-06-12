package Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Controlador.ControladorCategoria;
import Modelo.Categoria;


public class VistaCategoria extends JFrame {
    private ControladorCategoria controladorCategoria;
    private VistaTarea vistaTarea;
    private JFrame ventana;
    private JPanel panel;
    private JButton CrearCategoria;
    private JButton Cancelar;
    private JTextField NombreCategoria;
    private JTextField EstadoCategoria;


    
    public VistaCategoria(ControladorCategoria controladorCategoria,VistaTarea vistaTarea) {
        this.vistaTarea = vistaTarea;
        this.controladorCategoria = controladorCategoria;
    }
    public void VistaAgregarCategoria() {
        ventana = new JFrame("Categorias");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarComponentes();
        setLocationRelativeTo(null);
    }
    public void inicializarComponentes(){
        setLocationRelativeTo(null);
        panel = new JPanel();
        panel.add(new JLabel("Titulo de la Categoria")).setBounds(30, 25, 120, 25);
        NombreCategoria = new JTextField(20);
        NombreCategoria.setBounds(170, 25, 100, 25);
        EstadoCategoria = new JTextField(20);
        EstadoCategoria.setBounds(170, 50, 100, 25);
        CrearCategoria = new JButton("Crear Categoria");
        CrearCategoria.setBounds(125 ,120, 125, 25);
        Cancelar = new JButton("Cancelar");
        Cancelar.setBounds(15 ,120, 100, 25);

        
        panel.setLayout(null);
        panel.add(NombreCategoria);
        panel.add(EstadoCategoria);
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
        String categoriaN = NombreCategoria.getText();
        String categoriaE = EstadoCategoria.getText();
        boolean estadoCategoria = categoriaE.equalsIgnoreCase("true");  
        if (!categoriaN.isEmpty() ) {
            controladorCategoria.agregarCategoria(categoriaN,estadoCategoria);
            JOptionPane.showMessageDialog(this, "Categoría agregada correctamente");            
            vistaTarea.actualizarCategorias();
            limpiarCampo();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingresa el nombre de la categoría");
        }
    }
    private void limpiarCampo() {
        NombreCategoria.setText("");
        EstadoCategoria.setText("");
    }

}
