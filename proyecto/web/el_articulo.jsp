<%-- 
    Document   : el_articulo
    Created on : 19-abr-2019, 15:20:42
    Author     : Usuario
--%>

<%@page import="model.usuario"%>
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
        <%
            String nombre = request.getParameter("nombre");
            String img = request.getParameter("img");
            String id = request.getParameter("no_articulo");

        %>


        <sql:setDataSource var="LADB" url="jdbc:derby://localhost:1527/a"  driver="org.apache.derby.jdbc.ClientDriver" user="a" password="a" />


        <sql:query var="lol" dataSource="${LADB}">



            SELECT ar.PRECIO  , li.DUENO ,tis.NOMBRE , ar.DESCRIP  , ar.CANT  
            FROM TB_ARTICULO ar, TB_LICENCIA li, TB_ARTISTA tis
            where ar.ID_LICENCIA=li.ID_LICENCIA and ar.ID_ARTISTA=tis.ID_ARTISTA and ar.NO_ARTICULO=<%=request.getParameter("no_articulo")%> 

        </sql:query>

        <script>
            function IrAServletUsandoPost(direccionACambiar)
            {
                document.formulario.action = direccionACambiar;
                document.formulario.submit();


            }
        </script>


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
                <span class="titulo"><%=nombre%>  <a href="#" class="precio">
                        $${nepe.precio}
                    </a>
                </span><br/><br/><hr/>



                <form name="formulario" action="servletDondeIr" method="Post">
                    <span class="desc">
                        ${nepe.descrip} <p>
                            franquicia:${nepe.dueno} <p>

                            cantidad <input type="number" name="cant_pedida"  value="1"  size="2" min="1" pattern="^[0-9]+"/><p>
                    </span><br/><br/>

                    <input type="hidden" name="no_articulo" value="<%=request.getParameter("no_articulo")%>" />
                    <input type="hidden" name="nombre" value="<%=nombre%>" />
                    <input type="hidden" name="img" value="<%=img%>" />
                    <input type="hidden" name="cantidad"  value="${nepe.cant}"  size="5"/>
                    <input type="hidden" name="precio"  value="${nepe.precio}" />

                    <input class="boton" type ="button" onclick="javascript:IrAServletUsandoPost('test'); myFunction()" value="Añadir al carrito" />
                </form>




            </div>
        </c:forEach>
        <script>
            function myFunction() {

                if (<%=usuario.isInicio()%>) {
                    alert("articulo al carrito!");
                } else {
                    alert("inicia sesión!");
                }

            }
        </script>
    </body>
</html>
