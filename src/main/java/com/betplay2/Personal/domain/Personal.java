package com.betplay2.Personal.domain;

public class Personal {
    int id;
    String nombre;
    String apellidos;
    int edad;
    int equipoId;
    public int getEquipoId() {
        return equipoId;
    }
    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }
    public void concentrarse(){
        System.out.println(String.format("%s esta en concentracion junto al equipo", this.nombre));
    }
    public void viajar(){
        System.out.println(String.format("%s esta viajando junto al equipo", this.nombre));
    }
    public Personal(int id, String nombre, String apellidos, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Personal() {
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
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
