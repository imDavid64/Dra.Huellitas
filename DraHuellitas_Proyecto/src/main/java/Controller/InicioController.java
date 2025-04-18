package Controller;

import Model.ClienteDAO;
import View.AgregarCliente;
import View.AgregarMascota;
import View.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioController implements ActionListener {

    private Inicio ObjI;
    private AgregarMascota ObjM;

    public InicioController(Inicio VistaInicio) {
        this.ObjI = VistaInicio;
        ObjM = new AgregarMascota(); // Instancia la nueva ventana.

        // Añadir el ActionListener al botón
        ObjI.getBtmAgregaCliente().addActionListener((ActionListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ObjI.getBtmAgregaCliente()) {
            ObjM.setVisible(true);
            ObjI.dispose();
        }
    }

}
