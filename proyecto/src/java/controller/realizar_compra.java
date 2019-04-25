/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.ws.rs.client.Entity.json;
import model.Articulo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 */
public class realizar_compra extends HttpServlet {

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
        List<Articulo> articulos = new ArrayList<>();

        String llegan = request.getParameter("json");
        System.out.println("101001110llega=" + llegan);

        JSONArray jsonarray = null;
        try {
            jsonarray = (JSONArray) new JSONParser().parse(llegan);
        } catch (ParseException ex) {
            System.out.println("11001001001111 no lo conierte" + ex);
        }

        if (jsonarray != null) {

            for (int i = 0; i < jsonarray.size(); i++) {
                Articulo extraido = new Articulo();
                JsonObject jsonObject = Json.createReader(new StringReader(jsonarray.get(i).toString())).readObject();
                 
                extraido.setCant(jsonObject.getString("cant"));
                 extraido.setCant_pedida(jsonObject.getString("cant_pedida"));
                 extraido.setImg(jsonObject.getString("img"));
                 extraido.setNo_Articulo(jsonObject.getString("no_articulo"));
                 extraido.setNombre(jsonObject.getString("nombre"));
                 extraido.setPrecio(jsonObject.getString("precio"));
                 
                articulos.add(extraido);
            }
            
            if (registrar_compra.registra(articulos)==1) {
                model.usuario.setArticulos(null);
            request.getRequestDispatcher("A2.jsp").forward(request, response);    
            }else{
             request.getRequestDispatcher("carrito.jsp").forward(request, response);    
            }
            
        } else {
            System.out.println("ERROR LLEGA NULL");
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
