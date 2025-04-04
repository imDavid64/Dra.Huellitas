package Controller;

import Model.DAO.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MascotaController {

    public boolean agregarMascota(String nombre, String tipo, String raza, java.sql.Date fechaNacimiento,
            double peso, String sexo, int idCliente) {
        String sql = "{call agregar_mascota(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            // Configura los parámetros de entrada
            stmt.setString(1, nombre);
            stmt.setString(2, tipo);
            stmt.setString(3, raza);
            stmt.setDate(4, fechaNacimiento); // Asegúrate de usar java.sql.Date
            stmt.setDouble(5, peso);
            stmt.setString(6, sexo);
            stmt.setInt(7, idCliente);

            // Ejecuta el procedimiento almacenado
            stmt.execute();
            return true; // Indica que la mascota fue agregada correctamente

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar la mascota: " + e.getMessage());
        }
        return false; // Indica que hubo un problema
    }

}
