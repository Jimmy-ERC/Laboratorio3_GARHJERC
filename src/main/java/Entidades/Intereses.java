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
    private int cantidad;
    private String nombreCarrera;
    private String descripcion;
    private Date fechaSeleccion;    

    public Intereses() {
        
    }

    public Intereses(int IDUsuario, int IDCarrera) {
        this.IDUsuario = IDUsuario;
        this.IDCarrera = IDCarrera;
    }   

    public Intereses(int cantidad, Date fechaSeleccion) {
        this.cantidad = cantidad;
        this.fechaSeleccion = fechaSeleccion;
    }

    public Intereses(int cantidad, String nombreCarrera) {
        this.cantidad = cantidad;
        this.nombreCarrera = nombreCarrera;
    }
    
    public Intereses(int IDInteres, String nombreCarrera, String descripcion) {
        this.IDInteres = IDInteres;
        this.nombreCarrera = nombreCarrera;
        this.descripcion = descripcion;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }    

    public Date getFechaSeleccion() {
        return fechaSeleccion;
    }

    public void setFechaSeleccion(Date fechaSeleccion) {
        this.fechaSeleccion = fechaSeleccion;
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
