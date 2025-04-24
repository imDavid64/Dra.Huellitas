/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ProductoDAO;
/**
 *
 * @author Daniela
 */
public class ProductoController {
    
    private ProductoDAO productoDAO;
    
    public ProductoController(){
        productoDAO = new ProductoDAO();
    }
    
    public boolean agregarProducto(int IdProveedor, String nombre, String descripcion, int precio, int stock, String tipo) {
        return productoDAO.agregarProducto(IdProveedor, nombre, descripcion, precio, stock, tipo);
    }
}
