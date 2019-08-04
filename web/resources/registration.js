let form = document.querySelector('form');
let section = document.querySelector('section');

function submitInfo(){
    let formData = new FormData(form);
    for(let [name, value] of formData){
        let paragraph = document.createElement('p');
        paragraph.setAttribute('value', `${name} = ${value}`);
        section.appendChild(paragraph);
    }
}
