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
    private int restante;
    private boolean llena;
    private ArrayList<Tarea> tareas;

    public Estacion(int numero, int restante) {
        this.numero = numero;
        this.restante = restante;
        this.llena = false;
        this.tareas = new ArrayList<>();
    }
    
    public void addTarea(Tarea tarea){
        this.tareas.add(tarea);
        this.restante = restante - tarea.getTiempo();
    }

    public int getNumero() {
        return numero;
    }

    public int getRestante() {
        return restante;
    }

    public boolean getLlena() {
        return llena;
    }

    public void setLlena(boolean llena) {
        this.llena = llena;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
}

