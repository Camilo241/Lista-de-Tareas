package Modelo;

public class Categoria {
    private int id;
    private String nombreCategoria;
    private boolean estadoCategoria;

    public Categoria(String nombreCategoria, boolean estadoCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.estadoCategoria = estadoCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public boolean isEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(boolean estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }

}
