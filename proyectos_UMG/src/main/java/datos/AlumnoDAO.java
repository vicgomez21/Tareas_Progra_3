/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class AlumnoDAO {

   private static final String SQL_SELECT = "SELECT id_alumno, nombre_Alumno, direccion_Alumno, telefono_Alumno, email_Alumno, estatus_Alumno FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos(id_alumno, nombre_Alumno, direccion_Alumno, telefono_Alumno, email_Alumno, estatus_Alumno ) VALUES(?, , , , , ?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET id_alumno=?, nombre_Alumno=?, direccion_Alumno=?, telefono_Alumno=?, email_Alumno=?, estatus_Alumno=? WHERE carnetAlumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumos WHERE estatus_Alumno=?";
    private static final String SQL_QUERY = "SELECT id_alumno, nombre_Alumno, direccion_Alumno, telefono_Alumno, email_Alumno, estatus_Alumno  FROM alumnos WHERE carnetAlumno = ?";  
    //-------------------------------------------------------------------------------
    //SELECT
    public List<Alumno> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //inicializacion del objeto
        Alumno alumno = null;
        List<Alumno> alumnos = new ArrayList<Alumno>();
//condicional sobre algun error try y catch
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_alumno = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre_Alumno");
                String direccion = rs.getString("direccion_Alumno");
                String telefono  = rs.getString("telefono_Alumno");
                String email = rs.getString("email_Alumno");
                String estatus = rs.getString("estatus_Alumno");
                
                
                alumno = new Alumno();
                alumno.setId_alumno(id_alumno);
                alumno.setNombreAlumno(nombre);
                alumno.setDireAlumno(direccion);
                alumno.setEmailAlumno(email);
                alumno.setEstatAlumno(estatus);
                alumnos.add(alumno);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return alumnos;
    }
//-------------------------------------------------------------------------------
    //INSERT
    public int insert(Alumno alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getNombreAlumno());
            stmt.setString(2, alumno.getDireAlumno());
            stmt.setString(3, alumno.getTelAlumno());
            stmt.setString(4, alumno.getEmailAlumno());
            stmt.setString(6, alumno.getEstatAlumno());


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
//-------------------------------------------------------------------------------
    //UPDATE
    public int update(Alumno alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumno.getNombreAlumno());
            stmt.setString(2, alumno.getDireAlumno());
            stmt.setInt(3, alumno.getId_alumno());

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
//-------------------------------------------------------------------------------
    //DELETE
    public int delete(Alumno alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumnos.getId_alumno());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    //-------------------------------------------------------------------------------
    //QUERY
//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Alumno query(Alumno alumno) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Alumno> alumnos = new ArrayList<Alumno>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, alumno.getId_alumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_alumno = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre_Alumno");
                String direccion = rs.getString("direccion_Alumno");
                
                alumno = new Alumno();
                alumno.setId_alumno(id_alumno);
                alumno.setNombreAlumno(nombre);
                alumno.setDireAlumno(direccion);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return alumno;
    }
        
}
