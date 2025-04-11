/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Sistema de Votación
 */
package vista.seguridad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.seguridad.ControladorCampeonato;
import Controlador.seguridad.Equipo;
import java.util.ArrayList;

public class VistaCampeonato extends JInternalFrame {
    private JTextField[] txtCandidatos;
    private JButton btnConfirmarCandidatos;
    private JButton btnGenerarVotacion;
    private JTable tblResultados;
    private JLabel lblGanador;
    private JButton btnReiniciar;

    private ControladorCampeonato controlador;
    private DefaultTableModel modeloTabla;

    public VistaCampeonato() {
        super("Sistema de Votación", true, true, true, true);
        controlador = new ControladorCampeonato();
        initComponents();
    }

    private void initComponents() {
        setSize(800, 600);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior para los campos de texto y botones
        JPanel panelSuperior = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtCandidatos = new JTextField[6];
        for (int i = 0; i < 6; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            panelSuperior.add(new JLabel("Candidato " + (i + 1) + ":"), gbc);
            
            gbc.gridx = 1;
            txtCandidatos[i] = new JTextField(20);
            panelSuperior.add(txtCandidatos[i], gbc);
        }

        // Botones
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        btnConfirmarCandidatos = new JButton("Confirmar Candidatos");
        panelSuperior.add(btnConfirmarCandidatos, gbc);

        gbc.gridy = 7;
        btnGenerarVotacion = new JButton("Generar Votación Aleatoria");
        panelSuperior.add(btnGenerarVotacion, gbc);

        gbc.gridy = 8;
        btnReiniciar = new JButton("Reiniciar Sistema");
        panelSuperior.add(btnReiniciar, gbc);

        add(panelSuperior, BorderLayout.NORTH);

        // Configurar la tabla de resultados
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Candidato");
        modeloTabla.addColumn("Votos Obtenidos");
        modeloTabla.addColumn("Porcentaje");

        tblResultados = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tblResultados);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior para el ganador
        JPanel panelInferior = new JPanel();
        lblGanador = new JLabel("Ganador: ");
        panelInferior.add(lblGanador);
        add(panelInferior, BorderLayout.SOUTH);

        // Configurar eventos
        btnConfirmarCandidatos.addActionListener(e -> confirmarCandidatos());
        btnGenerarVotacion.addActionListener(e -> generarVotacion());
        btnReiniciar.addActionListener(e -> reiniciarSistema());
    }

    private void confirmarCandidatos() {
        for (JTextField txtCandidato : txtCandidatos) {
            controlador.agregarEquipo(txtCandidato.getText());
        }
        JOptionPane.showMessageDialog(this, "Candidatos registrados correctamente.");
    }

    private void generarVotacion() {
        controlador.generarVotacionAleatoria();
        actualizarTabla();
        mostrarGanador();
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        ArrayList<Equipo> candidatos = controlador.getEquipos();
        int totalVotos = candidatos.stream().mapToInt(Equipo::getPuntos).sum();
        
        for (Equipo candidato : candidatos) {
            double porcentaje = totalVotos > 0 ? (candidato.getPuntos() * 100.0 / totalVotos) : 0;
            modeloTabla.addRow(new Object[]{
                candidato.getNombre(),
                candidato.getPuntos(),
                String.format("%.2f%%", porcentaje)
            });
        }
    }

    private void mostrarGanador() {
        ArrayList<Equipo> candidatos = controlador.getEquipos();
        if (!candidatos.isEmpty()) {
            lblGanador.setText("Ganador: " + candidatos.get(0).getNombre());
        }
    }

    private void reiniciarSistema() {
        controlador = new ControladorCampeonato();
        for (JTextField txtCandidato : txtCandidatos) {
            txtCandidato.setText("");
        }
        modeloTabla.setRowCount(0);
        lblGanador.setText("Ganador: ");
    }
}