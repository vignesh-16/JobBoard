//To Do: 
// -> handle 'Remember Me' option while sign in.

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
    const task = purpose != null || undefined ? purpose : `${method} call :`;
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

function requestPage (requestTo, method, body, purpose) {
    const endPoint = requestTo;
    const options = {
        method : method,
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify(body)
    }
    fetch(endPoint, options)
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

    const signInButton = document.getElementsByClassName("js-log-in")[0];
    const signUpButton = document.getElementsByClassName("js-sign-up")[0];
   
    signInButton.addEventListener("click", function() {
        let userId = document.getElementsByName("userid")[0].value
        let userPwd = document.getElementsByName("userpass")[0].value
        let data = {
            username: userId,
            password: userPwd
        }
        requestPage("/signin", "POST", data, "Check user credentials")
    });

    signUpButton.addEventListener("click", ()=> {
        window.location.href = "/signup";
    })

});
