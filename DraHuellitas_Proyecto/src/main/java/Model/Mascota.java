package Model;

public class Mascota {

    private int idMascota;
    private String nombre;
    private String tipo;
    private String raza;
    private java.sql.Date fechaNacimiento;
    private double peso;
    private String sexo;
    private int idCliente;

    // Constructor vacío (opcional)
    public Mascota() {}

    // Getters y Setters
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public java.sql.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.sql.Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Mascota{" + "idMascota=" + idMascota + ", nombre=" + nombre + 
               ", tipo=" + tipo + ", raza=" + raza + ", fechaNacimiento=" + fechaNacimiento +
               ", peso=" + peso + ", sexo=" + sexo + ", idCliente=" + idCliente + '}';
    }
}


