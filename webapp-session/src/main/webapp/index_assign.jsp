<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tarea 5: Session HTTP</title>
</head>
<body>
<h3>Tarea 5: Session HTTP</h3>
<p>Hola <%=session.getAttribute("nombre") != null ? session.getAttribute("nombre") : "anónimo"%>, bienvenido a la
    tarea5.</p>

<form action="/webapp-session/guardar-session" method="post">
    <div>
        <label for="color">Ingresa tu nombre de sesión</label>
        <div>
            <input type="text" name="nombre" id="color">
        </div>

    </div>
    <div>
        <input type="submit" value="Enviar">
    </div>

</form>
</body>
</html>