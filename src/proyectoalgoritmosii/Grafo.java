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
public class Grafo {
    private ArrayList<Tarea> tareas;
    
    public Grafo(){
        this.tareas = new ArrayList<>();
    }
    
    public ArrayList<Tarea> getTareas(){
        return this.tareas;
    }
    
    public void addTarea(Tarea tarea){
        this.tareas.add(tarea);
    }
    
    public int sumarTiempos(){
        int total = 0;
        for(Tarea tarea : this.tareas){
            total = total + tarea.getTiempo();
        }
        return total;
    }
    
}
