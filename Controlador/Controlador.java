package Controlador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Categoria;
import Modelo.Tarea;
import SQL.coneccion;

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
    public void agregarCategoria(String NombreCategoria, boolean estadoCategoria) {
        Categoria categoria = new Categoria(NombreCategoria, estadoCategoria);
        
        String sql = "{call SP_InsertarCategoria(?, ?)}";  // Usamos ? como marcadores de posición

        try (Connection conn = coneccion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, categoria.getNombreCategoria());  // Primer parámetro
            stmt.setBoolean(2, categoria.isEstadoCategoria());  // Segundo parámetro

            stmt.execute();
            System.out.println("Categoría insertada con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar la categoría: " + e.getMessage());
        }
    }

    public List<Tarea> obtenerTareas() {
        return listaTareas;
    }

    public List<Categoria> obtenerCategorias() {
        return listaCategorias;
    }
}
