package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/escuelaTAP";
    private static final String USER = "root";
    private static final String PASSWORD = "M1911";

    public static Connection conectar() {

        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa a la BD");

        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }

        return conexion;
    }
}