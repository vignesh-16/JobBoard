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

/**
 * @param {String} requestTo takes the end point which the request should be made.
 * @param {String} method takes the method type 'POST', 'GET', etc.,
 * @param {Object} body takes the parameter object required. 
 * @param {String} purpose (Optional) a brief message indicating what needs to achieved by the request.
 */
function requestToEndPoint (requestTo, method, body, purpose) {
    const endPoint = requestTo;
    const options = {
        method : method,
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify(body)
    }
    const task = purpose != null || undefined ? purpose : `${method} call :`
    let serverResponse = {};
    fetch(endPoint, options)
        .then(response => {
            if(response.ok) {
            return response.json(); // Parse response body as JSON
            } else {
            console.error(` >> There was some error during ${task}`);
            }
        })
        .then(data => {
            serverResponse.result = Object.assign(data);
        })
        .catch(err => {
            console.error(` >> Not able to execute ${task} -> ${err}`)
            return false;
        });
    return serverResponse
}

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
        let response = requestToEndPoint("/signin", "POST", data, "Check user credentials")
        if (response?.result?.statusCode == 401) {
            alert(`There was some error, please try again`)
        } else {
            document.body.innerHTML = JSON.stringify(response?.result?.view);
        }
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
        
        let response = requestToEndPoint("/CreateUser", "POST", newUser, "Create a new user")
        
        if(response?.result?.statusCode == 200) {
            userCreds.userId = response?.result?.data
            let response2 = requestToEndPoint("SaveUserCredentials", 'POST', userCreds, "Generate user credentials to login")
            if (response2?.result.statusCode == 200 ) {
                alert (`Your user account was created successfully!, please log in.`)
                signInSection.classList.remove("disabled");
                signUpSection.classList.add("disabled");
            } else {
                alert (`Something went wrong`)
            }
        } else {
            alert(`Something went wrong`)
        }
    })

});
