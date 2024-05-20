
package recursos;

/**
 *
 * @author rolan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    // Parámetros de configuración de la base de datos
    private static final String URL = "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=Database_GPM";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USUARIO = "sa";
    private static final String CONTRASENA = "1234";

    // Instancia única de la conexión (Singleton)
    private static Connection conexion;

    // Método privado para evitar la creación de instancias desde fuera de la clase
    private DBConnection() {}

    // Método estático para obtener la instancia única de la conexión
    public static Connection getConnection() {
        // Verificar si la conexión ya está establecida
        if (conexion == null) {
            try {
                // Cargar el driver de la base de datos
                Class.forName(DRIVER);
                // Establecer la conexión
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
                System.out.println("¡Conexión exitosa!");
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("¡Conexión fallida!");
                ex.printStackTrace();
            }
        }
        return conexion;
    }
}