<%-- 
    Document   : A2
    Created on : 07-abr-2019, 21:00:40
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul class="navegador"> 
            <img src="imagenes/ej.jpg" alt="Logo" title="Logo" id="logo" align="left"/>
            <li><a class="activo" href="index_anterior.xhtml">Inicio</a></li>
            <li><a href="#nuevo">Nuevo</a></li>

            <li class="drop"><a href="producto.xhtml"><span>Productos</span></a>
                <ul class="submenu">
                    <li><a href="#categoria1">Categoria 1</a></li>
                    <li><a href="#categoria2">Categoria 2</a></li>
                    <li><a href="#categoria3">Categoria 3</a></li>
                </ul>
            </li>

            <li><a href="#carrito">Carrito</a></li>
            <li><a href="#SobreNosotros">Sobre nosotros</a></li>
        </ul>

    <sql:setDataSource var="LADB" url="jdbc:derby://localhost:1527/a"  driver="org.apache.derby.jdbc.ClientDriver" user="a" password="a" />

    <sql:query var="lol" dataSource="${LADB}">
        SELECT * FROM A.ARTICULO FETCH FIRST 10 ROWS ONLY
    </sql:query>


    <div class="contenido">
        <ul>

            <c:forEach var="nispe" items="${lol.rows}">
                <form  action="el_arti">
                    <li > 
                        <img src="${nispe.img}" alt="" height="100" width="70"  />
                        <div class="bottom">${nispe.nombres}</div>
                        <input type="submit"  style=" background-color: #ffffff" value="ver" />
                        <input type="hidden" name="nombre" value="${nispe.nombres}" />
                        <input type="hidden" name="img" value="${nispe.img}" />
                        <input type="hidden" name="descripcion" value="${nispe.descripcion}" />
                        <input type="hidden" name="precio" value="${nispe.precio}" />
                    </li>
                </form>
            </c:forEach>

        </ul>
    </div>   
</body>
</html>
