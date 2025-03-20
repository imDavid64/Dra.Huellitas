
package Controller;

import Model.DAO.ClienteDAO;

public class ClienteController {
    
    private ClienteDAO clienteDAO;
    
    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }
    
    //Metodo para agregar un empleado usando el procedimiento almacenado
    public void agregarCliente
            (String nombre, String apellido, int telefono, String email, String direccion){
    
        clienteDAO.agregarCliente(nombre, apellido, telefono, email, direccion);
        
    }
}
