package Main;

import javax.swing.SwingUtilities;

import Controlador.Controlador;
import Modelo.Categoria;
import Vista.VistaCategoria;
import Vista.VistaTarea;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Controlador controlador = new Controlador();

            // Crear y mostrar las vistas
            VistaGeneral vistaGeneral = new VistaGeneral(controlador);
            vistaGeneral.setVisible(true);

            VistaTarea vistaAgregarTarea = new VistaTarea(controlador);
            

            VistaCategoria vistaCategoria = new VistaCategoria(controlador);
            
        });
    }
}
