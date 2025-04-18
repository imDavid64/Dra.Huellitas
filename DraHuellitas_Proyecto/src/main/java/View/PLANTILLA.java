/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author XPC
 */
public class PLANTILLA extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public PLANTILLA() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        navBtnInicio = new javax.swing.JButton();
        navBtnFacturar = new javax.swing.JButton();
        navBtnExpedientes = new javax.swing.JButton();
        navBtnServicios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dra.Huellitas");
        setBackground(new java.awt.Color(143, 206, 255));

        jPanel2.setBackground(new java.awt.Color(24, 114, 184));
        jPanel2.setPreferredSize(new java.awt.Dimension(960, 110));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" Veterinaria Dra.Huellitas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        navBtnInicio.setBackground(new java.awt.Color(255, 255, 255));
        navBtnInicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        navBtnInicio.setForeground(new java.awt.Color(0, 0, 0));
        navBtnInicio.setText("Inicio");
        navBtnInicio.setBorder(null);
        navBtnInicio.setMaximumSize(new java.awt.Dimension(102, 27));
        navBtnInicio.setMinimumSize(new java.awt.Dimension(102, 27));
        navBtnInicio.setPreferredSize(new java.awt.Dimension(102, 27));
        navBtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navBtnInicioActionPerformed(evt);
            }
        });

        navBtnFacturar.setBackground(new java.awt.Color(255, 255, 255));
        navBtnFacturar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        navBtnFacturar.setForeground(new java.awt.Color(0, 0, 0));
        navBtnFacturar.setText("Facturar");
        navBtnFacturar.setBorder(null);
        navBtnFacturar.setMaximumSize(new java.awt.Dimension(102, 27));
        navBtnFacturar.setMinimumSize(new java.awt.Dimension(102, 27));
        navBtnFacturar.setPreferredSize(new java.awt.Dimension(102, 27));
        navBtnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navBtnFacturarActionPerformed(evt);
            }
        });

        navBtnExpedientes.setBackground(new java.awt.Color(255, 255, 255));
        navBtnExpedientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        navBtnExpedientes.setForeground(new java.awt.Color(0, 0, 0));
        navBtnExpedientes.setText("Expedientes");
        navBtnExpedientes.setBorder(null);
        navBtnExpedientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navBtnExpedientesActionPerformed(evt);
            }
        });

        navBtnServicios.setBackground(new java.awt.Color(255, 255, 255));
        navBtnServicios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        navBtnServicios.setForeground(new java.awt.Color(0, 0, 0));
        navBtnServicios.setText("Servicios");
        navBtnServicios.setBorder(null);
        navBtnServicios.setMaximumSize(new java.awt.Dimension(102, 27));
        navBtnServicios.setMinimumSize(new java.awt.Dimension(102, 27));
        navBtnServicios.setPreferredSize(new java.awt.Dimension(102, 27));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(navBtnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(navBtnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(navBtnExpedientes)
                .addGap(89, 89, 89)
                .addComponent(navBtnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(navBtnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navBtnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navBtnExpedientes)
                    .addComponent(navBtnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void navBtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navBtnInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navBtnInicioActionPerformed

    private void navBtnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navBtnFacturarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navBtnFacturarActionPerformed

    private void navBtnExpedientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navBtnExpedientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navBtnExpedientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton navBtnExpedientes;
    private javax.swing.JButton navBtnFacturar;
    private javax.swing.JButton navBtnInicio;
    private javax.swing.JButton navBtnServicios;
    // End of variables declaration//GEN-END:variables
}
