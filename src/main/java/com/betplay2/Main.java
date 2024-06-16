package com.betplay2;


import java.util.ArrayList;
import java.util.Comparator;
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
        Boolean seguir3 = true;
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
                    while (seguir3) {
                        switch (menuReportes(input)) {
                            case 1:
                                ArrayList<Equipo> equiposGF = equipos.copiaArrayList();
                                EquipoController.quicksort(equiposGF, 0, equiposGF.size() - 1, Comparator.comparingInt(Equipo::getGF));
                                System.out.println(String.format("El equipo con mas goles del torneo es %s", equiposGF.get(equiposGF.size()-1).getNombre()));
                                break;
                            case 2:
                                ArrayList<Equipo> equiposPuntos = equipos.copiaArrayList();
                                EquipoController.quicksort(equiposPuntos, 0, equiposPuntos.size() - 1, Comparator.comparingInt(Equipo::getPuntos));
                                System.out.println(String.format("El equipo con mas puntos del torneo es %s", equiposPuntos.get(equiposPuntos.size()-1).getNombre()));
                                break;
                            case 3:
                                ArrayList<Equipo> equiposPG = equipos.copiaArrayList();
                                EquipoController.quicksort(equiposPG, 0, equiposPG.size() - 1, Comparator.comparingInt(Equipo::getPG));
                                System.out.println(String.format("El equipo con mas partidos gano del torneo es %s", equiposPG.get(equiposPG.size()-1).getNombre()));
                                break;
                            case 4:
                                System.out.println(String.format("En el torneo hubieron un total de %d goles",equipos.golesTotal()));
                                break;
                            case 5:
                                System.out.println(String.format("En el torneo el promedio de goles fue de %d", equipos.golesTotal()/partidos.getPartidos().size()));
                                break;
                            case 6:
                                System.out.println(String.format("El jugador con mas goles es %s", equipos.jugadorConMasGoles().getNombre()));
                                break;
                            case 7:
                                System.out.println(String.format("El jugador con mas tarjetas amarillas es %s", equipos.jugadorConMasTarjetasAmarillas()));
                                break;
                            case 8:
                                System.out.println(String.format("El jugador con mas tarjetas rojas es %s", equipos.jugadorConMasTarjetasRojas()));
                                break;
                            case 9:
                                equipos.mostrarJugadoresPorEquipo();
                                break;
                            case 10:
                                equipos.listarCuerpoTecnico();
                                break;
                            case 11:
                                seguir3 = false;
                                break;
                            default:
                                break;
                        }
                    }
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
                                equipos.registrarCTecnico(input, equipo);
                                break;
                            case 3:
                                equipos.registrarCMedico(input, equipo);
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
    public static int menuReportes(Scanner input){
        System.out.println("Submenú de Reportes:");
        System.out.println("1. Nombre del equipo que más goles anotó");
        System.out.println("2. Nombre del equipo que más puntos tiene");
        System.out.println("3. Nombre del equipo que más partidos ganó");
        System.out.println("4. Total de goles anotados por todos los equipos");
        System.out.println("5. Promedio de goles anotados en el torneo");
        System.out.println("6. Jugador con más goles");
        System.out.println("7. Jugador con más tarjetas amarillas");
        System.out.println("8. Jugador con más tarjetas rojas");
        System.out.println("9. Mostrar jugadores por equipo");
        System.out.println("10. Listar cuerpo Técnico");
        System.out.println("11. Salir");
        System.out.print("Seleccione una opción: ");
        int responder = input.nextInt();
        input.nextLine();
        return responder;
    }
}