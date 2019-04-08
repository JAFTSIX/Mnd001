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

   String user;
   String pass;
    public inicio_log() {
    }
    
    public String validar() {
        if (valida(user,pass)) {
            
        return "A2.jsp";
        }else{
        return "faces/inicio_login";
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
    
//</editor-fold>
    
}
