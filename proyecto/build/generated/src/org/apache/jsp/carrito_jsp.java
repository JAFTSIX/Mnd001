package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class carrito_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("  <ul class=\"navegador\"> \n");
      out.write("            <img src=\"imagenes/ej.jpg\" alt=\"Logo\" title=\"Logo\" id=\"logo\" align=\"left\"/>\n");
      out.write("            <li><a class=\"activo\" href=\"A2.jsp\">Inicio</a></li>\n");
      out.write("            <li><a href=\"#nuevo\">Nuevo</a></li>\n");
      out.write("            <li class=\"drop\"><a><span>Productos</span></a>\n");
      out.write("                <ul class=\"submenu\">\n");
      out.write("                    <li><a href=\"cat_1.jsp\">Categoria 1</a></li>\n");
      out.write("\n");
      out.write("                    <li><a href=\"cat_2.jsp\">Categoria 2</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <li><a href=\"#SobreNosotros\">Sobre nosotros</a></li>\n");
      out.write("\n");
      out.write("            <li><a>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrito.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("            <li><a href=\"carrito.jsp\">carrito</a></li>\n");
      out.write("            <li><a href=\"logout\">logout</a></li>\n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <!--> barra de navegacion<-->\n");
      out.write("\n");
      out.write("        <div class=\"selec\">\n");
      out.write("            <button class=\"borrar\" onclick=\"agregar('prueba', '12', '250000', 'imagenes/ej.jpg')\">agregar</button>\n");
      out.write("            <div class=\"resumen\">\n");
      out.write("                <div class=\"top\">Resumen:<hr/></div>\n");
      out.write("\n");
      out.write("                <table id=\"carrito\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Articulo</td>\n");
      out.write("                            <td>cant.</td>\n");
      out.write("                            <td>Precio</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"artNombre\">Art</td>\n");
      out.write("                            <td class=\"artCant\">1</td>\n");
      out.write("                            <td class=\"artPrecio\">₡100.0</td>\n");
      out.write("                            <td class=\"borrar\"><button class=\"borrar\" onclick=\"borrar(this, 'art1')\">X</button></td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("                <div class=\"bottom\" id=\"precio\"></div>\n");
      out.write("                <a href=\"#\" class=\"boton\" style=\"right: 0px; bottom: 50px;\">comprar</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <ol id=\"articulos\">\n");
      out.write("                <li id=\"art1\"> \n");
      out.write("                    <a href=\"articulo.xhtml\">\n");
      out.write("                        <img src=\"imagenes/ej.jpg\"/>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("            </ol>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function cargar() {\n");
      out.write("                \n");
      out.write("           var sheison = '");
      out.print(controller.lista.getJSONBRO());
      out.write("';\n");
      out.write("                console.log(sheison);\n");
      out.write("                var LEL = JSON.parse(sheison);\n");
      out.write("                console.log(LEL);\n");
      out.write("              \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            var i = 1;\n");
      out.write("            function agregar(art, cant, precio, imgSource) {\n");
      out.write("                \n");
      out.write("                i++;\n");
      out.write("                var tabla = document.getElementById('carrito');\n");
      out.write("                var fila = tabla.rows;\n");
      out.write("                var numFilas = fila.length;\n");
      out.write("                \n");
      out.write("                var newRow = document.getElementById('carrito').insertRow(numFilas);\n");
      out.write("                var cell1 = newRow.insertCell(0);\n");
      out.write("                var cell2 = newRow.insertCell(1);\n");
      out.write("                var cell3 = newRow.insertCell(2);\n");
      out.write("                var cell4 = newRow.insertCell(3);\n");
      out.write("                \n");
      out.write("                //Añadir en tabla\n");
      out.write("                var elem = document.getElementById(\"articulos\");\n");
      out.write("                \n");
      out.write("                cell1.innerHTML = art;\n");
      out.write("                cell1.setAttribute(\"class\", \"artNombre\");\n");
      out.write("                cell2.innerHTML = cant;\n");
      out.write("                cell2.setAttribute(\"class\", \"artCant\");\n");
      out.write("                cell3.innerHTML = \"₡\" + precio;\n");
      out.write("                cell3.setAttribute(\"class\", \"artPrecio\");\n");
      out.write("                \n");
      out.write("                cell4.setAttribute(\"class\", \"borrar\");\n");
      out.write("                var node = document.createElement(\"button\");\n");
      out.write("                node.setAttribute(\"class\", \"borrar\");\n");
      out.write("                node.setAttribute(\"onclick\", \"borrar(this,'art\" + i + \"')\");\n");
      out.write("                node.innerHTML = \"X\";\n");
      out.write("                cell4.appendChild(node);\n");
      out.write("                //Añadir en tabla\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                //Añadir en lista de imagenes\n");
      out.write("                var nodo0 = document.createElement(\"li\");\n");
      out.write("                nodo0.setAttribute(\"id\", \"art\" + i);\n");
      out.write("                var nodo1 = document.createElement(\"a\");\n");
      out.write("                nodo1.setAttribute(\"href\", \"articulo.xhtml\");\n");
      out.write("                var nodo2 = document.createElement(\"img\");\n");
      out.write("                nodo2.setAttribute(\"src\", imgSource);\n");
      out.write("                nodo1.appendChild(nodo2);\n");
      out.write("                nodo0.appendChild(nodo1);\n");
      out.write("                elem.appendChild(nodo0);\n");
      out.write("                //Añadir en lista de imagenes\n");
      out.write("                getTotal();\n");
      out.write("                console.log(i);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function borrar(x, artId) {\n");
      out.write("                var del = x.parentNode.parentNode.rowIndex;\n");
      out.write("                var elem = document.getElementById(artId);\n");
      out.write("                var prod = document.getElementById(\"articulos\");\n");
      out.write("                document.getElementById(\"carrito\").deleteRow(del);\n");
      out.write("                i--;\n");
      out.write("                //<![CDATA[\n");
      out.write("                for (var j = 0; j < prod.childNodes.length; j++) {\n");
      out.write("                    if (prod.childNodes[j].tagName === 'li' && prod.childNodes[j].id === artId) {\n");
      out.write("                        prod.removeChild(prod.childNodes[j]);\n");
      out.write("                        break;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                //]]>\n");
      out.write("                getTotal();\n");
      out.write("                console.log(i);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function getTotal() {\n");
      out.write("                var precio = document.getElementsByClassName(\"artPrecio\");\n");
      out.write("                var total = 0.0;\n");
      out.write("                //<![CDATA[\n");
      out.write("                for (var j = 0; j < precio.length; j++) {\n");
      out.write("                    var valor = precio[j].innerHTML;\n");
      out.write("                    var res = (parseFloat(valor.substr(1)));\n");
      out.write("                    total = total + res;\n");
      out.write("                }\n");
      out.write("                //]]>\n");
      out.write("                console.log(\"total: \" + total);\n");
      out.write("                var doc = document.getElementById(\"precio\");\n");
      out.write("                doc.innerHTML = \"\";\n");
      out.write("                var hzRule = document.createElement('hr');\n");
      out.write("                var format = document.createTextNode(\"Total: ₡\" + total);\n");
      out.write("                doc.appendChild(hzRule);\n");
      out.write("                doc.appendChild(format);\n");
      out.write("            }\n");
      out.write("            //asdasdasd\n");
      out.write("            window.onload = getTotal();\n");
      out.write("                        window.onload=cargar();\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
