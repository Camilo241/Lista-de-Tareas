package Modelo;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private String Categoria;
    

    public Tarea(int id, String titulo, String descripcion, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        Categoria = categoria;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

}
