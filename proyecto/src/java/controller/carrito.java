/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.usuario;

/**
 *
 * @author Usuario
 */
@Named(value = "carrito")
@RequestScoped
public class carrito {


    String id_Tarjeta;
    String id_Cliente;
    String nombre;
   
    /**
     * Creates a new instance of carrito
     */
    public carrito() {
    }

    @PostConstruct
    public void cargar() {
        id_Tarjeta=usuario.getId_Tarjeta();
        id_Cliente=usuario.getId_Cliente();
        nombre=usuario.getNombre();
    }
    
    public String getId_Tarjeta() {
        return id_Tarjeta;
    }

    public void setId_Tarjeta(String id_Tarjeta) {
        this.id_Tarjeta = id_Tarjeta;
    }

    public String getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
