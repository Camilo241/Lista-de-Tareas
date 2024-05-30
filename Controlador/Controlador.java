package Controlador;
import java.util.ArrayList;

import java.util.List;

import Modelo.Categoria;
import Modelo.Tarea;

public class Controlador {
    private List<Tarea> listaTareas;
    private List<Categoria> listaCategorias;

    public Controlador() {
        listaTareas = new ArrayList<>();
        listaCategorias = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        
        listaTareas.add(tarea);
        
    }

    public void agregarCategoria(Categoria categoria) {
        listaCategorias.add(categoria);
    }

    public List<Tarea> obtenerTareas() {
        return listaTareas;
    }

    public List<Categoria> obtenerCategorias() {
        return listaCategorias;
    }
}