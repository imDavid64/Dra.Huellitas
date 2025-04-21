package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {

    //conexión David
    //private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    //private static final String USERNAME = "DraHuellitas";
    //private static final String PASSWORD = "1234";
    
    //conexión Daniela
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "veterinaria";
    private static final String PASSWORD = "admin";

    public static Connection getConexion() throws SQLException {
        try {
            // Establecer la conexión con Oracle
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            throw e;
        }
    }

}
