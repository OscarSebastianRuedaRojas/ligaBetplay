package com.betplay2.Jugador.domain;

import java.sql.Date;

import com.betplay2.Personal.domain.Personal;

public class Jugador extends Personal{
    int dorsal;
    String posicion;
    int goles = 0;
    String nacionalidad;
    Date fechaIngreso;
    int ta = 0;
    int tr = 0;
    public Jugador() {
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public int getGoles() {
        return goles;
    }
    public void setGoles(int goles) {
        this.goles = goles;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public int getTa() {
        return ta;
    }
    public void setTa(int ta) {
        this.ta = ta;
    }
    public int getTr() {
        return tr;
    }
    public void setTr(int tr) {
        this.tr = tr;
    }
    
    
}
