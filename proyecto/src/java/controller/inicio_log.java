/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.controlador_user.valida;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.usuario;

/**
 *
 * @author Usuario
 */
@Named(value = "inicio_log")
@RequestScoped
public class inicio_log {

    String user;
    String pass;
    String id;
    String nombre = "";
    String apellido = "";
    String cuenta_bancaria = "";
    String correo;
    
    /////cuenta
    
    /////dirección
    

    public inicio_log() {
    }

    public String validar() {
        if (valida(user, pass)) {
            return "A2.jsp";
        } else {
            return "faces/inicio_login";
        }

    }

    public String registrar() {
        if (valida(user, pass)) {
            return "A2.jsp";
        } else {
            return "faces/registrarse";
        }

    }

    ///////////////////////////////////////geters y setters 
    //<editor-fold defaultstate="collapsed" desc="GET SET">
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public String getCuenta_bancaria() {
        return cuenta_bancaria;
    }

    public void setCuenta_bancaria(String cuenta_bancaria) {
        this.cuenta_bancaria = cuenta_bancaria;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

//</editor-fold>

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
