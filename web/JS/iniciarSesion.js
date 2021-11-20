function validarSesion() {
        alert("iniciando flujo")
        const nombre = document.getElementById("name")
        alert("nombre: " + nombre.value)
        const pass = document.getElementById("password")
        const parrafo = document.getElementById("warnings")
        let warnings = ""
        let entrar = false
        //parrafo.innerHTML = ""
        if (nombre.value.length < 6) {
            warnings += "El nombre no es valido <br>"
            entrar = true
        }

        if (pass.value.length < 8) {
            warnings += "La contraseña no es valida <br>"
            entrar = true
        }
        if (entrar) {
            alert("Error " + warnings)
           
        } else {
            window.open("./MenUsuario.jsp", "self")
        }
    }