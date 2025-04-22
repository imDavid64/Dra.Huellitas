
// ModificarCita.java

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ModificarCita extends JFrame {

    private JTextField idCitaField, fechaField, horaField, estadoField;

    public ModificarCita() {
        setTitle("Modificar Cita");
        setSize(350, 300);
        setLayout(null);

        JLabel idCitaLabel = new JLabel("ID Cita:");
        idCitaLabel.setBounds(30, 30, 100, 25);
        add(idCitaLabel);

        idCitaField = new JTextField();
        idCitaField.setBounds(140, 30, 160, 25);
        add(idCitaField);

        JLabel fechaLabel = new JLabel("Fecha (YYYY-MM-DD):");
        fechaLabel.setBounds(30, 70, 150, 25);
        add(fechaLabel);

        fechaField = new JTextField();
        fechaField.setBounds(180, 70, 120, 25);
        add(fechaField);

        JLabel horaLabel = new JLabel("Hora (HH:MM):");
        horaLabel.setBounds(30, 110, 150, 25);
        add(horaLabel);

        horaField = new JTextField();
        horaField.setBounds(180, 110, 120, 25);
        add(horaField);

        JLabel estadoLabel = new JLabel("Estado:");
        estadoLabel.setBounds(30, 150, 150, 25);
        add(estadoLabel);

        estadoField = new JTextField();
        estadoField.setBounds(180, 150, 120, 25);
        add(estadoField);

        JButton modificarButton = new JButton("Modificar");
        modificarButton.setBounds(120, 200, 100, 30);
        add(modificarButton);

        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarCita();
            }
        });
    }

    private void modificarCita() {
        int idCita;
        String fecha = fechaField.getText();
        String hora = horaField.getText();
        String estado = estadoField.getText();

        try {
            idCita = Integer.parseInt(idCitaField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID Cita inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    //conexión David
    //private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    //private static final String USERNAME = "DraHuellitas";
    //private static final String PASSWORD = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            CallableStatement stmt = conn.prepareCall("{call modificar_cita(?, ?, ?, ?)}");
            stmt.setInt(1, idCita);
            stmt.setDate(2, java.sql.Date.valueOf(fecha));
            stmt.setString(3, hora);
            stmt.setString(4, estado);
            stmt.execute();

            JOptionPane.showMessageDialog(this, "Cita modificada correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al modificar cita: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}