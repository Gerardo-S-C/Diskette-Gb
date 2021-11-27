/* Imagenes segun el tipo de numero de tarjeta */
const visaImg = 'img/visa.png';
const mastercardImg = 'img/mastercard.png';
const americanImg = 'img/american.png';
const discoverImg = 'img/discover.png';

/* Variables de validación */
const number = /^([0-9])*$/;
const validateVisa = /^4\d{3}-?\d{4}-?\d{4}-?\d{4}$/;
const validateMastercard = /^5[1-5]\d{2}-?\d{4}-?\d{4}-?\d{4}$/;
const validateAmericanExpress = /^3[47][0-9]{13}$/;
const validateDiscover = /^6(?:011|5[0-9]{2})[0-9]{12}$/;

// declaración de variables de validación por cada campo requerido
let validateCvv = false;
let validateDateCard = false;
let validateNameUser = false;
let validateNumCard = false;

/** Función que valida que sólo ingresen números en la tarjeta*/
const onlyNumberCard = (num) => {
  if (number.test(num)) {
    return true;
  }
};

// Función que válida que solo ingresen 16 caracteres en la tarjeta
const maxLengthCard = (num) => {
  if (num.length === 16 || num.length === 15) {
    return true;
  }
};

// Función que valida el tipo de tarjeta 
const validateTypeCard = (num, images) => {
  if (num.match(validateMastercard)) {
    images.attr('src', mastercardImg);
  } else if (num.match(validateVisa)) {
    images.attr('src', visaImg);
  } else if (num.match(validateAmericanExpress)) {
    images.attr('src', americanImg);
  } else if (num.match(validateDiscover)) {
    images.attr('src', discoverImg); 
  } else {
    images.attr('src', '');
  }
};


/* Función que valida el número de tarjeta según Algoritmo de Luhn*/

const validateNumberCard = (num, input, images) => {
  if (maxLengthCard(num) && onlyNumberCard(num)) {
    let sum = 0;
    let arrayCard = num.split('');
    let arrayReverse = arrayCard.reverse();

    arrayReverse.forEach((element, i) => {
      if (i % 2 !== 0) {
        let elementSelection = parseInt(arrayReverse[i]) * 2;
        if (elementSelection >= 10) {
          let elementFinal = parseInt(elementSelection / 10) + elementSelection % 10;
          arrayReverse[i] = elementFinal;
        } else {
          let otherElement = parseInt(arrayReverse[i]) * 2;
          arrayReverse[i] = otherElement;
        }
      }
    });

    arrayReverse.forEach((element, index) => {
      sum += parseInt(arrayReverse[index]);
    });

    if (sum > 0 && sum % 10 === 0) {
      validateNumCard = true;
      input.addClass('success');
      input.removeClass('error');
      validateTypeCard(num, images);
    } else {
      validateNumCard = false;
      input.addClass('error');
      input.removeClass('success');
      images.attr('src', '');
    }
  } else {
    validateNumCard = false;
    input.addClass('error');
    input.removeClass('success');
    images.attr('src', '');
  }
};

/* Función para validar el nombre */
const validateName = (name, input) => {
  /* Usaremos una expresion regular para validar que escriba bien su nombre */
  const PATERNNAME = /^([a-z ñáéíóú]{2,60})$/i;

  if (PATERNNAME.test(name)) {
    validateNameUser = true;
    input.addClass('success');
    input.removeClass('error');
  } else {
    validateNameUser = false;
    input.addClass('error');
    input.removeClass('success');
  }
};

/* Función para validar la fecha de expiración */
const validateDate = (exp, input) => {
  if (number.test(exp) && exp.length === 4) {
    validateDateCard = true;
    /* Extraemos el mes */
    let month = parseInt(exp.substr(0, 2));
    /* Extraemos en año */
    let year = parseInt(exp.substr(2, 2));
    /* Extraemos el valor de la fecha actual */
    let months = ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'];
    let currentDate = new Date();
    let currentMonths = months[currentDate.getUTCMonth()];
    let currentYear = currentDate.getFullYear();
    let stringYear = currentYear.toString();
    let valueYear = stringYear.substr(2, 2);
    let intYear = parseInt(valueYear);
    /* Si las partes de la fecha concuerdan con las que digitamos, es correcta */
    if ((year >= intYear) && (month >= currentMonths)) {
      input.addClass('success');
      input.removeClass('error');
    } else {
      input.addClass('error');
      input.removeClass('success');
    }
  } else {
    validateDateCard = false;
    input.addClass('error');
    input.removeClass('success');
  }
};

/* Función para validar que el codigo de seguridad solo tenga tres digitos */

const validateCode = (cvv, input) => {
  if (number.test(cvv) && (cvv.length === 3 || cvv.length === 4)) {
    validateCvv = true;
    input.addClass('success');
    input.removeClass('error');
  } else {
    validateCvv = false;
    input.addClass('error');
    input.removeClass('success');
  }
};
