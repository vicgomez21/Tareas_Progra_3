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
// el ? ño utiliza java para poder trasladarle informacion a una base de datos desde java
   private static final String SQL_SELECT = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos(nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno ) VALUES(?, ?,  ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre_alumno=?, direccion_alumno=?, telefono_alumno=?, email_alumno=?, estatus_alumno=? WHERE carnet_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE carnet_alumno=?";
    private static final String SQL_QUERY = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno  FROM alumnos WHERE carnet_alumno = ?";  
 //-------------------------------------------------------------------------------
    //SELECT
    public List<Alumno> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //inicializacion del objeto
        Alumno alumno = null;
       //trae todo los registros de la tabla y los coloca en la lista
        List<Alumno> alumnos_list = new ArrayList<Alumno>();
//condicional sobre algun error try y catch
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
    //llenamos   de registros nuestra lista       
            while (rs.next()) {
        //variables temporales para guardar los registros de la base de datos
                int carnet_alumno = rs.getInt("carnet_alumno");
                String nombre_alumno = rs.getString("nombre_alumno");
                String direccion_alumno = rs.getString("direccion_alumno");
                String telefono_alumno  = rs.getString("telefono_alumno");
                String email_alumno = rs.getString("email_alumno");
                String estatus_alumno = rs.getString("estatus_alumno");
                
        //llenamos los atributos de los objetos colocando los datos que hay en las temporales
                alumno = new Alumno();
                alumno.setCarnetAlumno(carnet_alumno);
                alumno.setNombreAlumno(nombre_alumno);
                alumno.setDireAlumno(direccion_alumno);
                alumno.setTelefonoAlumno(telefono_alumno);
                alumno.setEmailAlumno(email_alumno);
                alumno.setEstatusAlumno(estatus_alumno);
               //añadimos a la lista todos los registros o el objeto 
                alumnos_list.add(alumno);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
//retornamos la lista de todos los alumnos que hay en la base de datos
        return alumnos_list;
    }
//-------------------------------------------------------------------------------
    //INSERT
    public int insert(Alumno alumno) {
   //abrimos la conexion
        Connection conn = null;
        PreparedStatement stmt = null;
   //
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
           //Extraemos la informacion de java a la base de datos
           // llenamos los comodines declarados en SQL_insert
           stmt.setString(1, alumno.getNombreAlumno());
            stmt.setString(2, alumno.getDireAlumno());
            stmt.setString(3, alumno.getTelefonoAlumno());
            stmt.setString(4, alumno.getEmailAlumno());
            stmt.setString(5, alumno.getEstatusAlumno());


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
    //imprime en consola cuantas rows o filas fueron agregadas        
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
//retorna la cantidad de filas
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
       //imprimimos en la consola que haremos un update     
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            //comodines de java , colocaremos datos de java dentro la base de datos
            stmt.setString(1, alumno.getNombreAlumno());
            stmt.setString(2, alumno.getDireAlumno());
            stmt.setString(3, alumno.getTelefonoAlumno());
            stmt.setString(4, alumno.getEmailAlumno());
            stmt.setString(5, alumno.getEstatusAlumno());
           //comodin del where
            stmt.setInt(6,alumno.getCarnetAlumno());
//ejecucion del stmt
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
    public int delete(Alumno alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
        //toma el comodin (numero de carnet) y ejecuta  el SQL_DELETE 
            stmt.setInt(1, alumno.getCarnetAlumno());
            rows = stmt.executeUpdate();
        //en consola dira cuantos registros seran eliminados
            System.out.println("Registros eliminados:" + rows);
        
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
        finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    //-------------------------------------------------------------------------------
    //QUERY
//TRAE LA INFORMACION ESPESIFICA DE UN REGISTRO USANDO UN SELEC Y WHERE
    public Alumno query(Alumno alumno) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
   //TODA LA INFORMACION LA AGREGAMOS A UNA LIST   
        List<Alumno> alumnos_list = new ArrayList<Alumno>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
  //Traemos el comodin del Where para consultar la base de datos          
            stmt.setInt(1, alumno.getCarnetAlumno());
        //ejecuta la SQL_QUERY   
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                //variables temporales para guardar los registros de la base de datos
                int carnet_alumno = rs.getInt("carnet_alumno");
                String nombre_alumno = rs.getString("nombre_alumno");
                String direccion_alumno = rs.getString("direccion_alumno");
                String telefono_alumno  = rs.getString("telefono_alumno");
                String email_alumno = rs.getString("email_alumno");
                String estatus_alumno = rs.getString("estatus_alumno");
                
        //llenamos los atributos de los objetos colocando los datos que hay en las temporales
                alumno = new Alumno();
                alumno.setCarnetAlumno(carnet_alumno);
                alumno.setNombreAlumno(nombre_alumno);
                alumno.setDireAlumno(direccion_alumno);
                alumno.setTelefonoAlumno(telefono_alumno);
                alumno.setEmailAlumno(email_alumno);
                alumno.setEstatusAlumno(estatus_alumno);
               //añadimos a la lista todos los registros o el objeto 
                alumnos_list.add(alumno);
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return el objeto unico;  // Si se utiliza un ArrayList
        return alumno;
    }
        
}
