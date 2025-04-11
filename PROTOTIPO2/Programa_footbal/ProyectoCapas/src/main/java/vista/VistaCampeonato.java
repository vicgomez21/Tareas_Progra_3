/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ControladorCampeonato;
import domain.Equipo;
import java.util.ArrayList;

public class VistaCampeonato extends JInternalFrame {
    private JTextField[] txtEquipos;
    private JButton btnConfirmarEquipos;
    private JButton btnGenerarPartidos;
    private JTable tblPosiciones;
    private JLabel lblGanador;
    private JLabel lblEquipoBaja;
    private JButton btnReiniciar;

    private ControladorCampeonato controlador;
    private DefaultTableModel modeloTabla;

    public VistaCampeonato() {
        super("Campeonato de Fútbol", true, true, true, true);
        controlador = new ControladorCampeonato();
        initComponents();
    }

    private void initComponents() {
        setSize(800, 600); // Aumentamos el tamaño de la ventana
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior para los campos de texto y botones
        JPanel panelSuperior = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtEquipos = new JTextField[6];
        for (int i = 0; i < 6; i++) {
            gbc.gridx = 0; // Columna 0
            gbc.gridy = i; // Fila i
            panelSuperior.add(new JLabel("Equipo " + (i + 1) + ":"), gbc);

            gbc.gridx = 1; // Columna 1
            txtEquipos[i] = new JTextField(20); // Tamaño preferido de 20 columnas
            panelSuperior.add(txtEquipos[i], gbc);
        }

        // Botones
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2; // Ocupa 2 columnas
        btnConfirmarEquipos = new JButton("Confirmar Equipos");
        panelSuperior.add(btnConfirmarEquipos, gbc);

        gbc.gridy = 7;
        btnGenerarPartidos = new JButton("Generar Partidos");
        panelSuperior.add(btnGenerarPartidos, gbc);

        gbc.gridy = 8;
        btnReiniciar = new JButton("Reiniciar Campeonato");
        panelSuperior.add(btnReiniciar, gbc);

        add(panelSuperior, BorderLayout.NORTH);

        // Configurar la tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Equipo");
        modeloTabla.addColumn("Partidos Jugados");
        modeloTabla.addColumn("Partidos Ganados");
        modeloTabla.addColumn("Partidos Empatados");
        modeloTabla.addColumn("Partidos Perdidos");
        modeloTabla.addColumn("Goles a Favor");
        modeloTabla.addColumn("Goles en Contra");
        modeloTabla.addColumn("Puntos");

        tblPosiciones = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tblPosiciones);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior para el ganador y el equipo que baja
        JPanel panelInferior = new JPanel();
        lblGanador = new JLabel("Ganador: ");
        lblEquipoBaja = new JLabel("Equipo que baja: ");
        panelInferior.add(lblGanador);
        panelInferior.add(lblEquipoBaja);
        add(panelInferior, BorderLayout.SOUTH);

        // Configurar eventos
        btnConfirmarEquipos.addActionListener(e -> confirmarEquipos());
        btnGenerarPartidos.addActionListener(e -> generarPartidos());
        btnReiniciar.addActionListener(e -> reiniciarCampeonato());
    }

    private void confirmarEquipos() {
        for (JTextField txtEquipo : txtEquipos) {
            controlador.agregarEquipo(txtEquipo.getText());
        }
        JOptionPane.showMessageDialog(this, "Equipos registrados correctamente.");
    }

    private void generarPartidos() {
        controlador.generarPartidosAleatorios();
        actualizarTabla();
        mostrarResultados();
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0); // Limpiar la tabla
        for (Equipo equipo : controlador.getEquipos()) {
            modeloTabla.addRow(new Object[]{
                equipo.getNombre(),
                equipo.getPartidosJugados(),
                equipo.getPartidosGanados(),
                equipo.getPartidosEmpatados(),
                equipo.getPartidosPerdidos(),
                equipo.getGolesAFavor(),
                equipo.getGolesEnContra(),
                equipo.getPuntos()
            });
        }
    }

    private void mostrarResultados() {
        ArrayList<Equipo> equipos = controlador.getEquipos();
        lblGanador.setText("Ganador: " + equipos.get(0).getNombre());
        lblEquipoBaja.setText("Equipo que baja: " + equipos.get(equipos.size() - 1).getNombre());
    }

    private void reiniciarCampeonato() {
        controlador = new ControladorCampeonato();
        for (JTextField txtEquipo : txtEquipos) {
            txtEquipo.setText("");
        }
        modeloTabla.setRowCount(0);
        lblGanador.setText("Ganador: ");
        lblEquipoBaja.setText("Equipo que baja: ");
    }
}