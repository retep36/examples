colors = [
    'silver', 'gold', 'black',
    'brown', 'red', 'orange',
    'yellow', 'green', 'blue',
    'purple', 'gray', 'white'
];

offset = ['silver', 'gold', 'brown', 'red', 'green', 'white']

let index, tmp1 = 1, tmp2 = 0, tmp3 = -2, tmp4 = -1, tmpx, prve, druhe, tretie, stvrte;

prve = document.getElementById("prve");
prve.style.backgroundColor = colors[3];
druhe = document.getElementById("druhe");
druhe.style.backgroundColor = colors[2];
tretie = document.getElementById("tretie");
tretie.style.backgroundColor = colors[0];
stvrte = document.getElementById("stvrte");
stvrte.style.backgroundColor = offset[0];
let daco = document.getElementById("score");

function changeColor(clickedId) {
    if (clickedId == 'prve') {
        index = colors.indexOf(prve.style.backgroundColor);
        if (index == 11) index = 2;
        tmp1 = index - 1;
        prve.style.backgroundColor = colors[++index];
    }
    if (clickedId == 'druhe') {
        index = colors.indexOf(druhe.style.backgroundColor);
        if (index == 11) index = 1;
        tmp2 = index - 1;
        druhe.style.backgroundColor = colors[++index];
    }
    if (clickedId == 'tretie') {
        index = colors.indexOf(tretie.style.backgroundColor);
        if (index == 9) index = -1;
        tmp3 = index - 1;
        tretie.style.backgroundColor = colors[++index];
    }
    if (clickedId == 'stvrte') {
        index = offset.indexOf(stvrte.style.backgroundColor);
        if (index == 5) index = -1; 
        tmp4 = index;   
        stvrte.style.backgroundColor = offset[++index];
    }
    setThirdValue();
    setFourthValue();
    daco.innerHTML = tmp1.toString() + tmp2.toString() + tmp.toString() + ' ±' + tmpx + '%';
}

function setThirdValue(){
    switch (tmp3) {
        case -2: tmp = 'x0.01'; break;
        case -1: tmp = 'x0.1'; break;
        case 0: tmp = 'x1'; break;
        case 1: tmp = 'x10'; break;
        case 2: tmp = 'x100'; break;
        case 3: tmp = 'x1k'; break;
        case 4: tmp = 'x10k'; break;
        case 5: tmp = 'x100k'; break;
        case 6: tmp = 'x1M'; break;
        case 7: tmp = 'x10M'; break;
        default: break;
    }
}

function setFourthValue(){
    switch (tmp4) {
        case 0: tmpx = '5'; break;
        case 1: tmpx = '1'; break;
        case 2: tmpx = '2'; break;
        case 3: tmpx = '0.5'; break;
        case 4: tmpx = '20'; break;
        case -1: tmpx = '10'; break;
        default: break;
    }
}