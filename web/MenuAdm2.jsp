<%-- 
    Document   : MenuAdm2
    Created on : 16/11/2021, 03:56:14 PM
    Author     : illum
--%>
<%@page import="Control.accionesUsu"%>
<%@page import="Modelo.*"%>
<%@page import="java.util.List"%>
<%@page import="Control.Administrador"%>
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
                            <%
                                List<Bloques> listablo = Administrador.ConsBloques();
                                List<Actividades> listaact = Administrador.ConsActividades();
                                List<Dificultades> listdif = Administrador.ConsDificultadess();
                                for(Bloques blo : listablo ){
                            %>
                        <div class="accordion-item">
                          <button class="accordion-header" id="<%=blo.getId_blo()%>">
                            <div class="bloqest"><img src="./img/estafas.png" class="imgest" alt=""></div><strong class="estafasact"><%=blo.getNom_blo()%></strong>
                          </button>
                          <div class="accordion-body">
                            <div class="tituloact">
                                <%
                                    List<Act_Blo> injoin = Administrador.ActividadesXBloque(blo.getId_blo());
                                    for(Act_Blo actblo : injoin ){
                              %>
                                <strong class="phishing"><%=actblo.getNom_act() %></strong>
                            <%
                                }
                            %>
                            </div>
                            <div class="progresosusu">
                                <Strong class="btn-material1">Fácil</strong>

                                <div class="boton-modal3">
                                    <label for="btn-modal3">
                                        Cambiar Dificultad
                                    </label>
                                </div>
                                <input type="checkbox" id="btn-modal3">
                                <div class="container-modal3">
                                    <div class="content-modal3">
                                        <h2>Dificultades</h2>
                                        <form name="ActualizarDif1" method="post" action="ActualizarDif1" id="1">
                                            <%
                                                for(Dificultades dif : listdif){
                                            %>
                                            <input type="submit" class="btn-material1" id="easy" name="<%=dif.getDif_dif()%>" value="<%=dif.getDif_dif()%>">
                                            <%
                                                }
                                            %>
                                        </form>
                                        <div class="btn-cerrar3">
                                            <label for="btn-modal3" id="ok3">Aceptar</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <br>
                            <div class="progresousu">
                                <Strong class="btn-material2">Difícil</Strong>
                                <div class="boton-modal2">
                                    <label for="btn-modal2">
                                        Cambiar Dificultad
                                    </label>
                                </div>
                                <input type="checkbox" id="btn-modal2">
                                <div class="container-modal2">
                                    <div class="content-modal2">
                                        <h2>Dificultades</h2>
                                        <form name="ActualizarDif1" method="post" action="ActualizarDif1" id="1">
                                            <%
                                                for(Dificultades dif : listdif){
                                            %>
                                            <input type="submit" class="btn-material1" id="easy" name="<%=dif.getDif_dif()%>" value="<%=dif.getDif_dif()%>">
                                            <%
                                                }
                                            %>
                                        </form>
                                        <div class="btn-cerrar2">
                                            <label for="btn-modal2" id="ok2">Aceptar</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="boton-modal">
                                <label for="btn-modal">
                                    Cambiar bloque
                                </label>
                            </div>
                            <input type="checkbox" id="btn-modal">
                            <div class="container-modal">
                                <div class="content-modal">
                                    <h2>Bloques Disponibles</h2>
                                    <%
                                        List<Bloques> blobot = Administrador.ConsBloques();
                                        for(Bloques bot : blobot){
                                    %>
                                        <button class="btn-material1" id="bloque1"><%=bot.getNom_blo()%></button>
                                    <%
                                    }
                                    %>
                                    <div class="btn-cerrar">
                                        <label for="btn-modal" id="ok">Ok</label>
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
                          </div>  
                            <br>
                            <%
                                }
                            %>  
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