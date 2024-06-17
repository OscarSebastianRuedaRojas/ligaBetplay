package com.betplay2.CMedico.domain;

import com.betplay2.Personal.domain.Personal;

public class CMedico extends Personal{
    String Titulacion;
    int experiencia;
    public CMedico() {
    }
    public String getTitulacion() {
        return Titulacion;
    }
    public void setTitulacion(String titulacion) {
        Titulacion = titulacion;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
}
