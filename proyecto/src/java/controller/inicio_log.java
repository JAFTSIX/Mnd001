/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.controlador_user.valida;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Direccion;
import model.usuario;

/**
 *
 * @author Usuario
 */
@Named(value = "inicio_log")
@RequestScoped
public class inicio_log {

    String correo;
    String contra;


    public inicio_log() {
    }

    public String validar() {
        if (valida(correo, contra)) {
            //  System.out.println(usuario.toS());
            // System.out.println(usuario.tota());
            return "A2.jsp";
        } else {
            return "faces/inicio_login";
        }

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

  

 
}
