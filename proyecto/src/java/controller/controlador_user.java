package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.conexion;
import model.usuario;

public class controlador_user {

    public static boolean valida(String username, String pass) {

        try {
            Statement consulta = conexion.getConexion().createStatement();
            ResultSet data = consulta.executeQuery("select PASS,ID_CLIENTE from A.CUENTA where USERNAME='" + username + "'");
            if (data.next()) {

                if (pass.equals(data.getString(1))) {
                    usuario.setPass(pass);
                    usuario.setUsername(username);
                    usuario.setInicio(true);
                    completa_datos(data.getString(2));
                    consulta.close();
                    data.close();
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR NO COMUNICATION");
        }

        return false;
    }

    public static void completa_datos(String id_cliente) {
        try {
            System.out.println("lleeeeeega");
            Statement consulta = conexion.getConexion().createStatement();
            ResultSet data = consulta.executeQuery("SELECT NOMBRE FROM A.CLIENTE WHERE ID_CLIENTE='" + id_cliente + "'");
            if (data.next()) {
                System.out.println("" + data.getString(1));
                usuario.setNombre(data.getString(1));

                consulta.close();
                data.close();
            }
        } catch (SQLException e) {
            System.err.println("ERROR NO COMUNICATION");
        }

    }

    public static int registrar_db(String user, String pass, String pass2, String id,
            String nombre, String apellido, String correo, String numero_cuenta, String direccion,
            String pais, String ciudad, String cod_postal) {

        if (pass.equals(pass2)) {

            try {
                Statement consulta = conexion.getConexion().createStatement();
                ResultSet data = consulta.executeQuery("select ID_CLIENTE from A.Cliente  where ID_CLIENTE='" + id + "'");
                if (data.next()) {
                    System.out.println("controlarpersona/registrar/ ENTRA AL DATA NEXT");
                    String h = data.getString(1);
                    if (id.equals(h)) {
                        System.out.println("controlarpersona/registrar/ data.gedtstring " + h);
                        consulta.close();
                        return 0;
                    }
                }
                
                Statement consulta2 = conexion.getConexion().createStatement();
                ResultSet data2 = consulta.executeQuery("select username from A.CUENTA  where username='" + user + "'");
                if (data2.next()) {
                    System.out.println("controlarpersona/registrar/ ENTRA AL DATA NEXT*");
                    String h = data2.getString(1);
                    if (id.equals(h)) {
                        System.out.println("controlarpersona/registrar/ data.gedtstring* " + h);
                        consulta2.close();
                        return 0;
                    }
                }

                if (id.equals("") || nombre.equals("") || apellido.equals("") || pass.equals("")
                        || correo.equals("") || user.equals("") || numero_cuenta.equals("")
                        || cod_postal.equals("") || pais.equals("") || ciudad.equals("") || direccion.equals("")) {
                    System.out.println("controlarpersona/registrar/ no esta lleno");
                    return 2;

                } else {

                    System.out.println("/registrar/ ENTRA AL INSERT");
                    try (PreparedStatement stm = conexion.getConexion().prepareStatement("INSERT INTO A.Cliente VALUES (?,?,?)")) {
                        stm.setString(1, id);
                        stm.setString(2, nombre);
                        stm.setString(3, apellido);
                        stm.executeUpdate();
                    }

                    try (PreparedStatement stm2 = conexion.getConexion().prepareStatement("INSERT INTO A.CUENTA VALUES (?, ?, ?, ?,?)")) {
                        stm2.setString(1, id);
                        stm2.setString(2, user);
                        stm2.setString(3, pass);
                        stm2.setString(4, correo);
                        stm2.setString(5, numero_cuenta);
                        stm2.executeUpdate();
                    }
                    try (PreparedStatement stm3 = conexion.getConexion().prepareStatement("INSERT INTO A.DIRECCION VALUES (?,?,?,?,?)")) {
                        stm3.setString(1, id);
                        stm3.setString(2, direccion);
                        stm3.setString(3, pais);
                        stm3.setString(4, cod_postal);
                        stm3.setString(5, ciudad);
                        stm3.executeUpdate();
                    }

                    return 1;
                }

            } catch (SQLException e) {
                System.err.println("controlarpersona/registrar/ ERROR NO COMUNICATION"
                        + "\n" + e);
            }

        }
        System.out.println("controlarpersona/registrar/ return 2*-2");
        return 2;

    }

}
