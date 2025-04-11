/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.DVD;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class DVD_DAO {
    
    private static final String SQL_SELECT = "SELECT id_video , nombre_video, clasificacion_video, valor_video FROM dvd";
    private static final String SQL_INSERT = "INSERT INTO dvd (nombre_video, clasificacion_video, valor_video) VALUES(?,?,?)";
    //   private static final String SQL_UPDATE = "UPDATE tbl_articulos SET fecha_ingreso=?, nombre_articulo=?, talla_articuloXS=?, talla_articuloS=?, talla_articuloM=?, talla_articuloL=?, talla_articuloXL=?,  color_articulo=?, nombre_proveedor=?, existencia_articulo=?  WHERE PK_id_articulo = ?";
    private static final String SQL_UPDATE = "UPDATE dvd SET nombre_video=?, clasificacion_video=?, valor_video=? WHERE id_video=?";
    private static final String SQL_DELETE = "DELETE FROM dvd WHERE id_video=?";
    private static final String SQL_QUERY = "SELECT id_video , nombre_video, clasificacion_video, valor_video FROM dvd WHERE id_video = ?";

    
    
    
    
    
    
    public List<DVD> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DVD dvd = null;
        List<DVD> dvdsls = new ArrayList<DVD>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id_video = rs.getInt("id_video");
                String nombre_video = rs.getString("nombre_video");
                String clasificacion_video = rs.getString("clasificacion_video");
                int valor_video =rs.getInt("valor_video");
                

                dvd = new DVD();
                dvd.setId_video(id_video);
                dvd.setNombre_video(nombre_video);
                dvd.setClasificacion(clasificacion_video);
                dvd.setValor_registro(valor_video);
               
                dvdsls.add(dvd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return dvdsls;
    }

    public int insert(DVD dvd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

           
            stmt.setString(1, dvd.getNombre_video());
            stmt.setString(2, dvd.getClasificacion());
            stmt.setInt(3,dvd.getValor_registro());
           
            

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public DVD query(DVD dvd) {
      Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DVD> dvdls = new ArrayList<DVD>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1,dvd.getId_video());
            rs = stmt.executeQuery();
             while (rs.next()) {

                int id_video = rs.getInt("id_video");
                String nombre_video = rs.getString("nombre_video");
                String clasificacion_video = rs.getString("clasificacion_video");
                int valor_video =rs.getInt("valor_video");
                

                dvd = new DVD();
                dvd.setId_video(id_video);
                dvd.setNombre_video(nombre_video);
                dvd.setClasificacion(clasificacion_video);
                dvd.setValor_registro(valor_video);
               
              
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dvd;
    }

    public int delete(DVD dvd) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, dvd.getId_video());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(DVD dvd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, dvd.getNombre_video());
            stmt.setString(2, dvd.getClasificacion());
            stmt.setInt(3, dvd.getValor_registro());
            
            //WHERE
            stmt.setInt(4, dvd.getId_video());
            

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    
    
    
    
}
