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
            Statement consulta = conexion.getConexion().createStatement();
            ResultSet data = consulta.executeQuery("select nombre from A.Cliente where nombre='" + id_cliente + "'");
            if (data.next()) {
                usuario.setNombre(data.getString(1));
                consulta.close();
                data.close();
            }
        } catch (SQLException e) {
            System.err.println("ERROR NO COMUNICATION");
        }

    }

    /*
     public static int registrar(usuario s) {
     
     try {
     Statement consulta = conexion.getConexion().createStatement();
     ResultSet data = consulta.executeQuery("select ID from PROF.USUARIOS where ID='" + s.getId() + "'");
     if (data.next()) {
     System.out.println("controlarpersona/registrar/ ENTRA AL DATA NEXT");
     String h = data.getString(1);
     if (s.getId().equals(h)) {
     System.out.println("controlarpersona/registrar/ data.gedtstring " + h);
     consulta.close();
     return 0;
     }
     }
     
     if (s.getId() == null || s.getNombre() == null || s.getPw() == null) {
     System.out.println("controlarpersona/registrar/ no esta lleno");
     return 2;
     } else {
     System.out.println("controlarpersona/registrar/ ENTRA AL INSERT");
     PreparedStatement stm = conexion.getConexion().prepareStatement("INSERT INTO PROF.USUARIOS VALUES (?,?,?)");
     stm.setString(1, s.getId());
     stm.setString(2, s.getPw());
     stm.setString(3, s.getNombre());
     stm.executeUpdate();
     stm.close();
     return 1;
     }
     
     } catch (SQLException e) {
     System.err.println("controlarpersona/registrar/ ERROR NO COMUNICATION"+
     " "+e);
     }
     System.out.println("controlarpersona/registrar/ return 2*-2");
     return 2;
     
     }*/
}
