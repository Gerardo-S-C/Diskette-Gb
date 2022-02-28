<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Patua+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=PT+Serif&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Secular+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./CSS/ActividadesV2.css">
    <link rel="shortcut icon" href="./img/diskettelogo.jpg">
    <title>Actividades</title>
</head>
<body>
    <header id="header">
        <nav class="menu">
            <div class="icono-cabeza">
                <h1><a href="#">DisketteGb</a></h1>
            </div>
            <div class="list-container">
                <ul class="lists">
                    <li><a href="MenUsuarioV2.html">Inicio</a></li>
                    <li><a href="actividadesV2.html" class="activo">Actividades</a></li>
                    <li><a href="AvisosV2.html">Aviso de Privacidad</a></li>
                    <li><a href="index.html">Cerrar Sesión</a></li>
                </ul>
            </div>
        </nav>
    </header>
    <main>
        <section class="sec" id="menu">
            <div class="contenido">
                <div class="estafas">
                    <div class="titulo">
                        <h2>ESTAFAS</h2>
                    </div>
                    <div class="acts">
                        <div class="phishing">
                            <div class="img">
                                <img src="./IMG/phishing.png" class="imgp">
                            </div>
                            <div class="descripcion">
                                <h2>Pishing</h2>
                                <br>
                                <p>bla bla bla</p>
                                <div class="botones">
                                    <p>Iniciar</p>
                                    <a type="button" class="btn-material" href="simulacion_navegador.html">Fácil</a>
                                    <a type="button" class="btn-material" href="">Difícil</a>
                                </div>
                            </div>
                        </div>
                        <div class="spam">
                            <div class="img">
                                <img src="./IMG/spam.png" class="imgs">
                            </div>
                            <div class="descripcion">
                                <h2>Spam</h2>
                                <br>
                                <p>bla bla bla</p>
                                <div class="botones">
                                    <p>Iniciar</p>
                                    <a type="button" class="btn-material" href="">Fácil</a>
                                    <a type="button" class="btn-material" href="">Difícil</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="virus">
                    <div class="titulo">
                        <h2>VIRUS</h2>
                    </div>
                    <div class="acts">
                        <h2>PRÓXIMAMENTE</h2>
                        <div class="ejecutables"></div>
                        <div class="links"></div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</body>
</html>