/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.conexion;
import model.consultas.consulta1;
import model.consultas.consulta2;
import model.consultas.consulta3;
import model.consultas.consulta4;
import model.consultas.consulta5;
import model.consultas.consulta6;
import model.consultas.consulta7;
import model.consultas.consulta8;

/**
 *
 * @author Fabian
 */
@Named(value = "conectConsultas")
@SessionScoped
public class conectConsultas implements Serializable {

    private List<consulta1> primerConsulta = new ArrayList<consulta1>();
    private List<consulta2> segundaConsulta = new ArrayList<consulta2>();
    private List<consulta3> tercerConsulta = new ArrayList<consulta3>();
    private List<consulta4> cuartaConsulta = new ArrayList<consulta4>();
    private List<consulta5> quintaConsulta = new ArrayList<consulta5>();
    private List<consulta6> sextaConsulta = new ArrayList<consulta6>();
    private List<consulta7> setimaConsulta = new ArrayList<consulta7>();
    private List<consulta8> octavaConsulta = new ArrayList<consulta8>();
    private List<consulta8> novenaConsulta = new ArrayList<consulta8>();

    private String fecha1;
    private String fecha2;
    private String precio1;
    private String precio2;

    public conectConsultas() {
    }

    public String consulta1() {

        try {
            Statement stm = conexion.getConexion().createStatement();
            ResultSet result = stm.executeQuery("Select C.id_Cliente, nombre, sum(total) totalComprado, count(E.id_Cliente) cantidadCompras "
                    + "from tb_Encabezado E, tb_Cliente C "
                    + "Where E.id_Cliente=C.id_Cliente and fecha between '" + fecha1 + "' and '" + fecha2 + "' "
                    + "group by C.id_Cliente, nombre "
                    + "having sum(total)>1");
            while (result.next()) {
                consulta1 consultin = new consulta1();
                consultin.setId(result.getString(1));
                consultin.setNombre(result.getString(2));
                consultin.setTotal(result.getString(3));
                consultin.setTotalCompra(result.getString(4));
                primerConsulta.add(consultin);
            }

        } catch (SQLException ex) {
            Logger.getLogger(conectConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "vip";
    }

    public String consulta2() {

        try {
            Statement stm = conexion.getConexion().createStatement();
            ResultSet result = stm.executeQuery("Select no_Articulo Id,A.nombre Articulo, T.nombre Tipo, cant, AR.nombre Artista, dueno Licencia, P.nombre Proveedor\n"
                    + "from tb_Tipo T, tb_Articulo A, tb_Artista AR, tb_licencia L, tb_Proveedor P\n"
                    + "where T.id_Tipo=A.id_Tipo and AR.id_Artista=A.id_Artista and A.id_Licencia=L.id_Licencia and P.id_proveedor=A.id_proveedor");
            while (result.next()) {
                consulta2 consultin = new consulta2();
                consultin.setId(result.getString(1));
                consultin.setNombre(result.getString(2));
                consultin.setTipo(result.getString(3));
                consultin.setCantidad(result.getString(4));
                consultin.setArtista(result.getString(5));
                consultin.setLicencia(result.getString(6));
                consultin.setProveedor(result.getString(7));
                segundaConsulta.add(consultin);
            }

        } catch (SQLException ex) {
            Logger.getLogger(conectConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/consultas/nombres.xhtml";
    }

    public String consulta3() {

        try {
            Statement stm = conexion.getConexion().createStatement();
            ResultSet result = stm.executeQuery("Select AR.id_Artista, AR.nombre Artista, A.nombre Articulo, T.nombre Tipo, descrip\n"
                    + "from tb_Artista AR, tb_Articulo A, tb_Tipo T\n"
                    + "Where AR.id_Artista=A.id_Artista and T.id_Tipo=a.id_Tipo");
            while (result.next()) {
                consulta3 consultin = new consulta3();
                consultin.setId(result.getString(1));
                consultin.setNombre(result.getString(2));
                consultin.setArticulo(result.getString(3));
                consultin.setTipo(result.getString(4));
                consultin.setDescrip(result.getString(5));
                tercerConsulta.add(consultin);
            }

        } catch (SQLException ex) {
            Logger.getLogger(conectConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/consultas/artistaArticulo.xhtml";
    }

    public String consulta4() {

        try {
            Statement stm = conexion.getConexion().createStatement();
            ResultSet result = stm.executeQuery("Select no_Articulo, A.nombre articulo, precio, descrip, DUENO, AR.nombre artista\n"
                    + "from tb_Articulo A, tb_Artista AR, tb_licencia L\n"
                    + "Where cant=0 and AR.id_Artista=a.id_Artista and A.id_Licencia=L.id_Licencia\n"
                    + "order by A.nombre");
            while (result.next()) {
                consulta4 consultin = new consulta4();
                consultin.setId(result.getString(1));
                consultin.setArticulo(result.getString(2));
                consultin.setPrecio(result.getString(3));
                consultin.setDescrip(result.getString(4));
                consultin.setLicencia(result.getString(5));
                consultin.setArtista(result.getString(6));
                cuartaConsulta.add(consultin);
                System.out.println("SI FUNCIONA");
                System.out.println(consultin.getDescrip());
            }

        } catch (SQLException ex) {
            Logger.getLogger(conectConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/consultas/agotados.xhtml";
    }

    public String consulta5() {

        try {
            Statement stm = conexion.getConexion().createStatement();
            ResultSet result = stm.executeQuery("Select no_Articulo, A.nombre Articulo, precio, descrip, DUENO, AR.nombre Artista\n"
                    + "from tb_Articulo A, tb_Artista AR, tb_licencia L\n"
                    + "Where precio between " + precio1 + " and " + precio2 + " and cant!=0 and AR.id_Artista=a.id_Artista and A.id_Licencia=L.id_Licencia\n"
                    + "order by A.nombre");
            while (result.next()) {
                consulta5 consultin = new consulta5();
                consultin.setId(result.getString(1));
                consultin.setArticulo(result.getString(2));
                consultin.setPrecio(result.getString(3));
                consultin.setDescrip(result.getString(4));
                consultin.setLicencia(result.getString(5));
                consultin.setArtista(result.getString(6));
                quintaConsulta.add(consultin);
                System.out.println("SI FUNCIONA");
                System.out.println(consultin.getDescrip());
            }

        } catch (SQLException ex) {
            Logger.getLogger(conectConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "filtro";
    }

    public String consulta6() {

        try {
            Statement stm = conexion.getConexion().createStatement();
            ResultSet result = stm.executeQuery("Select no_Articulo, A.nombre articulo, T.nombre, precio, descrip,\n"
                    + "    (case\n"
                    + "	    When A.id_Tipo=1 Then precio*0.25\n"
                    + "		When A.id_Tipo=2 Then precio*0.15\n"
                    + "		Else precio*0.20\n"
                    + "		End) Descuento\n"
                    + "From tb_Articulo A, tb_Tipo T\n"
                    + "Where fecha<'" + fecha1 + "' and cant>0 and A.id_Tipo=T.id_Tipo");
            while (result.next()) {
                consulta6 consultin = new consulta6();
                consultin.setId(result.getString(1));
                consultin.setArticulo(result.getString(2));
                consultin.setTipo(result.getString(3));
                consultin.setPrecio(result.getString(4));
                consultin.setDescrip(result.getString(5));
                consultin.setDescuento(result.getString(6));
                sextaConsulta.add(consultin);
                System.out.println("SI FUNCIONA");
                System.out.println(consultin.getDescrip());
            }

        } catch (SQLException ex) {
            Logger.getLogger(conectConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "descuentos";
    }

    public String consulta7() {

        try {
            Statement stm = conexion.getConexion().createStatement();
            ResultSet result = stm.executeQuery("Select C.ID_CLIENTE, C.NOMBRE CUENTA, D.NOMBRE, D.APELLIDO, D.DIRECCION, D.DIRECCION2, D.TELEFONO\n"
                    + "from TB_DIRECCLIENTE DC, TB_CLIENTE C, TB_DIRECCION D\n"
                    + "Where DC.ID_DIRECCION=D.ID_DIRECCION AND DC.ID_CLIENTE=C.ID_CLIENTE");
            while (result.next()) {
                consulta7 consultin = new consulta7();
                consultin.setId(result.getString(1));
                consultin.setCuenta(result.getString(2));
                consultin.setNombre(result.getString(3));
                consultin.setApellido(result.getString(4));
                consultin.setDireccion(result.getString(5));
                consultin.setDireccion2(result.getString(6));
                consultin.setTelefono(result.getString(7));
                setimaConsulta.add(consultin);
            }

        } catch (SQLException ex) {
            Logger.getLogger(conectConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/consultas/direcciones.xhtml";
    }

    public String consulta8() {

        try {
            Statement stm = conexion.getConexion().createStatement();
            ResultSet result = stm.executeQuery("select L.ID_LICENCIA, DUENO, count(A.CANT) cantidad, avg(A.PRECIO) total\n"
                    + "from tb_licencia L, tb_articulo A\n"
                    + "where L.ID_LICENCIA=A.ID_LICENCIA\n"
                    + "group by L.ID_LICENCIA, DUENO");
            while (result.next()) {
                consulta8 consultin = new consulta8();
                consultin.setId(result.getString(1));
                consultin.setNombre(result.getString(2));
                consultin.setCantidad(result.getString(3));
                consultin.setTotal(result.getString(4));
                octavaConsulta.add(consultin);
            }

        } catch (SQLException ex) {
            Logger.getLogger(conectConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/consultas/promedio.xhtml";
    }

    public String consulta9() {

        try {
            Statement stm = conexion.getConexion().createStatement();
            ResultSet result = stm.executeQuery("select L.ID_LICENCIA, DUENO, count(A.CANT) cantidad, avg(A.PRECIO) total\n"
                    + "from tb_licencia L, tb_articulo A\n"
                    + "where L.ID_LICENCIA=A.ID_LICENCIA\n"
                    + "group by L.ID_LICENCIA, DUENO");
            while (result.next()) {
                consulta8 consultin = new consulta8();
                consultin.setId(result.getString(1));
                consultin.setNombre(result.getString(2));
                consultin.setCantidad(result.getString(3));
                consultin.setTotal(result.getString(4));
                octavaConsulta.add(consultin);
            }

        } catch (SQLException ex) {
            Logger.getLogger(conectConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/consultas/promedio.xhtml";
    }

    public List<consulta1> getPrimerConsulta() {
        return primerConsulta;
    }

    public void setPrimerConsulta(List<consulta1> primerConsulta) {
        this.primerConsulta = primerConsulta;
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }

    public List<consulta2> getSegundaConsulta() {
        return segundaConsulta;
    }

    public void setSegundaConsulta(List<consulta2> segundaConsulta) {
        this.segundaConsulta = segundaConsulta;
    }

    public List<consulta3> getTercerConsulta() {
        return tercerConsulta;
    }

    public void setTercerConsulta(List<consulta3> tercerConsulta) {
        this.tercerConsulta = tercerConsulta;
    }

    public List<consulta4> getCuartaConsulta() {
        return cuartaConsulta;
    }

    public void setCuartaConsulta(List<consulta4> cuartaConsulta) {
        this.cuartaConsulta = cuartaConsulta;
    }

    public List<consulta5> getQuintaConsulta() {
        return quintaConsulta;
    }

    public void setQuintaConsulta(List<consulta5> quintaConsulta) {
        this.quintaConsulta = quintaConsulta;
    }

    public String getPrecio1() {
        return precio1;
    }

    public void setPrecio1(String precio1) {
        this.precio1 = precio1;
    }

    public String getPrecio2() {
        return precio2;
    }

    public void setPrecio2(String precio2) {
        this.precio2 = precio2;
    }

    public List<consulta6> getSextaConsulta() {
        return sextaConsulta;
    }

    public void setSextaConsulta(List<consulta6> sextaConsulta) {
        this.sextaConsulta = sextaConsulta;
    }

    public List<consulta7> getSetimaConsulta() {
        return setimaConsulta;
    }

    public void setSetimaConsulta(List<consulta7> setimaConsulta) {
        this.setimaConsulta = setimaConsulta;
    }

    public List<consulta8> getOctavaConsulta() {
        return octavaConsulta;
    }

    public void setOctavaConsulta(List<consulta8> octavaConsulta) {
        this.octavaConsulta = octavaConsulta;
    }

    public List<consulta8> getNovenaConsulta() {
        return novenaConsulta;
    }

    public void setNovenaConsulta(List<consulta8> novenaConsulta) {
        this.novenaConsulta = novenaConsulta;
    }


}
