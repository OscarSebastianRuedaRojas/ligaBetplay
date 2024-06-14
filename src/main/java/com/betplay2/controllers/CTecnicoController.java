package com.betplay2.controllers;

import java.util.Scanner;

import com.betplay2.models.CTecnico;
import com.betplay2.models.Create;

public class CTecnicoController implements Create<CTecnico>{
    @Override
    public CTecnico create(Scanner input) {
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
