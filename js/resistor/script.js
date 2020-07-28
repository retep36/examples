const colors = [
    'silver', 'gold', 'black',
    'brown', 'red', 'orange',
    'yellow', 'green', 'blue',
    'purple', 'gray', 'white'
];

const offset = ['silver', 'gold', 'brown', 'red', 'green', 'white']

let index, tmp1 = 1, tmp2 = 0, tmp3 = -2, tmp4 = -1, tmpx;
let firstColor, secondColor, thirdColor, fourthColor;

firstColor = document.getElementById("prve");
firstColor.style.backgroundColor = colors[3];
secondColor = document.getElementById("druhe");
secondColor.style.backgroundColor = colors[2];
thirdColor = document.getElementById("tretie");
thirdColor.style.backgroundColor = colors[0];
fourthColor = document.getElementById("stvrte");
fourthColor.style.backgroundColor = offset[0];
let actualScore = document.getElementById("score");

function changeColor(clickedId) {
    if (clickedId == 'prve') {
        index = colors.indexOf(firstColor.style.backgroundColor);
        if (index == 11) index = 2;
        tmp1 = index - 1;
        firstColor.style.backgroundColor = colors[++index];
    }
    if (clickedId == 'druhe') {
        index = colors.indexOf(secondColor.style.backgroundColor);
        if (index == 11) index = 1;
        tmp2 = index - 1;
        secondColor.style.backgroundColor = colors[++index];
    }
    if (clickedId == 'tretie') {
        index = colors.indexOf(thirdColor.style.backgroundColor);
        if (index == 9) index = -1;
        tmp3 = index - 1;
        thirdColor.style.backgroundColor = colors[++index];
    }
    if (clickedId == 'stvrte') {
        index = offset.indexOf(fourthColor.style.backgroundColor);
        if (index == 5) index = -1; 
        tmp4 = index;   
        fourthColor.style.backgroundColor = offset[++index];
    }
    setThirdValue();
    setFourthValue();
    actualScore.innerHTML = `${tmp1.toString()}${tmp2.toString()}${tmp.toString()}&#x2126; &#177;${tmpx}%`;
    reduction(tmp1, tmp2, tmp, tmpx);
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

function reduction(tmp1, tmp2, tmp, tmpx){
    let result = document.getElementById('hodnota');
    let base = `${tmp1}${tmp2}`;
    console.log(base);
    let multiplier = (tmp.replace('x', ''));
    switch(multiplier){
        case '0.01': multiplier = 0.01; break;
        case '0.1': multiplier = 0.1; break;
        case '1': multiplier = 1; break;
        case '10': multiplier = 10; break;
        case '100': multiplier = 100; break;
        case '1k': multiplier = 1000; break;
        case '10k': multiplier = 10000; break;
        case '100k': multiplier = 100000; break;
        case '1M': multiplier = 1000000; break;
        case '10M': multiplier = 10000000; break;
    }
    let finalScore = (base * multiplier).toFixed(2);
    finalScore = formatNumber(finalScore);

    result.innerHTML = `${finalScore}&#x2126; &#177;${tmpx}%`;
}

function formatNumber(num) {
    return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1 ');
  }