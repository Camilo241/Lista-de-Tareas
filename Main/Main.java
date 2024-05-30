package Main;

import javax.swing.SwingUtilities;

import Controlador.Controlador;
import Vista.VistaGeneral;
import Vista.VistaTarea;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Controlador controlador = new Controlador();
            VistaTarea vistaTarea = new VistaTarea(controlador);

            VistaGeneral vistaGeneral = new VistaGeneral(controlador,vistaTarea);
            vistaGeneral.VistaGeneralListar();

        });
    }
}
