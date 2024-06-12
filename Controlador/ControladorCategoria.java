package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Categoria;
import SQL.coneccion;

public class ControladorCategoria {
    private List<Categoria> listaCategorias;

    public ControladorCategoria() {
        listaCategorias = new ArrayList<>();
    }

    public void agregarCategoria(String nombreCategoria, boolean estadoCategoria) {
        Categoria categoria = new Categoria(nombreCategoria, estadoCategoria);

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

    public List<Categoria> cargarCategorias(String nombreCategoria) {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "{call SP_ConsultarCategorias()}";

        try (Connection conn = coneccion.getConnection();
            CallableStatement stmt = conn.prepareCall(sql)){
            stmt.getString("@NombreCategoria");
            Categoria categoria = new Categoria(nombreCategoria, true);
            categorias.add(categoria);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al cargar las categorías: " + e.getMessage());
        }

        return categorias;
    }
}
