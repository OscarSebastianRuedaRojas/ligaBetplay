package com.betplay2.Equipo.domain;

import java.util.ArrayList;

import com.betplay2.CMedico.domain.CMedico;
import com.betplay2.CTecnico.domain.CTecnico;
import com.betplay2.Jugador.domain.Jugador;

public class EquipoJava extends Equipo{
    ArrayList<Jugador> jugadores = new ArrayList<>();
    ArrayList<CMedico> cMedico = new ArrayList<>();
    ArrayList<CTecnico> cTecnico = new ArrayList<>();
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public ArrayList<CMedico> getcMedico() {
        return cMedico;
    }
    public void setcMedico(ArrayList<CMedico> cMedico) {
        this.cMedico = cMedico;
    }
    public ArrayList<CTecnico> getcTecnico() {
        return cTecnico;
    }
    public void setcTecnico(ArrayList<CTecnico> cTecnico) {
        this.cTecnico = cTecnico;
    }
}
