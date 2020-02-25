var daco, prve, druhe, tretie, stvrte;

$(function(){
    colors = [
        'silver', 'gold', 'black', 
        'brown', 'red', 'orange', 
        'yellow', 'green', 'blue', 
        'purple', 'gray', 'white'
    ];
    
    offset = ['silver', 'gold', 'brown', 'red', 'green', 'blue', 'purple', 'initial']
    
    prve = $('#prve');
    prve.css('background-color', colors[3]);
    druhe = $('#druhe');
    druhe.css('background-color', colors[2]);
    tretie = $('#tretie');
    tretie.css('background-color', colors[2]);
    stvrte = $('#stvrte');
    stvrte.css('background-color', colors[3]);
    daco = document.getElementById("score");
})

var index = 0;


$('#prve').click(function(){
    console.log(prve.css('background-color'));
    if(index == 11) index = 2;
    index++;
    console.log(index);
});


    // $('.tlacidlo').click(function(e){
    //     var index = 1, tmp1=1, tmp2=0, tmp3 = 0, tmp4 = 1, tmpx;
    //     switch(e.currentTarget.id){
    //         case 'prve':
    //             //index = colors.index(prve.css('background-color'));
    //             //index = colors.index();
    //             //index = prve.css('background-color');
    //             console.log(index);
    //             if(index == 11) index = 2;
    //             tmp1 = index-1;
    //             index = index++;
    //             console.log(colors[index]);
    //             console.log(index);
    //             prve.css('background-color', colors[++index]);
    //             break;
    //         case 'druhe':
    //             index = colors.indexOf(druhe.css("background-color"));
    //             if(index == 11) index = 1;
    //             tmp2 = index-1;
    //             druhe.css('background-color', colors[++index]);
    //             break;
    //        }
    //     if(e.currentTarget.id == 'tretie'){
    //         index = colors.indexOf(tretie.css("background-color"));
    //         if(index == 11) index = -1;
    //         tmp3 = index-1;
    //         tretie.css('background-color', colors[++index]);
    //     }
    //     if(e.currentTarget.id == 'stvrte'){
    //         index = offset.indexOf(stvrte.css("background-color"));
            
    //         if(index == 7) index = -1;
    //         if(index == 6) {
    //             stvrte.css('background-color', '#eee');
    //             index++;
    //         }
    //         else{
    //             stvrte.css('background-color',  offset[++index]);
    //         }
    //         tmp4 = index;
    //     }
    //     var tmp = 'x1';
    //     if(tmp3 < 10){
    //         for(var i=0; i<tmp3;i++){
    //             tmp = tmp + '0';
    //         } 
    //     }
    //     if(tmp3 == -2){ tmp = '/10';}
    //     if(tmp3 == -1){tmp = '/100';}
    
    //     switch(tmp4){
    //         case 2: tmpx = '2'; break;
    //         case 3: tmpx = '0.5'; break;
    //         case 4: tmpx = '0.25'; break;
    //         case 5: tmpx = '0.1'; break;
    //         case 6: tmpx = '0.05'; break;
    //         case -1: tmpx = '10'; break;
    //         case 0: tmpx = '5'; break;
    //         default: tmpx = '1'; break;
    //     }
    
    //     daco.innerHTML = tmp1.toString() + tmp2.toString() + tmp.toString() + ' ±' + tmpx + '%';
    // })