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
    /*
    PROYECTO ANALSIS 2
    FECHA DE CREACION: 18/10/19
    ULTIMA MODIFICACION: 17/11/19*/
    
    /*FECHA DE CREACION: 18/10/19
    ULTIMA MODIFICACION: 02/11/19
    CREADOR: Carlos
    
    Algoritmo es una variable que guarda qué algoritmo se ha escogido ejecutar en el menuAlgoritmo,
    tareas se refiere a la cantidad de tareas que se ha escogido trabajar en el menuTamaño,
    grafo es el objeto grafo que almacena las tareas y sus conecciones,
    estaciones es la lista de estaciones, generadas segun la formala tiempo_total_de_tareas/tiempo_de_ciclo,
    usados es una lista que almacena las tareas que ya se han procesado durante la ejecucion de un algritmo*/
    public static String algoritmo;
    public static int tareas;
    public static Grafo grafo;
    public static ArrayList<Estacion> estaciones;
    public static ArrayList<Tarea> usados;
    
    
    /*FECHA DE CREACION: 08/11/19
    ULTIMA MODIFICACION: 10/11/19
    CREADOR: Carlos
    
    Variables utilizadas para la medicion empririca del algoritmo dinamico*/
    static int compsDina = 0;
    static int asigsDina = 0;
    static int lineaDina = 0;
    
    
    /*FECHA DE CREACION: 18/10/19
    ULTIMA MODIFICACION: 20/10/19
    CREADOR: Javier(10, 20, 30) y Carlos(60)
    
    Matrices base para la creacion de las tareas y sus conecciones*/
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
                                     //0                 1                   2                   3                   4                   5                   6
                                     //1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0
    public static int[][] matriz60 = {{0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//1
                                      {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//2
                                      {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//3
                                      {0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//4
                                      {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//5
                                      {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//6
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//7
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//8
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//9
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//10
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//11
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//12
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//13
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//14
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//15
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//16
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//17
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//18
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//19
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//20
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//21
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//22
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//23
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//24
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//25
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//26
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//27
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//28
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//29
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//30
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//31
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//32
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//33
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//34
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//35
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//36
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//37
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//38
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0},//39
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},//40
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},//41
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},//42
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},//43
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},//44
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},//45
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},//46
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},//47
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},//48
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},//49
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},//50
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0},//51
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},//52
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},//53
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},//54
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},//55
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},//56
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},//57
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},//58
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},//59
                                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};//60
    
    public static void main(String[] args) {
        pedirDatos();
    }
    /*FECHA DE CREACION: 20/10/19
    ULTIMA MODIFICACION: 20/10/19
    CREADOR: Carlos
    
    Algoritmo que pide en consola los datos de horas de trabajo y produccion total diaria,
    necesarios para el calculo de tiempo de cilo, devolviendo este ultimo dato*/
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
        System.out.println("Tiempo de ciclo: " + ciclo);
        menuTamano(ciclo);
    }
    /*FECHA DE CREACION: 18/10/19
    ULTIMA MODIFICACION: 18/10/19
    CREADOR: Carlos
    
    Menu que perimite al usuario escoger desde consola la cantidad de tareas a trabajar*/
    public static void menuTamano(int ciclo){
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Seleccione la cantidad de tareas que desea optimizar:\n"
                + "1) 10   tareas\n"
                + "2) 20   tareas\n"
                + "3) 30   tareas\n"
                + "4) 60   tareas\n"
                + "5) 120  tareas\n"
                + "6) 1200 tareas");
        System.out.println("Opción: ");
        String option = scanner.next();
           switch(option){
            case "1":
                System.out.println("Ha seleccionado 10 tareas.");
                tareas = 10;
                matrizAdy = matriz10;
                crearTareas(ciclo);
                break;
            case "2":
                System.out.println("Ha seleccionado 20 tareas.");
                tareas = 20;
                matrizAdy = matriz20;
                crearTareas(ciclo);
                break;
            case "3":
                System.out.println("Ha seleccionado 30 tareas.");
                tareas = 30;
                matrizAdy = matriz30;
                crearTareas(ciclo);
                break;
            case "4":
                System.out.println("Ha seleccionado 60 tareas.");
                tareas = 60;
                matrizAdy = matriz60;
                crearTareas(ciclo);
                break;
            case "5":
                System.out.println("Ha seleccionado 120 tareas.");
                tareas = 120;
                crearTareas(ciclo);
                break;
            case "6":
                System.out.println("Ha seleccionado 1200 tareas.");
                tareas = 1200;
            default: 
                System.out.println("Elección inválida, por favor seleccione una opcción válida.");
                menuTamano(ciclo);
                break;
            } 
    }
    /*FECHA DE CREACION: 18/10/19
    ULTIMA MODIFICACION: 18/10/19
    CREADOR: Carlos
    
    Menu que permite al usario escoger desde consola el algoritmo a ejecutar*/
    public static void menuAlgoritmo(int ciclo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Algoritmos:\n"
                + "1) Programación dinámica\n"
                + "2) Algoritmo genético\n");
        System.out.println("Opción: ");
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
    /*FECHA DE CREACION: 20/10/19
    ULTIMA MODIFICACION: 12/11/19
    CREADOR: Javier
    
    Algoritmo que crea una matriz aleatoria para trabajar tamaños de 120 o 1200*/
    public static void crearMatriz() {
        matrizAdy = new int[tareas][tareas];
        
        if (tareas == 10) {
            matrizAdy = matriz10;
        } else if (tareas == 20){
            matrizAdy = matriz20;
        } else if (tareas == 30){
            matrizAdy = matriz30;
        } else if (tareas == 60){
            matrizAdy = matriz60;
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
                System.out.println(matrizAdy[i][j]+", ");
            }
            System.out.println("");
        }
    }
    /*FECHA DE CREACION: 30/10/19
    ULTIMA MODIFICACION: 30/10/19
    CREADOR: Carlos
    
    Algoritmo que crea una cantidad de tareas, con tiempos aleatorios y sus respectivas relaciones de dependencia y adyacencia,
    segun se especifico en el menuTamaño y las introduce en el grafo*/
    
    public static void crearTareas(int ciclo){
        grafo = new Grafo();
        Random rnd = new Random();
        for (int i = 1; i <= tareas; i++) {
            int tiempo = rnd.nextInt(50) + 1;
            Tarea newTarea = new Tarea(i, tiempo);
            grafo.addTarea(newTarea);
        }
        
        for (int i = 0; i < tareas; i++) {
            for (int j = 0; j < tareas; j++) {
                if(matrizAdy[i][j] == 1){
                    grafo.addAdyacencia(i, j);
                    grafo.addRequisito(j, i);
                }
            }
        }
        printTareas();
        crearEstaciones(ciclo);
        menuAlgoritmo(ciclo);
    }
    /*FECHA DE CREACION: 30/10/19
    ULTIMA MODIFICACION: 30/10/19
    CREADOR: Carlos
    
    Imprime los datos de cada tarea creada*/
    public static void printTareas(){
        System.out.println("TAREAS CREADAS SEGUN DATOS PROPORCIONADOS \n");
        ArrayList<Tarea> tareasO = grafo.getTareas();
        for(Tarea tarea : tareasO){
            System.out.println("Tarea número: " + tarea.getNumero() + ". Tiempo: " +
                    tarea.getTiempo());
            String adyacentesS = "Adyacentes: ";
            ArrayList<Tarea> tareasD = tarea.getAdyacentes();
            for(Tarea adya : tareasD){
                String adyaS = String.valueOf(adya.getNumero());
                adyacentesS = adyacentesS + adyaS + ", ";
            }
            System.out.println(adyacentesS);
            String previosS = "Previos: ";
            ArrayList<Tarea> tareasP = tarea.getPrevios();
            for(Tarea previo : tareasP){
                String previoS = String.valueOf(previo.getNumero());
                previosS = previosS + previoS + ", ";
            }
            System.out.println(previosS);
        }
        System.out.println("");
    }
    /*FECHA DE CREACION: 30/10/19
    ULTIMA MODIFICACION: 30/10/19
    CREADOR: Carlos
    
    Crea una determinada cantidad de estaciones segun la formula especificada*/
    public static void crearEstaciones(int ciclo){
        estaciones = new ArrayList<>();
        int tiempoT = grafo.sumarTiempos();
        System.out.println("Tiempo de tareas total: " + tiempoT);
        int estacionesI = (tiempoT / ciclo) + 1;
        System.out.println("Estaciones totales: " + estacionesI);
        for(int i = 1; i < (estacionesI + 1); i++){
            Estacion est = new Estacion(i, ciclo);
            estaciones.add(est);
        }
    }
    
    public static void algoritmoDinamico(int ciclo){
        asigsDina = 0;
        compsDina = 0;
        lineaDina = 0;
        int iteracion = 0;
        usados = new ArrayList<>();                                             asigsDina++; lineaDina++;
        ArrayList<Estacion> estacionesF = new ArrayList<>();                    asigsDina++; lineaDina++;                                            
        for(Estacion est : estaciones){                                         asigsDina++; compsDina++; lineaDina++;                                                                  
            while(!est.getLlena()){                                             compsDina++; lineaDina++;                           
                est = etapa(est, iteracion);                                               asigsDina++; lineaDina++;                                                       
                iteracion++;
            }
            estacionesF.add(est);                                               asigsDina++; lineaDina++;                                                      
        }
        
        //IMPRESION DE LOS RESULTADOS PRELIMINARES, NO CUENTA DENTRO DE LOS PASOS
        System.out.println("DISTRIBUCION DE TAREAS, CON SUS TIEMPOS, POR ESTACION \n");
        for(Estacion esta : estacionesF){
            System.out.println("Estación número: " + esta.getNumero() + ""
                    + ". Tiempo sobrante: " + esta.getRestante());
            String tareasS = "Tareas en la estación y duración de cada tarea: ";
            ArrayList<Tarea> tareasE = esta.getTareas();
            for(Tarea tarea : tareasE){
                tareasS = tareasS + "Tarea#" + tarea.getNumero() + 
                        ", duracion: " + tarea.getTiempo() +"; ";
            }
            System.out.println(tareasS);
            System.out.println("");
        }
        
        optimizador(estaciones, ciclo);
    }
    
    public static Estacion etapa(Estacion estacion, int iteracion){                            lineaDina++;
        if(usados.size() == tareas){                                            compsDina++; lineaDina++;
            return estacion;
        }else if(usados.isEmpty()){                                             compsDina++; lineaDina++;
            Tarea primero = grafo.getTareas().get(0);                           asigsDina++; lineaDina++;
            estacion.addTarea(primero);                                         asigsDina++; lineaDina++;
            usados.add(primero);                                                asigsDina++; lineaDina++; lineaDina++;
            System.out.println("");
            System.out.println("Etapa: " + iteracion);
            System.out.println("Usados: Ninguno" );
            System.out.println("Candidatos: 1");
            System.out.println("Escogido: 1");
            System.out.println("");
            return estacion;
        }
        ArrayList<Tarea> candidatos = sacarCandidatos(usados);                  asigsDina++; lineaDina++;
        Tarea escogido = escogerCandidato(candidatos, usados);                  asigsDina++; lineaDina++;
        if(escogido.getTiempo() > estacion.getRestante()){                      compsDina++; lineaDina++;
            estacion.setLlena(true);                                            asigsDina++; lineaDina++; lineaDina++;
            //if(iteracion <= 10){
                printEtapa(candidatos, escogido, iteracion);
            //}
            return estacion;
        }
        //if(iteracion <= 10){
            printEtapa(candidatos, escogido, iteracion);
        //}
        estacion.addTarea(escogido);                                            asigsDina++; lineaDina++;
        usados.add(escogido);                                                   asigsDina++; lineaDina++; lineaDina++;        
        return estacion;
    }
    
    public static ArrayList<Tarea> sacarCandidatos(ArrayList<Tarea> usados){
        ArrayList<Tarea> candidatos = new ArrayList<Tarea>();                   asigsDina++; lineaDina++;
        
        for(Tarea usado : usados){                                              asigsDina++; compsDina++; lineaDina++;
            ArrayList<Tarea> adyacentes = usado.getAdyacentes();                asigsDina++; lineaDina++;
            for(Tarea adya : adyacentes){                                       asigsDina++; compsDina++; lineaDina++; lineaDina++;
                if((!usados.contains(adya)) && (!candidatos.contains(adya))){   compsDina++; lineaDina++;
                    candidatos.add(adya);                                       asigsDina++; lineaDina++;
                }
            }
        }
                                                                                lineaDina++;
        return candidatos;
    }
    
    public static Tarea escogerCandidato(ArrayList<Tarea> candidatos, ArrayList<Tarea> usados){
        Tarea escogido = null;                                                  asigsDina++; lineaDina++;
        int mayor = 0;                                                          asigsDina++; lineaDina++; lineaDina++;
        for(Tarea cand : candidatos){                                           asigsDina++; compsDina++; lineaDina++; lineaDina++;
            if(revisarPrevios(cand, usados)){                                   compsDina++; lineaDina++; lineaDina++;
                if(cand.getTiempo() > mayor){                                   compsDina++; lineaDina++;
                    escogido = cand;                                            asigsDina++; lineaDina++;
                    mayor = cand.getTiempo();                                   asigsDina++; lineaDina++;
                }
            }
        }                                                                       lineaDina++;
        return escogido;
    }
    
    public static boolean revisarPrevios(Tarea tarea, ArrayList<Tarea> usados){
        boolean result = true;                                                  asigsDina++; lineaDina++;
        ArrayList<Tarea> previos = tarea.getPrevios();                          asigsDina++; lineaDina++; lineaDina++;
        for(Tarea prev : previos){                                              asigsDina++; compsDina++; lineaDina++;
            if(!usados.contains(prev)){                                         compsDina++; lineaDina++;
                result = false;                                                 asigsDina++; lineaDina++; lineaDina++;
                break;
            }
        }                                                                       lineaDina++;
        return result;
    }
    
    public static void printEtapa(ArrayList<Tarea> candidatos, Tarea escogido, int iteracion){
        System.out.println("");
        System.out.println("Etapa " + iteracion);
        
        String usadosS = "Usados: ";
        for(Tarea usado : usados){
            usadosS = usadosS + String.valueOf(usado.getNumero()) + ", ";
        }
        System.out.println(usadosS);
        String candidadosS = "Candidatos: ";
        for(Tarea candidato : candidatos){
            candidadosS = candidadosS + String.valueOf(candidato.getNumero()) + ", ";
        }
        System.out.println(candidadosS);
        System.out.println("Escogido: " + escogido.getNumero());
        System.out.println("");
    }
    
    public static void optimizador(ArrayList<Estacion> estaciones, int ciclo){
        System.out.println("OPTIMIZACION FINAL DE LAS ESTACIONES Y TIEMPO DE CICLO \n");
        int optimizacion = 0;                                                   asigsDina++; lineaDina++; lineaDina++;
        while(posible(estaciones, optimizacion)) {                              compsDina++; lineaDina++;
            optimizacion++;                                                     asigsDina++; lineaDina++;
        }
        //IMPRESION DE LOS RESULTADOS OPTIMIZADOS, NO CUENTA DENTRO DE LOS PASOS
        if(optimizacion == 0){
            System.out.println("No es posible optimizar más el resultado pues no se"
                    + " puede disminuir el tiempo de ciclo");
        }else{
            int newCiclo = ciclo - optimizacion;
            System.out.println("El tiempo de ciclo puede ser reducido de " + ciclo + " a " +  newCiclo +
                    ", ahorrando " + optimizacion + " segundos.");
            System.out.println("Optimizacion resultante de las estaciones:");
            for(Estacion estacion : estaciones){
                String linea = "Estacion " + String.valueOf(estacion.getNumero()) + " se reduce de "
                        + estacion.getRestante() + " a "; 
                estacion.optimizar(optimizacion);
                linea = linea + String.valueOf(estacion.getRestante() + " segundos sobrantes.");
                System.out.println(linea);
            }
        }
        System.out.println("\n");
        System.out.println("Algoritmo dinamico. Asignaciones totales:" + asigsDina + ", comparaciones totales: " + compsDina + ", lineas ejecutadas: " + lineaDina);
        System.out.println("\n");
        menuTamano(ciclo);
    }
    
    public static boolean posible(ArrayList<Estacion> estaciones, int optimizacion){
        boolean result = true;                                                  asigsDina++; lineaDina++; lineaDina++;
        for(Estacion estacion : estaciones){                                    asigsDina++; compsDina++; lineaDina++; lineaDina++;
            if((estacion.getRestante() - optimizacion) <= 0){                   compsDina++; lineaDina++; lineaDina++;
                result = false;                                                 asigsDina++; lineaDina++;lineaDina++;
                break;
            }
        }                                                                       lineaDina++;
        return result;
    }
}
