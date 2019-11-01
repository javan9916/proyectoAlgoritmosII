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
public class Tarea {

    private String nombre;
    private String[] procedencias;

    public Tarea(String nombre, String[] procedencias) {
        this.nombre = nombre;
        this.procedencias = procedencias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProcedencias(String[] procedencias) {
        this.procedencias = procedencias;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getProcedencias() {
        return procedencias;
    }

    private int numero;
    private int tiempo;
    private int[] previos;

    public Tarea(int numero, int tiempo, int[] previos) {
        this.numero = numero;
        this.tiempo = tiempo;
        this.previos = previos;
    }
    
}
