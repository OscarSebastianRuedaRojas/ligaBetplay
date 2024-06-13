package com.betplay2.controllers;

import java.util.Scanner;
import java.util.ArrayList;

import com.betplay2.models.Create;
import com.betplay2.models.Equipo;


public class EquipoController implements Create<Boolean>{
    ArrayList<Equipo> equipos = new ArrayList<>();
    @Override
    public Boolean create(Scanner input) {
        Equipo equipo = new Equipo();
        System.out.println("Ingresa el nombre del equipo que deseas crear");
        equipo.setNombre(input.nextLine());
        equipos.add(equipo);
        System.out.println(String.format("El equipo %s fue agregado exitosamente", equipo.getNombre()));
        System.out.println("Desea agregar otro equipo? \n 1.Si \n 2.No");
        int respuesta = input.nextInt();
        input.nextLine();
        if (respuesta==1) {
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<Equipo> copiaArrayList(){
        ArrayList<Equipo> copia = new ArrayList<>();
        copia.addAll(equipos);
        return copia;
    }
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
}
