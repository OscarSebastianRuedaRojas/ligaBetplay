package com.betplay2.models;

public class Partido {
    EquipoJava equipoLocal;
    EquipoJava equipoVisitante;
    String fecha;
    int golesLocal;
    int golesVisitante;
    public Partido() {
    }
    public Partido(EquipoJava equipoLocal, EquipoJava equipoVisitante, String fecha, int golesLocal, int golesVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }
    public EquipoJava getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(EquipoJava equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public EquipoJava getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(EquipoJava equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getGolesLocal() {
        return golesLocal;
    }
    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }
    public int getGolesVisitante() {
        return golesVisitante;
    }
    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
    
}
