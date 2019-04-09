/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value = "usu")
@Stateless
public class usuario implements Serializable {

    static boolean inicio = false;

    static String id;
    static String nombre="";
    static String pass;
    static String username;
    static String cuenta_bancaria;
    static String correo;

    public usuario() {
    }

    public static boolean isInicio() {
        return inicio;
    }

    public static void setInicio(boolean inicio) {
        usuario.inicio = inicio;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        usuario.id = id;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        usuario.nombre = nombre;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        usuario.pass = pass;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        usuario.username = username;
    }

    public static String getCuenta_bancaria() {
        return cuenta_bancaria;
    }

    public static void setCuenta_bancaria(String cuenta_bancaria) {
        usuario.cuenta_bancaria = cuenta_bancaria;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        usuario.correo = correo;
    }

   

}
