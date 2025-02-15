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

   
   private int carnetAlumno;
   private  String nombreAlumno;
   private  String direAlumno;
   private  String telefonoAlumno;
   private  String emailAlumno;
   private  String estatusAlumno;

//METODOS PARA OBTENER Y COLOCAR INFORMACION DENTRO DE LOS ATRIBUTOS PRIVADOS
    public int getCarnetAlumno() {
        return carnetAlumno;
    }

    public void setCarnetAlumno(int carnetAlumno) {
        this.carnetAlumno = carnetAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getDireAlumno() {
        return direAlumno;
    }

    public void setDireAlumno(String direAlumno) {
        this.direAlumno = direAlumno;
    }

    public String getTelefonoAlumno() {
        return telefonoAlumno;
    }

    public void setTelefonoAlumno(String telefonoAlumno) {
        this.telefonoAlumno = telefonoAlumno;
    }

    public String getEmailAlumno() {
        return emailAlumno;
    }

    public void setEmailAlumno(String emailAlumno) {
        this.emailAlumno = emailAlumno;
    }

    public String getEstatusAlumno() {
        return estatusAlumno;
    }

    public void setEstatusAlumno(String estatusAlumno) {
        this.estatusAlumno = estatusAlumno;
    }
//SOBRE CARGA DE CONSTRUCTORES ( GENERAMOS OBJETOS CON DISTINTOS ATRIBUTOS)
    public Alumno() {
    
    }

    public Alumno(int carnetAlumno, String nombreAlumno, 
            String direAlumno, String telefonoAlumno, 
            String emailAlumno,String estatusAlumno) {
        //this son los atributos y la variable en memoria
        this.carnetAlumno = carnetAlumno;
        this.nombreAlumno = nombreAlumno;
        this.direAlumno = direAlumno;
        this.telefonoAlumno = telefonoAlumno;
        this.emailAlumno = emailAlumno;
        this.estatusAlumno = estatusAlumno;
    }
    
    
    
     @Override
    public String toString() {
        return "Alumno{" + "carnetAlumno=" + carnetAlumno + 
                ", nombreAlumno=" + nombreAlumno + 
                ", direAlumno=" + direAlumno + 
                ", telefonoAlumno=" + telefonoAlumno + 
                ", emailAlumno=" + emailAlumno +
                ", estatusAlumno=" + estatusAlumno + '}';
    }
}

   

