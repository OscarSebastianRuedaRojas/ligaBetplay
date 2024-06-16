package com.betplay2.controllers;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

import com.betplay2.models.Create;
import com.betplay2.models.Equipo;
import com.betplay2.models.Jugador;
import com.betplay2.models.CMedico;
import com.betplay2.models.CTecnico;


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
    public void registrarCTecnico(Scanner input, Equipo equipo){
        CTecnicoController cTecnicoController = new CTecnicoController();
        CTecnico cuerpCTecnico = cTecnicoController.create(input);
        ArrayList<CTecnico> cuerpTecnicos = equipo.getcTecnico();
        cuerpTecnicos.add(cuerpCTecnico);
        equipo.setcTecnico(cuerpTecnicos);
    }
    public static void quicksort(ArrayList<Equipo> equipos, int izq, int der, Comparator<Equipo> comparator) {
        if (izq < der) {
            int pivoteIndex = partition(equipos, izq, der, comparator);
            quicksort(equipos, izq, pivoteIndex - 1, comparator);
            quicksort(equipos, pivoteIndex + 1, der, comparator);
        }
    }

    private static int partition(ArrayList<Equipo> equipos, int izq, int der, Comparator<Equipo> comparator) {
        Equipo pivote = equipos.get(izq);
        int i = izq;
        int j = der;
        Equipo aux;
        while (i < j) {
            while (i < j && comparator.compare(equipos.get(i), pivote) <= 0) i++;
            while (comparator.compare(equipos.get(j), pivote) > 0) j--;
            if (i < j) {
                aux = equipos.get(i);
                equipos.set(i, equipos.get(j));
                equipos.set(j, aux);
            }
        }
        equipos.set(izq, equipos.get(j));
        equipos.set(j, pivote);
        return j;
    }
    public Jugador jugadorConMasGoles() {
        Jugador maxJugador = null;
        int maxGoles = 0;
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador.getGoles() > maxGoles) {
                    maxGoles = jugador.getGoles();
                    maxJugador = jugador;
                }
            }
        }
        return maxJugador;
    }

    public Jugador jugadorConMasTarjetasAmarillas() {
        Jugador maxJugador = null;
        int maxTarjetasAmarillas = 0;
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador.getTa() > maxTarjetasAmarillas) {
                    maxTarjetasAmarillas = jugador.getTa();
                    maxJugador = jugador;
                }
            }
        }
        return maxJugador;
    }

    public Jugador jugadorConMasTarjetasRojas() {
        Jugador maxJugador = null;
        int maxTarjetasRojas = 0;
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador.getTr() > maxTarjetasRojas) {
                    maxTarjetasRojas = jugador.getTr();
                    maxJugador = jugador;
                }
            }
        }
        return maxJugador;
    }
    public void mostrarJugadoresPorEquipo() {
        for (Equipo equipo : equipos) {
            System.out.println("Equipo: " + equipo.getNombre());
            for (Jugador jugador : equipo.getJugadores()) {
                System.out.println(String.format("Jugador: %s, Dorsal: %d, Posición: %s, Goles: %d, Tarjetas Amarillas: %d, Tarjetas Rojas: %d",
                        jugador.getNombre(), jugador.getDorsal(), jugador.getPosicion(), jugador.getGoles(), jugador.getTa(), jugador.getTr()));
            }
        }
    }
    public void listarCuerpoTecnico() {
        for (Equipo equipo : equipos) {
            System.out.println("Equipo: " + equipo.getNombre());
            for (CTecnico cTecnico : equipo.getcTecnico()) {
                System.out.println(String.format("Cuerpo Técnico: %s, Cargo: %s", cTecnico.getNombre(), cTecnico.getRol()));
            }
        }
    }
    public int golesTotal(){
        int goles = 0;
        for (Equipo equipo : equipos) {
            goles += equipo.getGF();
        }
        return goles;
    }
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    

}
