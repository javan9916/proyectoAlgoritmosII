/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmosii;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Javier
 */
public class ProyectoAlgoritmosII {
    
    public static ArrayList<Tarea> verticesLocales;
    public static String algoritmo;
    public static int vertices;
    public static int arcos;
    public static int [][] matrizAdy;
    
    public static int [][] matriz10 = {{0,1,1,1,0,0,0,0,0,0},
                                       {0,0,0,0,0,1,0,0,0,0},
                                       {0,0,0,0,0,1,0,0,0,0},
                                       {0,0,0,0,1,0,1,0,1,0},
                                       {0,0,0,0,0,0,0,1,0,0},
                                       {0,0,0,0,0,0,0,0,1,0},
                                       {0,0,0,0,0,0,0,1,0,0},
                                       {0,0,0,0,0,0,0,0,0,1},
                                       {0,0,0,0,0,0,0,0,0,1},
                                       {0,0,0,0,0,0,0,0,0,0}};
    
    public static int[][] matriz20 = {};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Especifique las horas de trabajo diarias.");
        String horasS = scanner.next();
        System.out.println("Especifique la cantidad de produccion diaria.");
        String produS = scanner.next();
        int horas = Integer.valueOf(horasS);
        int produ = Integer.valueOf(produS);
        int ciclo = (horas * 60 * 60) / produ;
        menuTamano(ciclo);
    }
    
    public static void menuTamano(int ciclo) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Seleccione la cantidad de tareas que desea optimizar:\n"
                + "1) 10 tareas\n"
                + "2) 20 tareas\n"
                + "3) 30 tareas\n"
                + "4) 60 tareas\n"
                + "5) tareas aleatorias\n");
        System.out.print("Opción: ");
        String option = scanner.next();
           switch(option){
            case "1":
                System.out.println("Ha seleccionado 10 tareas.");
                vertices = 10;
                menuAlgoritmo(ciclo);
                break;
            case "2":
                System.out.println("Ha seleccionado 20 tareas.");
                vertices = 20;
                menuAlgoritmo(ciclo);
                break;
            case "3":
                System.out.println("Ha seleccionado 30 tareas.");
                vertices = 30;
                menuAlgoritmo(ciclo);
                break;
            case "4":
                System.out.println("Ha seleccionado 60 tareas.");
                vertices = 60;
                menuAlgoritmo(ciclo);
                break;
            case "5":
                System.out.println("Ha seleccionado tareas aleatorias.");
                vertices = r.nextInt(361-60) + 60;
                menuAlgoritmo(ciclo);
                break;
            default: 
                System.out.println("Elección inválida, por favor seleccione una opcción válida.");
                menuTamano(ciclo);
                break;
            } 
    }
    
    public static void menuAlgoritmo(int ciclo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Algoritmos:\n"
                + "1) Programación dinámica\n"
                + "2) Algoritmo genético\n");
        System.out.print("Opción: ");
        String option = scanner.next();
        switch(option){
            case "1":
                System.out.println("Ha seleccionado programación dinámica.");
                algoritmo = "d";
                menuTamano(ciclo);
                break;
            case "2":
                System.out.println("Ha seleccionado el algoritmo genético.");
                algoritmo = "g";
                menuTamano(ciclo);
                break;
            default: 
                System.out.println("Elección inválida, por favor seleccione una opción válida.");
                menuAlgoritmo(ciclo);
                break;
        }
    }
    
    public static void algoritmoDinamico(int ciclo){
        
    }
    
    public static Estacion etapa(Estacion estacion){
        Estacion actual = estacion;
        return actual;
    }
}
