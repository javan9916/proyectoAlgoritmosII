/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmosii;

import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class Tarea {
    private int numero;
    private int tiempo;
    private ArrayList<Tarea> previos;
    private ArrayList<Tarea> adyacentes;

    public Tarea(int numero, int tiempo) {
        this.numero = numero;
        this.tiempo = tiempo;
        this.previos = new ArrayList<>();
        this.adyacentes = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public int getTiempo() {
        return tiempo;
    }

    public ArrayList<Tarea> getPrevios() {
        return previos;
    }
    
    public ArrayList<Tarea> getAdyacentes(){
        return adyacentes;
    }
    
    public void addPrevio(Tarea previo){
        this.previos.add(previo);
    }
    
    public void addAdyacente(Tarea adya){
        this.adyacentes.add(adya);
    }
}
