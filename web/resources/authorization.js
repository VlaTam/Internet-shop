let responseTransfer = {registration: false};

function addMessage(){
    let message;
    if (responseTransfer.registration)
        message = document.createTextNode('You are registered');
    else
        message = document.createTextNode('You are NOT registered');

    alert(message);
}

let status = function (response) {
    if (response.status >= 400) {
        return Promise.reject(new Error(response.statusText))
    }
    return Promise.resolve(response)
};

let json = function (response) {
    return response.json()
};

function doFetch(object) {
    fetch('/user/authorization', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(object)
    })
        .then(status)
        .then(json)
        .then(function (data) {
            responseTransfer.registration = data.registration;
            addMessage();
        })
        .catch(function (error) {
            alert(error);
        });
}


/*let responseTransfer = {authorized: false};
let form = document.querySelector('#authorizeForm');

function addMessage(){
    let message;
    if (responseTransfer.authorized)
        message = document.createTextNode('You are authorized');
    else
        message = document.createTextNode('You are NOT authorized');

    let content = document.querySelector('form');
    content.appendChild(message);
}

let status = function (response) {
    if (response.status >= 400) {
        return Promise.reject(new Error(response.statusText))
    }
    return Promise.resolve(response)
};

let json = function (response) {
    return response.json()
};

function authorize(){
    let formData = new FormData(form);
    let user = {};
    user.mailAddress = formData.get('mailAddress');
    user.password = formData.get('password');

    fetch('/user/authorization', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user)
    })
        .then(status)
        .then(json)
        .then(function (data) {
            responseTransfer.authorized = data.authorized;
            addMessage();
        })
        .catch(function (error) {
            alert(error);
        });
}*/
