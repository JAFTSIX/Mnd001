/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.ejb.Stateful;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value = "usu")
@Stateful
public class usuario implements Serializable {

    static boolean inicio = false;

    static String id;
    static String nombre = "";
    static String pass;
    static String username;
    static String cuenta_bancaria = "";
    static String correo_electronico;

    /////dirección
    static String direccion;
    static String ciudad;
    static String pais;
    static String cod_postal;
    static String postal;

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

    public static String getCorreo_electronico() {
        return correo_electronico;
    }

    public static void setCorreo_electronico(String correo_electronico) {
        usuario.correo_electronico = correo_electronico;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static void setDireccion(String direccion) {
        usuario.direccion = direccion;
    }

    public static String getCiudad() {
        return ciudad;
    }

    public static void setCiudad(String ciudad) {
        usuario.ciudad = ciudad;
    }

    public static String getPais() {
        return pais;
    }

    public static void setPais(String pais) {
        usuario.pais = pais;
    }

    public static String getCod_postal() {
        return cod_postal;
    }

    public static void setCod_postal(String cod_postal) {
        usuario.cod_postal = cod_postal;
    }

    public static String getPostal() {
        return postal;
    }

    public static void setPostal(String postal) {
        usuario.postal = postal;
    }

}
