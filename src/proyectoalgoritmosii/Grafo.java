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

/*FECHA DE CREACION: 18/10/19
ULTIMA MODIFICACION:27/10/19

Clase que almacena la lista de tareas creadas, ademas de algunas funciones relacionadas a estas*/
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
    //Suma el tiempo total de las tareas en el grafo
    public int sumarTiempos(){
        int total = 0;
        for(Tarea tarea : tareas){
            total = total + tarea.getTiempo();
        }
        return total;
    }
    //Crea una relacion de adyacencia entre 2 tareas
    public void addAdyacencia(int origen, int destino){
        tareas.get(origen).addAdyacente(tareas.get(destino));
    }
    //Crea una relacion de dependencia entre 2 tareas
    public void addRequisito(int tarea, int previo){
        tareas.get(tarea).addPrevio(tareas.get(previo));
    }
    
}
