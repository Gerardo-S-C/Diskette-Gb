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
    <link href="https://fonts.googleapis.com/css2?family=Patua+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=PT+Serif&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Secular+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./CSS/MenUsuarioV2.css">
    <link rel="shortcut icon" href="./img/diskettelogo.jpg">
    <script src="https://kit.fontawesome.com/d10bfaa166.js" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/d18743e159.js" crossorigin="anonymous"></script>
    <%
    String nombre = (String) session.getAttribute("Usuario");
    System.out.println(nombre);
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
    <header id="header">

        <nav class="menu">

            <div class="icono-cabeza">
                <h1><a href="#">DisketteGb</a></h1>
            </div>

            <div class="list-container">
                <ul class="lists">
                    <li><a href="MenUsuario.jsp" class="activo">Inicio</a></li>
                    <li><a href="actividades.jsp">Actividades</a></li>
                    <li><a href="AvisosV2.html">Aviso de Privacidad</a></li>
                    <li><a href="logout.jsp">Cerrar Sesión</a></li>
                </ul>
            </div>

        </nav>

    </header>
    <main>
        <section class="sec" id="menu">
            <div class="contenido">
                <div class="perfil">
                    <div class="foto">
                        <img class="imgfoto" src="./IMG/undraw_personal_info_re_ur1n.svg">
                    </div>
                    <div class="info">
                        <div class="email">
                            <h2>Correo electrónico:</h2>
                            <p>alanmzg69@gmail.com</p>
                        </div>
                        <br>
                        <br>
                        <div class="password">
                            <h2>Contraseña:</h2>
                            <div class="inputpass">
                                <input type="password" id="password" placeholder="Password">
                                <span>
                                    <i class="fa fa-eye" aria-hidden="true" id="eye" onclick="toggle()"></i>
                                </span>
                            </div>
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class="phone">
                            <h2>Número de teléfono:</h2>
                            <p>5578952487</p>
                        </div>
                    </div>
                </div>
                <div class="bnpr">
                    <div class="bienvenida">
                        <h2>¡Bienvenido, ${Usuario}!</h2>
                        <br>
                        <p>En DisketteGb podrás iniciar tu camino hacia el internet. Aprenderás a evitar grandes problemas que afectan a miles de usuarios todos los días y así tener una gran experiencia en este mundo. 
                            "Los límites solo se encuentran en tu propia mente" y "Todo es muy difícil antes de ser fácil". ¡Ánimo! </p>
                    </div>
                    <div class="progresos">
                        <h2>Progresos</h2>
                        <br>
                        <p>Aquí podrás visualizar los avances que llevas en cada actividad, recuerda que para continuar o empezar alguna debes ir al apartado de Actividades localizado en la parte superior de tu pantalla.</p>
                        <br>
                        <div class="act">
                            <div class="cuadros">
                                <p>Phishing</p> <div class="barraestafa barraestafa2"> </div>
                            </div>
                            <div class="cuadros">
                                <p>Spam</p> <div class="barraestafa barraestafa2"> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <script src="./JS/header.js"></script>
    <script>
        var state = false;
        function toggle(){
            if(state){
                document.getElementById("password").setAttribute("type","password");
                document.getElementById("eye").style.color= '#7a797e';
                state = false;
            }else{
                document.getElementById("password").setAttribute("type","text");
                document.getElementById("eye").style.color= '#5887ef';
                state = true;
            }
        }
    </script>
</body>
</html>