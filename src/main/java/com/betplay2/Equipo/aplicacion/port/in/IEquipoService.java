package com.betplay2.Equipo.aplicacion.port.in;

import java.util.ArrayList;
import java.util.Scanner;

import com.betplay2.Equipo.domain.Equipo;
import com.betplay2.Equipo.domain.EquipoJava;
import com.betplay2.Jugador.domain.Jugador;

public interface IEquipoService {
    Boolean create(Scanner input);
    ArrayList<EquipoJava> copiaArrayList();
    EquipoJava elegirEquipo(Scanner input);
    void registrarJugador(Scanner input, EquipoJava equipo);
    void registrarCMedico(Scanner input, EquipoJava equipo);
    void registrarCTecnico(Scanner input, EquipoJava equipo);
    Jugador jugadorConMasGoles();
    Jugador jugadorConMasTarjetasAmarillas();
    Jugador jugadorConMasTarjetasRojas();
    void mostrarJugadoresPorEquipo();
    ArrayList<Jugador> obtenerArrayDeJugadores();
    void listarCuerpoTecnico();
    int golesTotal();
    ArrayList<Equipo> convertirAEquipos(ArrayList<EquipoJava> equiposJava);
}
