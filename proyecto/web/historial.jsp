<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : carrito
    Created on : 22-abr-2019, 0:26:44
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>


    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>

        <%
            List<model.Direccion> list = model.usuario.getDirecciones();
            pageContext.setAttribute("direcciones", list);
        %>

        <ul class="navegador"> 
            <img src="imagenes/ej.jpg" alt="Logo" title="Logo" id="logo" align="left"/>
            <li><a class="activo" href="A2.jsp">Inicio</a></li>
            <li><a href="#nuevo">Nuevo</a></li>
            <li class="drop"><a><span>Productos</span></a>
                <ul class="submenu">
                    <li><a href="cat_1.jsp">Categoria 1</a></li>

                    <li><a href="cat_2.jsp">Categoria 2</a></li>
                </ul>
            </li>

            <li><a href="#SobreNosotros">Sobre nosotros</a></li>

            <li><a><%= model.usuario.getNombre()%></a></li>
            <li><a href="carrito.jsp">carrito</a></li>
            <li><a href="historial.jsp">historial</a></li>
            <li><a href="logout">logout</a></li>

        </ul>


        <div class="selec">

            <div class="resumen">
                <div class="top">compras:<hr/></div>
                <table id="carrito">
                    <thead>
                        <tr>
                            <td>fecha</td>
                            <td>Precio</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="artNombre">Art</td>
                            <td class="artCant">1</td>
                        </tr>


                    </tbody>
                </table>


                <table class="egt">

                    <caption>historial de compras</caption>

                    <thead>

                        <tr>

                            <th>Elemento</th>

                            <th>Descripción</th>

                        </tr>

                    </thead>

                    <tbody>

                        <tr>

                            <th colspan="2" scope="rowgroup">El elemento raíz</th>

                        </tr>

                        <tr>

                            <td>html</td>

                            <td>Es el contenedor para todos los elementos de un documento</td>

                        </tr>

                    </tbody>

                   
            </div>


        </div>


    </body>
</html>
