
// AgregarServicio.java

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AgregarServicio extends JFrame {

    private JTextField nombreField, descripcionField, precioField;

    public AgregarServicio() {
        setTitle("Agregar Servicio");
        setSize(350, 250);
        setLayout(null);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(30, 30, 80, 25);
        add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(120, 30, 180, 25);
        add(nombreField);

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setBounds(30, 70, 80, 25);
        add(descripcionLabel);

        descripcionField = new JTextField();
        descripcionField.setBounds(120, 70, 180, 25);
        add(descripcionField);

        JLabel precioLabel = new JLabel("Precio:");
        precioLabel.setBounds(30, 110, 80, 25);
        add(precioLabel);

        precioField = new JTextField();
        precioField.setBounds(120, 110, 180, 25);
        add(precioField);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.setBounds(120, 160, 100, 30);
        add(agregarButton);

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarServicio();
            }
        });
    }

    private void agregarServicio() {
        String nombre = nombreField.getText();
        String descripcion = descripcionField.getText();
        double precio;

        try {
            precio = Double.parseDouble(precioField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    //conexión David
    //private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    //private static final String USERNAME = "DraHuellitas";
    //private static final String PASSWORD = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            CallableStatement stmt = conn.prepareCall("{call agregar_servicio(?, ?, ?)}");
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setDouble(3, precio);
            stmt.execute();

            JOptionPane.showMessageDialog(this, "Servicio agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar servicio: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
