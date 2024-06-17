package com.betplay2.Jugador.aplicacion.port.in;

import java.util.Scanner;

public interface CreateJugador<Jugador> {
    Jugador createJugador(Scanner input);
}
