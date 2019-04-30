/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.consultas;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Fabian
 */
@Named(value = "consulta10")
@RequestScoped
public class consulta10 {

    private String id;
    private String numero;
    private String nombre;
    private String correo;
    
    public consulta10() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
    
}
