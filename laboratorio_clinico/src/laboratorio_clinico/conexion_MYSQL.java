
package laboratorio_clinico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class conexion_MYSQL {
      
    private String user = "root";
    private String password = "Matheus22";
    private String DB_name = "laboratorio_clinico";
    private String host = "localhost";
    
    private Connection conectar = null;
    
    private final String URL = "jdbc:mysql://" + host + ":3306/" + DB_name;

    public conexion_MYSQL() {
    }

    public Connection obtener_conexion() {
        try {
            conectar = DriverManager.getConnection(URL, user, password);
        } catch (SQLException ex) {
            System.out.println("Error al intentar conectarse a la base de datos!! " + ex);
        }
        if (conectar != null) {
            System.out.println("Conectado a la base de datos....");
        }
        return conectar;
    }
}
