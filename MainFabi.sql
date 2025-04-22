// Main.java

import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Dra. Huellitas - Menú Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnAgregarServicio = new JButton("Agregar Servicio");
        btnAgregarServicio.setBounds(60, 30, 160, 30);
        add(btnAgregarServicio);

        JButton btnAgendarCita = new JButton("Agendar Cita");
        btnAgendarCita.setBounds(60, 70, 160, 30);
        add(btnAgendarCita);

        JButton btnModificarCita = new JButton("Modificar Cita");
        btnModificarCita.setBounds(60, 110, 160, 30);
        add(btnModificarCita);

        // Acciones de los botones
        btnAgregarServicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AgregarServicio().setVisible(true);
            }
        });

        btnAgendarCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AgendarCita().setVisible(true);
            }
        });

        btnModificarCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModificarCita().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
