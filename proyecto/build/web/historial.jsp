<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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

            <div class="caja_hi">

                <div class="top">compras:<hr/></div>
                <table id="historia" >

                    <caption>historial de compras</caption>

                    <thead>

                        <tr>

                            <th></th>

                            <th>Información</th>

                        </tr>   

                    </thead>
                    <sql:setDataSource var="LADB" url="jdbc:derby://localhost:1527/a"  driver="org.apache.derby.jdbc.ClientDriver" user="a" password="a" />


                    <sql:query var="encabezados" dataSource="${LADB}">
                        select EN.NO_COMPRA ,EN.TOTAL,EN.FECHA
                        from TB_CLIENTE CL,TB_ENCABEZADO EN
                        WHERE CL.ID_CLIENTE=EN.ID_CLIENTE AND CL.ID_CLIENTE=<%= model.usuario.getId_Cliente()%>

                    </sql:query>

                    <c:forEach var="enca" items="${encabezados.rows}">
                        <tbody>     

                            <tr>

                                <th colspan="2" scope="rowgroup"> total: ${enca.total}           fecha:${enca.fecha} </th>

                            </tr>
                            <sql:query var="lineas" dataSource="${LADB}">
                                select AR.NOMBRE,LI.UNIDADES,LI.PRECIO_UNIDAD,LI.PRECIO_TOTAL
                                from TB_ENCABEZADO EN,TB_LINEAPEDIDO LI,TB_ARTICULO AR
                                WHERE LI.NO_ARTICULO=AR.NO_ARTICULO AND LI.NO_COMPRA =EN.NO_COMPRA AND EN.NO_COMPRA=${enca.no_compra}

                            </sql:query>

                            <c:forEach var="linea" items="${lineas.rows}">
                                <tr>
                                    <th>nombre</th>
                                    <th>unidades</th>
                                    <th>precio por unidad</th>
                                    <th>precio total</th>
                                </tr>  
                                <tr>

                                    <td>${linea.nombre}</td>
                                    <td>  ${linea.unidades}</td>
                                    <td>${linea.precio_unidad}</td>
                                    <td>${linea.precio_total}</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:forEach>


            </div>


        </div>


    </body>
</html>
