import * as utils from '../js/utility';

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
    const GoToProfile = document.getElementById("js-my-profile");
    GoToProfile.addEventListener("click" , ()=>{
        window.location.href = "/profile";
    });
});
