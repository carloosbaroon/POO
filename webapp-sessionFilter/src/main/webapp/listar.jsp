<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="org.cbaron.apiservlet.webapp.headers.*, java.util.*" %>
<%@ page import="org.cbaron.apiservlet.webapp.headers.models.Producto" %>
<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    Optional<String> username = (Optional<String>) request.getAttribute("username");
    String mensajeRequest = (String) request.getAttribute("mensaje");
    String mensajeGlobal = (String) request.getServletContext().getAttribute("mensaje");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado de productos</title>
</head>
<body>
<h1>Listado de productos</h1>
<% if (username.isPresent()) {%>
<div>Hola <%=username.get()%>, bienvenido!</div>
<%}%>
<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>categoria</th>
        <% if (username.isPresent()) {%>
        <th>precio</th>
        <th>agregar</th>
        <%}%>
    </tr>
    <% for (Producto p : productos) {%>
    <tr>
        <td><%=p.getId()%>
        </td>
        <td><%=p.getNombre()%>
        </td>
        <td><%=p.getCategoria().getNombre()%>
        </td>
        <% if (username.isPresent()) { %>
        <td><%= p.getPrecio() %></td>
        <td><a href="<%= request.getContextPath() %>/carro/agregar?id=<%= p.getId() %>">Agregar al carro</a></td>
        <% } %>
    </tr>
    <%}%>
</table>
<p><%=mensajeGlobal%>
</p>
<p><%=mensajeRequest%>
</p>

</body>
</html>