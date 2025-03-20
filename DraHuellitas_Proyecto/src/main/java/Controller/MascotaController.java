
package Controller;

import Model.DAO.MascotaDAO;

public class MascotaController {
    
    private MascotaDAO mascotaDAO;
    
    public MascotaController() {
        this.mascotaDAO = new MascotaDAO();
    }
    
    
    //Metodo para agregar un empleado usando el procedimiento almacenado
    public void agregarMascota(String nombre, String tipo, String raza, int edad,
            int peso, String sexo, int id_cliente){
        
        mascotaDAO.agregarMascota(nombre, tipo, raza, edad, peso, sexo, id_cliente);
    
    }
    
}
