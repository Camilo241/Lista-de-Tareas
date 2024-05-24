package Main;

import javax.swing.SwingUtilities;

import Controlador.Controlador;
import Vista.VistaCategoria;
import Vista.VistaGeneral;
import Vista.VistaTarea;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Controlador controlador = new Controlador();

            // Crear y mostrar las vistas
            VistaGeneral vistaGeneral = new VistaGeneral(controlador);
            vistaGeneral.setVisible(true);

            VistaTarea vistaTarea = new VistaTarea(controlador);
            vistaTarea.setVisible(true);
            

            VistaCategoria vistaCategoria = new VistaCategoria(controlador);
            vistaCategoria.setVisible(true);
                        
        });
    }
}
