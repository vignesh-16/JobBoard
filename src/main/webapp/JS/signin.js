document.addEventListener("DOMContentLoaded", function() {
    
    const signInSection = document.getElementsByClassName("log-in-section")[0];
    const signUpSection = document.getElementsByClassName("sign-up-section")[0];
    const signInButton = document.getElementsByClassName("js-log-in")[0];
    const signUpButton = document.getElementsByClassName("js-sign-up")[0];
   

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

});
