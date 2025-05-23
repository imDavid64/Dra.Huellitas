/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ClienteController;
import Controller.MascotaController;
import Model.Cliente;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Date;

/**
 *
 * @author XPC
 */
public class AgregarMascota extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public AgregarMascota() {
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

        //Accion del Boton de Ir a pantalla de Expedientes
        navBtnFacturar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Facturar facturar = new Facturar();
                //facturar.setVisible(true);
                setVisible(false);

            }
        });

        //Accion del Boton de Ir a pantalla de Expedientes
        navBtnServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        ///////////////////////NAVBAR///////////////////////

        ClienteController clienteController = new ClienteController();

        MascotaController mascotaController = new MascotaController();

        //Accion del Boton de Buscar Cliente
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Cliente cliente = clienteController.buscarCliente(
                        inTxtNombrePropietario.getText(),
                        inTxtApellidoPropietario.getText()
                );

                if (!inTxtNombrePropietario.getText().equals("")
                        && !inTxtApellidoPropietario.getText().equals("")) {

                    inTxtIdCliente.setText(String.valueOf(cliente.getIdCliente()));

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún cliente.",
                            "Resultado", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        //Accion del Boton de Agregar Mascota
        btnAgragarMascota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inTxtNombrePropietario.getText().equals("")
                        && !inTxtApellidoPropietario.getText().equals("")
                        && !inTxtIdCliente.getText().equals("")) {

                    String nombre = inTxtNombre.getText();
                    String tipo = inTxtTipo.getText();
                    String raza = inTxtRaza.getText();
                    java.util.Date fechaUtil = inTxtFechaNacimiento.getDate();
                    double peso = Double.parseDouble(inTxtPeso.getText());
                    String sexo = inTxtSexo.getText();
                    int idCliente = Integer.parseInt(inTxtIdCliente.getText());

                    if (fechaUtil == null) {
                        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fecha válida.",
                                "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    java.sql.Date fechaNacimiento = new java.sql.Date(fechaUtil.getTime());
                    mascotaController.agregarMascota(nombre, tipo, raza, fechaNacimiento, peso, sexo, idCliente);

                    JOptionPane.showMessageDialog(null, "Se agregó la mascota correctamente :)", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

                    Expedientes expediente = new Expedientes();
                    expediente.setVisible(true);
                    setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Debe buscar un propietario", "Error", JOptionPane.ERROR_MESSAGE);
                }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        inTxtNombre = new javax.swing.JTextField();
        inTxtTipo = new javax.swing.JTextField();
        inTxtRaza = new javax.swing.JTextField();
        inTxtPeso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAgragarMascota = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        navBtnInicio = new javax.swing.JButton();
        navBtnFacturar = new javax.swing.JButton();
        navBtnExpedientes = new javax.swing.JButton();
        navBtnServicios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inTxtNombrePropietario = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        inTxtSexo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inTxtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        inTxtIdCliente = new javax.swing.JTextField();
        inTxtApellidoPropietario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dra.Huellitas");

        inTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inTxtNombreActionPerformed(evt);
            }
        });

        inTxtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inTxtTipoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre mascota");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tipo");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Raza");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Nacimiento");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Peso");

        btnAgragarMascota.setText("Agregar");

        btnCancelar.setText("Cancelar");

        jPanel2.setBackground(new java.awt.Color(24, 114, 184));
        jPanel2.setPreferredSize(new java.awt.Dimension(960, 110));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" Veterinaria Dra.Huellitas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
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
        navBtnFacturar.setActionCommand("Facturar");
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
                .addContainerGap(152, Short.MAX_VALUE))
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Propietario");

        inTxtNombrePropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inTxtNombrePropietarioActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Sexo");

        inTxtFechaNacimiento.setDateFormatString("yyyy-MM-dd");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("ID Cliente");

        inTxtIdCliente.setEditable(false);

        inTxtApellidoPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inTxtApellidoPropietarioActionPerformed(evt);
            }
        });

        jLabel10.setText("Nombre");

        jLabel11.setText("Apellido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inTxtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgragarMascota))
                    .addComponent(inTxtTipo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inTxtRaza, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inTxtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inTxtPeso, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inTxtSexo)
                    .addComponent(inTxtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inTxtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(100, 100, 100)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inTxtApellidoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inTxtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(inTxtApellidoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inTxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inTxtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(inTxtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inTxtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgragarMascota)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(inTxtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inTxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inTxtNombreActionPerformed

    private void inTxtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inTxtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inTxtTipoActionPerformed

    private void navBtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navBtnInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navBtnInicioActionPerformed

    private void navBtnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navBtnFacturarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navBtnFacturarActionPerformed

    private void navBtnExpedientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navBtnExpedientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navBtnExpedientesActionPerformed

    private void inTxtNombrePropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inTxtNombrePropietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inTxtNombrePropietarioActionPerformed

    private void inTxtApellidoPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inTxtApellidoPropietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inTxtApellidoPropietarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgragarMascota;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField inTxtApellidoPropietario;
    private com.toedter.calendar.JDateChooser inTxtFechaNacimiento;
    private javax.swing.JTextField inTxtIdCliente;
    private javax.swing.JTextField inTxtNombre;
    private javax.swing.JTextField inTxtNombrePropietario;
    private javax.swing.JTextField inTxtPeso;
    private javax.swing.JTextField inTxtRaza;
    private javax.swing.JTextField inTxtSexo;
    private javax.swing.JTextField inTxtTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton navBtnExpedientes;
    private javax.swing.JButton navBtnFacturar;
    private javax.swing.JButton navBtnInicio;
    private javax.swing.JButton navBtnServicios;
    // End of variables declaration//GEN-END:variables
}
