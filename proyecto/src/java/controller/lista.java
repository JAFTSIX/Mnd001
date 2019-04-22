/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Usuario
 */
@Named(value = "lista")
@RequestScoped
public class lista {

    /**
     * Creates a new instance of lista
     */
    static String JSONBRO;

    public lista() {
    }

    public static String getJSONBRO() {
        return JSONBRO;
    }

    public static void setJSONBRO(String JSONBRO) {
        lista.JSONBRO = JSONBRO;
    }

    

}
