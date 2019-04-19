/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Direccion {

    String id_direccion;
    String nombre ;
    String apellido ;
    
    String direccion;
    String direccion2;
    String ciudad;
    
    String pais;
    String cod_postal;
    String telefono;

    public Direccion() {

    }
//id_direc ,nombre , apellido, dir1,dir2,ciudad,pais,cod postal, telefono
    //id_direcc,nombre,appellido.dir,dir2,ciudad,pais,cod postal,telefono
    public Direccion(String id_direccion, String nombre, String apellido,
     String direccion, String direccion2, String ciudad, String pais, String cod_postal, String telefono) {
        this.id_direccion = id_direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.direccion2 = direccion2;
        this.ciudad = ciudad;
        this.pais = pais;
        this.cod_postal = cod_postal;
        this.telefono = telefono;
    }

    

    public String getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(String id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    @Override
    public String toString() {
        return "Direccion{" + "id_direccion=" + id_direccion + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", direccion2=" + direccion2 + ", ciudad=" + ciudad + ", pais=" + pais + ", cod_postal=" + cod_postal + ", telefono=" + telefono + '}';
    }


}
