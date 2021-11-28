/* const nombre = document.getElementById("name")
const email = document.getElementById("email")
const pass = document.getElementById("password")
const pass2 = document.getElementById("password2")
const parrafo = document.getElementById("warnings") */
const formulario = document.getElementById("form")
const input = document.querySelectorAll('#form input')

const expresiones = {
	password: /^.{4,12}$/, // 4 a 12 digitos.
	correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
}
const campos = {
	password: false,
	email: false
}
const validarFormulario = (e) =>     {
    switch(e.target.name){
    case "email":
        validarCampo(expresiones.correo, e.target, 'email');
    break;
    case "password":
        validarCampo(expresiones.password, e.target, 'password');
    break;
    }
}

const validarCampo = (expresion, input, campo) =>{

    if(expresion.test(input.value)){
        document.getElementById(`grupo_${campo}`).classList.remove('formulario__grupo-incorrecto');
        document.getElementById(`grupo_${campo}`).classList.add('formulario__grupo-correcto');

        campos[campo]=true;
    }else{
        document.getElementById(`grupo_${campo}`).classList.remove('formulario__grupo-correcto');
        document.getElementById(`grupo_${campo}`).classList.add('formulario__grupo-incorrecto');

        campos[campo]=false;
    }
}

input.forEach((input) => {
    input.addEventListener('keyup', (validarFormulario));
    input.addEventListener('blur', validarFormulario);
    
})
formulario.addEventListener('submit', (e) =>{
    e.preventDefault();
    if(campos.email && campos.password){
        formulario.submit();
    }
    else{
        alert('Ingrese todos los datos faltantes o inicia una nueva cuenta');
    }
    
})