
// AgendarCita.java

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AgendarCita extends JFrame {

    private JTextField clienteField, empleadoField, fechaField, horaField;

    public AgendarCita() {
        setTitle("Agendar Cita");
        setSize(350, 300);
        setLayout(null);

        JLabel clienteLabel = new JLabel("ID Cliente:");
        clienteLabel.setBounds(30, 30, 100, 25);
        add(clienteLabel);

        clienteField = new JTextField();
        clienteField.setBounds(140, 30, 160, 25);
        add(clienteField);

        JLabel empleadoLabel = new JLabel("ID Empleado:");
        empleadoLabel.setBounds(30, 70, 100, 25);
        add(empleadoLabel);

        empleadoField = new JTextField();
        empleadoField.setBounds(140, 70, 160, 25);
        add(empleadoField);

        JLabel fechaLabel = new JLabel("Fecha (YYYY-MM-DD):");
        fechaLabel.setBounds(30, 110, 150, 25);
        add(fechaLabel);

        fechaField = new JTextField();
        fechaField.setBounds(180, 110, 120, 25);
        add(fechaField);

        JLabel horaLabel = new JLabel("Hora (HH:MM):");
        horaLabel.setBounds(30, 150, 150, 25);
        add(horaLabel);

        horaField = new JTextField();
        horaField.setBounds(180, 150, 120, 25);
        add(horaField);

        JButton agendarButton = new JButton("Agendar");
        agendarButton.setBounds(120, 200, 100, 30);
        add(agendarButton);

        agendarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agendarCita();
            }
        });
    }

    private void agendarCita() {
        int idCliente, idEmpleado;
        String fecha = fechaField.getText();
        String hora = horaField.getText();

        try {
            idCliente = Integer.parseInt(clienteField.getText());
            idEmpleado = Integer.parseInt(empleadoField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID Cliente o ID Empleado inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    //conexión David
    //private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    //private static final String USERNAME = "DraHuellitas";
    //private static final String PASSWORD = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            CallableStatement stmt = conn.prepareCall("{call agendar_cita(?, ?, ?, ?)}");
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idEmpleado);
            stmt.setDate(3, java.sql.Date.valueOf(fecha));
            stmt.setString(4, hora);
            stmt.execute();

            JOptionPane.showMessageDialog(this, "Cita agendada correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al agendar cita: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}