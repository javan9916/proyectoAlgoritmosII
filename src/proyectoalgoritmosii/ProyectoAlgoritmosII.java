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
                                      //A,B,C,D,E,F,G,H,I,J
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
    

                                       //A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T
    public static int [][] matriz20 = { {0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    
                                       //A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,A,B,C,D
    public static int [][] matriz30 = { {0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//A
                                        {0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//B
                                        {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//C
                                        {0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//D
                                        {0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//E
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//F
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//G
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//H
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//I
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//J
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},//K
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},//L
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},//M
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},//N
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},//O
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},//P
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},//Q
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0},//R
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},//S
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0},//T
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},//U
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},//V
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},//W
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},//X
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0},//Y
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0},//Z
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},//AA
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},//AB
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},//AC
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};//AD

    
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
    
    public static void crearMatriz() {
        matrizAdy = new int[vertices][vertices];
        int cont = 0;
        Random r = new Random();
        
        if (vertices == 10) {
            matrizAdy = matriz10;
        } else if (vertices == 20){
            matrizAdy = matriz20;
        } else if (vertices == 30){
            matrizAdy = matriz30;
        } else if (vertices == 60){
            //matrizAdy = matriz60;
        } else {
            int i = 0;
            int j = 0;
            boolean o;
            int racha;
            while (i < vertices) {
                if (i >= j) {
                    j++;
                } else {
                    if (i < (vertices/2)-1) {
                        o = true;
                        racha = ThreadLocalRandom.current().nextInt(2, 4);
                    } else if (j >= vertices) {
                        o = false;
                        racha = (vertices - 1);
                    } else {
                        o = r.nextBoolean();
                        racha = ThreadLocalRandom.current().nextInt(2, 4);
                    }
                    
                    if ((i + racha) > j)
                        o = true;
                    
                    for (int k = 0; k < racha; k++) {
                        if (o && j < vertices) {
                            matrizAdy[i][j] = 1;
                            j++;
                        } else if (!o && i < vertices - 1 && (i != j || i < j)) {
                            matrizAdy[i][j] = 1;
                            i++;
                        }
                    }
                    
                    if (o) {
                        i++;
                    } else {
                        j++;
                    }
                }
            }
        }
    }
    
    public static void crearMatrizxd(){
        matrizAdy = new int[vertices][vertices];
        int cont = 0;
        Random r = new Random();

        if (vertices == 10) {
            matrizAdy = matriz10;
        } else if(vertices != 20){
            //matrizAdy = matriz20;
        } else {
            boolean o;
            int racha = 0;
            int a = 0;
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (i != j && i < j) {
                        if (i == 0) {
                            o = true;
                            racha = ThreadLocalRandom.current().nextInt(2, 4);
                        } else if (j == vertices) {
                            o = false;
                            racha = (vertices - i);
                        } else {
                            if (a <= 20) {
                               j = a; 
                            }
                            o = r.nextBoolean();
                            racha = ThreadLocalRandom.current().nextInt(2, 4);
                        }
                        
                        for (int k = 0; k < racha; k++) {
                            if (o && j < vertices) {
                                matrizAdy[i][j] = 1;
                                j++;
                            } else if (!o && i < vertices - 1) {
                                System.out.println(j);
                                matrizAdy[i][j] = 1;
                                i++;
                            }
                        }
                        a = j;
                        /*if (i == 0 || i == (vertices / 2) - 2 || i == (vertices / 2) + 2) {
                            cont++;
                        }*/
                        break;
                    }
                    
                }
            }

            /*while (cont < arcos) {
                for (int i = 0; i < vertices; i++) {
                    int limite = 1;
                    if (i <= vertices - 3 && limite <= 2) {
                        int j = 19;
                        if ((2 + i) != (vertices - 1)) {
                            j = ThreadLocalRandom.current().nextInt(2 + i, vertices - 1);
                        }
                        if (matrizAdy[i][j] == 0 && i + 2 <= j) {
                            matrizAdy[i][j] = 1;
                            matrizAdy[j][i] = 1;
                            limite++;
                            cont++;
                        }
                    }
                }
            }*/
        }
        
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrizAdy[i][j]+", ");
            }
            System.out.println("");
        }
    }
    
    /*public static Estacion etapa(Estacion estacion){
        Estacion actual = estacion;
        return actual;
    }*/

}
