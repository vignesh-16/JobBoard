$(window).on('beforeunload', function() {
    $.ajax({
        url: '/TerminateSession',
        type: 'POST',
        async: false, // Synchronous request to ensure it's completed before the page is unloaded
        success: function() {
            console.log('Session invalidated successfully');
        },
        error: function() {
            console.error('Error invalidating session');
        }
    });
});

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
        let newUser = { id: "", firstname : firstname, lastname : lastname, email : email, accountType : accountType };
        let userCreds = { id: "", userId: "", userLogin : email, password : password, accountType : accountType };
        let instance = Date.now();

        const options = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newUser)
        }

        fetch('/CreateUser', options)
        .then(response => {
            console.info(` >> Request response: ${JSON.stringify(response)}`)
            if(response.ok) {
                
                console.info(` >>> User Created Successfully!`)
            } else {
                console.info(` >> There was some error while creating new user`)
            }
        })
        .catch(err => {
            console.error(` >> User creation failed: ${JSON.stringify(err)}`)
        })
        console.log(` >> This is single param: ${instance} & ${JSON.stringify(options)}`)

        // Constructing the request body
        // const requestBody = {
        //   'newUser': newUser,
        //   'userCreds': userCreds
        // };
        
        //
        // // Making the POST request
        // fetch('/createuser', options)
        //     .then(response => {
        //         console.info(`Server response: ${JSON.stringify(response)}`)
        //     })
        //     .catch(err => {
        //         console.error(` >> Create user request failed: ${JSON.stringify(err)}`)
        //     })

        signInSection.classList.remove("disabled");
        signUpSection.classList.add("disabled");
    })

});
