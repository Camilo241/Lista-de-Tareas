package Main;

import javax.swing.SwingUtilities;

import Controlador.ControladorCategoria;
import Controlador.ControladorTarea;
import Vista.VistaGeneral;
import Vista.VistaTarea;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControladorTarea controladorTarea = new ControladorTarea();
            ControladorCategoria controladorCategoria = new ControladorCategoria();
            VistaTarea vistaTarea = new VistaTarea(controladorTarea, controladorCategoria);

            VistaGeneral vistaGeneral = new VistaGeneral(controladorTarea, controladorCategoria, vistaTarea);
            vistaGeneral.VistaGeneralListar();

        });
    }
}
