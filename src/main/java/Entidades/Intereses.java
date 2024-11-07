/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author elelt
 */
public class Intereses {
    private int IDInteres;
    private int IDUsuario;
    private int IDCarrera;
    private Date fechaSeleccion;

    public Intereses() {
    }

    public Intereses(int IDInteres, int IDUsuario, int IDCarrera, Date fechaSeleccion) {
        this.IDInteres = IDInteres;
        this.IDUsuario = IDUsuario;
        this.IDCarrera = IDCarrera;
        this.fechaSeleccion = fechaSeleccion;
    }

    public int getIDInteres() {
        return IDInteres;
    }

    public void setIDInteres(int IDInteres) { 
        this.IDInteres = IDInteres;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public int getIDCarrera() {
        return IDCarrera;
    }

    public void setIDCarrera(int IDCarrera) {
        this.IDCarrera = IDCarrera;
    }

    public Date getFechaSeleccion() {
        return fechaSeleccion;
    }

    public void setFechaSeleccion(Date fechaSeleccion) {
        this.fechaSeleccion = fechaSeleccion;
    }
    
    
}
