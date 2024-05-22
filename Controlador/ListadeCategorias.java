package Controlador;

import java.util.ArrayList;

public class ListadeCategorias {

    ArrayList <String> Categoria = new ArrayList<String>();


    public ListadeCategorias(ArrayList<String> categoria) {
        Categoria = categoria;
    }

    public void addCategoria(String categoria) {
        Categoria.add(categoria);
    }
    
    public void removeCategoria(String categoria) {
        Categoria.remove(categoria);
    }

    public ArrayList<String> getCategoria() {
        return Categoria;
    }
}
