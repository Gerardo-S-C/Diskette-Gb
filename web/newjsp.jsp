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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Patua+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=PT+Serif&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Secular+One&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./CSS/MenuAdm2V2.css?1.0">
    <link rel="shortcut icon" href="./img/diskettelogo.jpg">
    <title>Actividades</title>
</head>
<body>
    <header id="header">
        <nav class="menu">
            <div class="icono-cabeza">
                <h1><a href="MenuAdm.jsp">DisketteGb</a></h1>
            </div>
            <div class="list-container">
                <ul class="lists">
                    <li><a href="MenuAdm.jsp">Usuarios</a></li>
                    <li><a href="MenuAdm2.jsp" class="activo">Actividades</a></li>
                    <li><a href="logout.jsp">Cerrar Sesión</a></li>
                </ul>
            </div>
        </nav>
    </header>
    <main>
        <section class="sec" id="menu">
            <div class="contenido">
                <%
                    List<Bloques> listablo = Administrador.ConsBloques();
                    List<Actividades> listaact = Administrador.ConsActividades();
                    List<Dificultades> listdif = Administrador.ConsDificultadess();
                    List<Act_Blo> listcons = Administrador.Consulta();
                    //Recorrera los bloques que hay (Estafas y Virus) para asignarlos a los acordeones
                    // blo -> es la variable que recorrera los valores
                    // listablo -> es la lista con los valores de los bloques
                    for(Bloques blo : listablo){
                        System.out.println("bloque "+blo.getNom_blo());
                        List<Act_Blo> injoin = Administrador.ActividadesXBloque(blo.getId_blo());  
                        for(Act_Blo actblo : injoin ){
                            System.out.println("actividad "+actblo.getNom_act());
                            List<Dificultades> dif = Administrador.ConsDificultadess();
                            for(Dificultades d : dif){
                                System.out.println("dificultad "+d.getDif_dif());
                                for(Act_Blo c : listcons){
                                   System.out.println(c.getId_act_blo());
                                   continue;
                                }break;
                            }break;
                        }break;
                    }                  
                    for(Bloques blo : listablo ){
                        System.out.println(blo.getNom_blo());
                %>
                <div class="<%=blo.getNom_blo()%>">
                    <div class="titulo">
                        <h2><%=blo.getNom_blo()%></h2>
                    </div>
                    <div class="acts">
                        <%
                        List<Act_Blo> injoin = Administrador.ActividadesXBloque(blo.getId_blo()); 
                        for(Act_Blo actblo : injoin ){
                            System.out.println(actblo.getNom_act());
                        %>
                        <div class="<%=actblo.getNom_act()%>">
                            <div class="img">
                                <img src="./img/<%=actblo.getNom_act()%>.png" class="img<%=actblo.getNom_act()%>">
                            </div>
                            <div class="descripcion">
                                <h2><%=actblo.getNom_act()%></h2>
                                <div class="botones">
                                    <div class="dificultades">
                                    <%
                                        List<Dificultades> dif = Administrador.ConsDificultadess();
                                        for(Dificultades d : dif){                    
                                            System.out.println(d.getId_dif()+" "+d.getDif_dif());
                                            int cons = 0;
                                        %>
                                        <div class="dropdown">
                                            <div class="tipodif">
                                                <p><%=d.getDif_dif()%></p>
                                            </div>                                            
                                            <button class="btn btn-outline-dark dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                            Cambiar dificultad
                                            </button>
                                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                                <form name="ActualizarDif1" method="post" id="form" action="ActualizarDif1">
                                                <%
                                                    
                                                %>
                                                    <input type="hidden" name="facil" value="facil" class="dropdown-item" readonly>
                                                    <input type="hidden" name="id" value="<%=d.getId_dif()%>" class="dropdown-item" readonly>
                                                    <input type="hidden" name="actividad" value="<%=actblo.getNom_act()%>" class="dropdown-item" readonly>
                                                    <input type="hidden" name="bloque" value="<%=blo.getNom_blo()%>" class="dropdown-item" readonly>
                                                    <input type="submit" id="boton" class="dropdown-item" value="Fácil">
                                                </form>
                                                <form name="ActualizarDif1" method="post" id="form" action="ActualizarDif1">
                                                    <input type="hidden" name="dificil" value="dificil" class="dropdown-item" readonly>
                                                    <input type="hidden" name="id" value="<%=d.getId_dif()%>" class="dropdown-item" readonly>
                                                    <input type="hidden" name="actividad" value="<%=actblo.getNom_act()%>" class="dropdown-item" readonly>
                                                    <input type="hidden" name="bloque" value="<%=blo.getNom_blo()%>" class="dropdown-item" readonly>
                                                    <input type="submit" id="boton" class="dropdown-item" value="Difícil">
                                                </form>
                                            </ul>
                                        </div>
                                        <br>                                       
                                        <%                                         
                                        }                                        
                                        %>
                                    </div>
                                    <div class="dropdown">
                                        <button class="btn btn-outline-dark dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                          Cambiar de bloque
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                          <li><a class="dropdown-item" href="#">Estafas</a></li>
                                          <li><a class="dropdown-item" href="#">Virus</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </section>
    </main>
    <footer>
        <div class="container-footer-all">
              
          <div class="container-body">
      
              <div class="colum1">
                  <h1>Mas informacion sobre Bellakrisis</h1>
      
                  <p>Nuestro sistema cuenta con actividades relacionadas a los diferentes riesgos que pueda enfrentarse el usuario al momento de navegar en la web, cada una de estas dispondrá con la situación que le corresponda a fin de hacerlo cada vez más complicado de detectar para asegurar el aprendizaje del usuario. 
      
                    El progreso que realice en los bloques se guardará y mostrará con el fin de incitarlo a concluir la actividad de manera satisfactoria, similar al sentimiento de concluir algo al 100% e invitarlo indirectamente a concluir el resto de los bloques. </p>
      
              </div>
      
              <div class="colum2">
      
                  <h1>Redes Sociales</h1>
      
                  <div class="row">
                      <img src="https://articles-images.sftcdn.net/wp-content/uploads/sites/2/2011/08/privacidad-facebook.jpg">
                      <label>Siguenos en Facebook</label>
                  </div>
                  <div class="row">
                      <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPkAAADKCAMAAABQfxahAAAAZlBMVEUdq93///8AptsApdsAqNz2/P7u+PzB5fT7/v/y+v3o9vvj8/pgv+Xc8fnJ6PW94/NSuuONz+ul2e8wsd+Z1O1qw+a24PJ8yenV7fg/teHH5/V2x+iS0eyh1u6CzOpLuOKv3PFWv+UhOSBSAAALFElEQVR4nN2d2YKiOhCGISkVBQUFBNoF5/1fcsCtw5J9Afq/mTk9fZDPbFWVqsTzZ69tGN/uUZ16jdIqyY+nTbjSf6yn/wibWsX32kPQyPuo+TtCaXI9aD56zuThqcboF7mjBh9H57XG0+dLfk4AjVN/6ZGXK7R88PpjpuTrK9BauwuP05PcmN8k77/MknxbeJzmJoTSTPzJ+wR/fnuG5MFVqLmJhvceYk8Ocwz4MzfMjzxO5bif7V6X/AeHebNCQPT5z7mRryMszd0K3wP2g8umvdvv6DslDsk3xmkkFHvyDf5u9nTPeO4meY+g6vujAfkG65oIGirUGvzNfqM8dZeln5kDx9+fDsgr8EJbYBxta9UGf6Nfxp66iQi7IP39eZ88br71dGsRj669ck//ole9tT04NOsj8VREDOU+edX8O9TWKUd00MRuBenu94HB5pJC58uEhPi8Hvnh2TFQ5DvXQdx2YaG/h2qwv0VDKxCT47hHnr9+GQp3yC/96Pb0r8KgvEUeGrGG0JH8xC75+jO34s4v2VdppMVfgjHqVmlnye+SZ98XQBLGsL5Cc9x0oa6d1yWvfn8P01ZHC1opGKzy4L227JDvyRdAJ2fkkQNwyHsf2iG/dUYbdoV+NTjIqeBp367vkCfd795Rq5tZz3ja9T+WJA/6r+BkrK9SB9xo6MWS5MMvH13tk19cDPKhFxaQ5Ldht8N32+AmV3Ka0AA8uJ1I8nzk20f9KdG0quFnGle/q++LZsLzeC+BEk6wQ09n600OXjdksTvVCPCeHOdryv+ZDqZFcwpsczeOJ+lzrx8JQq9ViyAPadsZg95iTifb0xsmfK8yS17bVM8wJEFOn2vw2RJ4YHlFA+/95kH4yAn/LeiSn+nfP7Lkulke5Shqg+vrQ5aniNyTfA58gvzEeA2UWIlQWZ7Ys/JxTDzc81rfPZggz1hjDphBXUVZX8sRggHUp/8S5Ff2bGPBir87MN8GGB8DhSA/ct4D5aZXdjesHcF3q0GC3PjydtDZV1ATpN+4tHhvb2XWg5mis/9aZaIz3FuoMjjRuXBPeyLCzoKr2lcAxiY6ms1oT0A2m5glQ8pYs9t3VvrqTFNC1mtXAGYsOtfDHKhRZ/HeB+mPAfLEJubwnXvOKkm+lXgOyrVdV/sOKqnh3jg3MkF7Eso07Zq1y9UcqkHSIC8aRRdK9XxXN8Hml+DfsJlIcqFljRCudIa74FJiQqNxVJJc3nWCRN2elf2e1TVugnT2WOTfBXCkys51EwwJvPGUpw65ys4eqLZ74YYcEkpCdIdcrQMCTlRy6OTmU1XR42gdclVLGkA249gVOdCdS2rmgOxHeEfJNDo35PTUjy65znzbDPhYxrhxQ053MXoZQlorDSDvKO7HOZnhgL4jOp4Vpv5JqLoJWvROVjVGels/E1D/dRBKTiJD3oklA6OpsGPkfm3i4xCqsj1vzDuxXiXIN4Y8KMBpETOLqpx4LBLkvmamNfmpANVxQ92V2rnwUmXIzTYFIKiL8+iE7yQyIT7D+RbWWWjwq/ujXPfMvMTBQBdf1RrtrIy/Ng03TS5ZXIafqc/FsiZsyTx1s/ZG8JJX/bscbw8Xpoyw9fpSZf2VWn7Jcjw1MTaAx8h3E+x3WRKiVy+OVuo9nO9+2BLQo6TjNYqO4iX2hegxUkp1pjl7ZlqNZPpyyJ1UGTgQphvQtIpcJ5Ul9oXofhO1Fnk/9UubkRB51PWq/wR65VNFkCOcd1yLcPljHRjFlgR5a1xHZOR8bd+YsyxWrSVB3ibstEFEYiHIF27SMMx2kvwdbAeU3n8+E0O2bHQUj0L3yX931RqXsm4c6l3Dv3dRbWFNiBEEJ8i7JmvjTHlp405epnprI2JEwDmZgDDMFV6U6OAK+XALUueMAQb5ftmz2YgYUbgOOaV2acFixCW6druJ/ZVZCbOyOUjyKbKurQpY6QwkefzXBjrDX+mSr9zXGFgVY2upR+5k18Oh2DVHBnKjZitGEK5P7r7KwK6Y+Vpd++5PdXemBdcnd19gYVEs53xAPkXtnDUNz1hgkbs42sWZ2GmZPfI/ZLuzoo8j5H/IguWd+dUn3/4dck7y+SBqIVKjuQyxwYfkto9+cCW20T5GbiwXcGKxAs4UckfFBtbFKzUYIf8TKxtvTRvfRf75A/2dkSDDIPfvy7fkgHuFw/jcv3ifjeOn0ckXnybDjDezyJefJsMvIqNZOuWiG31wxKkE+bLRQaBImm7dLhqdD866oUL/JPmpJHQECOvb2S01QwiJVI0x+0WwzAwhgcWcR26zvsGi+JarALlfLrHHi4AL3MFzdFJ2YVCCh+4LfD/7ZFm+G99ZESX3/c2SzHhuGEqG3PfPFV4KPCv7T4Hc9w/JMlLjxJY0GfLGf7umC2h44Quz5O5X22eVxD1/U0i4yeVvllsd/k1NxxISPtqGRR6cwxVZBxKsdpssmvdOBDMdSpjcTzCkSV7cj8fjvcijysMjpwXPSlj89DImeZsDDL+aGosv8VHOIV9NTSIrmZsQ2TPcwnbTZZqcQ76wxG/elrkEuZO7oIxJ1GIXIndxT4wxMcpv5cmX1OiMs+BUyBc00lO5w/m41utijh/AvCQJWfKlJEtJrWhC5EvJhQXZO40FfLVFTHKS05sYucwZ35Mp5XPIky8hT4yT16xKPv8MaKRw9Z9YTGb2Q10eXJA8mPfJOlKeihy5v53zXoPajRmi/WQ9X3QQj72pkPu72WZQSNswkuSzPWNF9apDiVlxNcvMSJEEMF1y37/Pz6SBSvVyFLmV8DG70LPiIJcm98NqXuYcUr8TRtr6yeaUPKJzm6m83Tej5BF+4YJRct+P03l0eaikr8XQJPf90zzYte77UiNvE2cmH+8jF9m7IPf9snBzQDFNutdUq5M3vusmTyejRzc9cC3yFr685c8rl12bOFj7LkdN8qfWh8cxT6rKYR4J64BHh+Rvhe6OD1R2UwiZI3d4GA3SsWA+MkW+clgEYATcFPnBYcTGDLgh8sLlPZhmwI2Q/7gM0ZmY3J7SJ99eXNrwWCoXhiVt8pNTI07HIe9Jk/zgNkaDdU1WQlrkpeMgBUgmhDClQR7mbo11APULeUekTL6PHBc4jFxnrSVF8jJy7Z2iSCf0ZIh8dXZf0IKk82DMk4dH96UsACr3DxslXz/qCeqXUKUVa9QnX52jSbaSsX4YQoc8PDWT+RTc4Jnv6cLk27iYLNSIEgs9XYR8XZ6KFE8WXgZgnlCsRU7dfl7t41teeZMG1VGtvEnMJz/8y+/Z6bw5lPtGZfkTP7Jj0dam4akLtSw2eEvur4o2Xo6+au92nEWCAIosjfAPebsvPIv9wa5QatIxo5D7fjy3CmOAo2r+ixy5H2Sz6OBvAcqtdnSSvFm+7pNvC38EtVFHnEfeWGmXWRwpgCo7NhuDvJnq8snbHVLNbXE18ob9Mm02gDPuEet1d59qngdw1M8p5M1cl03BDjjSy3sxQN7oXDvu9Mi721/HRMjd5v8Ars+Gw4sConupwTkBB72+vbBS8Lwjs2L652FmOcja9Kv8x7aZShG3CvtaIUst3/SoPJ4I2xc7Hy6rjUfgAGGv2Gzt89ElFoFcn/MUGZvxmsZObpOMbVLCsddgf4pAOyAHCOH6ejC7Q6YmybPCHpfKU2z8Btqr8pMLN0xI8rtLbTS2Qs+MT0FkaEY1qorTwbWxwpTqLnJ4eNyjOm07ABo5U6r9EWqBvbTOj495Mb+kly2yWodl/Lhdizz65r2mVZVEeXG8nc6H/Xo73bLF0X/v8phrtgVdeQAAAABJRU5ErkJggg==">
                      <label>Siguenos en Twitter</label>
                  </div>
                  <div class="row">
                      <img src="data:image/jpeg;base64,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">
                      <label>Siguenos en Instagram</label>
                  </div>
      
      
              </div>
      
              <div class="colum3">
      
                  <h1>Informacion Contactos</h1>
      
                  <div class="row2">
                      <img src="https://cdn-icons-png.flaticon.com/512/48/48821.png">
                      <label>Nte 80-A 6208, Gertrudis Sánchez II Sección, Ciudad de México, CDMX </label>
                  </div>
      
                  <div class="row2">
                      <img src="https://icones.pro/wp-content/uploads/2021/04/icone-de-telephone-portable-noir.png">
                      <label>5573429195</label>
                  </div>
      
                  <div class="row2">
                      <img src="https://cdn-icons-png.flaticon.com/512/39/39547.png">
                       <label>BellaKrisis@gmail.com.</label>
                  </div>
      
              </div>
      
          </div>
      
        </div>
      
          <div class="container-footer">
             <div class="footer">
                  <div class="copyright">
                      © 2022 Todos los Derechos Reservados | <a href="">Bellakrisis</a>
                  </div>
              </div>
      
          </div>
      </footer>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
      </body>
</html>