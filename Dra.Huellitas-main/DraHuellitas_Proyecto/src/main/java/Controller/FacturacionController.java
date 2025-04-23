/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.DAO.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacturacionController implements ActionListener{

    public void mostrarFactura(String id_factura) {
    String sql = "SELECT id_factura, id_cliente, TO_CHAR(fecha, 'YYYY-MM-DD') AS fecha, total, id_metodo_pago, estado_pago FROM factura WHERE id_factura = ?";

    try (Connection conn = ConexionOracle.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, id_factura);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("Factura:");
            System.out.println("ID Factura: " + rs.getString("id_factura"));
            System.out.println("Cliente: " + rs.getString("id_cliente"));
            System.out.println("Fecha: " + rs.getString("fecha"));
            System.out.println("Total: " + rs.getInt("total"));
            System.out.println("Método de pago: " + rs.getString("id_metodo_pago"));
            System.out.println("Estado de pago: " + rs.getString("estado_pago"));
        } else {
            System.out.println("No se encontró la factura con ID: " + id_factura);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al obtener la factura: " + e.getMessage());
    }
}

    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Evento");
    }
    
}
