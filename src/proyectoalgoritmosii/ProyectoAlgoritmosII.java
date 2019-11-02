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
    
    public static String algoritmo;
    public static int tareas;
    public static Grafo grafo = new Grafo();
    public static ArrayList<Estacion> estaciones = new ArrayList<>();
    
    public static int [][] matrizAdy;
                                      //A,B,C,D,E,F,G,H,I,J
    public static int [][] matriz10 = {{0,1,1,1,0,0,0,0,0,0},//A
                                       {0,0,0,0,0,1,0,0,0,0},//B
                                       {0,0,0,0,0,1,0,0,0,0},//C
                                       {0,0,0,0,1,0,1,0,1,0},//D
                                       {0,0,0,0,0,0,0,1,0,0},//E
                                       {0,0,0,0,0,0,0,0,1,0},//F
                                       {0,0,0,0,0,0,0,1,0,0},//G
                                       {0,0,0,0,0,0,0,0,0,1},//H
                                       {0,0,0,0,0,0,0,0,0,1},//I
                                       {0,0,0,0,0,0,0,0,0,0}};//J
    

                                       //A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T
    public static int [][] matriz20 = { {0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//A
                                        {0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//B
                                        {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0},//C
                                        {0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0},//D
                                        {0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0},//E
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},//F
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},//G
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0},//H
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},//I
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},//J
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},//K
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},//L
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},//M
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},//N
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},//O
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},//P
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},//Q
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},//R
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},//S
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};//T
    
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
        //pedirDatos();
    }
    
    public static void pedirDatos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Especifique las horas de trabajo diarias.");
        String horasS = scanner.next();
        System.out.println("Especifique la cantidad de produccion diaria.");
        String produS = scanner.next();
        int ciclo = 0;
        try{
            int horas = Integer.valueOf(horasS);
            int produ = Integer.valueOf(produS);
            ciclo = (horas * 60 * 60) / produ;
        }catch(NumberFormatException e){
            System.out.println("Los datos de horas de trabajo y cantidad de producción beben ser números enteros.");
            pedirDatos();
        }
        
        menuTamano(ciclo);
    }
    
    public static void menuTamano(int ciclo){
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
                tareas = 10;
                menuAlgoritmo(ciclo);
                break;
            case "2":
                System.out.println("Ha seleccionado 20 tareas.");
                tareas = 20;
                menuAlgoritmo(ciclo);
                break;
            case "3":
                System.out.println("Ha seleccionado 30 tareas.");
                tareas = 30;
                menuAlgoritmo(ciclo);
                break;
            case "4":
                System.out.println("Ha seleccionado 60 tareas.");
                tareas = 60;
                menuAlgoritmo(ciclo);
                break;
            case "5":
                System.out.println("Ha seleccionado tareas aleatorias.");
                tareas = r.nextInt(301-60) + 60;
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
                algoritmoDinamico(ciclo);
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
        matrizAdy = new int[tareas][tareas];
        
        if (tareas == 10) {
            matrizAdy = matriz10;
        } else if (tareas == 20){
            matrizAdy = matriz20;
        } else if (tareas == 30){
            matrizAdy = matriz30;
        } else if (tareas == 60){
            //matrizAdy = matriz60;
        } else {
            tareas = 60;
            int i = 0;
            int j = 0;
            boolean o = true;
            int racha = 0;
            while (i < tareas && j < tareas) {
                if (i >= j) {
                    j++;
                } else {
                    if (i == 0) {
                        o = true;
                        racha = 3;
                    } else if (j <= (tareas/2)-1) {
                        o = true;
                        racha = 2;
                    } else if (j < tareas/2) {
                        o = true;
                        racha = 3;
                    } else if (j == tareas/2) {
                        o = false;
                        racha = 3;
                    } else if (j > tareas/2 && j < tareas-1) {
                        o = false;
                        racha = 2;
                    } else if (j == tareas-1){
                        o = false;
                        racha = 3;
                    }
                    
                    for (int k = 0; k < racha; k++) {
                        if (o && j < tareas) {
                            matrizAdy[i][j] = 1;
                            j++;
                        } else if (!o && i < tareas - 1 && (i != j || i < j)) {
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
        
        for (int i = 0; i < tareas; i++) {
            for (int j = 0; j < tareas; j++) {
                System.out.print(matrizAdy[i][j]+", ");
            }
            System.out.println("");
        }
    }

    public static void crearEstaciones(int ciclo, String algoritmo){
        int tiempoT = grafo.sumarTiempos();
        int estacionesI = tiempoT / ciclo;
        for(int i = 1; i < (estacionesI + 1); i++){
            Estacion est = new Estacion(i, ciclo);
            estaciones.add(est);
        }
        switch(algoritmo){
            case "d":
                algoritmoDinamico(ciclo);
                break;
            case "g":
                break;
            default:
                break;
        }
    }
    public static ArrayList<Tarea> usados = new ArrayList<>();
    
    public static void algoritmoDinamico(int ciclo){   
        ArrayList<Estacion> estacionesF = new ArrayList<>();
        for (Estacion est : estaciones) {
            while(!est.getLlena()){
                est = etapa(est);
            }
            estacionesF.add(est);
        }
    }
    
    public static Estacion etapa(Estacion estacion){
        ArrayList<Tarea> candidatos = sacarCandidatos(usados);
        Tarea escogido = escogerCandidato(candidatos, usados);
        if(escogido.getTiempo() > estacion.getRestante()){
            estacion.setLlena(true);
            return estacion;
        }
        estacion.addTarea(escogido);
        usados.add(escogido);
        return estacion;
    }
    
    public static ArrayList<Tarea> sacarCandidatos(ArrayList<Tarea> usados){
        ArrayList<Tarea> candidatos = new ArrayList<Tarea>();
        
        for(Tarea usado : usados){
            ArrayList<Tarea> adyacentes = usado.getAdyacentes();
            for(Tarea adya : adyacentes){
                if((!usados.contains(adya)) && (!candidatos.contains(adya))){
                    candidatos.add(adya);
                }
            }
        }
        
        return candidatos;
    }
    
    public static Tarea escogerCandidato(ArrayList<Tarea> candidatos, ArrayList<Tarea> usados){
        Tarea escogido = null;
        int mayor = 0;
        for(Tarea cand : candidatos){
            if(revisarPrevios(cand, usados)){
                if(cand.getTiempo() < mayor){
                    escogido = cand;
                    mayor = cand.getTiempo();
                }
            }
        }
        return escogido;
    }
    
    public static boolean revisarPrevios(Tarea tarea, ArrayList<Tarea> usados){
        boolean result = true;
        ArrayList<Tarea> previos = tarea.getPrevios();
        for(Tarea prev : previos){
            if(!usados.contains(prev)){
                result = false;
                break;
            }
        }
        return result;
    }
}
