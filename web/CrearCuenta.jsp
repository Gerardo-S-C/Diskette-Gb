<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="google-signin-client_id" content="864494698898-3g3ougdhoh4gojms4nc54afktastj07t.apps.googleusercontent.com" />
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
    <link rel="stylesheet" href="./CSS/crear.css" />
    <title>Registro</title>
</head>
<body>
    
    <main>
        <section class="datos">
            <p class="Titulo">Crear Cuenta</p>
            <div class="botones">
                <form name="" action="./IniciarSesion.html" method="POST" id="form">    
                            <label for="" class="campos">Nombre: </label>
                            <input type="" id="name" class="form-control" aria-describedby="passwordHelpBlock" required>
                        <br>
                        <br>
                            <label for="" class="campos">Correo electrónico: </label>
                            <input type="email" id="email" class="form-control" aria-describedby="passwordHelpBlock" required>
                        <br>
                        <br>
                            <label for="" class="campos">Contraseña: </label>
                            <input type="password" id="password" class="form-control" aria-describedby="passwordHelpBlock" required>
                        <br>
                        <br>
                            <label for="" class="campos">Confirmar Contraseña: </label>
                            <input type="password" id="password" class="form-control" aria-describedby="passwordHelpBlock" required>
                        <br>
                        <br>
                        <div class="BC">
                            <div class="wrapper">
                                <button type="submit" class="button" id="boton" href="./IniciarSesion.html">Confirmar</button>
                            <!--    <p class="warnings" id="warnings"></p>-->
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <div class="BV">
            <div class="wrapper">
                <a class="button2" href="./index.html">Volver</a>
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
    </main>
   
   
    <script src="./JS/validacion.js"></script>
</body>
</html>