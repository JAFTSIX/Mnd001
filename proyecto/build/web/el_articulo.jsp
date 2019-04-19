<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : el_articulo
    Created on : 07-abr-2019, 19:54:11
    Author     : Usuario
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

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
                String nombre = request.getParameter("nombre");
                String img = request.getParameter("img");
                String id = request.getParameter("no_articulo");

            %>

            <sql:setDataSource var="LADB" url="jdbc:derby://localhost:1527/a"  driver="org.apache.derby.jdbc.ClientDriver" user="a" password="a" />


            <sql:query var="lol" dataSource="${LADB}">



                SELECT ar.PRECIO  , li.DUENO ,tis.NOMBRE , ar.DESCRIP  , ar.CANT  
                FROM TB_ARTICULO ar, TB_LICENCIA li, TB_ARTISTA tis
                where ar.ID_LICENCIA=li.ID_LICENCIA and ar.ID_ARTISTA=tis.ID_ARTISTA and ar.NO_ARTICULO=<%=id%> 

            </sql:query>



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
            <li><a href="faces/carrito.xhtml">carrito</a></li>
            <li><a href="logout">logout</a></li>
            
            <%            } else {
            %>
            <li><a href="faces/inicio_login.xhtml">login</a></li>
            <li><a href="faces/registrarse.xhtml">registrarse</a></li>
                <%                }
                %>



        </ul>

            <c:forEach var="nepe" items="${lol.rows}">
                <div class="selec">
                    <div class="bottom">artista:${nepe.nombre}</div>
                    <img src="<%=img%>" width="50" height="50"/>
                    <span class="titulo"><%=nombre%>
                    </span><br/><br/><hr/>

                    <span class="desc">
                        ${nepe.descrip} <p>
                            franquicia:${nepe.dueno} 
                    </span><br/><br/>
                    <a href="#" class="precio">
                        $${nepe.precio}
                    </a>

                    <a href="test" class="boton">Añadir al carrito</a>


                </div>
            </c:forEach>
        </body>
    </html>
</f:view>
