let form = document.querySelector('#registrationForm');
let address = {};
let user = {};

function saveUser() {
    let formData = new FormData(form);
    address.country = formData.get('country');
    address.city = formData.get('city');
    address.street = formData.get('street');
    address.houseNumber = formData.get('houseNumber');
    address.flatNumber = formData.get('flatNumber');
    address.postalCode = formData.get('postalCode');

    user.lastName = formData.get('lastName');
    user.firstName = formData.get('firstName');
    user.birthday = formData.get('birthday');
    user.mailAddress = formData.get('mailAddress');
    user.password = formData.get('password');
    user.address = address;
}

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

function register(object) {
    fetch('/user/registration', {
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
            document.location.href = "/";
        });
}

function createUser(){
   saveUser();
   register(user);
}
