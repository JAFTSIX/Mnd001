package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.conexion;

import model.Articulo;

public class registrar_compra {

    
    
    static int registra(List<Articulo> articulos) {

        double total = 0;
        for (int i = 0; i < articulos.size(); i++) {

            int cantidad = Integer.parseInt(articulos.get(i).getCant_pedida());

            total += Double.parseDouble(articulos.get(i).getPrecio()) * cantidad;
        }
        
        String no_autogenerado = null;
        try {

            try (PreparedStatement stm = conexion.getConexion().
                    prepareStatement("INSERT INTO A.TB_ENCABEZADO (FECHA, TOTAL, ID_CLIENTE) VALUES (?,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS)) {

                Calendar dCalendar = Calendar.getInstance();
                dCalendar.setTime(new Date());

                stm.setDate(1, new java.sql.Date(dCalendar.getTime().getTime()));
                stm.setDouble(2, total);
                stm.setInt(3, Integer.parseInt(model.usuario.getId_Cliente()));
                stm.executeUpdate();
                ResultSet rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    no_autogenerado = rs.getString(1);
                }
            }
            if (no_autogenerado != null) {

                for (Articulo articulo : articulos) {
                    try (PreparedStatement stm = conexion.getConexion().
                            prepareStatement("INSERT INTO A.TB_LINEAPEDIDO"
                                    + " (no_Compra,NO_ARTICULO, UNIDADES, PRECIO_UNIDAD, PRECIO_TOTAL) \n"
                                    + "VALUES (?,?,?,?,?)")) {

                        stm.setInt(1, Integer.parseInt(no_autogenerado));
                        int unidades = Integer.parseInt(articulo.getCant_pedida());

                        stm.setInt(2, Integer.parseInt(articulo.getNo_Articulo()));
                        stm.setInt(3, unidades);
                        double precio = Double.parseDouble(articulo.getPrecio());
                        stm.setDouble(4, precio);

                        stm.setDouble(5, precio * unidades);
                        stm.executeUpdate();

                    }
                }
                
            } else {
                System.out.println("?????el key autogenerado no se recuperó");
            }

            return 1;

        } catch (SQLException e) {
            System.err.println("?????sql exception iokse "
                    + "\n" + e);
        }

        System.out.println("??????? return 2");
        return 2;
    }
    
    
    
    
    
    
    

}
