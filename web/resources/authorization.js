let form = document.querySelector('#auth_form');

function onAuthorize(){
    let formData = new FormData(form);
    let user = {};
    user.email = formData.get('mailAddress');
    user.password = formData.get('password');

    let jsonString = JSON.stringify(formData);
    alert(jsonString);
}
