package com.betplay2.Equipo.aplicacion.port.out;

import java.util.ArrayList;

import com.betplay2.Equipo.domain.Equipo;

public interface EquipoRepository {
    void save(Equipo equipo);
    ArrayList<Equipo> findAll();
}
