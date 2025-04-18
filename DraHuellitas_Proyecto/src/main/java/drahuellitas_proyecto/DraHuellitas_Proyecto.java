package drahuellitas_proyecto;

import Controller.ClienteController;
import Controller.InicioController;
import Controller.MascotaController;
import View.AgregarCliente;
import View.AgregarMascota;
import View.Inicio;

public class DraHuellitas_Proyecto {

    public static void main(String[] args) {

        Inicio ventanaPrincipal = new Inicio();
        
        InicioController controlador = new InicioController(ventanaPrincipal);
        
        ventanaPrincipal.setVisible(true);
        
        
        
        /*
        // Ejecutar el JFrame en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(() -> {
            new Inicio().setVisible(true); // Crear instancia de Inicio y hacerla visible
        });
        */

        //Se crean las instancias para la vista
        //AgregarCliente vista = new AgregarCliente();
        // Crear la instancia del controlador y pasar la vista
        //ClienteController cliente = new ClienteController(vista);
        //MascotaController mascota = new MascotaController();
        // Iniciar la vista
        //cliente.iniciar();
    }
}
