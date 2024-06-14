package com.betplay2.controllers;

import java.util.Scanner;

import com.betplay2.models.CMedico;
import com.betplay2.models.Create;

public class CMedicoController implements Create<CMedico>{
    @Override
    public CMedico create(Scanner input) {
        CMedico cMedico = new CMedico();
        System.out.println("Ingresa el nombre del integrante del cuerpo medico");
        cMedico.setNombre(input.nextLine());
        System.out.println("Ingresa los apellidos del integrante del cuerpo medico");
        cMedico.setApellidos(input.nextLine());
        System.out.println("Ingresa la edad del integrante del cuerpo medico");
        cMedico.setEdad(input.nextInt());
        input.nextLine();
        System.out.println(String.format("Ingresa la titulacion de %s", cMedico.getNombre()));
        cMedico.setTitulacion(input.nextLine());
        System.out.println(String.format("Ingresa los años de experiencia de %s como %s", cMedico.getNombre(), cMedico.getTitulacion()));
        cMedico.setExperiencia(input.nextInt());
        input.nextLine();
        return null;
    }
}
