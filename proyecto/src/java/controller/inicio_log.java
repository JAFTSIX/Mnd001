/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.controlador_user.valida;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Usuario
 */
@Named(value = "inicio_log")
@RequestScoped
public class inicio_log {

    String id;
    String nombre = "";
    String apellido = "";
    String correo;
    String user;

    String pass;
    String pass2;

    /////cuenta
    String numero_cuenta;

    /////dirección
    String direccion;
    String ciudad;
    String cod_postal;
    String pais;

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

        int i = controlador_user.registrar_db(user, pass, pass2, id, nombre, apellido, correo, numero_cuenta, direccion, pais, ciudad, cod_postal);
        if (i == 1) {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

//</editor-fold>
}
