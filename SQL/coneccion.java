package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class coneccion {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;encrypt=true;integratedSecurity=true;trustServerCertificate=true;databaseName=ListaTareas;user=sa;password=1234";//localhost;//casi simpre el puerto para sql server es 1433 
        try (Connection coneccion = DriverManager.getConnection(url)){
            System.out.println("Coneccion ha sido Exitosa.");
            
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
}
