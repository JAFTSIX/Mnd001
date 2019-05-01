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
            <li><a href="faces/direccion_anadir.xhtml">añadir direccion</a></li>
        </ul>


        <div class="selec">
            <div class="resumen">
                <div class="top">Resumen:<hr/></div>
                <form id="actualizar" name="actualizar" action="actualizar_compra">

                    <table id="carrito">


                        <thead>
                            <tr>
                                <td>Articulo</td>
                                <td>cant.</td>
                                <td>Precio</td>
                            </tr>
                        </thead>
                        <input id="json1"  type="hidden" name="json1" value=""/>

                        <tbody>
                        </tbody>
                    </table>
                </form>

                <form id="form" name="form" action="realizar_compra">
                    <div class="bottom" id="precio"></div>
                    <select name="direccion" >
                        <c:forEach var="dir" items="${direcciones}">

                            <option value="${dir.cod_postal}">${dir.cod_postal}</option>
                        </c:forEach>
                    </select>
                    <input id="json"  type="hidden" name="json" value=""/>
                    <input class="boton" style="right: 0px; bottom: 50px;" type="submit" value="comprar" />
                </form>
            </div>
            <ol id="articulos">


            </ol>
        </div>

        <script>

            var sheison = '<%=controller.lista.getJSONBRO()%>';

            var articulos;


           

            function cargar() {


                articulos = JSON.parse(sheison);
                console.log(articulos);
                for (var i = 0; i < articulos.length; i++) {
                    console.log(articulos[i].nombre);
                    agregar(articulos[i].nombre, articulos[i].cant_pedida, articulos[i].precio, articulos[i].img,
                            articulos[i].no_articulo);
                }
                actualizar_sheison();

            }

            var cantidad_articulos = 0;
            function agregar(art, cant, precio, imgSource, no_articulo) {
                //var form = document.getElementById('actualizar');

                cantidad_articulos++;
                //trae la tabla
                var tabla = document.getElementById('carrito');
                //fila tiene las filas de la tabla
                var fila = tabla.rows;
                ///num fila tiene el numero de filas
                var numFilas = fila.length;


                //crea una fila 
                var newRow = document.getElementById('carrito').insertRow(numFilas);

//incerta una celda vacia
                //articulo
                var cell1 = newRow.insertCell(0);
                //cantidad
                var cell2 = newRow.insertCell(1);
                //precio
                var cell3 = newRow.insertCell(2);
                //elimina
                var cell4 = newRow.insertCell(3);

                //Añadir en tabla



                //mete el nombre del articulo en las etiquetas
                cell1.innerHTML = art;
                //determinamos la clase artnombre        
                cell1.setAttribute("class", "artNombre");

                //insertamos la cantidad
                cell2.innerHTML = cant;
                //determinamos la clase artCant      
                cell2.setAttribute("class", "artCant");

                //insertamos el precio
                cell3.innerHTML = "$" + precio;
                //determinamos la clase artPrecio
                cell3.setAttribute("class", "artPrecio");

                //determinamos la clase borrar
                cell4.setAttribute("class", "borrar");

                //creo boton
                //creo boton
                var boton_x = document.createElement("input");
                //
                boton_x.setAttribute("type", "submit");
                boton_x.setAttribute("class", "borrar");
                boton_x.setAttribute("onclick", "borrar(this,'art" + cantidad_articulos + "','" + no_articulo + "');");
                boton_x.setAttribute("value", "X");

                //<form id="form" name="form" action="realizar_compra">
                var from_x = document.createElement("form");
                from_x.setAttribute("action", "actualizar_lista");

                //<input id="json1"  type="hidden" name="json1" value=""/>CREO ESTE
                var hidden = document.createElement("input");
                hidden.setAttribute("id", "json" + cantidad_articulos);
                hidden.setAttribute("name", "json" + cantidad_articulos);
                hidden.setAttribute("type", "hidden");

                from_x.appendChild(boton_x);
                from_x.appendChild(hidden);
                //mete el form en la celda 4

                cell4.appendChild(from_x);
                //Añadir en tabla




                //trae los elementos de articulos
                var elem = document.getElementById("articulos");

                //Añadir en lista de imagenes
                //crea una etiqueta li
                var nodo0 = document.createElement("li");
                //le ponemos el id a la lista li
                nodo0.setAttribute("id", "art" + cantidad_articulos);

                //crea una etiqueta a
                var nodo1 = document.createElement("a");

                // crea una etiqueta img
                var nodo2 = document.createElement("img");
                //inserta la url de la imagen
                nodo2.setAttribute("src", imgSource);

                // dentro de a meto la img
                nodo1.appendChild(nodo2);
                //meto a en li
                nodo0.appendChild(nodo1);
                //meto el li a articulos
                elem.appendChild(nodo0);
                //Añadir en lista de imagenes

                getTotal();
                console.log(cantidad_articulos);
            }

            function borrar(x, artId, no_arti) {
                var index;
                console.log("no_articulo " + no_arti);
                for (var i = 0; i < articulos.length; i++) {

                    if (articulos[i].no_articulo === no_arti) {
                        index = i;
                    }

                }

                if (index > -1) {
                    articulos.splice(index, 1);
                }

                //se obtiene el numero de la linea que esta usando(tabla)
                var del = x.parentNode.parentNode.rowIndex;
                //borra la fila de la linea de  facturacion 
                document.getElementById("carrito").deleteRow(del);


                //se obtiene el  elemento(li) con el id del articulo
                var nodo = document.getElementById(artId);
                //prod tiene la etiqueta ol entera (Ol)
                var prod = document.getElementById("articulos");
                //se reduce la cantidad de elementos 
                i--;

                prod.removeChild(nodo);
                actualizar_sheison();
                getTotal();
                console.log(i);
            }

            function getTotal() {
                var precio = document.getElementsByClassName("artPrecio");
                var cantidad = document.getElementsByClassName("artCant");
                var total = 0.0;
                //<![CDATA[
                for (var j = 0; j < precio.length; j++) {
                    var valor = precio[j].innerHTML;
                    var can = cantidad[j].innerHTML;
                    var res = (parseFloat(valor.substr(1)));
                    var CINER = (parseFloat(can));
                    res = res * CINER;
                    total = total + res;
                }

                console.log("total: " + total);
                var doc = document.getElementById("precio");
                doc.innerHTML = "";
                var hzRule = document.createElement('hr');
                var format = document.createTextNode("Total: $" + total);
                doc.appendChild(hzRule);
                doc.appendChild(format);
            }

            function actualizar_sheison() {
                sheison = JSON.stringify(articulos);

                document.form.json.value = sheison;
                for (var x = 0; x <= cantidad_articulos; x++) {
                    if (x>0) {
                        var i_de = "json" + x;
                        var elhiden = document.getElementById(i_de);
                        elhiden.setAttribute("value", sheison);
                    }

                }

                //compra_art.setAttribute("value", "" + sheison);

                console.log("articulos  " + articulos);
                console.log("sheison  " + sheison);

            }


            window.onload = getTotal();
            window.onload = cargar();

        </script>

    </body>
</html>
