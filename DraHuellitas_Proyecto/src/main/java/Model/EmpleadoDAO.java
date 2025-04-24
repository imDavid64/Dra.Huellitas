/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XPC
 */
public class EmpleadoDAO {

    // Método para obtener los veterinarios
    public List<Empleado> obtenerVeterinarios() {
        List<Empleado> veterinarios = new ArrayList<>();
        String sql = "{ call PKG_EMPLEADO.OBTENER_EMPLEADOS(?) }"; //Llamada al procedimiento

        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {
            // Crear un SYS_REFCURSOR para recibir los resultados
            stmt.registerOutParameter(1, Types.REF_CURSOR);

            // Ejecutar el procedimiento
            stmt.execute();

            // Obtener el cursor de resultados
            try (ResultSet rs = (ResultSet) stmt.getObject(1)) {
                while (rs.next()) {
                    // Crear un objeto Empleado para cada fila
                    Empleado empleado = new Empleado(
                            rs.getInt("id_empleado"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            "Veterinario" // Ya sabemos que estos son veterinarios
                    );
                    veterinarios.add(empleado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return veterinarios;
    }
}
