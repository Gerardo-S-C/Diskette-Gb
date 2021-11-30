<%@page import="Modelo.UsuarioConsulta"%>
<%@page import="Control.accionesUsu"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="CSS/primera1.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
         <link rel="stylesheet" href="CSS/basura.css">
        <title>Como hacer una transacción bancaria?</title>
<%
    String nombre = (String) session.getAttribute("Usuario");
%>
    </head>
    <body>
        <div class="form-group">
            <!--Para el Tache de las simulaciones-->
            <form name="X" method="post" id="progress" action="AumentarProgresoEZ" class="justify-content-md-center">
                <div class="d-grid gap-2 d-md-flex justify-content-between">
                    <label> <h1>TUTORIALES PROS || PORQUE SABEMOS QUE NOS NECESITA :]</h1> </label>
                    <button type="submit" class="btn "><img src="./img/tache.png" height="80px" width="80px" class="tache"></button>
                </div>
            </form>         
            <form action="">
                <table>
                    <thead>
                    <th>Ingrese sus datos por favor :]</th>
                    </thead>
                    <tr>
                        <td><label for="name"class="col-form-label">Nombre</label></td>
                        <td><input type="text" placeholder="Escribe tu nombre"  name="name" maxlength="30" id="name"></td>
                    <tr>
                        <td><label for="teléfono">Teléfeno</label></td>
                        <td><input type="text" placeholder="Escribe tu teléfono" maxlength="10" name="teléfono" id="teléfono">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="número">Número de tarjeta</label></td>
                        <td><input type="text" name="cn" class="inline" id="cn" placeholder="Escribe tu número" maxlength="16"></td>
                    </tr>
                    <tr>
                        <td><label for="nombre">Fecha de caducidad</label></td>
                        <td><input type="text"  placeholder="MM/YY" pattern="[0-9]{4}" name="exp" id="exp">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="cvv">Número cvv</label></td>
                        <td><input type="text" placeholder="Escribe el número CVV" maxlength="3" name="cvv" id="cvv"></td>
                    </tr>
                    <tr>
                        <td><input id="button-pay" type="submit" class="btn btn-info btn-block" disabled value="Enviar" onclick="enviarPagina();"/></td>
                        <td>
                                        <div class="col-3 container-type-card">
                                            <img id="type-card" class="type-card" src="" alt="" height="100px" >
            </div>
                        <script>
                            function enviarPagina(){
                                location.href="./inicio2.html"
                            }
                        </script>
            <div class="col-3 container-type-card">
                <button  class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap"><img class="imgtar" src="img/tar.png" width="200" height="100"></button>
            </div>
                        <p>NOTA DEL SISTEMA: Esta tarjeta son los datos <br> falsos para poder seguir con la simuación.</p>
                        <p>EN NINGÚN MOMENTO INGRESE <br>SUS DATOS REALES.</p>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <br><br><br><br><br><br><br><br>
                        <div class="abajo"> anuncios</div>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                  
                <div class="modal-body">
                  
                  <div class="contenedor">
          
                      <section class="tarjeta" id="tarjeta">
                          <div class="delantera">
                              <div class="logo-marca" id="logo-marca">
                              </div>
                              <img src="img/chip-tarjeta.png" class="chip" alt="">
                              <div class="datos">
                                  <div class="grupo" id="numero">
                                      <p class="label">Número Tarjeta</p>
                                      <p class="numero">372 7515 3453 6212</p>
                                  </div>
                                  <div class="flexbox">
                                      <div class="grupo" id="nombre">
                                          <p class="label">Nombre Tarjeta</p>
                                          <p class="nombre">Pedro Josefino</p>
                                      </div>
              
                                      <div class="grupo" id="expiracion">
                                          <p class="label">Expiración</p>
                                          <p class="expiracion"><span class="mes">03</span> / <span class="year">24</span></p>
                                      </div>
                                  </div>
                              </div>
                          </div>
              
                          <div class="trasera">
                              <div class="barra-magnetica"></div>
                              <div class="datos">
                                  <div class="grupo" id="firma">
                                      <p class="label">Firma</p>
                                      <div class="firma"><p>PedroJosefo</p></div>
                                  </div>
                                  <div class="grupo" id="ccv">
                                      <p class="label">CCV</p>
                                      <p class="ccv">8500</p>
                                  </div>
                              </div>
                              <p class="leyenda">Teléfono: 55 8794 0235</p>
                              <p class="leyenda">Para cualquier duda llame a su banco de preferencia o consulte la pagina web otra vez</p>
                              <a href="#" class="link-banco">www.trucoteca.com</a>
                          </div>
                      </section>
              
              
                  <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
                  <script src="JS/tarjeta.js"></script>
                  <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
                  <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
                  <script src="JS/index.js"></script>
                  <script src="JS/app.js"></script>
          
                </div>
                <div class="modal-footer">
                </div>
              </div>
            </div>
          </div>
        <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
        <script src="JS/tarjeta.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="JS/index.js"></script>
        <script src="JS/app.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>     

        <script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-1116393974429402"
        crossorigin="anonymous"></script>
        <!-- Bloque vertical -->
        <ins class="adsbygoogle" style="display:block" data-ad-client="ca-pub-1116393974429402" data-ad-slot="9376117010"
             data-ad-format="auto" data-full-width-responsive="true"></ins>
        <script>
            (adsbygoogle = window.adsbygoogle || []).push({});
        </script>
    </body>

</html>
