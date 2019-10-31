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
        pedirDatos();
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
                tareas = r.nextInt(361-60) + 60;
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
