/* const nombre = document.getElementById("name")
const email = document.getElementById("email")
const pass = document.getElementById("password")
const pass2 = document.getElementById("password2")
const parrafo = document.getElementById("warnings") */
const formulario = document.getElementById("registrarUsuario")
const input = document.querySelectorAll('#registrarUsuario input')

const expresiones = {
	nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	password: /^.{4,12}$/, // 4 a 12 digitos.
	correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
}
const campos = {
	name: false,
	password: false,
	email: false
}
const validarFormulario = (e) =>     {
    switch(e.target.name){
    case "name":
        validarCampo(expresiones.nombre, e.target, 'name');
    break;
    case "email":
        validarCampo(expresiones.correo, e.target, 'email');
    break;
    case "password1":
        validarCampo(expresiones.password, e.target, 'password1');
        validarPassword2();
    break;
    case "password2":
        validarPassword2();
    break;
    }
}

const validarCampo = (expresion, input, campo) =>{
    if(expresion.test(input.value)){
        document.getElementById(`grupo_${campo}`).classList.remove('formulario__grupo-incorrecto');
        document.getElementById(`grupo_${campo}`).classList.add('formulario__grupo-correcto');
        document.querySelector(`#grupo_${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
        campos[campo]=true;
    }else{
        document.getElementById(`grupo_${campo}`).classList.remove('formulario__grupo-correcto');
        document.getElementById(`grupo_${campo}`).classList.add('formulario__grupo-incorrecto');
        document.querySelector(`#grupo_${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
        campos[campo]=false;
    }
}

const validarPassword2 = () => {
	const inputPassword1 = document.getElementsByName('password1')[0];
	const inputPassword2 = document.getElementsByName('password2')[0];
	if(inputPassword1.value !== inputPassword2.value){
        document.getElementById('grupo_password2').classList.remove('formulario__grupo-correcto');
		document.getElementById('grupo_password2').classList.add('formulario__grupo-incorrecto');
		document.querySelector('#grupo_password2 .formulario__input-error').classList.add('formulario__input-error-activo');
		campos['password'] = false;
	} else {
		document.getElementById('grupo_password2').classList.remove('formulario__grupo-incorrecto');
		document.getElementById('grupo_password2').classList.add('formulario__grupo-correcto');
		document.querySelector('#grupo_password2 .formulario__input-error').classList.remove('formulario__input-error-activo');
		campos['password'] = true;
	}
}

input.forEach((input) => {
    input.addEventListener('keyup', (validarFormulario));
    input.addEventListener('blur', validarFormulario);
    
})
formulario.addEventListener('submit', (e) =>{
    e.preventDefault();
    if(campos.email && campos.name && campos.password){
        alert('Resgistro exitoso, inicie sesión para empesar con sus actividades =)');
        formulario.submit();
    }
    else{
        alert('Ingrese todos los datos faltantes');
    }
    
})