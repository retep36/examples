colors = [
    'silver', 'gold', 'black', 
    'brown', 'red', 'orange', 
    'yellow', 'green', 'blue', 
    'purple', 'gray', 'white'
];

offset = ['silver', 'gold', 'brown', 'red', 'green', 'blue', 'purple', 'initial']

let index, tmp1=1, tmp2=0, tmp3 = 0, tmp4 = 1, tmpx, prve, druhe, tretie, stvrte;

let prve = document.getElementById("prve");
// prve = $('#prve');
// prve.css('background-color', colors[3]);
// let prve = document.getElementById("prve");
prve.style.backgroundColor = colors[3];
let druhe = document.getElementById("druhe");
druhe.style.backgroundColor = colors[2];
let tretie = document.getElementById("tretie");
tretie.style.backgroundColor = colors[2];
let stvrte = document.getElementById("stvrte");
stvrte.style.backgroundColor = colors[3];
let daco = document.getElementById("score");

function changeColor(clickedId){
    if(clickedId == 'prve'){
        
        if(index == 11) index = 2;
        tmp1 = index-1;
        prve.style.backgroundColor = colors[++index]; 
    }
    if(clickedId == 'druhe'){
        index = colors.indexOf(druhe.style.backgroundColor);
        if(index == 11) index = 1;
        tmp2 = index-1;
        druhe.style.backgroundColor = colors[++index]; 
    }
    if(clickedId == 'tretie'){
        index = colors.indexOf(tretie.style.backgroundColor);
        if(index == 11) index = -1;
        tmp3 = index-1;
        tretie.style.backgroundColor = colors[++index]; 
    }
    if(clickedId == 'stvrte'){
        index = offset.indexOf(stvrte.style.backgroundColor);
        
        if(index == 7) index = -1;
        if(index == 6) {
            stvrte.style.backgroundColor = '#eee';
            index++;
        }
        else{
            stvrte.style.backgroundColor = offset[++index];
        }
        tmp4 = index;
        console.log(tmp4);
    }
    var tmp = 'x1';
    if(tmp3 < 10){
        for(var i=0; i<tmp3;i++){
            tmp = tmp + '0';
        } 
    }
    if(tmp3 == -2){
        tmp = '/10';
    }
    if(tmp3 == -1){
        tmp = '/100';
    }

    switch(tmp4){
        case 2: tmpx = '2'; break;
        case 3: tmpx = '0.5'; break;
        case 4: tmpx = '0.25'; break;
        case 5: tmpx = '0.1'; break;
        case 6: tmpx = '0.05'; break;
        case -1: tmpx = '10'; break;
        case 0: tmpx = '5'; break;
        default: tmpx = '1'; break;
    }

    daco.innerHTML = tmp1.toString() + tmp2.toString() + tmp.toString() + ' ±' + tmpx + '%';
}