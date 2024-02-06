document.addEventListener("DOMContentLoaded", function() {
    var signInButton = document.getElementsByClassName("js-log-in")[0];

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

        // fetch("/signin", {
        //     method: "POST",
        //     headers: {
        //         "Content-Type": "application/json"
        //     },
        //     body: JSON.stringify({data: data})
        // })
        // .then(response => {
        //     if (!response.ok) {
        //         throw new Error("Network response was not ok");
        //     }
        //     return response.json();
        // })
        // .then(data => {
        //     console.log(data);
        //     // Handle the response data as needed
        // })
        // .catch(error => {
        //     console.error("There was a problem with your fetch operation:", error);
        // });
    });
});
