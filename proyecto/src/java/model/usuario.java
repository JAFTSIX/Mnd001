/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateful;

/**
 *
 * @author Usuario
 */
@Stateful
public class usuario {

    static boolean inicio = false;

    static String nombre;
    static String pass;
    static String username;
    static String cuenta_bancaria;
    static String c;

    public usuario() {
    }

    static public boolean isInicio() {
        return inicio;
    }

    static public void setInicio(boolean inicio) {
        usuario.inicio = inicio;
    }

    static public String getNombre() {
        return nombre;
    }

    static public void setNombre(String nombre) {
        usuario.nombre = nombre;
    }

    
}
