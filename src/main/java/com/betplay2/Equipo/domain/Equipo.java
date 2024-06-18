package com.betplay2.Equipo.domain;


public class Equipo {
    int id;
    String nombre;
    int PJ = 0;
    int PG = 0;
    int PP = 0;
    int PE = 0;
    int GF = 0;
    int GC = 0;
    int TP = 0;
    int puntos = 0;


    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    
    public Equipo(int id, String nombre, int pJ, int pG, int pP, int pE, int gF, int gC, int tP, int puntos) {
        this.id = id;
        this.nombre = nombre;
        PJ = pJ;
        PG = pG;
        PP = pP;
        PE = pE;
        GF = gF;
        GC = gC;
        TP = tP;
        this.puntos = puntos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    
    
}
