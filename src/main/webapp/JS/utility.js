/**
 * @param {String} requestTo takes the end point which the request should be made.
 * @param {String} method takes the method type 'POST', 'GET', etc.,
 * @param {Object} body takes the parameter object required. 
 * @param {String} purpose (Optional) a brief message indicating what needs to achieved by the request.
 * @param {boolean} expectingPOJO true if server is expecting a POJO as request body.
 */
async function requestToEndPoint (requestTo, method, body, purpose, expectingPOJO) {
    const endPoint = requestTo;
    let options = {}
    if (! expectingPOJO ) {
        options = {
            method : method,
            headers : { 'Content-Type' : 'application/json' },
            body : JSON.stringify(body)
        }
    } else {
        options = {
            method : method,
            headers : { 'Content-Type' : 'application/json' },
            body : body
        }
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

/**
 * @param {String} requestTo takes the end point which the request should be made.
 * @param {String} method takes the method type 'POST', 'GET', etc.,
 * @param {File} body takes the parameter File required. 
 * @param {String} purpose (Optional) a brief message indicating what needs to achieved by the request.
 */
async function mediaRequestToEndPoint(requestTo, method, body, purpose) {
    const endPoint = requestTo;
    const formData = new FormData();
    formData.append('file', body); // 'file' should match the name of the parameter expected by the server
    const options = {
        method: method,
        body: formData
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

const successMessage = `<div id="notification-container" class="hidden">
                            <div id="notification" class="notification-up hide">
                                <span id="notification-message"></span>
                                <button id="close-btn" data-title='close notification' class="close" onclick="closeNotification()"></button>
                            </div>
                        </div>`

const ShowSuccessNotification = (message)=> {
    let dom = document.getElementById('toasters');
    dom.innerHTML = successMessage;
    let container = document.getElementById('notification-container');
    let popup = document.getElementsByClassName('notification-up')[0];
    let notificationMessage = document.getElementById('notification-message');
    notificationMessage.innerText = message || "Default success!";
    popup.className.replace('hide', 'show')
    container.classList.remove('hidden')
    setTimeout(() => { 
        popup.className.replace('show', 'hide')
        container.classList.add('hidden'); 
    }, 3000);
}