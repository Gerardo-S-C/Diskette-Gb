/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const cl = console.log;
(function() {
  card = {
    // Funcion que valida la longitud del input ingresado por el usuario
    validNumber(input) {
      let regex = /^\d*$/;
      if (!input.search(regex))
        return input;
      else return false;
    },
    validName(input) {
      let regex = /^[a-zA-Z\s]*$/;
      if (regex.test(cadena))
        return cadena;
      else return false;
    },
    validCvv(input) {
      let regex = /^\d{3}$/;
      if (regex.test(input)) return input
      // cvv.setAttribute('disabled', true);       
      else cl('errorCvv')
    },
    validMonth(input) {
      let regex = /^\d{2}$/;
      if (regex.test(input))
        return input;
      else return false;
    },
    validYear(input) {
      let regex = /^\d{2}$/;
      if (regex.test(input))
        return input;
      else return false;
    },
    validCard(numberCard) {
      if (numberCard) {
        let sumaTotal = 0;
        let revserNum = [...numberCard].reverse(); // obteniendo array inverso  
        for (let index = 1; index < revserNum.length; index = index + 2) {
          revserNum[index] = revserNum[index] * 2;
          if (revserNum[index] >= 10) {
            revserNum[index] = revserNum[index] - 9;
          }
        }
        for (let value of revserNum) {
          sumaTotal = sumaTotal + parseInt(value);
        }
        if (sumaTotal % 10 === 0) {
          return true;
          console.log('Es una tarjeta valida');
        }
      } else return cl('la tarjet es invalida');
    }
  };
})();

