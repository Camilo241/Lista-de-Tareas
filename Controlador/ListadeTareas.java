package Controlador;

import java.util.ArrayList;

import Modelo.Tarea;

public class ListadeTareas{

    ArrayList<Tarea> Tarea = new ArrayList<Tarea>();

    public void addTarea(Tarea tarea) {
        Tarea.add(tarea);
    }
    
    public void removeTarea(Tarea tarea) {
        Tarea.remove(tarea);
    }


    public ArrayList<Tarea> getTarea() {
        return Tarea;
    }
    
}