let responseTransfer = {authorized: false};
let form = document.querySelector('#authorizeForm');

let status = function (response) {
    if (response.status !== 200) {
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
            alert('User is authorized - ' + responseTransfer.authorized);
        })
        .catch(function (error) {
            alert(error);
        });
}
