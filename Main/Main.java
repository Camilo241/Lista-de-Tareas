package Main;

import Vista.VistaCategoria;
import Vista.VistaInterna;

public class Main {
    public static void main(String[] args) {
        VistaInterna vistaInterna = new Vista.VistaInterna();
        VistaCategoria vistaCategoria = new Vista.VistaCategoria();
        vistaCategoria.VistaAgregarCategoria();
        vistaInterna.VistaAgregarTarea();
    }
}
