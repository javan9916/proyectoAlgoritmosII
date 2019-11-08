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
    public static ArrayList<Tarea> usados = new ArrayList<>();
    
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
    
    public static void menuTamano(int ciclo){
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Seleccione la cantidad de tareas que desea optimizar:\n"
                + "1) 10 tareas\n"
                + "2) 20 tareas\n"
                + "3) 30 tareas\n"
                + "4) 60 tareas\n"
                + "5) tareas aleatorias\n");
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
                System.out.println("Ha seleccionado tareas aleatorias.");
                tareas = r.nextInt(301-60) + 60;
                crearTareas(ciclo);
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
    
    public static void crearTareas(int ciclo){
        Random rnd = new Random();
        for (int i = 1; i <= tareas; i++) {
            int tiempo = rnd.nextInt(51);
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
    
    public static void printTareas(){
        System.out.println("TAREAS CREADAS SEGUN DATOS PROPORCIONADOS \n");
        ArrayList<Tarea> tareasO = grafo.getTareas();
        for(Tarea tarea : tareasO){
            System.out.println("Tarea número: " + tarea.getNumero() + ". Tiempo: " + tarea.getTiempo());
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

    public static void crearEstaciones(int ciclo){
        int tiempoT = grafo.sumarTiempos();
        System.out.println("Tiempo de tareas total: " + tiempoT);
        int estacionesI = tiempoT / ciclo;
        System.out.println("Estaciones totales: " + estacionesI);
        for(int i = 1; i < (estacionesI + 1); i++){
            Estacion est = new Estacion(i, ciclo);
            estaciones.add(est);
        }
    }
    
    public static void algoritmoDinamico(int ciclo){   
        ArrayList<Estacion> estacionesF = new ArrayList<>();
        for(Estacion est : estaciones){
            while(!est.getLlena()){
                est = etapa(est);
            }
            estacionesF.add(est);
        }
        System.out.println("DISTRIBUCION DE TAREAS, CON SUS TIEMPOS, POR ESTACION \n");
        for(Estacion esta : estacionesF){
            System.out.println("Estación número: " + esta.getNumero() + ". Tiempo sobrante: " + esta.getRestante());
            String tareasS = "Tareas en la estación y duración de cada tarea: ";
            ArrayList<Tarea> tareasE = esta.getTareas();
            for(Tarea tarea : tareasE){
                tareasS = tareasS + "Tarea#" + tarea.getNumero() + ", duracion: " + tarea.getTiempo() + "; ";
            }
            System.out.println(tareasS);
            System.out.println("");
        }
        
        optimizador(estaciones, ciclo);
    }
    
    public static Estacion etapa(Estacion estacion){
        if(usados.size() == tareas){
            return estacion;
        }else if(usados.size() == 0){
            Tarea primero = grafo.getTareas().get(0);
            estacion.addTarea(primero);
            usados.add(primero);
            return estacion;
        }
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
                if(cand.getTiempo() > mayor){
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
    
    public static void optimizador(ArrayList<Estacion> estaciones, int ciclo){
        System.out.println("OPTIMIZACION FINAL DE LAS ESTACIONES Y TIEMPO DE CICLO \n");
        int optimizacion = 0;
        while(posible(estaciones, optimizacion)) {
            optimizacion++;
        }
        if(optimizacion == 0){
            System.out.println("No es posible optimizar más el resultado pues no se puede disminuir el tiempo de ciclo");
            return;
        }
        int newCiclo = ciclo - optimizacion;
        System.out.println("El tiempo de ciclo puede ser reducido de " + ciclo + " a " +  newCiclo + ", ahorrando " + optimizacion + " segundos.");
        System.out.println("Optimizacion resultante de las estaciones:");
        for(Estacion estacion : estaciones){
            String linea = "Estacion " + String.valueOf(estacion.getNumero()) + " se reduce de " + estacion.getRestante() + " a "; 
            estacion.optimizar(optimizacion);
            linea = linea + String.valueOf(estacion.getRestante() + " segundos sobrantes.");
            System.out.println(linea);
        }
        
    }
    
    public static boolean posible(ArrayList<Estacion> estaciones, int optimizacion){
        boolean result = true;
        for(Estacion estacion : estaciones){
            if((estacion.getRestante() - optimizacion) <= 0){
                result = false;
                break;
            }
        }
        return result;
    }
}
