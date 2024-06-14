package com.betplay2.controllers;

import java.util.Scanner;
import java.util.ArrayList;

import com.betplay2.models.Create;
import com.betplay2.models.Equipo;
import com.betplay2.models.Jugador;
import com.betplay2.models.CMedico;


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

    public Equipo elegirEquipo(Scanner input){
        System.out.println("Selecciona el equipo");
        for (int index = 0; index < equipos.size(); index++) {
            System.out.println(String.format("%d. %s", index+1, equipos.get(index).getNombre()));
        }
        int eleccion = input.nextInt();
        input.nextLine();
        return equipos.get(eleccion-1);
    }
    
    public void registrarJugador(Scanner input, Equipo equipo){
        JugadorController jugadorController = new JugadorController();
        Jugador jugador = jugadorController.create(input);
        ArrayList<Jugador> jugadores = equipo.getJugadores();
        jugadores.add(jugador);
        equipo.setJugadores(jugadores);
    }
    public void registrarCMedico(Scanner input, Equipo equipo){
        CMedicoController cMedicoController = new CMedicoController();
        CMedico cuerpCMedico = cMedicoController.create(input);
        ArrayList<CMedico> cuerpMedicos = equipo.getcMedico();
        cuerpMedicos.add(cuerpCMedico);
        equipo.setcMedico(cuerpMedicos);
    }
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
}
