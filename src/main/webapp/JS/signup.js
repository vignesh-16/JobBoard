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
