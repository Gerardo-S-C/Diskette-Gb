<%-- 
    Document   : formulario
    Created on : 16/11/2021, 07:12:19 PM
    Author     : illum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="CSS/formulario.css">
    <title>Página segura</title>
</head>
<body>
    <section class="form-register">
        <h4>Ingrese sus datos para seguir</h4>
        <input class="controls" type="text" name="nombres" id="nombres" placeholder="Ingrese su Nombre Completo">
        <input class="controls" type="text" name="dirección" id="dirección" placeholder="Ingrese su Dirección">
        <input class="controls" type="text" name="telefono" id="telefono" placeholder="Ingrese su Télefono">
        <input class="controls" type="text" name="numero" id="numero" placeholder="Ingrese su Número de tarjeta de Credito">
        <input class="controls" type="password" name="fecha" id="fecha" placeholder="Ingrese su Fecha de Vencimiento">
        <p>Estoy de acuerdo con <a href="#">Terminos y Condiciones</a></p>
        <input class="botons" type="submit" value="Ingresar">
      </section>
</body>
</html>