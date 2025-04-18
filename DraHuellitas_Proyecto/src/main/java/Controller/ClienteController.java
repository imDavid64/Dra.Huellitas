package Controller;

import Model.Cliente;
import Util.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ClienteController {

    /*
    private ClienteDAO clienteDAO;
    private AgregarCliente ObjC;
    private AgregarMascota ObjM;

    public ClienteController(AgregarCliente vistaC, AgregarMascota vistaM) {
        this.clienteDAO = new ClienteDAO();
        this.ObjC = vistaC;
        this.ObjM = vistaM;
        ObjC.getBtnAgragarCliente().addActionListener(this);  //Listener del boton "Agregar" Cliente
    }
    

    //Metodo para agregar un Cliente usando el procedimiento almacenado
    public void agregarCliente(String nombre, String apellido, int telefono, String email, String direccion) {

        clienteDAO.agregarCliente(nombre, apellido, telefono, email, direccion);

    }
    
     */
    
    
    public boolean agregarCliente(String nombre, String apellido, String telefono,
            String email, String direccion) {
        String sql = "{call AGREGAR_CLIENTE(?, ?, ?, ?, ?)}"; // Nombre del procedimiento almacenado

        try (Connection conn = ConexionOracle.getConexion(); 
                CallableStatement stmt = conn.prepareCall(sql)) {

            // Configura los parámetros de entrada
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, telefono);
            stmt.setString(4, email);
            stmt.setString(5, direccion);

            // Ejecuta el procedimiento almacenado
            stmt.execute();
            return true; // Retorna true si la operación fue exitosa

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar el cliente: " + e.getMessage());
        }

        return false; // Retorna false si ocurrió algún error
    }
    
    

    public Cliente buscarCliente(String nombre, String apellido) {
        String sql = "{call pkg_cliente.BUSCAR_CLIENTE(?, ?, ?)}";

        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            // Configura los parámetros de entrada
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);

            // Registra el parámetro de salida
            stmt.registerOutParameter(3, Types.REF_CURSOR);

            // Ejecuta el procedimiento almacenado
            stmt.execute();

            // Procesa el resultado del cursor
            try (ResultSet rs = (ResultSet) stmt.getObject(3)) {
                if (rs.next()) { // Si encuentra un cliente
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("id_cliente"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setDireccion(rs.getString("direccion"));

                    return cliente; // Devuelve el cliente encontrado
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al buscar el cliente: " + e.getMessage());
        }
        return null; // Si no se encontró nada, retorna null
    }

    /*

    //Action Listener para cuando se da click a los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ObjC.getBtnAgragarCliente()) {

            //Traer los datos del Formulario "AgregarCliente"
            String nombre = ObjC.getInTxtNombre().getText();
            String apellido = ObjC.getInTxtApellido().getText();
            int telefono = Integer.parseInt(ObjC.getInTxtTelefono().getText());
            String email = ObjC.getInTxtCorreo().getText();
            String direccion = ObjC.getInTxtDireccion().getText();

            //Se llama el metodo de "agregarCliente" y le pasamos los datos para los parametros
            agregarCliente(nombre, apellido, telefono, email, direccion);
        }
    }
     */
}


/*
  // Cambiar a la vista de buscar cliente
    private void mostrarBuscarCliente() {
        ObjC.setVisible(false);  // Ocultar la ventana de agregar cliente
        ObjM.setTitle("Buscar Cliente");
        ObjM.setVisible(true);  // Mostrar la ventana de buscar cliente
    }

    public void iniciar() {
        ObjC.setTitle("Agregar Cliente");
        ObjC.setVisible(true);
    }

    ;
 */
