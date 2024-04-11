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

document.addEventListener("DOMContentLoaded", ()=> {
    document.getElementById("jobcreater").addEventListener("submit", (e)=>{
        e.preventDefault();
        const formData = new FormData(e.target);
        const formProps = Object.fromEntries(formData);
        console.log(`>> form : ${JSON.stringify(formProps)}`)
        requestToEndPoint("/createJobPost", "POST", JobPost = JSON.stringify(formProps), "Create new job post", true)
    })
});