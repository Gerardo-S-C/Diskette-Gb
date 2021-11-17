<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page import="Modelo.*"%>
<%@page import="Control.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./CSS/MenUsuario.css" />
    <script
      src="https://kit.fontawesome.com/d10bfaa166.js"
      crossorigin="anonymous"
    ></script>
    <title>Inicio</title>
  </head>
  <body>
    <div class="grid">
      <div class="izq">
        <div class="usuario">
          <div class="cuadrousu">
            <img src="./img/Usuario.png" alt="" class="imgusu" />
            <p>${Usuario}</p>
          </div>
        </div>

        <div class="act">
          <div class="bloque1">
            <div class="acordeon">
              <li class="acc-item" id="user">
                <a href="./simulacion_buscar.html" class="btn"
                  ><i class="far fa-dizzy"></i>Estafa</a
                >
                <a href="./simulacion_buscar.html">Fácil</a>
                <div class="submenu">
                  <a href="./simulacion_navegador.html" class="Phising"
                    ><i class="far fa-address-card"></i>Phising</a
                  >
                </div>
              </li>
            </div>
          </div>

          <div class="boton">
            <div class="wrapper" id="iniciar">
              <a class="button" href="logout.jsp">Cerrar Sesión</a>
            </div>
          </div>
        </div>
      </div>

      <div class="proceso">
        <div class="proest">
          <div class="estaf">
            <p class="estafas">ESTAFAS</p>
            <p class="prosgenest">Proceso General:</p>
            <p class="porcentaje">50%</p>
            <div class="barraestafa barraestafa2"></div>
          </div>
        </div>
      </div>
    </div>

    <!-- Filter: https://css-tricks.com/gooey-effect/ -->
    <svg
      style="visibility: hidden; position: absolute"
      width="0"
      height="0"
      xmlns="http://www.w3.org/2000/svg"
      version="1.1"
    >
      <defs>
        <filter id="goo">
          <feGaussianBlur in="SourceGraphic" stdDeviation="10" result="blur" />
          <feColorMatrix
            in="blur"
            mode="matrix"
            values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 19 -9"
            result="goo"
          />
          <feComposite in="SourceGraphic" in2="goo" operator="atop" />
        </filter>
      </defs>
    </svg>
  </body>
</html>
