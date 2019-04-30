/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Articulo;
import model.usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 */
public class test extends HttpServlet {

   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws org.json.simple.parser.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        if (usuario.isInicio()) {

           
 Articulo d=new Articulo(request.getParameter("no_articulo"), request.getParameter("nombre"),
                    request.getParameter("cantidad"), request.getParameter("cant_pedida"),
                    request.getParameter("precio"), request.getParameter("img"));
            
 usuario.getArticulos().add(d);

            List<Articulo> articulos = usuario.getArticulos();

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
            System.out.println("el sheison " + artilucos.toString());
            System.out.println(" ***ARRAY= " + usuario.toA());
            request.getRequestDispatcher("A2.jsp").forward(request, response);

        } else {

            request.getRequestDispatcher("faces/inicio_login.xhtml").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
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
