/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateful;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */

@Named(value="negoci")
@Stateful
public class negocio {

    static  String arti_momento;

    public negocio() {
    }

    

    static public String getArti_momento() {
        return arti_momento;
    }

    static public void setArti_momento(String arti_momento) {
        negocio.arti_momento = arti_momento;
    }

    
    
}
