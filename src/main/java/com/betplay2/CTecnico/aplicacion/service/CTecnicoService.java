package com.betplay2.CTecnico.aplicacion.service;

import java.util.Scanner;

import com.betplay2.CTecnico.aplicacion.port.in.CreateTecnico;
import com.betplay2.CTecnico.domain.CTecnico;


public class CTecnicoService implements CreateTecnico<CTecnico>{
    @Override
    public CTecnico createTecnico(Scanner input) {
        CTecnico cTecnico = new CTecnico();
        System.out.println("Ingresa el nombre del integrante del cuerpo Tecnico");
        cTecnico.setNombre(input.nextLine());
        System.out.println("Ingresa el apellido del integrante del cuerpo Tecnico");
        cTecnico.setApellidos(input.nextLine());
        System.out.println("Ingresa la edad del integrante del cuerpo Tecnico");
        cTecnico.setEdad(input.nextInt());
        input.nextLine();
        System.out.println(String.format("Ingresa el rol de %s", cTecnico.getNombre()));
        cTecnico.setRol(input.nextLine());
        System.out.println(String.format("Ingresa el id de federacion de %s", cTecnico.getNombre()));
        cTecnico.setIdFederacion(input.nextLine());
        return cTecnico;
    }
}
