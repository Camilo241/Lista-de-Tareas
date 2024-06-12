package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Categoria;
import SQL.Coneccion;

public class ControladorCategoria {
    @SuppressWarnings("unused")
    private List<Categoria> listaCategorias;

    public ControladorCategoria() {
        listaCategorias = new ArrayList<>();
    }

    // CREATE
    public void agregarCategoria(String nombreCategoria, boolean estadoCategoria) {
        Categoria categoria = new Categoria(nombreCategoria, estadoCategoria);

        String sql = "{call SP_InsertarCategoria(?, ?)}"; // Usamos ? como marcadores de posición

        try (Connection conn = Coneccion.getConnection();
                CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, categoria.getNombreCategoria()); // Primer parámetro
            stmt.setBoolean(2, categoria.isEstadoCategoria()); // Segundo parámetro

            stmt.execute();
            System.out.println("Categoría insertada con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar la categoría: " + e.getMessage());
        }
    }

    // READ
    public List<Categoria> cargarCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "{call SP_ConsultarCategorias}";

        try (Connection conn = Coneccion.getConnection();
                CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("NOMBRE_CATEGORIA");
                // boolean estado = rs.getBoolean("ESTADO_CATEGORIA");
                Categoria categoria = new Categoria(nombre, true);
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener las categorías activas: " + e.getMessage());
        }

        return categorias;
    }

    // UPDATE

}
