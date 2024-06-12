package Controlador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Modelo.Categoria;
import Modelo.Tarea;
import SQL.coneccion;

public class ControladorTarea {
    private List<Tarea> listaTareas;
    

    public ControladorTarea() {
        listaTareas = new ArrayList<>();
    }
    //CREATE
    public void agregarTarea(LocalDateTime fecha,String titulo, String descripcion,String categoria, boolean estado ) {
        Tarea tarea = new Tarea( fecha,titulo, descripcion, categoria, estado);

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

    //READ
    public List<Tarea> cargarTareas() {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "{call SP_ConsultarTareas}";
    
        try (Connection conn = coneccion.getConnection();
            CallableStatement stmt = conn.prepareCall(sql)) {
    
            ResultSet rs = stmt.executeQuery();
    
            while (rs.next()) {
                LocalDateTime Fecha = rs.getDate("FECHA_TAREA");
                String Titulo = rs.getString("NOMBRE_TAREA");
                String Descripcion = rs.getString("DESCRIPCION_TAREA");
                String Categoria = rs.getString("CATEGORIA_TAREA");

                Tarea tarea = new Tarea(Fecha,Titulo, Descripcion, Categoria, false);
                tareas.add(tarea);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener las tareas " + e.getMessage());
        }
    
        return tareas;
    }

}
