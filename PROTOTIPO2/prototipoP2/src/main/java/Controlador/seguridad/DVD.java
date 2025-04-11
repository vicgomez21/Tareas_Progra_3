/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.seguridad;

/**
 *
 * @author VICTOR
 */
public class DVD {

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    public String getNombre_video() {
        return nombre_video;
    }

    public void setNombre_video(String nombre_video) {
        this.nombre_video = nombre_video;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public int getValor_registro() {
        return Valor_registro;
    }

    public void setValor_registro(int Valor_registro) {
        this.Valor_registro = Valor_registro;
    }

    public DVD() {
    }

    public DVD(int id_video, String nombre_video, String Clasificacion, int Valor_registro) {
        this.id_video = id_video;
        this.nombre_video = nombre_video;
        this.Clasificacion = Clasificacion;
        this.Valor_registro = Valor_registro;
    }

    @Override
    public String toString() {
        return "DVD{" + "id_video=" + id_video + ", nombre_video=" + nombre_video + ", Clasificacion=" + Clasificacion + ", Valor_registro=" + Valor_registro + '}';
    }
    int id_video;
    String nombre_video;
    String Clasificacion;
    int Valor_registro;
    
}
