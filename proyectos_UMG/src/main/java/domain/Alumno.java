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
    String telAlumno;
    String emailAlumno;
    String estatAlumno;

    public Alumno(int id_Alumno, String nombreAlumno, String direAlumno,
            String telAlumno, String emailAlumno, String estatAlumno) 
    {
        this.id_Alumno = id_Alumno;
        this.nombreAlumno = nombreAlumno;
        this.direAlumno = direAlumno;
        this.telAlumno = telAlumno;
        this.emailAlumno = emailAlumno;
        this.estatAlumno = estatAlumno;
    }
    
    public Alumno() {
    }
//-------------------------------------------------------------------
   //getter y setters
    public int getId_alumno() {
        return id_Alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_Alumno = id_alumno;
    }
//----------------------------------------------------------------------
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
//----------------------------------------------------------------------
    public String getDireAlumno() {
        return direAlumno;
    }

    public void setDireVendedor(String direAlumno) {
        this.direAlumno = direAlumno;
    }
//----------------------------------------------------------------------
      public String getTelAlumno() {
        return telAlumno;
    }

    public void setTelAlumno(String telAlumno) {
        this.telAlumno = telAlumno;
    }
//----------------------------------------------------------------------
      public String getEmailAlumno() {
        return emailAlumno;
    }

    public void setEmailAlumno(String emailAlumno) {
        this.emailAlumno = emailAlumno;
    }
//----------------------------------------------------------------------
     public String getEstatAlumno() {
        return estatAlumno;
    }

    public void setEstatAlumno(String estatAlumno) {
        this.estatAlumno = estatAlumno;
    }
//----------------------------------------------------------------------
//Return en pantalla  de todos los elementos
    @Override
    public String toString() {
        return "Alumno{" + "id_alumno=" + id_Alumno + 
                ", nombreAlumno=" + nombreAlumno + 
                ", direAlumno=" + direAlumno +
                ",telAlumno" + telAlumno+
                ",emailAlumno"+emailAlumno+
                "estatAlumno"+estatAlumno+'}';
    }
    
}
