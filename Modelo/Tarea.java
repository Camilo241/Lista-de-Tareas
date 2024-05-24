package Modelo;

import java.time.LocalDate;

public class Tarea {

    private LocalDate Fecha;
    private String titulo;
    private String descripcion;
    private String categoria;

    public Tarea(LocalDate fecha, String titulo, String descripcion, String categoria) {
        this.Fecha = fecha;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

        public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
