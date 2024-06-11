package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class coneccion {

    private static final String URL = "jdbc:sqlserver://localhost:1433;encrypt=true;integratedSecurity=true;trustServerCertificate=true;databaseName=ListaTareas;user=sa;password=1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void main(String[] args) {
        try (Connection coneccion = getConnection()) {
            System.out.println("Conexión ha sido exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

    }

    
    
}
