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
        <title>Ejemplo</title>
    </head>
    <body>
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


            <%
                if (model.usuario.isInicio()) {
            %>
            <li><a><%= model.usuario.getNombre()%></a></li>
            <li><a href="carrito.jsp">carrito</a></li>
            <li><a href="historial.jsp">historial</a></li>            
            <li><a href="logout">logout</a></li>

            <%            } else {
            %>
            <li><a href="faces/inicio_login.xhtml">login</a></li>
            <li><a href="faces/registrarse.xhtml">registrarse</a></li>
                <%                }
                %>



        </ul>

        <sql:setDataSource var="LADB" url="jdbc:derby://localhost:1527/a"  driver="org.apache.derby.jdbc.ClientDriver" user="a" password="a" />

            <sql:query var="lol" dataSource="${LADB}">
            SELECT NO_ARTICULO, NOMBRE,IMG FROM A.TB_ARTICULO FETCH FIRST 10 ROWS ONLY
        </sql:query>


        <div class="contenido">
            <ul>

                <c:forEach var="nispe" items="${lol.rows}">
                    <form  action="el_arti">
                        <li style="background-color: #ffffff"> 
                            <img src="${nispe.img}" alt="" height="100" width="70"  />
                            <div class="bottom">${nispe.nombre}</div>
                            <input  type="submit"  style=" background-color: #ffffff" value="ver" />
                            <input type="hidden" name="no_articulo" value="${nispe.no_articulo}" />
                            <input type="hidden" name="nombre" value="${nispe.nombre}" />
                            <input type="hidden" name="img" value="${nispe.img}" />
                        </li>
                    </form>
                </c:forEach>

            </ul>
        </div>   
    </body>
</html>
