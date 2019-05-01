/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Articulo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 */
public class actualizar_lista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        String llegan="";
        int s = model.usuario.getArticulos().size();
        for (int i = 0; i <= s; i++) {
            if (request.getParameter("json" + i) != null) {

                llegan = request.getParameter("json" + i);
                System.out.println("AQUIII EN ACTUALIZAR" + llegan);
            }
        }

        if (llegan.length()>4) {

            List<Articulo> articulos = new ArrayList<>();
            JSONArray jsonarray = null;
            try {
                jsonarray = (JSONArray) new JSONParser().parse(llegan);
            } catch (ParseException ex) {
                System.out.println("11001001001111 no lo conierte" + ex);
            }

            if (jsonarray != null) {

                for (int u = 0; u < jsonarray.size(); u++) {
                    Articulo extraido = new Articulo();
                    JsonObject jsonObject = Json.createReader(new StringReader(jsonarray.get(u).toString())).readObject();

                    extraido.setCant(jsonObject.getString("cant"));
                    extraido.setCant_pedida(jsonObject.getString("cant_pedida"));
                    extraido.setImg(jsonObject.getString("img"));
                    extraido.setNo_Articulo(jsonObject.getString("no_articulo"));
                    extraido.setNombre(jsonObject.getString("nombre"));
                    extraido.setPrecio(jsonObject.getString("precio"));

                    articulos.add(extraido);
                }
            } else {
                System.out.println("ERROR ");
            }

            model.usuario.setArticulos(articulos);
         
            articulos = model.usuario.getArticulos();
             JSONArray artilucos = new JSONArray();
            for (int i = 0; i < articulos.size(); i++) {

                JSONObject objeto = new JSONObject();
                objeto.put("no_articulo", articulos.get(i).getNo_Articulo());
                objeto.put("nombre", articulos.get(i).getNombre());
                objeto.put("cant", articulos.get(i).getCant());
                objeto.put("cant_pedida", articulos.get(i).getCant_pedida());
                objeto.put("precio", articulos.get(i).getPrecio());
                objeto.put("img", articulos.get(i).getImg());

                artilucos.add(objeto);

                //pasamos el string al json que se traducira
            }
                lista.setJSONBRO(artilucos.toString());
            
            request.getRequestDispatcher("carrito.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
