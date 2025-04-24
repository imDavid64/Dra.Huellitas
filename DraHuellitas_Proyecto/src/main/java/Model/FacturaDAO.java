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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Daniela
 */
public class FacturaDAO {
    
    public List<String> obtenerMetodosPago() throws SQLException {
    List<String> metodos = new ArrayList<>();
    String sql = "{ call OBTENER_METODOS_PAGO(?) }";

    try (Connection conn = ConexionOracle.getConexion();
         CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        while (rs.next()) {
            metodos.add(rs.getInt("id_metodo_pago") + " - " + rs.getString("nombre"));
        }
    }
    return metodos;
    }
    
    public List<Integer> obtenerIdsFactura() throws SQLException {
    List<Integer> ids = new ArrayList<>();
    String sql = "{ call OBTENER_IDS_FACTURA(?) }";

    try (Connection conn = ConexionOracle.getConexion();
         CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        while (rs.next()) {
            ids.add(rs.getInt("id_factura"));
        }
    }
    return ids;
    }
    
    public double obtenerMontoFactura(int idFactura) throws SQLException {
    String sql = "{ call OBTENER_MONTO_TOTAL(?, ?) }";
    try (Connection conn = ConexionOracle.getConexion();
         CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setInt(1, idFactura);
        stmt.registerOutParameter(2, Types.NUMERIC);
        stmt.execute();
        return stmt.getDouble(2);
    }
    }
    
    public void actualizarMontoFactura(int idFactura, double montoCancelado, int idMetodoPago) throws SQLException {
    String sql = "{ call ACTUALIZAR_MONTO_FACTURA(?, ?, ?) }";

    try (Connection conn = ConexionOracle.getConexion();
         CallableStatement stmt = conn.prepareCall(sql)) {
        
        stmt.setInt(1, idFactura);
        stmt.setDouble(2, montoCancelado);
        stmt.setInt(3, idMetodoPago);
        
        stmt.execute();
    }
    }
    
}
    

