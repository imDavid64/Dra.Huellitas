
package Model.DAO;

import Model.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MascotaDAO {
    
    public void agregarMascota
            (String nombre, String tipo, String raza, int edad,
            int peso, String sexo, int id_cliente){
            
        String sql = "{call agregar_mascota(?, ?, ?, ?, ?, ?, ?)}";
        
        try (Connection conn = ConexionOracle.getConexion();
                
            CallableStatement stmt = conn.prepareCall(sql)) {
            
            stmt.setString(1, nombre);
            stmt.setString(2, tipo);
            stmt.setString(3, raza);
            stmt.setInt(4, edad);
            stmt.setInt(5, peso);
            stmt.setString(6, sexo);
            stmt.setInt(7, id_cliente);
            
            // Ejecutar el procedimiento
            stmt.execute();
            System.out.println("Mascota agregado exitosamente.");
        
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error al agregar el mascota: " + e.getMessage());
        }
    };
}


//Ejemplo "stmt.registerOutParameter(8, Types.INTEGER);" Si el procedimiento tiene un parámetro OUT para un ID generado
