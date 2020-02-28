colors = [
    'silver', 'gold', 'black',
    'brown', 'red', 'orange',
    'yellow', 'green', 'blue',
    'purple', 'gray', 'white'
];

offset = ['silver', 'gold', 'brown', 'red', 'green', 'white']

var index, tmp1 = 1, tmp2 = 0, tmp3 = -2, tmp4 = -1, tmpx;
var prve, druhe, tretie, stvrte;

prve = document.getElementById("prve");
prve.style.backgroundColor = colors[3];
druhe = document.getElementById("druhe");
druhe.style.backgroundColor = colors[2];
tretie = document.getElementById("tretie");
tretie.style.backgroundColor = colors[0];
stvrte = document.getElementById("stvrte");
stvrte.style.backgroundColor = offset[0];
var daco = document.getElementById("score");

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
    daco.innerHTML = tmp1.toString() + tmp2.toString() + tmp.toString() + '&#x2126; &#177;' + tmpx + '%';
    prepocet(tmp1, tmp2, tmp, tmpx);
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

function prepocet(tmp1, tmp2, tmp, tmpx){
    var result = document.getElementById('hodnota');
    var zaklad = tmp1 + '' + tmp2;
    console.log(zaklad);
    var nasobitel = (tmp.replace('x', ''));
    switch(nasobitel){
        case '0.01': nasobitel = 0.01; break;
        case '0.1': nasobitel = 0.1; break;
        case '1': nasobitel = 1; break;
        case '10': nasobitel = 10; break;
        case '100': nasobitel = 100; break;
        case '1k': nasobitel = 1000; break;
        case '10k': nasobitel = 10000; break;
        case '100k': nasobitel = 100000; break;
        case '1M': nasobitel = 1000000; break;
        case '10M': nasobitel = 10000000; break;
    }
    var vysledok = (zaklad * nasobitel).toFixed(2);
    vysledok = formatNumber(vysledok);

    result.innerHTML = vysledok + '&#x2126; &#177;' + tmpx + '%';
}

function formatNumber(num) {
    return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1 ');
  }