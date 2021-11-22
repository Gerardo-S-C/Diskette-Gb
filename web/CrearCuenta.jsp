<%-- 
    Document   : Registrar
    Created on : 8/11/2021, 02:10:17 AM
    Author     : illum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./CSS/crear.css">
    <meta name="google-signin-client_id" content="864494698898-3g3ougdhoh4gojms4nc54afktastj07t.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <title>Registro</title>
</head>
<body>
    
    <div>
        <div class="datos">
            <p class="Titulo">Crear Cuenta</p>
            <form name="registrarUsuario" id="registrarUsuario" action="GuardarUsu" method="POST" >    
                <div class="botones">
                    <div class="datosUsuario">
                        <div class="grupo">
                        <label for="" type="text" class="campos">Nombre: </label>
                        <input type="text" id="name" name="name" class="form-control" aria-describedby="passwordHelpBlock">
                        </div>
                        <br>
                        <br>
                        <div class="grupo">
                        <label for="" class="campos">Correo electrónico: </label>
                        <input type="email" id="email" name="email" class="form-control" aria-describedby="passwordHelpBlock">
                        </div>
                        <br>
                        <br>
                        <div class="grupo">
                        <label for="" class="campos">Contraseña: </label>
                        <input type="password" id="password" name="password" class="form-control" aria-describedby="passwordHelpBlock">
                        </div>
                        <br>
                        <br>
                        <div class="grupo">
                        <label for="" class="campos">Confirmar Contraseña: </label>
                        <input type="password" id="password2" class="form-control" aria-describedby="passwordHelpBlock">
                        </div>
                        <br>
                        <br>
                        <div class="BC">
                            <div class="wrapper">
                                <input type="submit" onclick="validar();" class="button" id="boton" value="Registrar">
                                <!--    <p class="warnings" id="warnings"></p>-->
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
            </form>
        </div>
        <div class="">
            <div class="wrapper g-signin2" data-onsuccess="onSignIn"></div>

            <script>
              function onSignIn(googleUser) {
                // Useful data for your client-side scripts:
                var profile = googleUser.getBasicProfile();
                console.log("ID: " + profile.getId()); // Don't send this directly to your server!
                console.log('Full Name: ' + profile.getName());

                console.log("Image URL: " + profile.getImageUrl());
                console.log("Email: " + profile.getEmail());

                // The ID token you need to pass to your backend:
                var id_token = googleUser.getAuthResponse().id_token;
                //console.log("ID Token: " + id_token);
              }
            </script>
        </div>
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
    </div>
    <script src="./JS/validacion.js"></script>
</body>
</html>