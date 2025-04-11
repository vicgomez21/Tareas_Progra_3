/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.seguridad;

/**
 *
 * @author Diana
 */
public class Clientes {

    public Clientes() {
    }
    int id_cliente;
    String nombre_cliente;
    String apellido_cliente;
    String edad_cliente;
    String correo_cliente;
    String direccion_cliente;
    String telefono_cliente;
    String dpi_cliente;

    @Override
    public String toString() {
        return "Clientes{" + "id_cliente=" + id_cliente + ", nombre_cliente=" + nombre_cliente + ", apellido_cliente=" + apellido_cliente + ", edad_cliente=" + edad_cliente + ", correo_cliente=" + correo_cliente + ", direccion_cliente=" + direccion_cliente + ", telefono_cliente=" + telefono_cliente + ", dpi_cliente=" + dpi_cliente + '}';
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getEdad_cliente() {
        return edad_cliente;
    }

    public void setEdad_cliente(String edad_cliente) {
        this.edad_cliente = edad_cliente;
    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }

    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getDpi_cliente() {
        return dpi_cliente;
    }

    public void setDpi_cliente(String dpi_cliente) {
        this.dpi_cliente = dpi_cliente;
    }

    public Clientes(int id_cliente, String nombre_cliente, String apellido_cliente, String edad_cliente, String correo_cliente, String direccion_cliente, String telefono_cliente, String dpi_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.edad_cliente = edad_cliente;
        this.correo_cliente = correo_cliente;
        this.direccion_cliente = direccion_cliente;
        this.telefono_cliente = telefono_cliente;
        this.dpi_cliente = dpi_cliente;
    }

            
            
}
