
package Model;

import java.sql.Date;


public class Factura {
    private String id_factura;
    private String id_cliente;
    private String fecha;
    private int total;
    private String id_metodo_pago;
    private String Estado_pago;

    public Factura(String id_factura, String id_cliente, String fecha, int total, String id_metodo_pago, String Estado_pago) {
        this.id_factura = id_factura;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.total = total;
        this.id_metodo_pago = id_metodo_pago;
        this.Estado_pago = Estado_pago;
    }
    
    

    public Factura() {
    }

    public String[] getDataRow() {
        // Codigo de idfactura, idcliente, fecha, total, idmetodopago, estadopago
        
        return new String[]{
        this.id_factura,
        this.id_cliente,
        this.fecha,
        String.valueOf(this.total) ,
        this.id_metodo_pago,
        this.Estado_pago
        
        
        };
    }

    public String getEstado_pago() {
        return Estado_pago;
    }

    public void setEstado_pago(String Estado_pago) {
        this.Estado_pago = Estado_pago;
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(String id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }

    @Override
    public String toString() {
        return "Factura{" + "id_factura=" + id_factura + ", id_cliente=" + id_cliente + ", fecha=" + fecha + ", total=" + total + ", id_metodo_pago=" + id_metodo_pago + ", Estado_pago=" + Estado_pago + '}';
    }
    
    
}
