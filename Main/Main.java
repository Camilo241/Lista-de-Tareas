package Main;

import javax.swing.SwingUtilities;

import Controlador.Controlador;
import Vista.VistaGeneral;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Controlador controlador = new Controlador();

            VistaGeneral vistaGeneral = new VistaGeneral(controlador);
            vistaGeneral.VistaGeneralListar();

        });
    }
}
