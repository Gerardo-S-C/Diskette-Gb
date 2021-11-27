<%-- 
    Document   : paginabasura
    Created on : 26/11/2021, 02:26:01 AM
    Author     : illum
--%>


<%@page import="Modelo.UsuarioConsulta"%>
<%@page import="Control.accionesUsu"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="CSS/segunda.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <title>Como hacer una transacción bancaria?</title>
<%
    String nombre = (String) session.getAttribute("Usuario");
%>
    </head>
    <body>
        <div class="form-group">
            <!--Para el Tache de las simulaciones-->
            <form name="X" method="post" id="progress" action="AumentarProgresoEZ" class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button type="submit" class="btn "><img src="./img/tache.png" height="80px" width="80px" class="tache"></a></button>
            </form>
            <form action="">
                <table>
                    <tr>
                        <td><label for="name"class="col-form-label">Nombre</label></td>
                        <td><input type="text" placeholder="Escribe tu nombre"  name="name" maxlength="30" id="name"></td>
                    <tr>
                        <td><label for="teléfono">Télefeno</label></td>
                        <td><input type="text" placeholder="Escribe tu teléfono" maxlength="10" name="teléfono" id="teléfono">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="número">Número de tarjeta</label></td>
                        <td><input type="text" name="cn" class="inline" id="cn" placeholder="Escribe tu número" maxlength="16"></td>
                    </tr>
                    <tr>
                        <td><label for="nombre">Fecha de caducidad</label></td>
                        <td><input type="text"  placeholder="MM/YY" pattern="[0-9]{4}" name="exp" id="exp">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="cvv">Número cvv</label></td>
                        <td><input type="text" placeholder="Escribe el número" maxlength="3" name="cvv" id="cvv"></td>
                    </tr>
                    <tr>
                        <td><input id="button-pay" type="submit" class="btn btn-info btn-block" disabled value="Enviar"/></td>
                        <td>
                            <div class="col-3 container-type-card">
                                <img id="type-card" class="type-card" src="" alt="">
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
            
        </div>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="JS/index.js"></script>
        <script src="JS/app.js"></script>

        <script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-1116393974429402"
        crossorigin="anonymous"></script>
        <!-- Bloque vertical -->
        <ins class="adsbygoogle" style="display:block" data-ad-client="ca-pub-1116393974429402" data-ad-slot="9376117010"
             data-ad-format="auto" data-full-width-responsive="true"></ins>
        <script>
            (adsbygoogle = window.adsbygoogle || []).push({});
        </script>
    </body>

</html>