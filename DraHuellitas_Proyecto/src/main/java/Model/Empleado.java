/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author XPC
 */
public class Empleado {
    
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String rol;

    public Empleado(int idEmpleado, String nombre, String apellido, String rol) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}

