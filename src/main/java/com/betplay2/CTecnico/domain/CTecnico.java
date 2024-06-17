package com.betplay2.CTecnico.domain;

import com.betplay2.Personal.domain.Personal;

public class CTecnico extends Personal{
    String rol;
    String idFederacion;
    public CTecnico() {
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getIdFederacion() {
        return idFederacion;
    }
    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }
    
}
