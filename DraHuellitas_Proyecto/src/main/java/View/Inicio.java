/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author XPC
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        ///////////////////////NAVBAR///////////////////////
        //Accion del Boton de Ir a pantalla de Inicio
        navBtnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                setVisible(false);
            }
        });

        //Accion del Boton de Ir a pantalla de Expedientes
        navBtnExpedientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Expedientes expediente = new Expedientes();
                expediente.setVisible(true);
                setVisible(false);

            }
        });

        //Accion del Boton de Ir a pantalla de Facturar
        navBtnFacturar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Facturar facturar = new Facturar();
                //facturar.setVisible(true);
                setVisible(false);

            }
        });

        //Accion del Boton de Ir a pantalla de Servicio
        navBtnServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Servicios servicio = new Servicios();
                servicio.setVisible(true);
                setVisible(false);


            }
        });
        ///////////////////////NAVBAR///////////////////////

        btnAgregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProducto producto = new AgregarProducto();
                producto.setVisible(true);
                dispose();
            }
        });

        btnAgregaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarCliente cliente = new AgregarCliente();
                cliente.setVisible(true);
                setVisible(false);
            }
        });
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
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAgregaCliente = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("<html>Convertirnos en una referencia en<br>\ncuidado veterinario, reconocidos por<br>\nnuestra excelencia en servicios y compromiso<br>\ncon el bienestar animal, buscando ser<br>\nlíderes en la promoción de la salud animal<br>\na través de la educación continua y la<br>\nadopción de prácticas innovadoras.</html>");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Visión");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("<html>Brindamos servicios de salud<br>\ny cuidados veterinarios en un ambiente<br>\nde calidad, que permitan cumplir con<br>\nlas exigencias de nuestros clientes,<br>\nenfocándonos en educar para promover<br>\nla salud y bienestar animal.</html>");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Misión");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnAgregaCliente.setText("Agregar Cliente");

        btnAgregarProducto.setText("Agregar Producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregaCliente)
                        .addGap(81, 81, 81)
                        .addComponent(btnAgregarProducto)
                        .addGap(169, 169, 169))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 132, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregaCliente)
                            .addComponent(btnAgregarProducto))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    public JButton getBtmAgregaCliente() {
        return btnAgregaCliente;
    }

    public void setBtmAgregaCliente(JButton btmAgregaCliente) {
        this.btnAgregaCliente = btmAgregaCliente;
    }

    public JButton getNavBtnExpedientes() {
        return navBtnExpedientes;
    }

    public void setNavBtnExpedientes(JButton navBtnExpedientes) {
        this.navBtnExpedientes = navBtnExpedientes;
    }

    public JButton getNavBtnInicio() {
        return navBtnInicio;
    }

    public void setNavBtnInicio(JButton navBtnInicio) {
        this.navBtnInicio = navBtnInicio;
    }

    public JButton getNavBtnProductos() {
        return navBtnFacturar;
    }

    public void setNavBtnProductos(JButton navBtnProductos) {
        this.navBtnFacturar = navBtnProductos;
    }

    public JButton getNavBtnServicios() {
        return navBtnServicios;
    }

    public void setNavBtnServicios(JButton navBtnServicios) {
        this.navBtnServicios = navBtnServicios;
    }

    public static void main(String[] args) {
        // Asegurar que la GUI se ejecute en el hilo de despacho de eventos de Swing
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregaCliente;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton navBtnExpedientes;
    private javax.swing.JButton navBtnFacturar;
    private javax.swing.JButton navBtnInicio;
    private javax.swing.JButton navBtnServicios;
    // End of variables declaration//GEN-END:variables
}
