
package View;

import Controller.CitaController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ModificarCita extends javax.swing.JFrame {

    public ModificarCita() {
        initComponents();

        CitaController citaController = new CitaController();

        // Listener botón Modificar
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idCitaTexto = inTxtIdCita.getText();
                String fechaTexto = inTxtFecha.getText();
                String hora = inTxtHora.getText();
                String estado = inTxtEstado.getText();

                if (idCitaTexto.isEmpty() || fechaTexto.isEmpty() || hora.isEmpty() || estado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int idCita;
                try {
                    idCita = Integer.parseInt(idCitaTexto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID Cita inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                java.sql.Date fecha;
                try {
                    fecha = java.sql.Date.valueOf(fechaTexto); // Formato YYYY-MM-DD
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Usa YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                citaController.modificarCita(idCita, fecha, hora, estado);
                JOptionPane.showMessageDialog(null, "Cita modificada correctamente.", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);

                // Limpiar campos
                inTxtIdCita.setText("");
                inTxtFecha.setText("");
                inTxtHora.setText("");
                inTxtEstado.setText("");
            }
        });

        // Listener botón Cancelar
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }







    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        inTxtIdCita = new javax.swing.JTextField();
        inTxtFecha = new javax.swing.JTextField();
        inTxtHora = new javax.swing.JTextField();
        inTxtEstado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID Cita");

        jLabel2.setText("Fecha");

        jLabel3.setText("Hora");

        jLabel4.setText("Estado");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Modificar Cita");

        btnModificar.setText("Modificar");

        btnCancelar.setText("Cancelar");

        inTxtIdCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inTxtIdCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inTxtIdCita, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inTxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inTxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(135, 135, 135))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(98, 98, 98)
                .addComponent(btnModificar)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inTxtIdCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inTxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(inTxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnCancelar))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inTxtIdCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inTxtIdCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inTxtIdCitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField inTxtEstado;
    private javax.swing.JTextField inTxtFecha;
    private javax.swing.JTextField inTxtHora;
    private javax.swing.JTextField inTxtIdCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
