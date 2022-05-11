<%@page import="java.util.List"%>
<%@page import="Modelo.*"%>
<%@page import="Control.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quejas y Sugerencias</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
        String nombre = (String) session.getAttribute("Usuario");
        System.out.println(nombre);
        List<Dificultades> listdif = Administrador.ConsDificultadess();
        String email = accionesUsu.getEmailByName(nombre);
        System.out.println(email);
        String password = accionesUsu.getPassByEmail(email);
        int idbloEstafas=1;
        int idbloVirus=2;
        %>
        <div id="correo">
            <form id="form" method="post">
                <div class="field">
                  <label for="from_name">De</label>
                  <input type="text" name="from_name" id="from_name" class="from_name" value="<%=nombre%>">
                </div>
                <div class="field">
                  <label for="from_email">Correo</label>
                  <input type="text" name="from_email" id="from_email" class="from_email" value="<%=email%>">
                </div>
                <div class="field">
                  <label for="reply_to">Para</label>
                  <input type="text" name="reply_to" id="reply_to" class="reply_to" value="bellakrisis@gmail.com">
                </div>
                <div class="field">
                  <label for="subject">Asunto</label>
                  <input type="text" name="subject" class="subject" id="subject">
                </div>
                <div class="field">
                  <label for="message">Mensaje</label>
                  <input type="text" name="message" class="message" id="message">
                </div>
                <input type="submit" id="button" class="submit" name="submit" value="Enviar">
          </form>
        </div>
    <!--EMAILJS-->
    <script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js">
    </script>
    <script type="text/javascript">
       (function(){
          emailjs.init("6MYClGvZEQXpvbLK4");
       })();
    </script>
    <!--SWEET ALERT-->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script type="text/javascript">
        function emptyerror() {
            swal({
              icon: "error",
              title: "Oops...",
              text: "Los campos no pueden estar vacios!",
            });
        }

        function error() {
            swal({
              icon: "error",
              title: "Oops...",
              text: "Algo salió mal!",
            });
        }

        function success() {
            swal({
              icon: "success",
              title: "Success...",
              text: "Mensaje enviado correctamente, para aseguranos de ello le hemos enviado un mensaje a su correo.",
            });
        }
    </script>
    <script src="./JS/correo.js"></script>
    </body>
</html>
