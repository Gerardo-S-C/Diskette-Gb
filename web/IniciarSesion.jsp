<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <html lang="en">

  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
    <link rel="stylesheet" href="./CSS/iniciar.css" />
    <title>Iniciar Sesión</title>
  </head>

  <body>
    <div>
      <div class="datos">
        <p class="Titulo">Iniciar Sesión</p>
        <div class="botones">
          <form name="InicioSesion" method="post" id="form" action="IniciarSesion">
            <div class="aa">
              <label for="" class="campos">Correo: </label>
              <input type="text" id="correo" name="correo" class="form-control" aria-describedby="passwordHelpBlock" />

              <br />
              <br />

              <label for="" class="campos">Password: </label>
              <input type="password" id="password" name="password" class="form-control"
                aria-describedby="passwordHelpBlock" />

              <div class="BC">
                <div class="wrapper">
                  <button type="submit" id="boton" class="button" onclick="validarSesion();">
                    Confirmar
                  </button>
                  <p class="warnings" id="warnings"></p>
                </div>
                  
                <!-- Filter: https://css-tricks.com/gooey-effect/ -->
                <svg style="visibility: hidden; position: absolute" width="0" height="0"
                  xmlns="http://www.w3.org/2000/svg" version="1.1">
                  <defs>
                    <filter id="goo">
                      <feGaussianBlur in="SourceGraphic" stdDeviation="10" result="blur" />
                      <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 19 -9"
                        result="goo" />
                      <feComposite in="SourceGraphic" in2="goo" operator="atop" />
                    </filter>
                  </defs>
                </svg>
              </div>
            </div>
          </form>
        </div>
      </div>

      <div class="BV">
        <div class="wrapper">
          <a class="button2" href="./index.html">Volver</a>
        </div>

        <!-- Filter: https://css-tricks.com/gooey-effect/ -->
        <svg style="visibility: hidden; position: absolute" width="0" height="0" xmlns="http://www.w3.org/2000/svg"
          version="1.1">
          <defs>
            <filter id="goo">
              <feGaussianBlur in="SourceGraphic" stdDeviation="10" result="blur" />
              <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 19 -9"
                result="goo" />
              <feComposite in="SourceGraphic" in2="goo" operator="atop" />
            </filter>
          </defs>
        </svg>
      </div>
    </div>
    <script src="./JS/validarSesion.js"></script>
  </body>

  </html>