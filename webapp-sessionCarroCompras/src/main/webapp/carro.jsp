<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.cbaron.apiservlet.webapp.headers.models.*" %>
<%
    Carro carro = (Carro) session.getAttribute("carro");
%>
<html>
<head>
    <title>Carro de compras</title>
</head>
<body>
<h1>Carro de compras</h1>
<% if (carro == null || carro.getItems().isEmpty()) {%>
<p>Lo sentimos no hay productos en el carro</p>
<%} else {%>
<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>precio</th>
        <th>cantidad</th>
        <th>total</th>
    </tr>
    <% for (ItemCarro item: carro.getItems()) {%>
    <tr>
        <td><%=item.getProducto().getId()%></td>
        <td><%=item.getProducto().getNombre()%></td>
        <td><%=item.getProducto().getPrecio()%></td>
        <td><%=item.getCantidad()%></td>
        <td><%=item.getImporte()%></td>
    </tr>
    <%}%>
    <tr>
        <td colspan="4" style="text-align: right">Total:</td>
        <td><%=carro.getTotal()%></td>
    </tr>
</table>
<%} %>
<p><a href="<%=request.getContextPath()%>/productos">Seguir comprando</a></p>
<p><a href="<%=request.getContextPath()%>/index.html">Volver</a></p>
</body>
</html>
