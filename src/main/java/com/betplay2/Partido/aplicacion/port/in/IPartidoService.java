package com.betplay2.Partido.aplicacion.port.in;

import java.util.ArrayList;
import java.util.Scanner;

import com.betplay2.Equipo.domain.EquipoJava;

public interface IPartidoService {
    void create(Scanner input, ArrayList<EquipoJava> copia);
}
