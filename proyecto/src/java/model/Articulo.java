package model;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "arti")
@RequestScoped
public class Articulo implements Serializable{

    String no_Articulo;
    String nombre;
    String cant;
    String cant_pedida;
    String precio;
    String img;

    public Articulo(String no_Articulo, String nombre, String cant, String cant_pedida, String precio, String img) {
        this.no_Articulo = no_Articulo;
        this.nombre = nombre;
        this.cant = cant;
        this.cant_pedida = cant_pedida;
        this.precio = precio;
        this.img = img;
    }
 

    public Articulo() {
    }

     
    public String getNo_Articulo() {
        return no_Articulo;
    }

    public void setNo_Articulo(String no_Articulo) {
        this.no_Articulo = no_Articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public String getCant_pedida() {
        return cant_pedida;
    }

    public void setCant_pedida(String cant_pedida) {
        this.cant_pedida = cant_pedida;
    }

    @Override
    public String toString() {
        return "Articulo{" + "no_Articulo=" + no_Articulo + ", nombre=" + nombre + ", cant=" + cant + ", cant_pedida=" + cant_pedida + ", precio=" + precio + ", img=" + img + '}';
    }



}
