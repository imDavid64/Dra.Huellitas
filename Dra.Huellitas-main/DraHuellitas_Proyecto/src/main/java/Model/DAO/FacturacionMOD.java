package Model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FacturacionMOD {
    public void agregarCliente(String id_factura, String id_cliente, String fecha, int total, String id_metodo_pago, String Estado_pago) {

        String sql = "{call pkg_factura.OBTENER_FACTURA(?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, id_factura);
            stmt.setString(2, id_cliente);
            stmt.setString(3, fecha);
            stmt.setInt(4, total);
            stmt.setString(5, id_metodo_pago);
            stmt.setString(6, Estado_pago);

            // Ejecutar el procedimiento
            stmt.execute();
            System.out.println("La factura fue generada exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al generar la factura: " + e.getMessage());
        }
    }
}
