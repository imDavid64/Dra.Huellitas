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
public class ProductoDAO {
    public boolean agregarProducto(int IdProveedor, String nombre, String descripcion, int precio, int stock, String tipo){
        String sql = "{call AGREGAR_PRODUCTO(?, ?, ?, ?, ?, ?)}";
        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, IdProveedor);
            stmt.setString(2, nombre);
            stmt.setString(3, descripcion);
            stmt.setInt(4, precio);
            stmt.setInt(5, stock);
            stmt.setString(6, tipo);
            stmt.execute();
            
            System.out.println("Producto agregado exitosamente.");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar producto: " + e.getMessage());
        }
        return false;
    }
    
     public List<Producto> buscarProductos(String nombre, String descripcion) {
        List<Producto> productos = new ArrayList<>();
        String sql = "{ call BUSCAR_PRODUCTO(?, ?, ?) }";

        try (Connection conn = ConexionOracle.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.registerOutParameter(3, OracleTypes.CURSOR);

            stmt.execute();
            ResultSet rs = (ResultSet) stmt.getObject(3);

            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("id_producto"),
                    rs.getInt("id_proveedor"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getInt("precio"),
                    rs.getInt("stock"),
                    rs.getString("tipo")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }
     
    public int crearFactura(int idCliente, double total, int idMetodoPago, String estadoPago) throws SQLException {
    String sql = "{ call CREAR_FACTURA(?, ?, ?, ?, ?) }";
    try (Connection conn = ConexionOracle.getConexion();
         CallableStatement stmt = conn.prepareCall(sql)) {

        stmt.setInt(1, idCliente);
        stmt.setDouble(2, total);
        stmt.setInt(3, idMetodoPago);
        stmt.setString(4, estadoPago);
        stmt.registerOutParameter(5, Types.INTEGER);

        stmt.execute();
        return stmt.getInt(5);
    }
}

    public void agregarDetalleProducto(int idFactura, int idProducto, int cantidad, double precioUnitario) throws SQLException {
    String sql = "{ call AGREGAR_DETALLE_PRODUCTO(?, ?, ?, ?) }";
    try (Connection conn = ConexionOracle.getConexion();
         CallableStatement stmt = conn.prepareCall(sql)) {

        stmt.setInt(1, idFactura);
        stmt.setInt(2, idProducto);
        stmt.setInt(3, cantidad);
        stmt.setDouble(4, precioUnitario);
        stmt.execute();
        }
    }
    public void actualizarStock(int idProducto, int cantidad) throws SQLException {
    String sql = "{ call ACTUALIZAR_STOCK_PRODUCTO(?, ?) }";
    try (Connection conn = ConexionOracle.getConexion();
         CallableStatement stmt = conn.prepareCall(sql)) {

        stmt.setInt(1, idProducto);
        stmt.setInt(2, cantidad);
        stmt.execute();
        }
    }
}
