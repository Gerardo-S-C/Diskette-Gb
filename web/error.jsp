<%-- 
    Document   : error
    Created on : 16/11/2021, 08:02:46 PM
    Author     : illum
--%>

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
    <link rel="stylesheet" href="./CSS/404.css">
    <title>Error</title>
</head>
<body>
    <div class="cuadro">

        <p class="texto">Lo sentimos, algo salió mal...</p>

        <img class="img" src="./img/undraw_loading_re_5axr.svg" alt="">

    </div>
    <div class="BV">
        <div class="wrapper">
            <a class="button2" href="javascript: history.go(-1)">Volver</a>
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
</body>
</html>
