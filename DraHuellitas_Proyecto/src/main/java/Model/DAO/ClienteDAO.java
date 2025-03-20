package Model.DAO;

import Model.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ClienteDAO {
    
    public void agregarCliente
            (String nombre, String apellido, int telefono, String email, String direccion){
        
        String sql = "{call AGREGAR_CLIENTE(?, ?, ?, ?, ?)}";
        
        try (Connection conn = ConexionOracle.getConexion();
        
            CallableStatement stmt = conn.prepareCall(sql)) {
            
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setInt(3, telefono);
            stmt.setString(4, email);
            stmt.setString(5, direccion);
            
            // Ejecutar el procedimiento
            stmt.execute();
            System.out.println("Cliente agregado exitosamente.");
        
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error al agregar el cliente: " + e.getMessage());
        }
            
    };
}