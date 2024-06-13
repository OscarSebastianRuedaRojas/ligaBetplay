package com.betplay2;


import java.util.Scanner;

import com.betplay2.controllers.EquipoController;
import com.betplay2.controllers.PartidoController;
import com.betplay2.models.Equipo;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EquipoController equipos = new EquipoController();
        PartidoController partidos = new PartidoController();
        Boolean seguir = true;
        Boolean seguir2 = true;
        while (seguir) {
            switch (menuPrincipal(input)) {
                case 1:
                    while (true) {
                        if (equipos.create(input)) {
                            continue;
                        }else{
                            break;
                        }
                    }
                    break;
                case 2:
                    partidos.create(input, equipos.copiaArrayList(), equipos.getEquipos());
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    Equipo equipo = equipos.elegirEquipo(input);
                    while (seguir2) {
                        switch (menuPersonal(input)) {
                            case 1:
                                equipos.registrarJugador(input, equipo);
                                break;
                            case 2:
                                
                                break;
                            case 3:
                                
                                break;
                            case 4:
                                seguir2 = false;    
                                break;
                        
                            default:
                                break;
                        }
                    }
                    break;
                case 6:
                    seguir = false;
                    break;
            
                default:
                    break;
            }
        }
        
        
        input.close();
    }
    public static int menuPrincipal(Scanner input){
        System.out.println("Bienvenido a la Liga Betplay");
        System.out.println("1. Agregar equipo");
        System.out.println("2. Agregar partido");
        System.out.println("3. Reportes");
        System.out.println("4. Tabla de posiciones");
        System.out.println("5. Añadir personal");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
        int responder = input.nextInt();
        input.nextLine();
        return responder;
    }
    public static int menuPersonal(Scanner input){
        System.out.println("Agregar Personal");
        System.out.println("1. Agregar Jugador");
        System.out.println("2. Agregar Cuerpo Técnico (Ctecnico)");
        System.out.println("3. Agregar Cuerpo Médico (Cmedico)");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        int responder = input.nextInt();
        input.nextLine();
        return responder;
    }

}