/* global Swal, emailjs */

//ojala sirva AAAAAAAAAAAA

function validate(){
    let name = document.querySelector(".from_name")
    let email = document.querySelector(".from_email")
    let reply_to = document.querySelector(".reply_to")
    let subject = document.querySelector(".subject")
    let message = document.querySelector(".message")
    let submit = document.querySelector(".submit");
    
    submit.addEventListener("click", (e)=>{
        e.preventDefault();
        if(name.value == "" || email.value == "" || reply_to.value == "" || subject.value == "" || message.value == ""){
            emptyerror();
            console.log(name.value+" "+email.value+" "+reply_to.value+" "+subject.value+" "+message.value)
        }else{
            sendemail(name.value, email.value, reply_to.value, subject.value, message.value)
            success();
            console.log("email enviado")
            console.log(name.value+" "+email.value+" "+reply_to.value+" "+subject.value+" "+message.value)
        }
    })
}
validate()

function sendemail(name, email, reply_to, subject, message){
    emailjs.send("service_3yyi6gh","template_c1m8gfr",{
        from_name: name,
        from_email: email,
        reply_to: reply_to,
        subject: subject,
        message: message,
    });
}