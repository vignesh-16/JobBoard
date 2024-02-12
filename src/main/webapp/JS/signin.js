document.addEventListener("DOMContentLoaded", function() {
    
    const signInSection = document.getElementsByClassName("log-in-section")[0];
    const signUpSection = document.getElementsByClassName("sign-up-section")[0];
    const signInButton = document.getElementsByClassName("js-log-in")[0];
    const signUpButton = document.getElementsByClassName("js-sign-up")[0];
    const createNewAccount = document.getElementsByClassName("js-create-account")[0];
   

    signInButton.addEventListener("click", function() {
        let userId = document.getElementsByName("userid")[0].value
        let userPwd = document.getElementsByName("userpass")[0].value
        let data = {
            username: userId,
            password: userPwd
        }
        console.log(` >> credentials received for: ${userId}:${userPwd} and send it as ${JSON.stringify(data)}`)
        const xhr = new XMLHttpRequest();
        xhr.open("POST", "/signin", true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(data));
        xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
                // Request was successful
                console.log(xhr.responseText);
            }
        };
    });

    signUpButton.addEventListener("click", ()=> {
        signInSection.classList.add("disabled");
        signUpSection.classList.remove("disabled");
    })

    createNewAccount.addEventListener("click", ()=> {
        let firstname = document.getElementsByName("fname")[0].value;
        let lastname = document.getElementsByName("lname")[0].value;
        let email = document.getElementsByName("mail")[0].value;
        let accountType = document.getElementsByName("account-type")[0].value;
        let password = document.getElementsByName("password2")[0].value;
        let user = { firstname : firstname, lastname : lastname, email : email, accountType : accountType };
        let credentials = { userLogin : email, password : password, accountType : accountType };
        const ajax = new XMLHttpRequest();
        ajax.open("POST", "/createuser", true);
        ajax.setRequestHeader("Content-Type", "application/json");
        //ajax.send(user = user, credentials = creds);
        ajax.send(JSON.stringify({user : user, credentials : credentials}))
        ajax.onreadystatechange = ()=> {
            if(ajax.readyState === 4 && ajax.status === 200) {
                console.log(` >>>>>>>>> Request success: ${ajax.responseText}`)
            } else {
                console.error(`Request failed: ${ajax.responseText}${ajax.status}!!!`)
            }
        }
        console.log(` >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ${JSON.stringify(user)} and password: ${password}`)
        signInSection.classList.remove("disabled");
        signUpSection.classList.add("disabled");
    })

});
