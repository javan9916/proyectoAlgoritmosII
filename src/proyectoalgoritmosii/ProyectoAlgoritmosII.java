/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmosii;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Javier
 */
public class ProyectoAlgoritmosII {
    
    public static Grafo g;
    public static ArrayList<Vertice> verticesLocales;
    public static ArrayList<Arco> arcosLocales;
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
    
    public static void main(String[] args) {
        menuTamano();
    }
    
    public static void menuAlgoritmo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Algoritmos:\n"
                + "1) Programación dinámica\n"
                + "2) Algoritmo genético\n");
        System.out.print("Opción: ");
        String option = scanner.next();
        switch(option){
            case "1":
                System.out.println("Ha seleccionado programación dinámica.");
                menuTamano();
                break;
            case "2":
                System.out.println("Ha seleccionado el algoritmo genético.");
                menuTamano();
                break;
            default: 
                System.out.println("Elección inválida, por favor seleccione una opción válida.");
                menuAlgoritmo();
                break;
        }
    }
    
    public static void menuTamano() {
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
                //crearMatriz1(algoritmo);
                break;
            case "2":
                System.out.println("Ha seleccionado 20 tareas.");
                vertices = 20;
                //crearMatriz1(algoritmo);
                break;
            case "3":
                System.out.println("Ha seleccionado 30 tareas.");
                vertices = 30;
                //crearMatriz1(algoritmo);
                break;
            case "4":
                System.out.println("Ha seleccionado 60 tareas.");
                vertices = 60;
                //crearMatriz1(algoritmo);
                break;
            case "5":
                System.out.println("Ha seleccionado tareas aleatorias.");
                vertices = r.nextInt(361-60) + 60;
                //crearMatriz1(algoritmo);
                break;
            default: 
                System.out.println("Elección inválida, por favor seleccione una opcción válida.");
                menuTamano();
                break;
            } 
    }
    
}
