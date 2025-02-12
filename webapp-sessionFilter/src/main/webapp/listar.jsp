<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado de productos</title>
</head>
<body>
<h1>Listado de productos</h1>
<c:if test="${requestScope.username.isPresent()}">
    <div>Hola ${username.get()}, bienvenido!</div>
    <p><a href="${pageContext.request.contextPath}/productos/form">Crear [+]</a></p>
</c:if>
<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>categoria</th>
        <c:if test="${username.present}">
        <th>precio</th>
        <th>agregar</th>
        <th>editar</th>
        <th>eliminar</th>
        </c:if>
    </tr>
    <c:forEach items="${productos}" var="p">
    <tr>
        <td>${p.id}</td>
        <td>${p.nombre}</td>
        <td>${p.categoria.nombre}</td>
        <c:if test="${username.present}">
        <td>${p.precio}</td>
        <td><a href="${pageContext.request.contextPath}/carro/agregar?id=${p.id}">Agregar al carro</a></td>
        <td><a href="${pageContext.request.contextPath}/productos/form?id=${p.id}">editar</a></td>
        <td><a onclick="return confirm('Seguro que deseas eliminar?');"
               href="${pageContext.request.contextPath}/productos/eliminar?id=${p.id}">eliminar</a></td>
        </c:if>
    </tr>
    </c:forEach>
</table>
<p>${applicationScope.mensaje}</p>
<p>${requestScope.mensaje}</p>
</body>
</html>