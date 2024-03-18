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
    const fileInput = document.getElementsByClassName("js-file-input")[0];
    fileInput.addEventListener('input',()=>{
        console.log(`Hey!! file received!!!`)
        let file = fileInput.value;
        mediaRequestToEndPoint("uploadResume", "POST", file, "storeInDb")
    })
});