/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.seguridad;


import Controlador.seguridad.RelDVD_cleinte;
import Modelo.seguridad.RelDvdClienteDAO1;
import Modelo.seguridad.DVD_DAO;
import Controlador.seguridad.DVD;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import Controlador.seguridad.Bitacora;
import Controlador.seguridad.UsuarioConectado;
import org.jfree.base.log.LogConfiguration;
import java.sql.*;
import Modelo.seguridad.ClientesDAO;
import Controlador.seguridad.Clientes;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author visitante
 */
public class MantenimientoRelClientes_dvd extends javax.swing.JInternalFrame {
int APLICACION=301;


public void llenadoDeCombos() {
         
        ClientesDAO perfilDAO = new ClientesDAO();
        List<Clientes> salon = perfilDAO.select();
        cboperfil.addItem("Seleccione un Id");
        for (int i = 0; i < salon.size(); i++) {
            cboperfil.addItem(String.valueOf(salon.get(i).getId_cliente()));
            cboperfil.addActionListener(e -> {
    // mandamos a traer el ID
    String idSelec = cboperfil.getSelectedItem().toString();
    int idSeleccionado = Integer.parseInt(idSelec);
    // Busca el perfil en la lista
    for (Clientes perfil : salon) {
        if (perfil.getId_cliente()== idSeleccionado) {
            txtper.setText(perfil.getNombre_cliente());
            
            break;
        }
    }});
            
    }
    DVD_DAO aplicacionDAO = new DVD_DAO();
    List<DVD> aplicaciones = aplicacionDAO.select(); 
    DefaultListModel<String> modelo = new DefaultListModel<>();
    DefaultListModel<String> modelo2 = new DefaultListModel<>();
    //Recorre la lista :v
    for (DVD app : aplicaciones) {
    modelo.addElement(app.getNombre_video()); 
}
lstAplicD.setModel(modelo);
lstAplicA.setModel(modelo2);

// Listener para detectar la selección del usuario
lstAplicA.addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) { // Evita doble evento
            String nombreAppSeleccionada = lstAplicA.getSelectedValue();
            
            if (nombreAppSeleccionada != null) {
                // Buscar el ID de la aplicación seleccionada
                for (DVD app : aplicaciones) {
                    if (app.getNombre_video().equals(nombreAppSeleccionada)) {
                        int idAppSeleccionada = app.getId_video();
                        System.out.println("ID seleccionado: " + idAppSeleccionada); // Opcional: para debug
                        txtidApl.setText(String.valueOf(idAppSeleccionada)); // Asignar el ID a un campo
                        break;
                    }
                }
            }
        }
    }
}); 

    }




public void llenadoperfilesaplicaciones(){
// 1. Obtener todas las aplicaciones disponibles

DVD_DAO aplicacionDAO = new DVD_DAO();
List<DVD> aplicaciones = aplicacionDAO.select();

// 2. Modelos para las listas
DefaultListModel<String> modelo = new DefaultListModel<>(); // Para listAplicD (todas las apps)
DefaultListModel<String> modelo2 = new DefaultListModel<>(); // Para listAplicA (apps del perfil)

// 3. Llenar listAplicD con TODAS las aplicaciones
for (DVD aplicacion : aplicaciones) {
    modelo.addElement(aplicacion.getNombre_video());
}
lstAplicD.setModel(modelo);

// 4. Listener para cuando seleccionen un perfil
cboperfil.addActionListener(e -> {
    // Limpiar modelo2 antes de agregar nuevos elementos
    modelo2.clear();
    
    try {
        // Obtener perfil seleccionado
        String idSelec = cboperfil.getSelectedItem().toString();
        int idSeleccionado = Integer.parseInt(idSelec);
        
        // Obtener relaciones perfil-aplicación
        RelDvdClienteDAO1 relPerfAplDAO = new RelDvdClienteDAO1();
        List<RelDVD_cleinte> relaciones = relPerfAplDAO.select();
        
        // Filtrar aplicaciones del perfil seleccionado
        for (RelDVD_cleinte relacion : relaciones) {
            if (relacion.getId_cliente()== idSeleccionado) {
                // Buscar la aplicación por ID
                for (DVD app : aplicaciones) {
                    if (app.getId_video()== relacion.getId_video()) {
                        modelo2.addElement(app.getNombre_video());
                        break; // Salir del for interno
                    }
                }
            }
        }
        
        lstAplicA.setModel(modelo2);
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar aplicaciones: " + ex.getMessage());
    }
});

}


    public void llenarlistaUnoaUno() {
    int indice=0;
    String cadena; 
     
    indice = lstAplicD.getSelectedIndex();
    if (indice != -1) {
        
    cadena = (String) lstAplicD.getSelectedValue();
    DefaultListModel<String> modeloAplA;
    
    if (lstAplicA.getModel() == null) {
        modeloAplA = new DefaultListModel<>();
        lstAplicA.setModel(modeloAplA);
        
    } else {
        
        modeloAplA = (DefaultListModel<String>) lstAplicA.getModel();
                
    }
    modeloAplA.addElement(cadena);
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona una Aplicacion", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
        int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(UsuarioConectado.getIdUsuario(), APLICACION,  "Asignar Una Aplicaciones");    
   
    }
    
    public void llenarlista() {
    DVD_DAO aplicacionDAO = new DVD_DAO();
    List<DVD> aplicaciones = aplicacionDAO.select(); 
    DefaultListModel<String> modelo = new DefaultListModel<>(); 
    //Recorre la lista :v
    for (DVD app : aplicaciones) {
    modelo.addElement(app.getNombre_video()); 
}
lstAplicA.setModel(modelo);
        
        int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(UsuarioConectado.getIdUsuario(), APLICACION,  "Asignar Todas Las Aplicaciones");    
   
    }
    
    public void vaciarlista() {
 
    DefaultListModel<String> modelo = new DefaultListModel<>();
    
    modelo.clear();
    lstAplicA.setModel(modelo);
      
        int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(UsuarioConectado.getIdUsuario(), APLICACION,  "Eliminar Todas Las Aplicaciones");    
   
    }
    
    public void vaciarlistaUnoaUno() {
    
    int indice = lstAplicA.getSelectedIndex();
    if (indice != -1) {
        ((DefaultListModel<String>) lstAplicA.getModel()).remove(indice);
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona una Aplicacion", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
     
    
        int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(UsuarioConectado.getIdUsuario(), APLICACION,  "Eliminar una Aplicacion");    
   
    }
    
    public MantenimientoRelClientes_dvd() {
        initComponents(); 
        llenadoDeCombos(); 
        llenadoperfilesaplicaciones();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        btnAsignarT = new javax.swing.JButton();
        btnAsignarU = new javax.swing.JButton();
        btnEliminarT = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        btnEliminarU = new javax.swing.JButton();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        cboperfil = new javax.swing.JComboBox<>();
        txtper = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAplicA = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstAplicD = new javax.swing.JList<>();
        label7 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        bntconfir = new javax.swing.JButton();
        txtidApl = new javax.swing.JTextField();
        label9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fecha_caduce = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MantenimientoAplicacion");
        setVisible(true);

        btnAsignarT.setBackground(new java.awt.Color(153, 153, 255));
        btnAsignarT.setText("▶▶");
        btnAsignarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarTActionPerformed(evt);
            }
        });

        btnAsignarU.setBackground(new java.awt.Color(153, 153, 255));
        btnAsignarU.setText("▶");
        btnAsignarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarUActionPerformed(evt);
            }
        });

        btnEliminarT.setBackground(new java.awt.Color(153, 153, 255));
        btnEliminarT.setText("◀◀️");
        btnEliminarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Aplicaciones Asignadas");

        btnEliminarU.setBackground(new java.awt.Color(153, 153, 255));
        btnEliminarU.setText("◀️");
        btnEliminarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Perfil Seleccionado");

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Asignar");

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Aplicaciones Disponibles");

        cboperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboperfilActionPerformed(evt);
            }
        });

        txtper.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtper.setEnabled(false);
        txtper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtperActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lstAplicA);

        lstAplicD.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                lstAplicDComponentAdded(evt);
            }
        });
        lstAplicD.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lstAplicDAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(lstAplicD);

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Quitar");

        btnSalir.setBackground(new java.awt.Color(255, 153, 153));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        bntconfir.setBackground(new java.awt.Color(153, 255, 204));
        bntconfir.setText("Confirmar ");
        bntconfir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntconfirActionPerformed(evt);
            }
        });

        txtidApl.setEnabled(false);

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Aplicacion Seleccionada");

        jLabel2.setText("Fecha:");

        jLabel3.setText("Fecha:");

        jLabel4.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(cboperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtper, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidApl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(label9))
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(label6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(label4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fecha_caduce, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bntconfir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(141, 141, 141))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminarU, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminarT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label7)
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAsignarT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAsignarU, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(label5)))
                                .addGap(24, 24, 24)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addGap(170, 170, 170))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lb)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(label9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidApl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(label3))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(label5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAsignarT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAsignarU)
                        .addGap(30, 30, 30)
                        .addComponent(label7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarU)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha_caduce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntconfir))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnAsignarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarTActionPerformed
        // TODO add your handling code here:
   llenarlista();
    }//GEN-LAST:event_btnAsignarTActionPerformed

    private void btnAsignarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarUActionPerformed
    llenarlistaUnoaUno();
    }//GEN-LAST:event_btnAsignarUActionPerformed

    private void btnEliminarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTActionPerformed
//        // TODO add your handling code here:
vaciarlista();
txtidApl.setText(" "); 
DefaultListModel<String> modelo2 = new DefaultListModel<>();
lstAplicA.setModel(modelo2);
    }//GEN-LAST:event_btnEliminarTActionPerformed

    private void btnEliminarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUActionPerformed
        vaciarlistaUnoaUno();
        txtidApl.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarUActionPerformed

 
    
    private void bntconfirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntconfirActionPerformed
        // TODO add your handling code here:
        

RelDvdClienteDAO1 relPerfAplDAO = new RelDvdClienteDAO1();
RelDVD_cleinte relPerfAplAconfirmar = new RelDVD_cleinte();

// Obtener fecha actual
java.util.Date fechaActual = new java.util.Date();

// Asegurar que fechaActual es una instancia de Date antes de formatear

    // Formatear la fecha actual
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
    String fechaFormateada = sdf.format(fechaActual);
    
    // Calcular fecha de caducidad (5 días adelante)
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    calendar.setTime(fechaActual); // Establecer la fecha actual en el calendario
    calendar.add(java.util.Calendar.DAY_OF_MONTH, 5); // Sumar 5 días

    // Formatear la nueva fecha
    String fechaCaduce = sdf.format(calendar.getTime());

    System.out.println("Fecha actual: " + fechaFormateada);
    System.out.println("Fecha de caducidad: " + fechaCaduce);


// Asignar la fecha al objeto
relPerfAplAconfirmar.setFecha_alquiler(fechaFormateada);
relPerfAplAconfirmar.setFecha_caducidad(fechaCaduce);
relPerfAplAconfirmar.setTotal(total.getText());

// Conversión de txtapli.getText() a int (con manejo de errores)
try {
    int codigoAplicacion = Integer.parseInt(txtidApl.getText());
    relPerfAplAconfirmar.setId_video(codigoAplicacion);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Selecciona un Id video", "ERROR", JOptionPane.ERROR_MESSAGE);
    return; // Detener la ejecución si hay un error
}

// Conversión del ítem seleccionado en cboperfil a int (con manejo de errores)
try {
    Object itemSeleccionado = cboperfil.getSelectedItem();
    if (itemSeleccionado != null) {
        int codigoPerfil = Integer.parseInt(itemSeleccionado.toString());
        relPerfAplAconfirmar.setId_cliente(codigoPerfil);
        JOptionPane.showMessageDialog(this, "Felicidades Asignacion Exitosa", "Anuncio", JOptionPane.INFORMATION_MESSAGE);
    } 
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Selecciona un Cliente", "Advertencia", JOptionPane.ERROR_MESSAGE);
}

relPerfAplDAO.insert(relPerfAplAconfirmar);




int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(UsuarioConectado.getIdUsuario(), APLICACION,  "Ingreso De RelAplPerf");    


    }//GEN-LAST:event_bntconfirActionPerformed

    private void lstAplicDComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_lstAplicDComponentAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lstAplicDComponentAdded

    private void lstAplicDAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstAplicDAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lstAplicDAncestorAdded

    private void cboperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboperfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboperfilActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int valor=JOptionPane.showConfirmDialog(this,"¿Està seguro de salir del Mantenimiento?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (valor==JOptionPane.YES_OPTION) 
                    {
                     this.dispose();
                        
                    }
    int resultadoBitacora=0;
        Bitacora bitacoraRegistro = new Bitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(UsuarioConectado.getIdUsuario(), APLICACION,  "Salio de Mantenimiento RelAplPerf");    

        
        
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtperActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntconfir;
    private javax.swing.JButton btnAsignarT;
    private javax.swing.JButton btnAsignarU;
    private javax.swing.JButton btnEliminarT;
    private javax.swing.JButton btnEliminarU;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboperfil;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField fecha_caduce;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JList<String> lstAplicA;
    private javax.swing.JList<String> lstAplicD;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtidApl;
    private javax.swing.JTextField txtper;
    // End of variables declaration//GEN-END:variables
}
