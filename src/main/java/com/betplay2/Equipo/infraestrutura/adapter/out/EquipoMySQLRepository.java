package com.betplay2.Equipo.infraestrutura.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.betplay2.Equipo.aplicacion.port.out.EquipoRepository;
import com.betplay2.Equipo.domain.Equipo;

public class EquipoMySQLRepository implements EquipoRepository{
    private final String url;
    private final String user;
    private final String password;

    
    public EquipoMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Equipo equipo) {
        String query = "INSERT INTO equipo (nombre, PJ, PG, PP, PE, GF, GC, TP, puntos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, equipo.getNombre());
            statement.setInt(2, equipo.getPJ());
            statement.setInt(3, equipo.getPG());
            statement.setInt(4, equipo.getPP());
            statement.setInt(5, equipo.getPE());
            statement.setInt(6, equipo.getGF());
            statement.setInt(7, equipo.getGC());
            statement.setInt(8, equipo.getTP());
            statement.setInt(9, equipo.getPuntos());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al intentar guardar el equipo: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<Equipo> findAll() {
        ArrayList<Equipo> equipos = new ArrayList<>();
        try (Connection connection =  DriverManager.getConnection(url, user, password)){
            String query = "SELECT * FROM equipo";
            try(PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()) {
                        Equipo equipo = new Equipo(resultSet.getInt("id"), 
                        resultSet.getString("nombre"),
                        resultSet.getInt("PJ"),
                        resultSet.getInt("PG"),
                        resultSet.getInt("PP"),
                        resultSet.getInt("PE"),
                        resultSet.getInt("GF"),
                        resultSet.getInt("GC"),
                        resultSet.getInt("TP"),
                        resultSet.getInt("puntos")
                        );
                        equipos.add(equipo);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipos;
    }
}
