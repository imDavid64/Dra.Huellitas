
package drahuellitas_proyecto;

import Controller.ClienteController;
import Controller.MascotaController;

public class DraHuellitas_Proyecto {

    public static void main(String[] args) {
        
        //Se crear instancia del controlador
        ClienteController cliente = new ClienteController();
        MascotaController mascota = new MascotaController();
        
        
        //Se llamar al metodo para agregar un Cliente
        //cliente.agregarCliente("David", "Amador", 12345678, "david@gmail.com", "heredia");
        
        
        //Se llamar al metodo para agregar una Mascota
        mascota.agregarMascota("Canela", "Canino", "SRD", 14, 4, "Hembra", 1);
       
        
    }
}
