package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Direccion;
import model.conexion;
import model.usuario;

import java.util.Date;

public class controlador_user {

    //<editor-fold defaultstate="collapsed" desc="METODOS DE INICIO DE SESIÓN">
    public static boolean valida(String correo, String pass) {

        try {
            Statement consulta = conexion.getConexion().createStatement();
            ResultSet data = consulta.executeQuery("SELECT ID_CLIENTE,CORREO,NOMBRE,CONTRA,ID_TARJETA"
                    + " from TB_CLIENTE where correo='" + correo + "'");
            if (data.next()) {

                if (pass.equals(data.getString(4))) {
                    String id = data.getString(1);
                    usuario.setCorreo(correo);
                    usuario.setNombre(data.getString(3));
                    usuario.setContra(pass);
                    usuario.setInicio(true);
                    usuario.setId_Cliente(id);
                    String s = data.getString(5);
                    System.out.println("" + s);
                    completa_direcciones(id);
                    completa_tarjeta(s);
                    consulta.close();
                    data.close();
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR NO COMUNICATION EN VALIDACION");
        }

        return false;
    }

    public static void completa_direcciones(String id_cliente) {

        try {
            Statement consulta = conexion.getConexion().createStatement();
            List<Direccion> direcciones = new ArrayList<>();
            ResultSet data;

            data = consulta.executeQuery(" SELECT      DIR.ID_DIRECCION,     DIR.NOMBRE,"
                    + " DIR.APELLIDO,    DIR.DIRECCION,       DIR.DIRECCION2,\n"
                    + " DIR.CIUDAD,        DIR.PAIS,     DIR.COD_POSTAL,      DIR.TELEFONO \n"
                    + "    from TB_DIRECCLIENTE NAN,TB_DIRECCION DIR where NAN.ID_DIRECCION=DIR.ID_DIRECCION \n"
                    + "AND ID_CLIENTE=" + id_cliente);

            while (data.next()) {

                //id_direcc,nombre,appellido.dir,dir2,ciudad,pais,cod postal,telefono
                //id_direc,nombre,apellido,dir1,dir2,ciudad,pais,cod postal, telefono
                direcciones.add(new Direccion(data.getString(1), data.getString(2), data.getString(3),
                        data.getString(4), data.getString(5), data.getString(6), data.getString(7), data.getString(8), data.getString(9)));

            }

            usuario.setDirecciones(direcciones);
            consulta.close();
            data.close();
        } catch (SQLException e) {
            System.err.println("ERROR NO COMUNICATION EN DIRECCIONES");
        }

    }

    public static void completa_tarjeta(String tarjeta) {
        try {
            System.out.println("lleeeeeega");
            Statement consulta = conexion.getConexion().createStatement();
            ResultSet data = consulta.executeQuery("SELECT TITULAR,"
                    + "NO_TARJETA,VENCIMIENTO,CVC FROM TB_TARJETA WHERE ID_TARJETA=" + tarjeta + "");
            if (data.next()) {
                usuario.setId_Tarjeta(tarjeta);
                usuario.setTitular(data.getString(1));
                usuario.setNo_tarjeta(data.getString(2));
                usuario.setVencimiento(data.getString(3));
                usuario.setCvc(data.getString(4));

                consulta.close();
                data.close();
            }
        } catch (SQLException e) {
            System.err.println("ERROR NO COMUNICATION COMPLETA tarjeta");
        }

    }

//</editor-fold>
    static int registra(String nombre, String correo,
            String contra, String contra2, String titular, String no_tarjeta,
            Date vencimiento, String cvc, Direccion direccion) {
        Date NOW = new Date();
        String id_tarjeta = "";
        String id_direccion = "";
        String id_CLIENTE = "";
        //vencimiento de la tarjeta
        if (NOW.after(vencimiento)) {
            System.out.println("******* NOW after VENCIMIENTO" + NOW.before(vencimiento));
            return 0;
        }
        //las contraseñas son iguales
        if (!contra.equals(contra2)) {
            System.out.println("******* CONTRASEÑAS DIFERENTES");
            return 0;
        }

        //revisar si todo esta lleno
        if (nombre.equals("") || correo.equals("")
                || contra.equals("") || contra2.equals("") || no_tarjeta.equals("")
                || null == vencimiento || cvc.equals("") || direccion.equals("")) {
            System.out.println("controlarpersona/registrar/ no esta lleno");
            return 0;
        }

        try {
            //consultas
            Statement consulta = conexion.getConexion().createStatement();

            ////correo repetido
            ResultSet data = consulta.executeQuery("SELECT ID_CLIENTE from TB_CLIENTE WHERE CORREO='" + correo + "'");
            if (data.next()) {
                System.out.println("******* EL CORREO EXISTE");
                data.close();
                consulta.close();
                return 0;
            }

            data.close();

            //revisa si el codigo postal esta repetido
            data = consulta.executeQuery("SELECT ID_DIRECCION from TB_DIRECCION where COD_POSTAL='" + direccion.getCod_postal() + "'");

            if (data.next()) {
                
                System.out.println("******* LA DIRECCION EXISTE OPCION 1");
                id_direccion = data.getString(1);//////***************

//<editor-fold defaultstate="collapsed" desc="inserto tarjeta">
                try (PreparedStatement stm = conexion.getConexion().prepareStatement("INSERT INTO A.TB_TARJETA (TITULAR, NO_TARJETA, VENCIMIENTO, CVC) \n"
                        + "VALUES (?, ?, ?, ?)")) {
                    stm.setString(1, titular);
                    stm.setInt(2, Integer.parseInt(no_tarjeta));

                    Calendar dCalendar = Calendar.getInstance();
                    dCalendar.setTime(vencimiento);
                    stm.setDate(3, new java.sql.Date(dCalendar.getTime().getTime()));
                    stm.setInt(4, Integer.parseInt(cvc));
                    stm.executeUpdate();

                }
//</editor-fold>
                System.out.println("******* INSERTO LA TARJETA");
//<editor-fold defaultstate="collapsed" desc="CONSIGO ID TARJETA">
                data = consulta.executeQuery("SELECT ID_TARJETA from TB_TARJETA where CVC=" + cvc + " and NO_TARJETA=" + no_tarjeta + "");
                if (data.next()) {
                    id_tarjeta = data.getString(1);//////***************
                }
//</editor-fold>
                System.out.println("******* CONSIGO LA ID_TARJETA");
//<editor-fold defaultstate="collapsed" desc="INSERTO CLIENTE">
                try (PreparedStatement stm = conexion.getConexion().prepareStatement("INSERT INTO A.TB_CLIENTE (NOMBRE, CORREO, CONTRA, ID_TARJETA) \n"
                        + "	VALUES ( ?, ?,?,?)")) {
                    stm.setString(1, nombre);
                    stm.setString(2, correo);
                    stm.setString(3, contra);
                    stm.setInt(4, Integer.parseInt(id_tarjeta));
                    stm.executeUpdate();
                }

                //</editor-fold>
                System.out.println("******* INSERTO EL CLIENTE");
//<editor-fold defaultstate="collapsed" desc="CONSIGO ID CLIENTE">
                data = consulta.executeQuery("SELECT ID_CLIENTE from TB_CLIENTE WHERE CORREO='" + correo + "'");
                if (data.next()) {
                    id_CLIENTE = data.getString(1);
                }

//</editor-fold>
                System.out.println("******* CONSIGO LA ID_CLIENTE");

//<editor-fold defaultstate="collapsed" desc="INSERTO DIREC CLIENTE">
                try (PreparedStatement stm = conexion.getConexion().prepareStatement("INSERT INTO A.TB_DIRECCLIENTE (ID_DIRECCION, ID_CLIENTE) \n"
                        + "	VALUES (?,?)")) {
                    stm.setInt(1, Integer.parseInt(id_direccion));
                    stm.setInt(2, Integer.parseInt(id_CLIENTE));
                    stm.executeUpdate();
                }
//</editor-fold>
                System.out.println("******* INSERTO LA DIRECLIENT");
                data.close();
                consulta.close();

            } else {
                System.out.println("******* LA DIRECCION NOOOO EXISTE OPCION 2");

//<editor-fold defaultstate="collapsed" desc="inserto tarjeta">
                try (PreparedStatement stm = conexion.getConexion().prepareStatement("INSERT INTO A.TB_TARJETA (TITULAR, NO_TARJETA, VENCIMIENTO, CVC) \n"
                        + "VALUES (?, ?, ?, ?)")) {
                    stm.setString(1, titular);
                    stm.setInt(2, Integer.parseInt(no_tarjeta));

                    Calendar dCalendar = Calendar.getInstance();
                    dCalendar.setTime(vencimiento);
                    stm.setDate(3, new java.sql.Date(dCalendar.getTime().getTime()));
                    stm.setInt(4, Integer.parseInt(cvc));
                    stm.executeUpdate();

                }
//</editor-fold>

                System.out.println("******* INSERTO LA TARJETA");
//<editor-fold defaultstate="collapsed" desc="CONSIGO ID TARJETA QUE ACABO DE METER">
                data = consulta.executeQuery("SELECT ID_TARJETA from TB_TARJETA where CVC=" + cvc + " and NO_TARJETA= " + no_tarjeta);

                if (data.next()) {
                    id_tarjeta = data.getString(1);//////***************

                }

//</editor-fold>
                System.out.println("******* CONSIGO LA ID_TARJETA");
//<editor-fold defaultstate="collapsed" desc="INSERTO CLIENTE">
                try (PreparedStatement stm = conexion.getConexion().prepareStatement("INSERT INTO A.TB_CLIENTE (NOMBRE, CORREO, CONTRA, ID_TARJETA) \n"
                        + "	VALUES ( ?, ?,?, ?)")) {
                    stm.setString(1, nombre);
                    stm.setString(2, correo);
                    stm.setString(3, contra);
                    stm.setInt(4, Integer.parseInt(id_tarjeta));
                    stm.executeUpdate();
                }

                //</editor-fold>
                System.out.println("******* INSERTO EL CLIENTE");
//<editor-fold defaultstate="collapsed" desc="CONSIGO ID CLIENTE">
                data = consulta.executeQuery("SELECT ID_CLIENTE from TB_CLIENTE WHERE CORREO='" + correo + "'");
                if (data.next()) {
                    id_CLIENTE = data.getString(1);
                }
//</editor-fold>
                System.out.println("******* CONSIGO EL IDCLIENTE");
//<editor-fold defaultstate="collapsed" desc="INSERTO DIRECCION">
                try (PreparedStatement stm = conexion.getConexion().prepareStatement("INSERT INTO A.TB_DIRECCION"
                        + " ( NOMBRE, APELLIDO, DIRECCION, DIRECCION2, CIUDAD, PAIS, COD_POSTAL, TELEFONO) \n"
                        + "            VALUES (?,?,?,?,?,?,?,?)")) {
                    stm.setString(1, direccion.getNombre());
                    stm.setString(2, direccion.getApellido());
                    stm.setString(3, direccion.getDireccion());
                    stm.setString(4, direccion.getDireccion2());
                    stm.setString(5, direccion.getCiudad());
                    stm.setString(6, direccion.getPais());
                    stm.setString(7, direccion.getCod_postal());
                    stm.setString(8, direccion.getTelefono());
                    stm.executeUpdate();
                }
//</editor-fold>
                System.out.println("******* INSERTO LA DIRECCION");
//<editor-fold defaultstate="collapsed" desc="CONSIGO ID_DIRECCION">
                data = consulta.executeQuery("SELECT ID_DIRECCION from TB_DIRECCION where COD_POSTAL='" + direccion.getCod_postal() + "'");
                if (data.next()) {
                    id_direccion = data.getString(1);//////***************
                }
//</editor-fold>
                System.out.println("******* CONSIGO LA ID:_DIRECCION");
//<editor-fold defaultstate="collapsed" desc="INSERTO DIREC CLIENTE">
                try (PreparedStatement stm = conexion.getConexion().prepareStatement("INSERT INTO A.TB_DIRECCLIENTE (ID_DIRECCION, ID_CLIENTE) \n"
                        + "	VALUES (?,?)")) {
                    stm.setInt(1, Integer.parseInt(id_direccion));
                    stm.setInt(2, Integer.parseInt(id_CLIENTE));
                    stm.executeUpdate();
                }
//</editor-fold>

                data.close();
                consulta.close();
            }

            return 1;

        } catch (SQLException e) {
            System.err.println("controlarpersona/registrar/ ERROR NO COMUNICATION"
                    + "\n" + e);
        }

        System.out.println("controlarpersona/registrar/ return 2*-2");
        return 2;
    }

}
