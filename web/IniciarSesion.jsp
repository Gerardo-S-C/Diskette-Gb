<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="./CSS/iniciar.css" />
    <meta
      name="google-signin-client_id"
      content="864494698898-3g3ougdhoh4gojms4nc54afktastj07t.apps.googleusercontent.com"
    />
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <title>Iniciar Sesión</title>
  </head>

  <body>
    <div>
      <div class="datos">
        <p class="Titulo">Iniciar Sesión</p>
        <div class="botones">
          <form
            name="InicioSesion"
            method="post"
            id="form"
            action="IniciarSesion"
          >
            <div class="aa">
                <div class="grupo" name="grupo_email">
                <label for="" class="campos">Correo: </label>
              <input
                type="email"
                id="grupo_email"
                name="email"
                class="form-control formulario__input"
                aria-describedby="passwordHelpBlock"
              />
              <p class="formulario__input-error">El correo solo puede contener letras, numeros, puntos, guiones y guion bajo.</p>
                </div>
                <div class="grupo" name="grupo_password">
              <label for="" class="campos">Password: </label>
              <input
                type="password"
                id="grupo_password"
                name="password"
                class="form-control formulario__input"
                aria-describedby="passwordHelpBlock"
                min="4"
                max="12"
              />
              <p class="formulario__input-error">La contraseña tiene que ser de 4 a 12 dígitos.</p>
                </div>
              <div class="BC">
                <div class="wrapper">
                  <input
                    type="submit"
                    id="boton"
                    class="button"
                    value="Confirmar"
                  >
                  <p class="warnings" id="warnings"></p>
                </div>
                <div class="">
                  <div
                    class="wrapper g-signin2"
                    data-onsuccess="onSignIn"
                  ></div>
                <a href="index.html" onclick="signOut();" class="button warnings"
                  >Salir de la sesión de google</a
                >
                  <script>
                    function onSignIn(googleUser) {
                      // Useful data for your client-side scripts:
                      var profile = googleUser.getBasicProfile();
                      //            console.log("ID: " + profile.getId()); // Don't send this directly to your server!
                      console.log("Email: " + profile.getEmail());

                      document.InicioSesion.correo.value = profile.getEmail();

                      // The ID token you need to pass to your backend:
                      var id_token = googleUser.getAuthResponse().id_token;
                      //console.log("ID Token: " + id_token);
                    }
                  </script>
                </div>

                <script>
                  function signOut() {
                    var auth2 = gapi.auth2.getAuthInstance();
                    auth2.signOut().then(function () {
                      console.log("User signed out.");
                    });
                  }
                </script>
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
                      <feGaussianBlur
                        in="SourceGraphic"
                        stdDeviation="10"
                        result="blur"
                      />
                      <feColorMatrix
                        in="blur"
                        mode="matrix"
                        values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 19 -9"
                        result="goo"
                      />
                      <feComposite
                        in="SourceGraphic"
                        in2="goo"
                        operator="atop"
                      />
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
        <svg
          style="visibility: hidden; position: absolute"
          width="0"
          height="0"
          xmlns="http://www.w3.org/2000/svg"
          version="1.1"
        >
          <defs>
            <filter id="goo">
              <feGaussianBlur
                in="SourceGraphic"
                stdDeviation="10"
                result="blur"
              />
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
      </div>
    </div>
    <script src="./JS/validaciones.js"></script>
  </body>
</html>
