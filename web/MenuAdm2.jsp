<%-- 
    Document   : MenuAdm2
    Created on : 16/11/2021, 03:56:14 PM
    Author     : illum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./CSS/MenuAdm2.css">
        <script src="https://kit.fontawesome.com/d10bfaa166.js" crossorigin="anonymous"></script>
        <title>Inicio</title>
    </head>
    <body>

        <div class="grid">

            <div class="izq">

                <div class="usuario">

                    <div class="cuadrousu">
                        <img src="./img/Usuario.png" alt="" class="imgusu"> <p>Admin</p>
                    </div>

                </div>

                <div class="act">

                    <div class="bloque1">

                        <div class="Us">
                            <img src="./img/icono usu.png" alt="" class="imgusu2"><a class="usuadm" href="MenuAdm.jsp" >Usuarios</a>
                        </div>

                        <br>
                        <br>
                        <br>

                        <div class="Us">
                            <img src="./img/act.jpg" alt="" class="imgusu2"><a class="usuadm" href="MenuAdm2.jsp" >Actividades</a>
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
                    <div class="usuarios">
                        <div class="accordion">
                            <div class="accordion-item">
                                <button class="accordion-header">
                                    <div class="bloqest"><img src="./img/estafas.png" class="imgest" alt=""></div><strong class="estafasact">Estafas</strong>

                                </button>
                                <div class="accordion-body">
                                    <div class="tituloact">
                                        <strong class="phishing">Phishing</strong>
                                    </div>
                                    <div class="progresosusu">
                                        <button class="btn-material1">Fácil</button><button class="btn-material">Cambiar Dificultad</button>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="progresousu">
                                        <button class="btn-material1">Difícil</button><button class="btn-material">Cambiar Dificultad</button>
                                    </div>
                                    <div class="wrapper" id="iniciar">
                                        <button class="btn-material2">Cambiar de Bloque</button>



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
                                </div>
                            </div>
                        </div>
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