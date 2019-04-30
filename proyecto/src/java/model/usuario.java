/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
/**
 *
 * @author Usuario
 */
@Named(value = "usua")
@Stateful
public class usuario  {

    static boolean inicio = false;

    static List<Direccion> direcciones = new ArrayList<>();
    static String id_Cliente;

    static List<Articulo> articulos = new ArrayList<>();
    
    static String nombre;
    static String correo;
    static String contra;

    //////////tarjeta
    static String id_Tarjeta;
    static String titular;
    static String no_tarjeta;
    static String vencimiento;
    static String cvc;

    public usuario() {
    }

    public static boolean isInicio() {
        return inicio;
    }

    public static void setInicio(boolean inicio) {
        usuario.inicio = inicio;
    }

    public static String getId_Cliente() {
        return id_Cliente;
    }

    public static void setId_Cliente(String id_Cliente) {
        usuario.id_Cliente = id_Cliente;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        usuario.nombre = nombre;
    }

    public static String getContra() {
        return contra;
    }

    public static void setContra(String contra) {
        usuario.contra = contra;
    }

    public static String getId_Tarjeta() {
        return id_Tarjeta;
    }

    public static void setId_Tarjeta(String id_Tarjeta) {
        usuario.id_Tarjeta = id_Tarjeta;
    }

    public static String getTitular() {
        return titular;
    }

    public static void setTitular(String titular) {
        usuario.titular = titular;
    }

    public static String getNo_tarjeta() {
        return no_tarjeta;
    }

    public static void setNo_tarjeta(String no_tarjeta) {
        usuario.no_tarjeta = no_tarjeta;
    }

    public static String getVencimiento() {
        return vencimiento;
    }

    public static void setVencimiento(String vencimiento) {
        usuario.vencimiento = vencimiento;
    }

    public static String getCvc() {
        return cvc;
    }

    public static void setCvc(String cvc) {
        usuario.cvc = cvc;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        usuario.correo = correo;
    }

    public static List<Direccion> getDirecciones() {
        return direcciones;
    }

    public static void setDirecciones(List<Direccion> direcciones) {
        usuario.direcciones = direcciones;
    }

    public static List<Articulo> getArticulos() {
        return articulos;
    }

    public static void setArticulos(List<Articulo> articulos) {
        usuario.articulos = articulos;
    }

    
    
    public static String toD () {
        return ""+direcciones.toString();
    }
    
    public static String toA () {
        return ""+articulos.toString();
    }
    
    public static String tota () {
        return "id_cliente"+id_Cliente+"/id tarjeta"+id_Tarjeta+"/titular"+titular
                +"/no_tarjeta"+no_tarjeta
                +"/vencimiento"+vencimiento
                +"/cvc"+cvc
                ;
    }

    public static void limpiar() {
        direcciones.clear();
        id_Cliente= null;
        nombre= null;
        correo= null;
        contra= null;
        articulos.clear();
        //////////tarjeta
        id_Tarjeta= null;
        titular= null;
        no_tarjeta= null;
        vencimiento= null;
        cvc= null;

    }
    
 

}
