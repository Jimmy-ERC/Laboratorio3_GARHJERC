/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author elelt
 */
public class Usuario {
    private int IDUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    private String region;
    private String rol;
    private String usuario;
    private String contraseña;

    public Usuario() {
        
    }

    public Usuario(int IDUsuario, String nombre, String apellido, String email, int edad, String region, String rol, String usuario, String contraseña) {
        this.IDUsuario = IDUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.region = region;
        this.rol = rol;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Usuario(String nombre, String apellido, String email, int edad, String region, String rol, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.region = region;
        this.rol = rol;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
