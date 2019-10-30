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
public class Grafo {
    ArrayList<Vertice> vertices;
    
    public Grafo() {
        
    }

    public void addVertice(Vertice vertice) {
        if (this.vertices == null) 
            vertices = new ArrayList<>();
        
        this.vertices.add(vertice);
    }
    
    public void marcarVertice(Vertice vertice){
        for(int i = 0; i < vertices.size(); i++){
            if(vertices.get(i) == vertice){
                if(!vertices.get(i).getUsed()){
                    vertices.get(i).marcarArcos();
                    vertices.get(i).setUsed(true);
                }
            }else{
                ArrayList<Arco> arcos = vertices.get(i).getArcos();
                for(int j = 0; j < arcos.size(); j++){
                    if(arcos.get(j).getDestino() == vertice){
                        if(!arcos.get(j).getUsed()){
                            arcos.get(j).setUsed(true);
                        }
                    }
                }
            }
        }
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }
    
    public Vertice buscarVerticeGrafo(String v) {
        int i = Integer.parseInt(v);
        return vertices.get(i);
    }
    
    public boolean verificarUsados() {
        for (int i = 0; i < vertices.size(); i++) {
            if (!vertices.get(i).getUsed()) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Vertice> buscarVerticesSueltos() {
        ArrayList<Vertice> v = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            if (!vertices.get(i).getUsed()) {
                ArrayList<Arco> a = vertices.get(i).getArcos();
                boolean suelto = true;
                if (!a.isEmpty()) {
                    for (int j = 0; j < a.size(); j++) {
                        if (!a.get(j).getDestino().getUsed()) {
                            suelto = false;
                        }
                    }
                }
                
                if (suelto) {
                    v.add(vertices.get(i));
                }
            }
        }
        
        return v;
    }
}
