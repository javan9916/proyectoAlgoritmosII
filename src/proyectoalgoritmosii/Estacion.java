/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmosii;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Estacion {
    private int numero;
    private int ciclo;
    private int restante;
    private ArrayList<Tarea> tareas;

    public Estacion(int numero, int ciclo, int restante) {
        this.numero = numero;
        this.ciclo = ciclo;
        this.restante = restante;
        this.tareas = new ArrayList<>();
    }
    
    
}

