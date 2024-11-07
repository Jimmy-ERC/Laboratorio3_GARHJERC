/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author elelt
 */
public class Carreras {
    private int IDCarrera;
    private String nombreCarrera;
    private String descripcion;

    public Carreras() {
    }

    public Carreras(int IDCarrera, String nombreCarrera, String descripcion) {
        this.IDCarrera = IDCarrera;
        this.nombreCarrera = nombreCarrera;
        this.descripcion = descripcion;
    }

    public int getIDCarrera() {
        return IDCarrera;
    }

    public void setIDCarrera(int IDCarrera) {
        this.IDCarrera = IDCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
