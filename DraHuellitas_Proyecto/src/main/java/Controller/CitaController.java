package Controller;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Date;

public class CitaController {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "DraHuellitas";
    private static final String PASSWORD = "1234";

    public void agendarCita(int idCliente, int idEmpleado, Date fecha, String hora) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            CallableStatement stmt = conn.prepareCall("{call agendar_cita(?, ?, ?, ?)}");
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idEmpleado);
            stmt.setDate(3, fecha);
            stmt.setString(4, hora);
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agendar cita: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modificarCita(int idCita, Date fecha, String hora, String estado) {
    try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
        CallableStatement stmt = conn.prepareCall("{call modificar_cita(?, ?, ?, ?)}");
        stmt.setInt(1, idCita);
        stmt.setDate(2, fecha);
        stmt.setString(3, hora);
        stmt.setString(4, estado);
        stmt.execute();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al modificar cita: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}

}
