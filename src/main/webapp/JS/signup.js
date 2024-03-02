//To Do: 
// -> Validation of email & password when signing up.

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
async function requestToEndPoint (requestTo, method, body, purpose) {
    const endPoint = requestTo;
    const options = {
        method : method,
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify(body)
    }
    const task = purpose != null || undefined ? purpose : `${method} call :`;
    let serverResponse = {};
    try {
        const response = await fetch(endPoint, options);
        if (response.ok) {
            const data = await response.json(); // Parse response body as JSON
            serverResponse.result = Object.assign(data);
        } else {
            console.error(` >> There was some error during ${task}`);
        }
    } catch (err) {
        console.error(` >> Not able to execute ${task} -> ${err}`);
    }
    return serverResponse;   
}

async function requestPage (requestTo, method, body, purpose) {
    const endPoint = requestTo;
    const options = {
        method : method,
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify(body)
    }
    await fetch(endPoint, options)
        .then(response => {
            if(response.ok) {
                return response.json();
            }
        })
        .then(data => {
            console.log(` >> Server response received: ${JSON.stringify(data)}`);
            let loadPage = data.view.viewName;
            window.location.href = loadPage;
        })
}

document.addEventListener("DOMContentLoaded", function() {
    const createNewAccount = document.getElementsByClassName("js-create-account")[0];
    createNewAccount.addEventListener("click", async () => {
        let firstname = document.getElementsByName("fname")[0].value;
        let lastname = document.getElementsByName("lname")[0].value;
        let email = document.getElementsByName("mail")[0].value;
        let accountType = document.getElementsByName("account-type")[0].value;
        let password = document.getElementsByName("password2")[0].value;
        let newUser = { id: "", firstname : firstname, lastname : lastname, email : email, accountType : accountType };
        let userCreds = { id: "", userId: "", userLogin : email, password : password, accountType : accountType };
        
        let response = await requestToEndPoint("/CreateUser", "POST", newUser, "Create a new user")
        
        if(response?.result?.statusCode == 200) {
            userCreds.userId = response?.result?.data
            let response2 = await requestToEndPoint("SaveUserCredentials", 'POST', userCreds, "Generate user credentials to login")
            if (response2?.result.statusCode == 200 ) {
                alert (`Your user account was created successfully!, please log in.`)
                window.location.href = "/";
            } else {
                console.warn(` Something went wrong while creating user creds: ${JSON.stringify(response2)} `)
                alert (`Something went wrong`)
            }
        } else {
            console.warn(` Something went wrong while creating user: ${JSON.stringify(response)} `)
            alert(`Something went wrong`)
        }
    })
});
