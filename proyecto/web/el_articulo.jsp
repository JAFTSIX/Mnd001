<%-- 
    Document   : el_articulo
    Created on : 07-abr-2019, 19:54:11
    Author     : Usuario
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
    
        </head>
        <body>
    
                    <%
                   String nombre=request.getParameter("nombre");
        String img=request.getParameter("img");
        String descripcion=request.getParameter("descripcion");
        String precio=request.getParameter("precio");
        
                    
            %>
            <ul class="navegador">
                <img src="imagenes/ej.jpg" alt="Logo" title="Logo" id="logo" align="left"/>
                <li><a href="index_anterior.xhtml">Inicio</a></li>
                <li><a href="#nuevo">Nuevo</a></li>

                <li class="drop"><a class="activo" href="producto.xhtml"><span>Productos</span></a>
                    <ul class="submenu">
                        <li><a href="#categoria1">Categoria 1</a></li>
                        <li><a href="#categoria2">Categoria 2</a></li>
                        <li><a href="#categoria3">Categoria 3</a></li>
                    </ul>
                </li>

                <li><a href="#carrito">Carrito</a></li>
                <li><a href="#SobreNosotros">Sobre nosotros</a></li>
            </ul>

            <div class="selec">
                <div class="bottom">Item 1</div>
                <img src="<%=img%>" width="50" height="50"/>
                <span class="titulo"><%=nombre%>
                </span><br/><br/><hr/>

                <span class="desc">
                    <%=descripcion%>
                </span><br/><br/>
                <a href="#" class="precio">
                    ₡<%=precio%>
                </a>
                <a href="#" class="boton">Añadir al carrito</a>


            </div>

        </body>
    </html>
</f:view>
