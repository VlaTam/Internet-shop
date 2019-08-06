let form = document.querySelector('#addProductForm');

function addProduct() {
    let formData = new FormData(form);

    let product = {
        name: formData.get('name'),
        price: formData.get('price')
    };

    let jsonProduct = JSON.stringify(product);

/*    fetch('/product/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: jsonProduct
    })
        .then(response => response.json())
        .then(jsonString => alert(jsonString.message));*/
}
