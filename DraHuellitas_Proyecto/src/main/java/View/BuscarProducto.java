/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Producto;
import Model.ProductoDAO;
import Model.ProductoFactura;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import View.Facturar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Daniela
 */
public class BuscarProducto extends javax.swing.JFrame {

    /**
     * Creates new form BuscarProducto
     */
    public BuscarProducto() {
        initComponents();
        setLocationRelativeTo(null);
        cargarProductos();
        configurarTabla();
        comboBoxProducto.addActionListener(e -> mostrarDetalleProducto());
        btnAgregarAFactura.addActionListener(e -> agregarAFactura());
        btnGenerarFactura.addActionListener(e -> generarFactura());

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                setVisible(false);
            }
        });
    }

    private List<Producto> listaProductos;
    // b) En BuscarProducto.java, agregá:
    private List<ProductoFactura> listaDetalle = new ArrayList<>();
    private DefaultTableModel modeloTabla;

    private void cargarProductos() {
        ProductoDAO productodao = new ProductoDAO();
        listaProductos = productodao.buscarProductos("", "");

        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (Producto p : listaProductos) {
            modelo.addElement(p.getNombre() + " - " + p.getDescripcion());
        }
        comboBoxProducto.setModel(modelo);
    }

    private void mostrarDetalleProducto() {
        int index = comboBoxProducto.getSelectedIndex();
        if (index >= 0 && index < listaProductos.size()) {
            Producto p = listaProductos.get(index);
            txtP.setText(String.valueOf(p.getPrecio()));
            txtS.setText(String.valueOf(p.getStock()));
            txtT.setText(p.getTipo());
        }
    }

    private void configurarTabla() {
        modeloTabla = new DefaultTableModel(new Object[]{"Producto", "Cantidad", "Precio", "Subtotal"}, 0);
        tableDetalleFactura.setModel(modeloTabla);
    }

    private void actualizarTablaDetalle() {
        modeloTabla.setRowCount(0); // Limpia tabla
        for (ProductoFactura item : listaDetalle) {
            modeloTabla.addRow(new Object[]{
                item.getProducto().getNombre(),
                item.getCantidad(),
                item.getPrecioUnitario(),
                item.getSubtotal()
            });
        }
    }

    private void agregarAFactura() {
        int index = comboBoxProducto.getSelectedIndex();
        if (index < 0 || index >= listaProductos.size()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto válido.");
            return;
        }

        Producto seleccionado = listaProductos.get(index);
        int cantidad = (int) SpinnerStock.getValue();

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que 0.");
            return;
        }

        if (cantidad > seleccionado.getStock()) {
            JOptionPane.showMessageDialog(this, "Cantidad excede el stock disponible.");
            return;
        }

        // Verificar si ya está en la listaDetalle
        boolean encontrado = false;
        for (ProductoFactura item : listaDetalle) {
            if (item.getProducto().getIdProducto() == seleccionado.getIdProducto()) {
                item = new ProductoFactura(seleccionado, item.getCantidad() + cantidad, seleccionado.getPrecio()); // suma cantidad
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            ProductoFactura nuevoItem = new ProductoFactura(seleccionado, cantidad, seleccionado.getPrecio());
            listaDetalle.add(nuevoItem);
        }

        // Descontar stock visualmente
        seleccionado.setStock(seleccionado.getStock() - cantidad);
        txtS.setText(String.valueOf(seleccionado.getStock()));

        // Refrescar tabla
        actualizarTablaDetalle();

        // Aquí puedes agregar a la factura
        JOptionPane.showMessageDialog(this, "Producto agregado: " + seleccionado.getNombre() + "\nCantidad: " + cantidad);
    }

    private void generarFactura() {
        if (listaDetalle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay productos en la factura.");
            return;
        }

        try {
            ProductoDAO dao = new ProductoDAO();
            int idCliente = 1; // <- puedes obtenerlo del login en el futuro     
            int idMetodoPago = 1; // <- Puedes crear un ComboBox si quieres hacerlo seleccionable
            String estadoPago = "PENDIENTE"; // o "PAGADO", según corresponda

            double total = listaDetalle.stream().mapToDouble(ProductoFactura::getSubtotal).sum();

            // 1. Crear factura
            int idFacturaGenerada = dao.crearFactura(idCliente, total, idMetodoPago, estadoPago);

            // 2. Insertar cada producto en detalle_producto
            for (ProductoFactura item : listaDetalle) {
                dao.agregarDetalleProducto(idFacturaGenerada,
                        item.getProducto().getIdProducto(),
                        item.getCantidad(),
                        item.getPrecioUnitario());

                // 3. Actualizar stock en BD
                dao.actualizarStock(item.getProducto().getIdProducto(), item.getCantidad());
            }

            JOptionPane.showMessageDialog(this, "Factura generada correctamente con ID: " + idFacturaGenerada);
            modeloTabla.setRowCount(0);
            listaDetalle.clear();

            // Redirigir a ventana: Facturar
            Facturar facturarVentana = new Facturar();
            facturarVentana.setVisible(true);
            this.dispose(); // Cierra ventana actual

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar la factura: " + e.getMessage());
        }
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
        jLabel7 = new javax.swing.JLabel();
        SpinnerStock = new javax.swing.JSpinner();
        btnAgregarAFactura = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        nombreProducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtP = new javax.swing.JTextField();
        txtS = new javax.swing.JTextField();
        txtT = new javax.swing.JTextField();
        comboBoxProducto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDetalleFactura = new javax.swing.JTable();
        btnGenerarFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addGap(174, 174, 174)
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

        btnAgregarAFactura.setText("Agregar a Factura");

        btnCancelar.setText("Cancelar");

        nombreProducto.setText("Producto");

        jLabel1.setText("Cantidad");

        jLabel3.setText("Precio");

        jLabel4.setText("Stock");

        jLabel2.setText("Tipo");

        txtS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSActionPerformed(evt);
            }
        });

        comboBoxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tableDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableDetalleFactura);

        btnGenerarFactura.setText("Generar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerarFactura)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(63, 63, 63)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtT, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtP, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtS, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(187, 187, 187)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAgregarAFactura)))
                                .addComponent(comboBoxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SpinnerStock, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SpinnerStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarAFactura)
                            .addComponent(txtP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnGenerarFactura)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(()
                -> new BuscarProducto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinnerStock;
    private javax.swing.JButton btnAgregarAFactura;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JComboBox<String> comboBoxProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreProducto;
    private javax.swing.JTable tableDetalleFactura;
    private javax.swing.JTextField txtP;
    private javax.swing.JTextField txtS;
    private javax.swing.JTextField txtT;
    // End of variables declaration//GEN-END:variables
}
