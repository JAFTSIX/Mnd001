//SAAAAAAAAAAAAAAVEEEEEEEEEEE
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class conexion {

    private static String dbUrl = "jdbc:derby://localhost:1527/a;user=a;password=a;";
    private static Connection conn = null;

    public static synchronized Connection getConexion() {

        if (conn == null) {
            crearConexion();
        }
        return conn;
    }

    private static void crearConexion() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

            conn = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {

        }

    }

}
