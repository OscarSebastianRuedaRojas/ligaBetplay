package com.betplay2.controllers;

import java.sql.Date;
import java.util.Scanner;

import com.betplay2.models.Create;
import com.betplay2.models.Jugador;

public class JugadorController implements Create<Jugador>{
    @Override
    public Jugador create(Scanner input) {
        Jugador jugador = new Jugador();
        System.out.println("Ingresa el nombre del jugador");
        jugador.setNombre(input.nextLine());
        System.out.println("Ingresa el apellido del jugador");
        jugador.setApellidos(input.nextLine());
        System.out.println("Ingresa la edad del jugador");
        jugador.setEdad(input.nextInt());
        input.nextLine();
        System.out.println("Ingresa el dorsal del jugador");
        jugador.setDorsal(input.nextInt());
        input.nextLine();
        System.out.println("Ingresa la posicion del jugador");
        jugador.setPosicion(input.nextLine());
        System.out.println("Ingresa la nacionalidad del jugador");
        jugador.setNacionalidad(input.nextLine());
        Date current = new Date(0);
        jugador.setFechaIngreso(current);
        return jugador;
    }
}
