package controlador;

import domain.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Random;

public class ControladorCampeonato {
    private ArrayList<Equipo> equipos;

    public ControladorCampeonato() {
        equipos = new ArrayList<>();
    }

    // Agregar un equipo
    public void agregarEquipo(String nombre) {
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipos.add(equipo);
        // Almacenar el equipo en la base de datos
        almacenarEquipoEnBD(equipo);
    }

    // Método para almacenar el equipo en la base de datos
    private void almacenarEquipoEnBD(Equipo equipo) {
        String sql = "INSERT INTO equipos (nombre, partidos_jugados, partidos_ganados, partidos_empatados, partidos_perdidos, goles_a_favor, goles_en_contra, puntos) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Establecer los valores del equipo
            pstmt.setString(1, equipo.getNombre());
            pstmt.setInt(2, equipo.getPartidosJugados());
            pstmt.setInt(3, equipo.getPartidosGanados());
            pstmt.setInt(4, equipo.getPartidosEmpatados());
            pstmt.setInt(5, equipo.getPartidosPerdidos());
            pstmt.setInt(6, equipo.getGolesAFavor());
            pstmt.setInt(7, equipo.getGolesEnContra());
            pstmt.setInt(8, equipo.getPuntos());

            // Ejecutar la inserción
            pstmt.executeUpdate();
            System.out.println("Equipo almacenado en la base de datos: " + equipo.getNombre());

        } catch (SQLException e) {
            System.err.println("Error al almacenar el equipo en la base de datos: " + e.getMessage());
        }
    
    }

    // Generar partidos aleatorios
    public void generarPartidosAleatorios() {
        Random rand = new Random();
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                int golesEquipoA = rand.nextInt(11); // Goles entre 0 y 10
                int golesEquipoB = rand.nextInt(11);

                // Actualizar estadísticas de los equipos
                actualizarEstadisticas(equipos.get(i), golesEquipoA, golesEquipoB);
                actualizarEstadisticas(equipos.get(j), golesEquipoB, golesEquipoA);
            }
        }
    }

    // Actualizar estadísticas de un equipo
    private void actualizarEstadisticas(Equipo equipo, int golesAFavor, int golesEnContra) {
        equipo.setPartidosJugados(equipo.getPartidosJugados() + 1);
        equipo.setGolesAFavor(equipo.getGolesAFavor() + golesAFavor);
        equipo.setGolesEnContra(equipo.getGolesEnContra() + golesEnContra);

        if (golesAFavor > golesEnContra) {
            equipo.setPartidosGanados(equipo.getPartidosGanados() + 1);
            equipo.setPuntos(equipo.getPuntos() + 3);
        } else if (golesAFavor == golesEnContra) {
            equipo.setPartidosEmpatados(equipo.getPartidosEmpatados() + 1);
            equipo.setPuntos(equipo.getPuntos() + 1);
        } else {
            equipo.setPartidosPerdidos(equipo.getPartidosPerdidos() + 1);
        }
    }

    // Obtener la lista de equipos ordenada por puntos
    public ArrayList<Equipo> getEquipos() {
        // Ordenar los equipos por puntos (de mayor a menor)
        equipos.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));
        return equipos;
    }
}