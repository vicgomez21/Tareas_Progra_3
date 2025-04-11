/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.Clientes;
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
 * @author Diana
 */
public class ClientesDAO {
    
    private static final String SQL_SELECT = "SELECT id_cliente, nombre_cliente, apellido_cliente, edad_cliente, correo_cliente, direccion_cliente, telefono_cliente, dpi_cliente FROM cleintes";
    private static final String SQL_INSERT = "INSERT INTO cleintes ( nombre_cliente, apellido_cliente, edad_cliente, correo_cliente, direccion_cliente, telefono_cliente, dpi_cliente) VALUES(?, ?, ?, ?, ?, ?, ?)";
    //   private static final String SQL_UPDATE = "UPDATE tbl_articulos SET fecha_ingreso=?, nombre_articulo=?, talla_articuloXS=?, talla_articuloS=?, talla_articuloM=?, talla_articuloL=?, talla_articuloXL=?,  color_articulo=?, nombre_proveedor=?, existencia_articulo=?  WHERE PK_id_articulo = ?";
    private static final String SQL_UPDATE = "UPDATE cleintes SET nombre_cliente=?, apellido_cliente=?, edad_cliente=?, correo_cliente=?, direccion_cliente=?, telefono_cliente=?, dpi_cliente=? WHERE id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM cleintes WHERE id_cliente=?";
    private static final String SQL_QUERY = "SELECT id_cliente, nombre_cliente, apellido_cliente, edad_cliente, correo_cliente, direccion_cliente, telefono_cliente, dpi_cliente FROM cleintes WHERE id_cliente = ?";

    
    
    
    
    
    
    public List<Clientes> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes clientes = null;
        List<Clientes> clientesls = new ArrayList<Clientes>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id_cliente = rs.getInt("id_cliente");
                String nombre_cliente = rs.getString("nombre_cliente");
                String apellido_cliente = rs.getString("apellido_cliente");
                String edad_cliente = rs.getString("edad_cliente");
                String correo_cliente = rs.getString("correo_cliente");
                String direccion_cliente = rs.getString("direccion_cliente");
                String telefono_cliente = rs.getString("telefono_cliente");
                String dpi_cliente = rs.getString("dpi_cliente");
                

                clientes = new Clientes();
                clientes.setId_cliente(id_cliente);
                clientes.setNombre_cliente(nombre_cliente);
                clientes.setApellido_cliente(apellido_cliente);
                clientes.setEdad_cliente(edad_cliente);
                clientes.setCorreo_cliente(correo_cliente);
                clientes.setDireccion_cliente(direccion_cliente);
                clientes.setTelefono_cliente(telefono_cliente);
                clientes.setDpi_cliente(dpi_cliente);
                clientesls.add(clientes);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientesls;
    }

    public int insert(Clientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

           
            stmt.setString(1, clientes.getNombre_cliente());
            stmt.setString(2, clientes.getApellido_cliente());
            stmt.setString(3, clientes.getEdad_cliente());
            stmt.setString(4, clientes.getCorreo_cliente());
            stmt.setString(5, clientes.getDireccion_cliente());
            stmt.setString(6, clientes.getTelefono_cliente());
            stmt.setString(7, clientes.getDpi_cliente());
            

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

    public Clientes query(Clientes clientes) {
      Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Clientes> clientesls = new ArrayList<Clientes>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1,clientes.getId_cliente());
            rs = stmt.executeQuery();
             while (rs.next()) {

                int id_cliente = rs.getInt("id_cliente");
                String nombre_cliente = rs.getString("nombre_cliente");
                String apellido_cliente = rs.getString("apellido_cliente");
                String edad_cliente = rs.getString("edad_cliente");
                String correo_cliente = rs.getString("correo_cliente");
                String direccion_cliente = rs.getString("direccion_cliente");
                String telefono_cliente = rs.getString("telefono_cliente");
                String dpi_cliente = rs.getString("dpi_cliente");
                

                clientes = new Clientes();
                clientes.setId_cliente(id_cliente);
                clientes.setNombre_cliente(nombre_cliente);
                clientes.setApellido_cliente(apellido_cliente);
                clientes.setEdad_cliente(edad_cliente);
                clientes.setCorreo_cliente(correo_cliente);
                clientes.setDireccion_cliente(direccion_cliente);
                clientes.setTelefono_cliente(telefono_cliente);
                clientes.setDpi_cliente(dpi_cliente);
                clientesls.add(clientes);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }

    public int delete(Clientes cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getId_cliente());
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

    public int update(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, cliente.getNombre_cliente());
            stmt.setString(2, cliente.getApellido_cliente());
            stmt.setString(3, cliente.getEdad_cliente());
            stmt.setString(4, cliente.getCorreo_cliente());
            stmt.setString(5, cliente.getDireccion_cliente());
            stmt.setString(6, cliente.getTelefono_cliente());
            stmt.setString(7, cliente.getDpi_cliente());
            //WHERE
            stmt.setInt(8, cliente.getId_cliente());
            

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
