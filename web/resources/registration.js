let form = document.querySelector('form');

let address = {
};

let user = {

};

function submitInfo(){
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

    //let formData = new FormData(form);
    let response = fetch('/user/registration', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user)
    });
    let result = response.text();
    alert(result.message);
}
