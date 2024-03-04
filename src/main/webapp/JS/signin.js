import * as utils from '../js/utility';
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
        utils.requestPage("/signin", "POST", data, "Check user credentials")
    });

    signUpButton.addEventListener("click", ()=> {
        window.location.href = "/signup";
    })

});
