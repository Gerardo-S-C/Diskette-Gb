$(document).ready(() => {
  $inputCardNumber = $('#cn');
  $inputName = $('#name');
  $inputExpiryDate = $('#exp');
  $inputSecurityCode = $('#cvv');
  $buttonPay = $('#button-pay');

  /** Función que valida todos los campos y activa el boton */
  const areAllValidationsPassing = () => {
    if (validateNumCard && validateNameUser && validateDateCard && validateCvv) {
      formStateEvent();
    } else {
      inactiveButtonPay();
    }
  };

  /** Funciones de activación y desactivación de boton */
  const formStateEvent = () => {
    $buttonPay.prop('disabled', false);
  };

  const inactiveButtonPay = () => {
    $buttonPay.prop('disabled', 'disabled');
  };


  /** Eventos*/

  $inputCardNumber
    .on('keyup', function() {
      $typeCard = $('#type-card');
      let cn = $(this).val();

      /* Llamamos a la funcion, para validar el número de tarjeta, 
      agregar una clase de error y success al input y la imagen que
      corresponda segun el numero que escriba */
      validateNumberCard(cn, $(this), $typeCard);
    })
    .on('keyup', areAllValidationsPassing);

  $inputName
    .on('keyup', function() {
      let name = $inputName.val();
      validateName(name, $(this));
    })
    .on('keyup', areAllValidationsPassing);

  $inputExpiryDate
    .on('keyup', function() {
      let exp = $inputExpiryDate.val();
      validateDate(exp, $(this));
    })
    .on('keyup', areAllValidationsPassing);

  $inputSecurityCode
    .on('keyup', function() {
      let cvv = $inputSecurityCode.val();
      validateCode(cvv, $(this));
    })
    .on('keyup', areAllValidationsPassing);
    
  $buttonPay.on('click', function() {
    $('#modalDemo').modal();
    return false;
  });
});