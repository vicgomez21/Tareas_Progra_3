/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author visitante
 */
public class Alumno {
    int id_Alumno;
    String nombreAlumno;
    String direAlumno;

    public Alumno() {
    }
//------------------------------------------------------------------
    public Alumno(int id_Alumno) {
        this.id_Alumno = id_Alumno;
    }

    public Alumno(String nombreAlumno, String direAlumno) {
        this.nombreAlumno = nombreAlumno;
        this.direAlumno = direAlumno;
    }
//-------------------------------------------------------------------
   //getter y setters
    public int getId_vendedor() {
        return id_Alumno;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_Alumno = id_vendedor;
    }

    public String getNombreVendedor() {
        return nombreAlumno;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreAlumno = nombreVendedor;
    }

    public String getDireVendedor() {
        return direAlumno;
    }

    public void setDireVendedor(String direVendedor) {
        this.direAlumno = direVendedor;
    }
//Return en pantalla  de todos los elementos
    @Override
    public String toString() {
        return "Vendedor{" + "id_vendedor=" + id_Alumno + ", nombreVendedor=" + nombreAlumno + ", direVendedor=" + direAlumno + '}';
    }
    
}
