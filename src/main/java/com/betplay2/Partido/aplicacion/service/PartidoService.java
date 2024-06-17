package com.betplay2.Partido.aplicacion.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.betplay2.Equipo.domain.EquipoJava;
import com.betplay2.Jugador.domain.Jugador;
import com.betplay2.Partido.aplicacion.port.in.IPartidoService;
import com.betplay2.Partido.domain.Partido;

public class PartidoService implements IPartidoService{
    ArrayList<Partido> partidos = new ArrayList<>();

    @Override
    public void create(Scanner input, ArrayList<EquipoJava> copia) {
        Partido partido = new Partido();
        partido.setEquipoLocal(readEquipos(copia, "local", input));
        partido.setEquipoVisitante(readEquipos(copia, "Visitante", input));
        System.out.println("Ingresa la fecha en la que se realizo el partido (DD/MM/AAAA)");
        partido.setFecha(input.nextLine());
        partido.setGolesLocal(goles(partido.getEquipoLocal(), input));
        partido.setGolesVisitante(goles(partido.getEquipoVisitante(), input));
        registroDatos(partido);
        registroAmarillas(partido.getEquipoLocal(), input, "Local");
        registroAmarillas(partido.getEquipoVisitante(), input, "Visitante");
        registroRojas(partido.getEquipoLocal(), input, "Local");
        registroRojas(partido.getEquipoVisitante(), input, "Visitante");
        partidos.add(partido);
    }

    private EquipoJava readEquipos(ArrayList<EquipoJava> equipos, String equipo, Scanner input) {
        System.out.println(String.format("Selecciona al equipo %s", equipo));
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, equipos.get(i).getNombre()));
        }
        int eleccion = input.nextInt();
        input.nextLine();
        EquipoJava equipoSeleccionado = equipos.get(eleccion - 1);
        equipos.remove(eleccion-1);
        return equipoSeleccionado;
    }

    private int goles(EquipoJava equipo, Scanner input) {
        System.out.println(String.format("Ingresa los goles realizados por %s", equipo.getNombre()));
        int goles = input.nextInt();
        int golesTotal = goles;
        input.nextLine();
        if (golesTotal > 0) {
            while (true) {
                System.out.println(String.format("Selecciona quien marco gol para el %s", equipo.getNombre()));
                for (int i = 0; i < equipo.getJugadores().size(); i++) {
                    System.out.println(String.format("%d. %s", i + 1, equipo.getJugadores().get(i).getNombre()));
                }
                int eleccion = input.nextInt();
                Jugador jugador = equipo.getJugadores().get(eleccion - 1);
                input.nextLine();
                System.out.println(String.format("Cuantos goles marco %s", jugador.getNombre()));
                while (true) {
                    int golesJugador = input.nextInt();
                    input.nextLine();
                    if (goles - golesJugador >= 0) {
                        goles = goles - golesJugador;
                        jugador.setGoles(jugador.getGoles() + golesJugador);
                        break;
                    } else {
                        System.out.println("El jugador no pudo realizar tantos goles, inténtalo otra vez");
                    }
                }
                if (goles == 0) {
                    break;
                }
            }
        }
        return golesTotal;
    }

    private void registroDatos(Partido partido) {
        if (partido.getGolesLocal() > partido.getGolesVisitante()) {
            partido.getEquipoLocal().setPuntos(partido.getEquipoLocal().getPuntos() + 3);
            partido.getEquipoLocal().setPG(partido.getEquipoLocal().getPG() + 1);
            partido.getEquipoVisitante().setPP(partido.getEquipoVisitante().getPP() + 1);
        } else if (partido.getGolesLocal() == partido.getGolesVisitante()) {
            partido.getEquipoLocal().setPuntos(partido.getEquipoLocal().getPuntos() + 1);
            partido.getEquipoVisitante().setPuntos(partido.getEquipoVisitante().getPuntos() + 1);
            partido.getEquipoLocal().setPE(partido.getEquipoLocal().getPE() + 1);
            partido.getEquipoVisitante().setPE(partido.getEquipoVisitante().getPE() + 1);
        } else {
            partido.getEquipoVisitante().setPuntos(partido.getEquipoVisitante().getPuntos() + 3);
            partido.getEquipoVisitante().setPG(partido.getEquipoVisitante().getPG() + 1);
            partido.getEquipoLocal().setPP(partido.getEquipoLocal().getPP() + 1);
        }
        partido.getEquipoLocal().setPJ(partido.getEquipoLocal().getPJ() + 1);
        partido.getEquipoVisitante().setPJ(partido.getEquipoVisitante().getPJ() + 1);
        partido.getEquipoLocal().setGF(partido.getEquipoLocal().getGF() + partido.getGolesLocal());
        partido.getEquipoLocal().setGC(partido.getEquipoLocal().getGC() + partido.getGolesVisitante());
        partido.getEquipoVisitante().setGF(partido.getEquipoVisitante().getGF() + partido.getGolesVisitante());
        partido.getEquipoVisitante().setGC(partido.getEquipoVisitante().getGC() + partido.getGolesLocal());

    }

    private void registroAmarillas(EquipoJava equipo, Scanner input, String nombre) {
        while (true) {
            System.out.println(String.format("Selecciona quien realizo una tarjeta amarilla del equipo %s", nombre));
            for (int index = 0; index < equipo.getJugadores().size(); index++) {
                System.out.println(String.format("%d. %s", index + 1, equipo.getJugadores().get(index).getNombre()));
            }
            int eleccion = input.nextInt();
            Jugador jugadorAmarilla = equipo.getJugadores().get(eleccion - 1);
            jugadorAmarilla.setTa(jugadorAmarilla.getTa() + 1);
            System.out.println(String.format("Algun otro jugador recibio amarilla del equipo %s", nombre));
            System.out.println("1.Si \n2.No");
            int eleccion2 = input.nextInt();
            input.nextLine();
            if (eleccion2 == 2) {
                break;
            }
        }
    }

    private void registroRojas(EquipoJava equipo, Scanner input, String nombre) {
        while (true) {
            System.out.println(String.format("Selecciona quien realizo una tarjeta roja del equipo %s", nombre));
            for (int index = 0; index < equipo.getJugadores().size(); index++) {
                System.out.println(String.format("%d. %s", index + 1, equipo.getJugadores().get(index).getNombre()));
            }
            int eleccion = input.nextInt();
            Jugador jugadorRoja = equipo.getJugadores().get(eleccion - 1);
            jugadorRoja.setTr(jugadorRoja.getTr() + 1);
            System.out.println(String.format("Algun otro jugador recibio roja del equipo %s", nombre));
            System.out.println("1.Si \n2.No");
            int eleccion2 = input.nextInt();
            input.nextLine();
            if (eleccion2 == 2) {
                break;
            }
        }
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
}
