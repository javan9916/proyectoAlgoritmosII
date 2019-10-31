/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmosii;

/**
 *
 * @author Javier
 */
public class Arco {
    private Tarea origen;
    private Tarea destino;
    private Boolean used;
    
    public Arco(Tarea origen, Tarea destino, Boolean anadido) {
        this.origen = origen;
        this.destino = destino;
        this.used = anadido;
    }

    public void setOrigen(Tarea origen) {
        this.origen = origen;
    }
    
    public Tarea getOrigen() {
        return origen;
    }

    public void setDestino(Tarea destino) {
        this.destino = destino;
    }
    
     public Tarea getDestino() {
        return destino;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Boolean getUsed() {
        return used;
    }
}
