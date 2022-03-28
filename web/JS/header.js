// color en el header

var enlaces = document.querySelectorAll('.lists li a');

enlaces.forEach((element) => {
    element.addEventListener('click', (event) => {
        enlaces.forEach((link) => {
            link.classList.remove('activo');
        });

        event.target.classList.add('activo');

    });
});

// ver abajo

var abajo = document.querySelector('#abajo');

abajo.addEventListener('click', () => {
    document.body.scrollTop = 1000;
    document.documentElement.scrollTop = 1000;

});

//ocultar y mostrar header

var menuContent = document.querySelector('.menu');
var prevScrollPos = window.pageYOffset;
var goTop = document.querySelector('.go-top');

window.onscroll = () => {

    let currentScrollPos = window.pageYOffset;

    if (prevScrollPos > currentScrollPos) {
        menuContent.style.top = '0px';
        menuContent.style.transition = '0.5s';
    } else {
        menuContent.style.top = '-60px';
        menuContent.style.transition = '0.5s';
    }
    prevScrollPos = currentScrollPos;

    var arriba = window.pageYOffset;

    //Condiciones
    if (arriba <= 600) {
        menuContent.style.borderBottom = 'none';

        //Ocultar Go Top
        goTop.style.right = '-100px';
    } else {
        menuContent.style.borderBottom = '2px solid #7a0606';

        //Mostrar Go Top
        goTop.style.right = '0px';
    }

}