package Modelo;

import java.time.LocalDateTime;

public class Tarea {
    private int id;
    private LocalDateTime Fecha;
    private String titulo;
    private String descripcion;
    private String categoria;
    private boolean estado;

    public Tarea(LocalDateTime fecha,String titulo, String descripcion, String categoria, boolean estado) {
        this.Fecha = LocalDateTime.now();;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
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

    public void setFecha(LocalDateTime fecha) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
