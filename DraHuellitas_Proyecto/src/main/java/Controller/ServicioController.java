package Controller;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class ServicioController {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "DraHuellitas";
    private static final String PASSWORD = "1234";

    public void agregarServicio(String nombre, String descripcion, double precio) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            CallableStatement stmt = conn.prepareCall("{call agregar_servicio(?, ?, ?)}");
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setDouble(3, precio);
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar servicio: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
