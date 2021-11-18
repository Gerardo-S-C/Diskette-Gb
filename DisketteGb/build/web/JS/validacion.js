const nombre = document.getElementById("name")
const email = document.getElementById("email")
const pass = document.getElementById("password")
const pass2 = document.getElementById("password2")
const parrafo = document.getElementById("warnings")
const formulario = document.getElementById("form")

 
    formulario.addEventListener("submit",(e) => {
        e.preventDefault()
        alert("Dentro del formulario")
    let warnings = ""
    let entrar = false
    let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/
    parrafo.innerHTML = ""
    if (nombre.value.length < 6) {
        warnings += "El nombre no es valido <br>"
        entrar = true
    }

    if (!regexEmail.test(email.value)) {
        warnings += `El email no es valido <br>`
        entrar = true
    }

    if (pass.value.length < 8) {
        warnings += "La contraseña no es valida <br>"
        entrar = true
    }

    if (pass.value != pass2.value) {
        warnings += "La contraseña no coincide"
        entrar = true
    }

    if (entrar) {
        alert("Error " + warnings)
       parrafo.innerHTML = warnings     
    } else {
        alert("Todo bien")
        formulario.submit()
       // window.open("./IniciarSesion.html", "self")
    }
})
   