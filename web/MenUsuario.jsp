<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page import="Modelo.*"%>
<%@page import="Control.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Serif&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/d10bfaa166.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./CSS/MenUsuario.css">
    <%
    String nombre = (String) session.getAttribute("Usuario");
    
    UsuarioConsulta usuC = accionesUsu.buscarUsuAsigProm(nombre);
    System.out.println(usuC.getPro_dif());
    List<Dificultades> listdif = Administrador.ConsDificultadess();
    String progreso = usuC.getPro_dif();
    %>
    <style>
        .barraestafa2::after{
            --barraavance:<%=progreso+"%"%>;
        }
    </style>
    <title>Inicio</title>
</head>
<body>
    
    
    <div class="grid">

        <div class="izq">

            <div class="usuario">

                <div class="cuadrousu">
                    <img src="./img/Usuario.png" alt=""  class="imgusu"> <p>${Usuario}</p>
                </div>

            </div>

                                                <div class="act">
                
                <div class="bloque1">     
                    
                    <div class="accordion">
                        <div class="accordion-item">
                          <button class="accordion-header">
                            <div class="bloqest"><img src="./img/estafas.png" class="imgest" alt=""></div><strong class="estafasact">Estafas</strong>
                          </button>
                          <div class="accordion-body">
                            <div class="phi"><img src="./img/phishing.png" class="imgphi" alt=""></div><strong class="phishing">Phishing</strong>
                            <a type="button" class="btn-material" href="simulacion_buscar.html">Fácil</a>  
                          </div>
                        </div>
                      </div>

                </div>
            </div>

            <div class="boton" id="divboton">
                    
                <div class="wrapper" id="iniciar">
                    <a class="button" href="logout.jsp">Cerrar Sesión</a>
                </div>

            </div>

        </div>

        <div class="proceso">

            <div class="proest">
                <div class="estaf">
                <p class="estafas">ESTAFAS</p>
                <p class="prosgenest">Proceso General:</p>
                <p class="porcentaje"><%=progreso+"%"%></p>
                <div id="progreso" class="barraestafa barraestafa2"> </div>
                </div>
            </div>

        </div>

    </div>

    <!-- Filter: https://css-tricks.com/gooey-effect/ -->
<svg style="visibility: hidden; position: absolute;" width="0" height="0" xmlns="http://www.w3.org/2000/svg" version="1.1">
    <defs>
        <filter id="goo"><feGaussianBlur in="SourceGraphic" stdDeviation="10" result="blur" />    
            <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 19 -9" result="goo" />
            <feComposite in="SourceGraphic" in2="goo" operator="atop"/>
        </filter>
    </defs>
</svg>
    <script src="./JS/acordeon.js"></script>
</body>
</html>