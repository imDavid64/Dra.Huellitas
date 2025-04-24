package Controller;

import Model.ClienteDAO;
import View.AgregarCliente;
import View.AgregarMascota;
import View.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioController{

    private Inicio ObjI;

    public InicioController(Inicio VistaInicio) {
        this.ObjI = VistaInicio;
    }
}
