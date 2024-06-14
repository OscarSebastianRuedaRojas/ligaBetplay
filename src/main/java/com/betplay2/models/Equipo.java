package com.betplay2.models;

import java.util.ArrayList;

public class Equipo {
    String nombre;
    int PJ = 0;
    int PG = 0;
    int PP = 0;
    int PE = 0;
    int GF = 0;
    int GC = 0;
    int TP = 0;
    int puntos = 0;

    ArrayList<Jugador> jugadores = new ArrayList<>();
    ArrayList<CMedico> cMedico = new ArrayList<>();
    ArrayList<CTecnico> cTecnico = new ArrayList<>();

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPJ() {
        return PJ;
    }
    
    public void setPJ(int pJ) {
        PJ = pJ;
    }
    public int getPG() {
        return PG;
    }
    public void setPG(int pG) {
        PG = pG;
    }
    public int getPP() {
        return PP;
    }
    public void setPP(int pP) {
        PP = pP;
    }
    public int getPE() {
        return PE;
    }
    public void setPE(int pE) {
        PE = pE;
    }
    public int getGF() {
        return GF;
    }
    public void setGF(int gF) {
        GF = gF;
    }
    public int getGC() {
        return GC;
    }
    public void setGC(int gC) {
        GC = gC;
    }
    public int getTP() {
        return TP;
    }
    public void setTP(int tP) {
        TP = tP;
    }
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
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
