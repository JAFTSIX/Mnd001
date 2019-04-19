/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.Direccion;

/**
 *
 * @author Usuario
 */
@Named(value = "registrarse")
@SessionScoped
public class Registrarse implements Serializable {

    String nombre = "";
    String correo = "";
    String contra = "";
    String contra2 = "";

    //////////tarjeta
    String titular = "";
    String no_tarjeta = "";
    Date vencimiento = new Date();
    String cvc = "";
    ///direccion
    String id_direccion = "";
    String Dnombre = "";
    String apellido = "";

    String direccion1 = "";
    String direccion2 = "";
    String ciudad = "";

    String pais = "";
    String cod_postal = "";
    String telefono = "";

    public Registrarse() {
    }

    public String registrar() {
        System.out.println("ssssssssssssss" + "n\"" + toing());

        Direccion direccion = new Direccion(id_direccion, Dnombre, apellido, direccion1, direccion2, ciudad, pais, cod_postal, telefono);
        int i = controlador_user.registra(nombre, correo, contra, contra2, titular,
                no_tarjeta, vencimiento, cvc, direccion);
        if (i == 1) {
            return "A2.jsp";
        } else {
            return "faces/registrarse";
        }

    }

    public String getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(String id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getDnombre() {
        return Dnombre;
    }

    public void setDnombre(String Dnombre) {
        this.Dnombre = Dnombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNo_tarjeta() {
        return no_tarjeta;
    }

    public void setNo_tarjeta(String no_tarjeta) {
        this.no_tarjeta = no_tarjeta;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getContra2() {
        return contra2;
    }

    public void setContra2(String contra2) {
        this.contra2 = contra2;
    }

    public String toing() {
        return "Registrarse{" + " nombre=" + nombre + ", correo=" + correo + ", contra=" + contra + ", contra2=" + contra2 + ", titular=" + titular + ", no_tarjeta=" + no_tarjeta + ", vencimiento=" + vencimiento + ", cvc=" + cvc + ", id_direccion=" + id_direccion + ", Dnombre=" + Dnombre + ", apellido=" + apellido + ", direccion1=" + direccion1 + ", direccion2=" + direccion2 + ", ciudad=" + ciudad + ", pais=" + pais + ", cod_postal=" + cod_postal + ", telefono=" + telefono + '}';
    }

}
