package Controlador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Modelo.Tarea;
import SQL.coneccion;

public class ControladorTarea {
    private List<Tarea> listaTareas;
    

    public ControladorTarea() {
        listaTareas = new ArrayList<>();
    }
    //CREATE
    public void agregarTarea(String titulo, String descripcion,String categoria, boolean estado ) {
        Tarea tarea = new Tarea( titulo, descripcion, categoria, estado);

        String sql = "{call SP_InsertarTarea(?, ?, ?, ?)}";

        try (Connection conn = coneccion.getConnection();
            CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, tarea.getTitulo());
            stmt.setString(2, tarea.getDescripcion());  
            stmt.setString(3,tarea.getCategoria());  
            stmt.setBoolean(4, tarea.isEstado());  

            stmt.execute();
            System.out.println("Tarea insertada con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar la categoría: " + e.getMessage());
        }
    }

    public List<Tarea> obtenerTareas() {
        return listaTareas;
    }

}
