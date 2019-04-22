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
            <li><a href="logout">logout</a></li>

        </ul>


        <div class="selec">
            <button class="borrar" onclick="agregar('prueba', '12', '250000', 'imagenes/ej.jpg')">agregar</button>
            <div class="resumen">
                <div class="top">Resumen:<hr/></div>

                <table id="carrito">
                    <thead>
                        <tr>
                            <td>Articulo</td>
                            <td>cant.</td>
                            <td>Precio</td>
                        </tr>
                    </thead>
                    <tbody>
                        

                    </tbody>
                </table>

                <form>
                    <div class="bottom" id="precio"></div>
                    <a href="#" class="boton" style="right: 0px; bottom: 50px;">comprar</a>
                    <in>  
                    </div>
                </form>


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
                        agregar(articulos[i].nombre, articulos[i].cant_pedida, articulos[i].precio, articulos[i].img);
                    }

                }

                var i = 1;
                function agregar(art, cant, precio, imgSource) {

                    i++;
                    var tabla = document.getElementById('carrito');
                    var fila = tabla.rows;
                    var numFilas = fila.length;

                    var newRow = document.getElementById('carrito').insertRow(numFilas);
                    var cell1 = newRow.insertCell(0);
                    var cell2 = newRow.insertCell(1);
                    var cell3 = newRow.insertCell(2);
                    var cell4 = newRow.insertCell(3);

                    //Añadir en tabla
                    var elem = document.getElementById("articulos");

                    cell1.innerHTML = art;
                    cell1.setAttribute("class", "artNombre");
                    cell2.innerHTML = cant;
                    cell2.setAttribute("class", "artCant");
                    cell3.innerHTML = "₡" + precio;
                    cell3.setAttribute("class", "artPrecio");

                    cell4.setAttribute("class", "borrar");
                    var node = document.createElement("button");
                    node.setAttribute("class", "borrar");
                    node.setAttribute("onclick", "borrar(this,'art" + i + "')");
                    node.innerHTML = "X";
                    cell4.appendChild(node);
                    //Añadir en tabla


                    //Añadir en lista de imagenes
                    var nodo0 = document.createElement("li");
                    nodo0.setAttribute("id", "art" + i);
                    var nodo1 = document.createElement("a");
                  
                    var nodo2 = document.createElement("img");
                    nodo2.setAttribute("src", imgSource);
                    nodo1.appendChild(nodo2);
                    nodo0.appendChild(nodo1);
                    elem.appendChild(nodo0);
                    //Añadir en lista de imagenes
                    getTotal();
                    console.log(i);
                }

                function borrar(x, artId) {
                    var del = x.parentNode.parentNode.rowIndex;
                    var elem = document.getElementById(artId);
                    var prod = document.getElementById("articulos");
                    document.getElementById("carrito").deleteRow(del);
                    i--;
                    //<![CDATA[
                    for (var j = 0; j < prod.childNodes.length; j++) {
                        if (prod.childNodes[j].tagName === 'li' && prod.childNodes[j].id === artId) {
                            prod.removeChild(prod.childNodes[j]);
                            break;
                        }
                    }
                    //]]>
                    getTotal();
                    console.log(i);
                }

                function getTotal() {
                    var precio = document.getElementsByClassName("artPrecio");
                    var total = 0.0;
                    //<![CDATA[
                    for (var j = 0; j < precio.length; j++) {
                        var valor = precio[j].innerHTML;
                        var res = (parseFloat(valor.substr(1)));
                        total = total + res;
                    }
                    //]]>
                    console.log("total: " + total);
                    var doc = document.getElementById("precio");
                    doc.innerHTML = "";
                    var hzRule = document.createElement('hr');
                    var format = document.createTextNode("Total: ₡" + total);
                    doc.appendChild(hzRule);
                    doc.appendChild(format);
                }
                //asdasdasd
                window.onload = getTotal();
                window.onload = cargar();

            </script>

    </body>
</html>
