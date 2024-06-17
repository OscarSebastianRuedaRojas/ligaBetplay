package com.betplay2.controllers;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

import com.betplay2.models.Create;
import com.betplay2.models.Equipo;
import com.betplay2.models.EquipoJava;
import com.betplay2.models.Jugador;
import com.betplay2.models.CMedico;
import com.betplay2.models.CTecnico;

public class EquipoController implements Create<Boolean> {
    ArrayList<EquipoJava> equipos = new ArrayList<>();

    @Override
    public Boolean create(Scanner input) {
        EquipoJava equipo = new EquipoJava();
        System.out.println("Ingresa el nombre del equipo que deseas crear");
        equipo.setNombre(input.nextLine());
        equipo.setId(equipos.size() + 1);
        equipos.add(equipo);
        System.out.println(String.format("El equipo %s fue agregado exitosamente", equipo.getNombre()));
        System.out.println("Desea agregar otro equipo? \n 1.Si \n 2.No");
        int respuesta = input.nextInt();
        input.nextLine();
        return respuesta == 1;
    }

    public ArrayList<EquipoJava> copiaArrayList() {
        ArrayList<EquipoJava> copia = new ArrayList<>(equipos);
        return copia;
    }

    public EquipoJava elegirEquipo(Scanner input) {
        System.out.println("Selecciona el equipo");
        for (int index = 0; index < equipos.size(); index++) {
            System.out.println(String.format("%d. %s", index + 1, equipos.get(index).getNombre()));
        }
        int eleccion = input.nextInt();
        input.nextLine();
        return equipos.get(eleccion - 1);
    }

    public void registrarJugador(Scanner input, EquipoJava equipo) {
        JugadorController jugadorController = new JugadorController();
        Jugador jugador = jugadorController.create(input);
        equipo.getJugadores().add(jugador);
    }

    public void registrarCMedico(Scanner input, EquipoJava equipo) {
        CMedicoController cMedicoController = new CMedicoController();
        CMedico cuerpCMedico = cMedicoController.create(input);
        equipo.getcMedico().add(cuerpCMedico);
    }

    public void registrarCTecnico(Scanner input, EquipoJava equipo) {
        CTecnicoController cTecnicoController = new CTecnicoController();
        CTecnico cuerpCTecnico = cTecnicoController.create(input);
        equipo.getcTecnico().add(cuerpCTecnico);
    }

    public static void quicksort(ArrayList<EquipoJava> equipos, int izq, int der, Comparator<EquipoJava> comparator) {
        if (izq < der) {
            int pivoteIndex = partition(equipos, izq, der, comparator);
            quicksort(equipos, izq, pivoteIndex - 1, comparator);
            quicksort(equipos, pivoteIndex + 1, der, comparator);
        }
    }

    private static int partition(ArrayList<EquipoJava> equipos, int izq, int der, Comparator<EquipoJava> comparator) {
        EquipoJava pivote = equipos.get(izq);
        int i = izq;
        int j = der;
        EquipoJava aux;
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
        for (EquipoJava equipo : equipos) {
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
        for (EquipoJava equipo : equipos) {
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
        for (EquipoJava equipo : equipos) {
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
        for (EquipoJava equipo : equipos) {
            System.out.println("Equipo: " + equipo.getNombre());
            for (Jugador jugador : equipo.getJugadores()) {
                System.out.println(String.format("Jugador: %s, Dorsal: %d, Posición: %s, Goles: %d, Tarjetas Amarillas: %d, Tarjetas Rojas: %d",
                        jugador.getNombre(), jugador.getDorsal(), jugador.getPosicion(), jugador.getGoles(), jugador.getTa(), jugador.getTr()));
            }
        }
    }

    public ArrayList<Jugador> obtenerArrayDeJugadores() {
        ArrayList<Jugador> todosLosJugadores = new ArrayList<>();
        for (EquipoJava equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                jugador.setEquipoId(equipo.getId());
                todosLosJugadores.add(jugador);
            }
        }
        return todosLosJugadores;
    }

    public void listarCuerpoTecnico() {
        for (EquipoJava equipo : equipos) {
            System.out.println("Equipo: " + equipo.getNombre());
            for (CTecnico cTecnico : equipo.getcTecnico()) {
                System.out.println(String.format("Cuerpo Técnico: %s, Cargo: %s", cTecnico.getNombre(), cTecnico.getRol()));
            }
        }
    }

    public int golesTotal() {
        int goles = 0;
        for (EquipoJava equipo : equipos) {
            goles += equipo.getGF();
        }
        return goles;
    }
    
    public ArrayList<Equipo> convertirAEquipos(ArrayList<EquipoJava> equiposJava) {
        ArrayList<Equipo> equipos = new ArrayList<>();
        for (EquipoJava equipoJava : equiposJava) {
            Equipo equipo = new Equipo();
            equipo.setId(equipoJava.getId());
            equipo.setNombre(equipoJava.getNombre());
            equipo.setPJ(equipoJava.getPJ());
            equipo.setPG(equipoJava.getPG());
            equipo.setPP(equipoJava.getPP());
            equipo.setPE(equipoJava.getPE());
            equipo.setGF(equipoJava.getGF());
            equipo.setGC(equipoJava.getGC());
            equipo.setTP(equipoJava.getTP());
            equipo.setPuntos(equipoJava.getPuntos());
            equipos.add(equipo);
        }
        return equipos;
    }
    

    public ArrayList<EquipoJava> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<EquipoJava> equipos) {
        this.equipos = equipos;
    }
}
