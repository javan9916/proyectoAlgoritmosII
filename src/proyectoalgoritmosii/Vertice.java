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
public class Vertice {
    private String vertice;
    private boolean used;
    private int beneficio;
    private ArrayList<Arco> arcos;
    
    public Vertice(String vertice, Boolean adyacente, int beneficio) {
        this.vertice = vertice;
        this.used = adyacente;
        this.beneficio = beneficio;
    }

    public void setVertice(String vertice) {
        this.vertice = vertice;
    }

     public String getVertice() {
        return vertice;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
    
    public Boolean getUsed() {
        return used;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void addArco(Arco arco) {
        if (arcos == null)
           this.arcos = new ArrayList<>();
        
        this.arcos.add(arco);
    }

    public ArrayList<Arco> getArcos() {
        return arcos;
    }
    
    public void marcarArcos(){
        for(int i = 0; i < arcos.size(); i++){
            arcos.get(i).setUsed(true);
        }
    }
    
    public int getArcosActivos(){
        int arcosT = 0;
        for(Arco arc : arcos){
            if(!arc.getUsed()){
                arcosT++;
            }
        }
        return arcosT;
    }
}
